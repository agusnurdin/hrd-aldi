/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.dao;

import java.util.List;
import mii.hrd.entity.SetUpGaji;

/**
 *
 * @author Rinaldi
 */
public interface SetUpGajiDAO extends GenericDAO{
    public SetUpGaji getById(long id);
    public List<SetUpGaji> getAll();
}
