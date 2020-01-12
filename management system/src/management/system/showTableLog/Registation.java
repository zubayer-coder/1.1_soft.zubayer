/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.system.showTableLog;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "registation", catalog = "inventorysystem", schema = "")
@NamedQueries({
    @NamedQuery(name = "Registation.findAll", query = "SELECT r FROM Registation r")
    , @NamedQuery(name = "Registation.findByRegId", query = "SELECT r FROM Registation r WHERE r.regId = :regId")
    , @NamedQuery(name = "Registation.findByName", query = "SELECT r FROM Registation r WHERE r.name = :name")
    , @NamedQuery(name = "Registation.findByFname", query = "SELECT r FROM Registation r WHERE r.fname = :fname")
    , @NamedQuery(name = "Registation.findByAddress", query = "SELECT r FROM Registation r WHERE r.address = :address")
    , @NamedQuery(name = "Registation.findByPhone", query = "SELECT r FROM Registation r WHERE r.phone = :phone")
    , @NamedQuery(name = "Registation.findByMail", query = "SELECT r FROM Registation r WHERE r.mail = :mail")
    , @NamedQuery(name = "Registation.findByUname", query = "SELECT r FROM Registation r WHERE r.uname = :uname")
    , @NamedQuery(name = "Registation.findByPass", query = "SELECT r FROM Registation r WHERE r.pass = :pass")})
public class Registation implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reg_id")
    private Integer regId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "fname")
    private String fname;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @Column(name = "uname")
    private String uname;
    @Basic(optional = false)
    @Column(name = "pass")
    private String pass;

    public Registation() {
    }

    public Registation(Integer regId) {
        this.regId = regId;
    }

    public Registation(Integer regId, String name, String fname, String address, String phone, String mail, String uname, String pass) {
        this.regId = regId;
        this.name = name;
        this.fname = fname;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
        this.uname = uname;
        this.pass = pass;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        Integer oldRegId = this.regId;
        this.regId = regId;
        changeSupport.firePropertyChange("regId", oldRegId, regId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        String oldFname = this.fname;
        this.fname = fname;
        changeSupport.firePropertyChange("fname", oldFname, fname);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        String oldMail = this.mail;
        this.mail = mail;
        changeSupport.firePropertyChange("mail", oldMail, mail);
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        String oldUname = this.uname;
        this.uname = uname;
        changeSupport.firePropertyChange("uname", oldUname, uname);
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        String oldPass = this.pass;
        this.pass = pass;
        changeSupport.firePropertyChange("pass", oldPass, pass);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regId != null ? regId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registation)) {
            return false;
        }
        Registation other = (Registation) object;
        if ((this.regId == null && other.regId != null) || (this.regId != null && !this.regId.equals(other.regId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "management.system.showTableLog.Registation[ regId=" + regId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
