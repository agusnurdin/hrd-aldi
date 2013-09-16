/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.impl;

import java.util.List;
import javax.persistence.EntityManager;
import mii.hrd.dao.AkunDAO;
import mii.hrd.entity.Akun;

/**
 *
 * @author Rinaldi
 */
public class AkunDAOImpl extends GenericDAOImpl implements AkunDAO{
    
    public AkunDAOImpl(EntityManager em){
        super(em);
    }
    @Override
    public Akun getByID(long id) {
        return em.find(Akun.class, id);
    }

    @Override
    public List<Akun> getAll() {
        return em.createQuery("SELECT a from Akun a").getResultList();
    }

    @Override
    public Akun getLogin(String username, String password) {
        return (Akun)em.createQuery("Select a from Akun a where a.username=:param and a.password=:param2")
                .setParameter("param",username).setParameter("param2",password).getSingleResult();
    }
    
}
