/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.dao;

import java.util.List;
import mii.hrd.entity.SetUpCuti;

/**
 *
 * @author Rinaldi
 */
public interface SetUpCutiDAO extends GenericDAO{
    public SetUpCuti getById(long id);
    public List<SetUpCuti> getAll();
}
