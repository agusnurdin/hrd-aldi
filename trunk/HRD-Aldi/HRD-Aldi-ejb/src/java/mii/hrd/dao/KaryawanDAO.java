/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.dao;

import java.util.List;
import mii.hrd.entity.Karyawan;

/**
 *
 * @author Rinaldi
 */
public interface KaryawanDAO extends GenericDAO {
    public Karyawan getByID(long id);
    public List<Karyawan> getAll();
    public List<Karyawan> getByNama(String nama);
    public List<Karyawan> getByYear(int year);
}
