/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Rinaldi
 */
@Entity
public class Karyawan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idKaryawan")
    private Long id;
    private String kodeKaryawan;
    private String namaKaryawan;
    private String jenisKelamin;
    private String alamat;
    private String tempatLahir;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalLahir;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalHired;
    @ManyToOne
    private Departemen departemen;
    @OneToMany(mappedBy = "karyawan")
    private List<RiwayatCuti> riwayatcutis;
    @OneToOne
    private Akun akun;
    @OneToOne
    private SetUpCuti cuti;
    @ManyToOne
    private SetUpGaji gaji;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Karyawan)) {
            return false;
        }
        Karyawan other = (Karyawan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mii.hrd.entity.Karyawan[ id=" + id + " ]";
    }

    /**
     * @return the kodeKaryawan
     */
    public String getKodeKaryawan() {
        return kodeKaryawan;
    }

    /**
     * @param kodeKaryawan the kodeKaryawan to set
     */
    public void setKodeKaryawan(String kodeKaryawan) {
        this.kodeKaryawan = kodeKaryawan;
    }

    /**
     * @return the namaKaryawan
     */
    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    /**
     * @param namaKaryawan the namaKaryawan to set
     */
    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    /**
     * @return the jenisKelamin
     */
    public String getJenisKelamin() {
        return jenisKelamin;
    }

    /**
     * @param jenisKelamin the jenisKelamin to set
     */
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the tempatLahir
     */
    public String getTempatLahir() {
        return tempatLahir;
    }

    /**
     * @param tempatLahir the tempatLahir to set
     */
    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    /**
     * @return the tanggalLahir
     */
    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    /**
     * @param tanggalLahir the tanggalLahir to set
     */
    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    /**
     * @return the tanggalHired
     */
    public Date getTanggalHired() {
        return tanggalHired;
    }

    /**
     * @param tanggalHired the tanggalHired to set
     */
    public void setTanggalHired(Date tanggalHired) {
        this.tanggalHired = tanggalHired;
    }

    /**
     * @return the departemen
     */
    public Departemen getDepartemen() {
        return departemen;
    }

    /**
     * @param departemen the departemen to set
     */
    public void setDepartemen(Departemen departemen) {
        this.departemen = departemen;
    }

    /**
     * @return the riwayatcutis
     */
    public List<RiwayatCuti> getRiwayatcutis() {
        return riwayatcutis;
    }

    /**
     * @param riwayatcutis the riwayatcutis to set
     */
    public void setRiwayatcutis(List<RiwayatCuti> riwayatcutis) {
        this.riwayatcutis = riwayatcutis;
    }

    /**
     * @return the akun
     */
    public Akun getAkun() {
        return akun;
    }

    /**
     * @param akun the akun to set
     */
    public void setAkun(Akun akun) {
        this.akun = akun;
    }

    /**
     * @return the cuti
     */
    public SetUpCuti getCuti() {
        return cuti;
    }

    /**
     * @param cuti the cuti to set
     */
    public void setCuti(SetUpCuti cuti) {
        this.cuti = cuti;
    }

    /**
     * @return the gaji
     */
    public SetUpGaji getGaji() {
        return gaji;
    }

    /**
     * @param gaji the gaji to set
     */
    public void setGaji(SetUpGaji gaji) {
        this.gaji = gaji;
    }
    
}
