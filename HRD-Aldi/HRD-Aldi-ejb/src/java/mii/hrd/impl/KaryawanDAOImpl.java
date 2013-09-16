/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import mii.hrd.dao.KaryawanDAO;
import mii.hrd.entity.Karyawan;

/**
 *
 * @author Rinaldi
 */
public class KaryawanDAOImpl extends GenericDAOImpl implements KaryawanDAO{
    
    public KaryawanDAOImpl(EntityManager em){
        super(em);
    }
    @Override
    public Karyawan getByID(long id) {
        return em.find(Karyawan.class, id);
    }

    @Override
    public List<Karyawan> getAll() {
        return em.createQuery("SELECT k FROM Karyawan k").getResultList();
    }

    @Override
    public List<Karyawan> getByNama(String nama) {
        return em.createQuery("SELECT k FROM Karyawan k where k.namaKaryawan LIKE:param").setParameter("param","%"+nama+"%").getResultList();
    }

    @Override
    public List<Karyawan> getByYear(int year) {
         List<Karyawan> karyawans = new ArrayList<Karyawan>();
         List<Karyawan> hasil = new ArrayList<Karyawan>();
         Date now= new Date();
        try{
            karyawans = (ArrayList<Karyawan>)em.createQuery("select k from Karyawan k").getResultList();
            for(Karyawan k:karyawans){
                int temp = (int)(now.getTime() - k.getTanggalHired().getTime());
                int hari = temp/(1000*60*60*24);
                if(hari<year){
                    hasil.add(k);
                }
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            //em.close();
            return hasil;
        }
    }

}
