/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.impl;

import java.util.List;
import javax.persistence.EntityManager;
import mii.hrd.dao.CutiDAO;
import mii.hrd.entity.RiwayatCuti;

/**
 *
 * @author Rinaldi
 */
public class CutiDAOImpl extends GenericDAOImpl implements CutiDAO{
    
    public CutiDAOImpl(EntityManager em){
        super(em);
    }
    
    @Override
    public RiwayatCuti getByID(long id) {
        return em.find(RiwayatCuti.class, id);
    }

    @Override
    public List<RiwayatCuti> getAll() {
        return em.createQuery("SELECT c from RiwayatCuti c").getResultList();
    }
    
}
