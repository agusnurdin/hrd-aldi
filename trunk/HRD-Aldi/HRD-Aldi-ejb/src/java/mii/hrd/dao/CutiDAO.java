/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.dao;

import java.util.List;
import mii.hrd.entity.RiwayatCuti;

/**
 *
 * @author Rinaldi
 */
public interface CutiDAO extends GenericDAO {
    public RiwayatCuti getByID(long id);
    public List<RiwayatCuti> getAll();
   
}
