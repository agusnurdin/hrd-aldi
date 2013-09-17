/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.hrd.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Rinaldi
 */
@Entity
public class RiwayatCuti implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alasan;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mulai;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date selesai;
    @ManyToOne
    private Karyawan karyawan;
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
        if (!(object instanceof RiwayatCuti)) {
            return false;
        }
        RiwayatCuti other = (RiwayatCuti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mii.hrd.entity.RiwayatCuti[ id=" + id + " ]";
    }

    /**
     * @return the alasan
     */
    public String getAlasan() {
        return alasan;
    }

    /**
     * @param alasan the alasan to set
     */
    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    /**
     * @return the mulai
     */
    public Date getMulai() {
        return mulai;
    }

    /**
     * @param mulai the mulai to set
     */
    public void setMulai(Date mulai) {
        this.mulai = mulai;
    }

    /**
     * @return the selesai
     */
    public Date getSelesai() {
        return selesai;
    }

    /**
     * @param selesai the selesai to set
     */
    public void setSelesai(Date selesai) {
        this.selesai = selesai;
    }

    /**
     * @return the karyawan
     */
    public Karyawan getKaryawan() {
        return karyawan;
    }

    /**
     * @param karyawan the karyawan to set
     */
    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }
    
}
