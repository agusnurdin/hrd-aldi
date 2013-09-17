/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.bean;

import java.util.List;
import javax.ejb.Local;
import mii.hrd.entity.SetUpGaji;

/**
 *
 * @author Rinaldi
 */
@Local
public interface SetUpGajiSessionBeanLocal {

    void insertSetupGaji(String namaGolongan, double gajiPokok);

    void updateSetupGaji(long id, String namaGolongan, double gajiPokok);

    void deleteSetupGaji(long id);

    List<SetUpGaji> setupGajiGetAll();
    
}
