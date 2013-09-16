/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.dao;

import java.util.List;
import mii.hrd.entity.Akun;

/**
 *
 * @author Rinaldi
 */
public interface AkunDAO extends GenericDAO{
    public Akun getByID(long id);
    public List<Akun> getAll();
    public Akun getLogin(String username,String password);
}
