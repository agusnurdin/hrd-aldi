/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.impl;

import java.util.List;
import javax.persistence.EntityManager;
import mii.hrd.dao.SetUpCutiDAO;
import mii.hrd.entity.SetUpCuti;

/**
 *
 * @author Rinaldi
 */
public class SetUpCutiDAOImpl extends GenericDAOImpl implements SetUpCutiDAO{
    
    public SetUpCutiDAOImpl(EntityManager em){
        super(em);
    }
    
    @Override
    public SetUpCuti getById(long id) {
        return this.em.find(SetUpCuti.class, id);
    }

    @Override
    public List<SetUpCuti> getAll() {
        return this.em.createQuery("SELECT sc FROM SetUpCuti sc").getResultList();
    }
    
}
