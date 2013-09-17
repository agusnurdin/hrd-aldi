/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.bean;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Rinaldi
 */
@Local
public interface CutiSessionBeanLocal {

    void insertCuti(String alasan, Date mulai, Date selesai, long idKaryawan);

    int getLamaCuti(Date mulai, Date selesai);
    
}
