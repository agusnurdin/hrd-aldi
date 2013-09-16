/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mii.hrd.dao.DepartemenDAO;
import mii.hrd.entity.Departemen;
import mii.hrd.impl.DepartemenDAOImpl;

/**
 *
 * @author Rinaldi
 */
@Stateless
public class DepartemenSessionBean implements DepartemenSessionBeanLocal {
    @PersistenceContext(unitName = "HRD-Aldi-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void insertDepartemen(String kodeDepartemen, String namaDepartemen, String keterangan) {
        DepartemenDAO ddao = new DepartemenDAOImpl(em);
        Departemen d = new Departemen();
        d.setKodeDepartemen(kodeDepartemen);
        d.setNamaDepartemen(namaDepartemen);
        d.setKeterangan(keterangan);
        ddao.insert(d);
    }

    @Override
    public void updateDepartemen(long id, String kodeDepartemen, String namaDepartemen, String keterangan) {
        DepartemenDAO ddao = new DepartemenDAOImpl(em);
        Departemen d = ddao.getByID(id);
        d.setKodeDepartemen(kodeDepartemen);
        d.setNamaDepartemen(namaDepartemen);
        d.setKeterangan(keterangan);
    }

    @Override
    public void deleteDepartemen(long id) {
        DepartemenDAO ddao = new DepartemenDAOImpl(em);
        Departemen d = ddao.getByID(id);
        ddao.delete(d);
    }

    @Override
    public List<Departemen> departemenGetAll() {
        DepartemenDAO ddao = new DepartemenDAOImpl(em);
        return ddao.getAll();
    }

   
    
}
