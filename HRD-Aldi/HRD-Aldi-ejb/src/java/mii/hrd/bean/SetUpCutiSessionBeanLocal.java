/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.bean;

import javax.ejb.Local;

/**
 *
 * @author Rinaldi
 */
@Local
public interface SetUpCutiSessionBeanLocal {

    void updateSetupCuti(long idKaryawan, int jatahCuti);
    
}
