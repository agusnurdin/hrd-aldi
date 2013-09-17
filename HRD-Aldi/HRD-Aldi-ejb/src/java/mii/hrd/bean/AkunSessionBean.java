/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mii.hrd.dao.AkunDAO;
import mii.hrd.entity.Akun;
import mii.hrd.impl.AkunDAOImpl;

/**
 *
 * @author Rinaldi
 */
@Stateless
public class AkunSessionBean implements AkunSessionBeanLocal {
    @PersistenceContext(unitName = "HRD-Aldi-ejbPU")
    private EntityManager em;

   
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @Override
    public void changePassword(long idAkun, String password) {
         AkunDAO adao = new AkunDAOImpl(em);
         Akun akun = adao.getByID(idAkun);
         akun.setPassword(password);
         adao.update(akun);
    }

    @Override
    public List<Akun> akunGetAll() {
        AkunDAO adao = new AkunDAOImpl(em);
        return adao.getAll();
    }

    
}
