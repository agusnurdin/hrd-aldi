/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mii.hrd.dao.KaryawanDAO;
import mii.hrd.dao.SetUpCutiDAO;
import mii.hrd.entity.Karyawan;
import mii.hrd.entity.SetUpCuti;
import mii.hrd.impl.KaryawanDAOImpl;
import mii.hrd.impl.SetUpCutiDAOImpl;

/**
 *
 * @author Rinaldi
 */
@Stateless
public class SetUpCutiSessionBean implements SetUpCutiSessionBeanLocal {
    @PersistenceContext(unitName = "HRD-Aldi-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void updateSetupCuti(long idKaryawan, int jatahCuti) {
        KaryawanDAO kdao = new KaryawanDAOImpl(em);
        SetUpCutiDAO scdao = new SetUpCutiDAOImpl(em);
        Karyawan k =kdao.getByID(idKaryawan);
        SetUpCuti sc = k.getCuti();
        sc.setJatahcuti(jatahCuti);
        scdao.update(sc);
    }

}
