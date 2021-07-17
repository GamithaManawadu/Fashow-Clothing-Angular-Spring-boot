package net.shoppingstore.supplyitemsapi.model;

import javax.persistence.*;

@Entity
@Table(name = "buyers")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "buyer_name")
    private String buyerName;

    @Column(name = "buyer_email")
    private String buyerEmail;

    @Column(name = "buyer_mobile")
    private String buyerMobile;

    @Column(name = "buyer_address")
    private String buyerAddress;

    public Buyer() {

    }

    public Buyer(long id, String buyerName, String buyerEmail, String buyerMobile, String buyerAddress) {
        super();
        this.id = id;
        this.buyerName = buyerName;
        this.buyerEmail = buyerEmail;
        this.buyerMobile = buyerMobile;
        this.buyerAddress = buyerAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getBuyerMobile() {
        return buyerMobile;
    }

    public void setBuyerMobile(String buyerMobile) {
        this.buyerMobile = buyerMobile;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }
}
