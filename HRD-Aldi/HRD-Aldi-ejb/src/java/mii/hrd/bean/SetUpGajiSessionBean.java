/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mii.hrd.dao.SetUpGajiDAO;
import mii.hrd.entity.SetUpGaji;
import mii.hrd.impl.SetUpGajiDAOImpl;

/**
 *
 * @author Rinaldi
 */
@Stateless
public class SetUpGajiSessionBean implements SetUpGajiSessionBeanLocal {
    @PersistenceContext(unitName = "HRD-Aldi-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void insertSetupGaji(String namaGolongan, double gajiPokok) {
        SetUpGajiDAO sgdao = new SetUpGajiDAOImpl(em);
        SetUpGaji sg = new SetUpGaji();
        sg.setNamaGolongan(namaGolongan);
        sg.setGajiPokok(gajiPokok);
        sgdao.insert(sg);
    }

    @Override
    public void updateSetupGaji(long id, String namaGolongan, double gajiPokok) {
        SetUpGajiDAO sgdao = new SetUpGajiDAOImpl(em);
        SetUpGaji sg = sgdao.getById(id);
        sg.setNamaGolongan(namaGolongan);
        sg.setGajiPokok(gajiPokok);
        sgdao.update(sg);
    }

    @Override
    public void deleteSetupGaji(long id) {
        SetUpGajiDAO sgdao = new SetUpGajiDAOImpl(em);
        SetUpGaji sg = sgdao.getById(id);
        sgdao.delete(sg);
    }

    @Override
    public List<SetUpGaji> setupGajiGetAll() {
         SetUpGajiDAO sgdao = new SetUpGajiDAOImpl(em);
         return sgdao.getAll();
    }

    
}
