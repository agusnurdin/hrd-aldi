/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.bean;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mii.hrd.dao.DepartemenDAO;
import mii.hrd.dao.KaryawanDAO;
import mii.hrd.dao.SetUpGajiDAO;
import mii.hrd.entity.Akun;
import mii.hrd.entity.Departemen;
import mii.hrd.entity.Karyawan;
import mii.hrd.entity.SetUpCuti;
import mii.hrd.entity.SetUpGaji;
import mii.hrd.impl.DepartemenDAOImpl;
import mii.hrd.impl.KaryawanDAOImpl;
import mii.hrd.impl.SetUpGajiDAOImpl;

/**
 *
 * @author Rinaldi
 */
@Stateless
public class KaryawanSessionBean implements KaryawanSessionBeanLocal {
    @PersistenceContext(unitName = "HRD-Aldi-ejbPU")
    private EntityManager em;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    Date tglLahir = new Date();
    Date tglHired = new Date();
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void insertKaryawan(String kodeKaryawan, String namaKaryawan, String jenisKelamin, String tempatLahir, String tanggalLahir, String tanggalHired, long idDepartemen, String username, String password, String fungsi, int jatahCuti, long idSetupGaji) {
        try {
            tglLahir = df.parse(tanggalLahir);
            tglHired = df.parse(tanggalHired);
        } catch (ParseException ex) {
            Logger.getLogger(KaryawanSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        KaryawanDAO kdao = new KaryawanDAOImpl(em);
        Karyawan k = new Karyawan();
        DepartemenDAO ddao = new DepartemenDAOImpl(em);
        SetUpGajiDAO gdao = new SetUpGajiDAOImpl(em);
        
        k.setKodeKaryawan(kodeKaryawan);
        k.setNamaKaryawan(namaKaryawan);
        k.setJenisKelamin(jenisKelamin);
        k.setAlamat(fungsi);
        k.setTempatLahir(tempatLahir);
        k.setTanggalLahir(tglLahir);
        k.setTanggalHired(tglHired);
        Departemen d = ddao.getByID(idDepartemen);
        k.setDepartemen(d);
        Akun akun = new Akun();
        akun.setUsername(username);
        akun.setPassword(password);
        akun.setFungsi(fungsi);
        akun.setKaryawan(k);
        SetUpCuti cuti = new SetUpCuti();
        cuti.setJatahcuti(jatahCuti);
        k.setCuti(cuti);
        SetUpGaji gaji = gdao.getById(idSetupGaji);
        k.setGaji(gaji);
        kdao.insert(k);
    }

    @Override
    public void updateKaryawan(long id, String kodeKaryawan, String namaKaryawan, String jenisKelamin, String tempatLahir, String tanggalLahir, String tanggalHired, long idDepartemen, String username, String password, String fungsi, int jatahCuti, long idSetupGaji) {
        KaryawanDAO kdao = new KaryawanDAOImpl(em);
        Karyawan k = kdao.getByID(id);
        DepartemenDAO ddao = new DepartemenDAOImpl(em);
        SetUpGajiDAO gdao = new SetUpGajiDAOImpl(em);
        
        k.setKodeKaryawan(kodeKaryawan);
        k.setNamaKaryawan(namaKaryawan);
        k.setJenisKelamin(jenisKelamin);
        k.setAlamat(fungsi);
        k.setTempatLahir(tempatLahir);
        k.setTanggalLahir(tglLahir);
        k.setTanggalHired(tglHired);
        Departemen d = ddao.getByID(idDepartemen);
        k.setDepartemen(d);
        Akun akun = new Akun();
        akun.setUsername(username);
        akun.setPassword(password);
        akun.setFungsi(fungsi);
        akun.setKaryawan(k);
        SetUpCuti cuti = new SetUpCuti();
        cuti.setJatahcuti(jatahCuti);
        k.setCuti(cuti);
        SetUpGaji gaji = gdao.getById(idSetupGaji);
        k.setGaji(gaji);
        kdao.update(k);
    }

    @Override
    public void deleteKaryawan(long id) {
        KaryawanDAO kdao = new KaryawanDAOImpl(em);
        Karyawan k = kdao.getByID(id);
        kdao.delete(k);
    }

    @Override
    public List<Karyawan> karyawanGetByNama(String nama) {
        KaryawanDAO kdao = new KaryawanDAOImpl(em);
        return kdao.getByNama(nama);
    }    

    @Override
    public List<Karyawan> karyawanGetAll() {
         KaryawanDAO kdao = new KaryawanDAOImpl(em);
         return kdao.getAll();
    }

    @Override
    public List<Karyawan> karyawangetByYear(int year) {
         KaryawanDAO kdao = new KaryawanDAOImpl(em);
         return kdao.getByYear(year);
    }

    @Override
    public int getJatahCuti(Date hired) {
        int jtcuti=0;
        int hari = this.getLamaKerja(hired);
        if(hari<365){
            jtcuti=0;
        }else if(hari>=365&&hari<1825){
            jtcuti=12;
        }else if(hari>=1825){
            jtcuti=14;
        }
        return jtcuti;
    }

    @Override
    public double getGaji(long id) {
        KaryawanDAO kdao = new KaryawanDAOImpl(em);
        Karyawan k = kdao.getByID(id);
        int hari = this.getLamaKerja(k.getTanggalHired());
        //if(hari%365)
        return k.getGaji().getGajiPokok();
    }

    @Override
    public int getLamaKerja(Date hired) {
        Date now = new Date();
        int t = ((int)(now.getTime() - hired.getTime()));
        int hari = t/(1000*60*60*24);
        return hari;
    }

    
    
    
   
}
