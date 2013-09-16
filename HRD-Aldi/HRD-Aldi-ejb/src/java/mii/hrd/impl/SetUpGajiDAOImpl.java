/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.impl;

import java.util.List;
import javax.persistence.EntityManager;
import mii.hrd.dao.SetUpGajiDAO;
import mii.hrd.entity.SetUpGaji;

/**
 *
 * @author Rinaldi
 */
public class SetUpGajiDAOImpl extends GenericDAOImpl implements SetUpGajiDAO{
    
    public SetUpGajiDAOImpl(EntityManager em){
        super(em);
    }
    @Override
    public SetUpGaji getById(long id) {
        return em.find(SetUpGaji.class, id);
    }

    @Override
    public List<SetUpGaji> getAll() {
        return em.createQuery("SELECT sg from SetUpGaji sg").getResultList();
    }
    
}
