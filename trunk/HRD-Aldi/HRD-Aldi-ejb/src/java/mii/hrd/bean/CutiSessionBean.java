/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.bean;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mii.hrd.dao.CutiDAO;
import mii.hrd.dao.KaryawanDAO;
import mii.hrd.entity.Karyawan;
import mii.hrd.entity.RiwayatCuti;
import mii.hrd.entity.SetUpCuti;
import mii.hrd.impl.CutiDAOImpl;
import mii.hrd.impl.KaryawanDAOImpl;

/**
 *
 * @author Rinaldi
 */
@Stateless
public class CutiSessionBean implements CutiSessionBeanLocal {
    @PersistenceContext(unitName = "HRD-Aldi-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void insertCuti(String alasan, Date mulai, Date selesai, long idKaryawan) {
        int lamacuti = this.getLamaCuti(mulai, selesai);
        CutiDAO cdao = new CutiDAOImpl(em);
        KaryawanDAO kdao = new KaryawanDAOImpl(em);
        RiwayatCuti rc = new RiwayatCuti();
        rc.setAlasan(alasan);
        rc.setMulai(mulai);
        rc.setSelesai(selesai);
        Karyawan k = kdao.getByID(idKaryawan);
        SetUpCuti sc = k.getCuti();
        sc.setJatahcuti(sc.getJatahcuti()-lamacuti);
        rc.setKaryawan(k);
        cdao.insert(rc);
    }

    @Override
    public int getLamaCuti(Date mulai, Date selesai) {
        int t = ((int)(mulai.getTime() - selesai.getTime()));
        int hari = t/(1000*60*60*24);
        return hari;
    }
    
    
}
