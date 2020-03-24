package JDBCintro.Merchant1.Entities;

import java.sql.Date;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String address;
    private String eMail;
    private String ccNo;
    private String ccType;
    private Date maturity;
    private List<Payment>payments;

    //todo  convert java.sql.Date  to localDate format(do not use Java
    //String str = "2000-10-10"
    // Date date = Date.valueOf(str);
    public Customer(int id, String name, String address, String eMail, String ccNo, String ccType, Date maturity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.eMail = eMail;
        this.ccNo = ccNo;
        this.ccType = ccType;
        this.maturity = maturity;
    }

    public Customer(String name, String address, String eMail, String ccNo, String ccType, Date maturity) {
        this.name = name;
        this.address = address;
        this.eMail = eMail;
        this.ccNo = ccNo;
        this.ccType = ccType;
        this.maturity = maturity;
    }

    public Customer(int id) {
        this.id = id;
    }

    public Customer() {

    }


    public Customer(int id, String name) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getCcNo() {
        return ccNo;
    }

    public void setCcNo(String ccNo) {
        this.ccNo = ccNo;
    }

    public String getCcType() {
        return ccType;
    }

    public void setCcType(String ccType) {
        this.ccType = ccType;
    }

    public Date getMaturity() {
        return maturity;
    }

    public void setMaturity(Date maturity) {
        this.maturity = maturity;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", eMail='" + eMail + '\'' +
                ", Credit Card No='" + ccNo + '\'' +
                ", Credit Card Type='" + ccType + '\'' +
                ", Maturity Date=" + maturity +
                '}';
    }


}
