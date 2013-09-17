/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.bean;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import mii.hrd.entity.Karyawan;

/**
 *
 * @author Rinaldi
 */
@Local
public interface KaryawanSessionBeanLocal {

    void insertKaryawan(String kodeKaryawan, String namaKaryawan, String jenisKelamin, String tempatLahir, String tanggalLahir, String tanggalHired, long idDepartemen, String username, String password, String fungsi, int jatahCuti, long idSetupGaji);
    void updateKaryawan(long id,String kodeKaryawan, String namaKaryawan, String jenisKelamin, String tempatLahir, String tanggalLahir, String tanggalHired, long idDepartemen, String username, String password, String fungsi, int jatahCuti, long idSetupGaji);
    void deleteKaryawan(long id);
    List<Karyawan> karyawanGetAll();
    List<Karyawan> karyawanGetByNama(String nama);
    List<Karyawan> karyawangetByYear(int year);

    int getJatahCuti(Date hired);

    double getGaji(long id);

    int getLamaKerja(Date hired);

    
    
    
}
