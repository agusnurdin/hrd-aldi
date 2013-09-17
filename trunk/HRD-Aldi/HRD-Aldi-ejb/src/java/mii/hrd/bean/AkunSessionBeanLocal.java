/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.bean;

import java.util.List;
import javax.ejb.Local;
import mii.hrd.entity.Akun;

/**
 *
 * @author Rinaldi
 */
@Local
public interface AkunSessionBeanLocal {

    void changePassword(long idAkun, String password);

    List<Akun> akunGetAll();
    
}
