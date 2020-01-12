/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.system.showTableLog;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "purchase", catalog = "inventorysystem", schema = "")
@NamedQueries({
    @NamedQuery(name = "Purchase.findAll", query = "SELECT p FROM Purchase p")
    , @NamedQuery(name = "Purchase.findByPurchaseId", query = "SELECT p FROM Purchase p WHERE p.purchaseId = :purchaseId")
    , @NamedQuery(name = "Purchase.findByProductId", query = "SELECT p FROM Purchase p WHERE p.productId = :productId")
    , @NamedQuery(name = "Purchase.findByQuantity", query = "SELECT p FROM Purchase p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "Purchase.findByPPrice", query = "SELECT p FROM Purchase p WHERE p.pPrice = :pPrice")
    , @NamedQuery(name = "Purchase.findByTotalPrice", query = "SELECT p FROM Purchase p WHERE p.totalPrice = :totalPrice")
    , @NamedQuery(name = "Purchase.findByPDate", query = "SELECT p FROM Purchase p WHERE p.pDate = :pDate")
    , @NamedQuery(name = "Purchase.findByProductName", query = "SELECT p FROM Purchase p WHERE p.productName = :productName")})
public class Purchase implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "purchase_id")
    private Integer purchaseId;
    @Basic(optional = false)
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @Column(name = "quantity")
    private String quantity;
    @Basic(optional = false)
    @Column(name = "pPrice")
    private String pPrice;
    @Basic(optional = false)
    @Column(name = "totalPrice")
    private String totalPrice;
    @Basic(optional = false)
    @Column(name = "pDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pDate;
    @Basic(optional = false)
    @Column(name = "product_name")
    private String productName;

    public Purchase() {
    }

    public Purchase(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Purchase(Integer purchaseId, int productId, String quantity, String pPrice, String totalPrice, Date pDate, String productName) {
        this.purchaseId = purchaseId;
        this.productId = productId;
        this.quantity = quantity;
        this.pPrice = pPrice;
        this.totalPrice = totalPrice;
        this.pDate = pDate;
        this.productName = productName;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        Integer oldPurchaseId = this.purchaseId;
        this.purchaseId = purchaseId;
        changeSupport.firePropertyChange("purchaseId", oldPurchaseId, purchaseId);
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        int oldProductId = this.productId;
        this.productId = productId;
        changeSupport.firePropertyChange("productId", oldProductId, productId);
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        String oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public String getPPrice() {
        return pPrice;
    }

    public void setPPrice(String pPrice) {
        String oldPPrice = this.pPrice;
        this.pPrice = pPrice;
        changeSupport.firePropertyChange("PPrice", oldPPrice, pPrice);
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        String oldTotalPrice = this.totalPrice;
        this.totalPrice = totalPrice;
        changeSupport.firePropertyChange("totalPrice", oldTotalPrice, totalPrice);
    }

    public Date getPDate() {
        return pDate;
    }

    public void setPDate(Date pDate) {
        Date oldPDate = this.pDate;
        this.pDate = pDate;
        changeSupport.firePropertyChange("PDate", oldPDate, pDate);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        String oldProductName = this.productName;
        this.productName = productName;
        changeSupport.firePropertyChange("productName", oldProductName, productName);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseId != null ? purchaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchase)) {
            return false;
        }
        Purchase other = (Purchase) object;
        if ((this.purchaseId == null && other.purchaseId != null) || (this.purchaseId != null && !this.purchaseId.equals(other.purchaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "management.system.showTableLog.Purchase[ purchaseId=" + purchaseId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
