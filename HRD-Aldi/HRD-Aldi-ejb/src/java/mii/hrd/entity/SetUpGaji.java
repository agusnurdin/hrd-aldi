/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Rinaldi
 */
@Entity
public class SetUpGaji implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namaGolongan;
    private double gajiPokok;
    
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
        if (!(object instanceof SetUpGaji)) {
            return false;
        }
        SetUpGaji other = (SetUpGaji) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mii.hrd.entity.SetUpGaji[ id=" + id + " ]";
    }

    /**
     * @return the namaGolongan
     */
    public String getNamaGolongan() {
        return namaGolongan;
    }

    /**
     * @param namaGolongan the namaGolongan to set
     */
    public void setNamaGolongan(String namaGolongan) {
        this.namaGolongan = namaGolongan;
    }

    /**
     * @return the gajiPokok
     */
    public double getGajiPokok() {
        return gajiPokok;
    }

    /**
     * @param gajiPokok the gajiPokok to set
     */
    public void setGajiPokok(double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }
    
}
