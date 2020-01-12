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
@Table(name = "order_table", catalog = "inventorysystem", schema = "")
@NamedQueries({
    @NamedQuery(name = "OrderTable.findAll", query = "SELECT o FROM OrderTable o")
    , @NamedQuery(name = "OrderTable.findByOrderId", query = "SELECT o FROM OrderTable o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "OrderTable.findByCustomerName", query = "SELECT o FROM OrderTable o WHERE o.customerName = :customerName")
    , @NamedQuery(name = "OrderTable.findByPhoneNo", query = "SELECT o FROM OrderTable o WHERE o.phoneNo = :phoneNo")
    , @NamedQuery(name = "OrderTable.findByEMail", query = "SELECT o FROM OrderTable o WHERE o.eMail = :eMail")
    , @NamedQuery(name = "OrderTable.findByOrdNumber", query = "SELECT o FROM OrderTable o WHERE o.ordNumber = :ordNumber")
    , @NamedQuery(name = "OrderTable.findByOrdDate", query = "SELECT o FROM OrderTable o WHERE o.ordDate = :ordDate")
    , @NamedQuery(name = "OrderTable.findByProductName", query = "SELECT o FROM OrderTable o WHERE o.productName = :productName")
    , @NamedQuery(name = "OrderTable.findByProductId", query = "SELECT o FROM OrderTable o WHERE o.productId = :productId")
    , @NamedQuery(name = "OrderTable.findByPurchaseId", query = "SELECT o FROM OrderTable o WHERE o.purchaseId = :purchaseId")
    , @NamedQuery(name = "OrderTable.findByQuantity", query = "SELECT o FROM OrderTable o WHERE o.quantity = :quantity")
    , @NamedQuery(name = "OrderTable.findBySellPrice", query = "SELECT o FROM OrderTable o WHERE o.sellPrice = :sellPrice")
    , @NamedQuery(name = "OrderTable.findByTotalPrice", query = "SELECT o FROM OrderTable o WHERE o.totalPrice = :totalPrice")})
public class OrderTable implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    @Basic(optional = false)
    @Column(name = "customer_name")
    private String customerName;
    @Basic(optional = false)
    @Column(name = "phone_no")
    private String phoneNo;
    @Basic(optional = false)
    @Column(name = "e_mail")
    private String eMail;
    @Basic(optional = false)
    @Column(name = "ord_number")
    private String ordNumber;
    @Basic(optional = false)
    @Column(name = "ord_date")
    @Temporal(TemporalType.DATE)
    private Date ordDate;
    @Basic(optional = false)
    @Column(name = "product_name")
    private String productName;
    @Basic(optional = false)
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @Column(name = "purchase_id")
    private int purchaseId;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "sell_price")
    private int sellPrice;
    @Basic(optional = false)
    @Column(name = "total_price")
    private int totalPrice;

    public OrderTable() {
    }

    public OrderTable(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderTable(Integer orderId, String customerName, String phoneNo, String eMail, String ordNumber, Date ordDate, String productName, int productId, int purchaseId, int quantity, int sellPrice, int totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.phoneNo = phoneNo;
        this.eMail = eMail;
        this.ordNumber = ordNumber;
        this.ordDate = ordDate;
        this.productName = productName;
        this.productId = productId;
        this.purchaseId = purchaseId;
        this.quantity = quantity;
        this.sellPrice = sellPrice;
        this.totalPrice = totalPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        Integer oldOrderId = this.orderId;
        this.orderId = orderId;
        changeSupport.firePropertyChange("orderId", oldOrderId, orderId);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        String oldCustomerName = this.customerName;
        this.customerName = customerName;
        changeSupport.firePropertyChange("customerName", oldCustomerName, customerName);
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        String oldPhoneNo = this.phoneNo;
        this.phoneNo = phoneNo;
        changeSupport.firePropertyChange("phoneNo", oldPhoneNo, phoneNo);
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        String oldEMail = this.eMail;
        this.eMail = eMail;
        changeSupport.firePropertyChange("EMail", oldEMail, eMail);
    }

    public String getOrdNumber() {
        return ordNumber;
    }

    public void setOrdNumber(String ordNumber) {
        String oldOrdNumber = this.ordNumber;
        this.ordNumber = ordNumber;
        changeSupport.firePropertyChange("ordNumber", oldOrdNumber, ordNumber);
    }

    public Date getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(Date ordDate) {
        Date oldOrdDate = this.ordDate;
        this.ordDate = ordDate;
        changeSupport.firePropertyChange("ordDate", oldOrdDate, ordDate);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        String oldProductName = this.productName;
        this.productName = productName;
        changeSupport.firePropertyChange("productName", oldProductName, productName);
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        int oldProductId = this.productId;
        this.productId = productId;
        changeSupport.firePropertyChange("productId", oldProductId, productId);
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        int oldPurchaseId = this.purchaseId;
        this.purchaseId = purchaseId;
        changeSupport.firePropertyChange("purchaseId", oldPurchaseId, purchaseId);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        int oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        int oldSellPrice = this.sellPrice;
        this.sellPrice = sellPrice;
        changeSupport.firePropertyChange("sellPrice", oldSellPrice, sellPrice);
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        int oldTotalPrice = this.totalPrice;
        this.totalPrice = totalPrice;
        changeSupport.firePropertyChange("totalPrice", oldTotalPrice, totalPrice);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderTable)) {
            return false;
        }
        OrderTable other = (OrderTable) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "management.system.showTableLog.OrderTable[ orderId=" + orderId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
