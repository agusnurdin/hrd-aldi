/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.bean;

import java.util.List;
import javax.ejb.Local;
import mii.hrd.entity.Departemen;

/**
 *
 * @author Rinaldi
 */
@Local
public interface DepartemenSessionBeanLocal {

    void insertDepartemen(String kodeDepartemen, String namaDepartemen, String keterangan);

    void updateDepartemen(long id, String kodeDepartemen, String namaDepartemen, String keterangan);

    void deleteDepartemen(long id);

    List<Departemen> departemenGetAll();

    
    
}
