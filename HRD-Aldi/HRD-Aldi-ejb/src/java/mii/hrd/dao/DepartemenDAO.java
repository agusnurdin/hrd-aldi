/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.dao;

import java.util.List;
import mii.hrd.entity.Departemen;

/**
 *
 * @author Rinaldi
 */
public interface DepartemenDAO extends GenericDAO {
    public Departemen getByID(long id);
    public List<Departemen> getAll();
}
