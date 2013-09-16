/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Rinaldi
 */
@Entity
public class Departemen implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepartemen")
    private Long id;
    @Column(unique = true)
    private String kodeDepartemen;
    private String namaDepartemen;
    private String keterangan;
    @OneToMany(mappedBy = "departemen")
    private List<Karyawan> karyawans;
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
        if (!(object instanceof Departemen)) {
            return false;
        }
        Departemen other = (Departemen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mii.hrd.entity.Departemen[ id=" + id + " ]";
    }

    /**
     * @return the kodeDepartemen
     */
    public String getKodeDepartemen() {
        return kodeDepartemen;
    }

    /**
     * @param kodeDepartemen the kodeDepartemen to set
     */
    public void setKodeDepartemen(String kodeDepartemen) {
        this.kodeDepartemen = kodeDepartemen;
    }

    /**
     * @return the namaDepartemen
     */
    public String getNamaDepartemen() {
        return namaDepartemen;
    }

    /**
     * @param namaDepartemen the namaDepartemen to set
     */
    public void setNamaDepartemen(String namaDepartemen) {
        this.namaDepartemen = namaDepartemen;
    }

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    /**
     * @return the karyawans
     */
    public List<Karyawan> getKaryawans() {
        return karyawans;
    }

    /**
     * @param karyawans the karyawans to set
     */
    public void setKaryawans(List<Karyawan> karyawans) {
        this.karyawans = karyawans;
    }
    
}
