package JDBCintro.Merchant1.Entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Payment {
    private int id;
    private Timestamp dt;
    private Merchant merchantId;
    private Customer customerId;
    private String goods;
    private double sumPaid;
    private double chargePaid;


    public Payment(int id, Timestamp dt, Merchant merchantId, Customer customerId, String goods, double sumPaid, double chargePaid) {
        this.id = id;
        this.dt = dt;
        this.merchantId = merchantId;
        this.customerId = customerId;
        this.goods = goods;
        this.sumPaid = sumPaid;
        this.chargePaid = chargePaid;
    }

    public Payment(Timestamp dt, Merchant merchantId, Customer customerId, String goods, double sumPaid, double chargePaid) {
        this.dt = dt;
        this.merchantId = merchantId;
        this.customerId = customerId;
        this.goods = goods;
        this.sumPaid = sumPaid;
        this.chargePaid = chargePaid;
    }

    public Payment() {
    };

    public Payment(int id, Timestamp dt, String goods, Double sumPaid, Double chargePaid) {
    }

    public Payment(Double totalSumPaid, String title, Integer id, Date lastSent) {

    }
// not sure if this one correct to use
//    public Payment(int id, Timestamp dt, String merchantId, String customerId, String goods, Double sumPaid, Double chargePaid) {
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDt() {
        return dt;
    }

    public void setDt(Timestamp dt) {
        this.dt = dt;
    }

    public Merchant getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Merchant merchantId) {
        this.merchantId = merchantId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public double getSumPaid() {
        return sumPaid;
    }

    public void setSumPaid(double sumPaid) {
        this.sumPaid = sumPaid;
    }

    public double getChargePaid() {
        return chargePaid;
    }

    public void setChargePaid(double chargePaid) {
        this.chargePaid = chargePaid;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", dt=" + dt +
                ", merchant=" + merchantId +
                ", customer=" + customerId +
                ", goods='" + goods + '\'' +
                ", sumPaid=" + sumPaid +
                ", chargePaid=" + chargePaid +
                '}';
    }
}
