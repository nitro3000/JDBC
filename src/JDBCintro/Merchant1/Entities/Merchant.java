package JDBCintro.Merchant1.Entities;

import java.sql.Date;

public class Merchant {
    private int id;
    private String title;
    private String bankName;
    private String swift;
    private String account;
    private double charge;
    private int period;
    private double minSum;
    private double needToSend;
    private double sent;
    private Date lastSent;

    public Merchant(int id, String title, String bankName, String swift, String account, double charge,
                    int period, double minSum, double needToSend, double sent, Date lastSent) {
        this.id = id;
        this.title = title;
        this.bankName = bankName;
        this.swift = swift;
        this.account = account;
        this.charge = charge;
        this.period = period;
        this.minSum = minSum;
        this.needToSend = needToSend;
        this.sent = sent;
        this.lastSent = lastSent;
    }

    public Merchant(String title, String bankName, String swift, String account, double charge,
                    int period, double minSum, double needToSend, double sent, Date lastSent) {
        this.title = title;
        this.bankName = bankName;
        this.swift = swift;
        this.account = account;
        this.charge = charge;
        this.period = period;
        this.minSum = minSum;
        this.needToSend = needToSend;
        this.sent = sent;
        this.lastSent = lastSent;
    }

    public Merchant(int id) {
    };


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getMinSum() {
        return minSum;
    }

    public void setMinSum(double minSum) {
        this.minSum = minSum;
    }

    public double getNeedToSend() {
        return needToSend;
    }

    public void setNeedToSend(double needToSend) {
        this.needToSend = needToSend;
    }

    public double getSent() {
        return sent;
    }

    public void setSent(double sent) {
        this.sent = sent;
    }

    public Date getLastSent() {
        return lastSent;
    }

    public void setLastSent(Date lastSent) {
        this.lastSent = lastSent;
    }


    @Override
    public String toString() {
        return "Merchant{" +
                "Id=" + id +
                ", Title='" + title + '\'' +
                ", Bank Name='" + bankName + '\'' +
                ", Swift='" + swift + '\'' +
                ", Account='" + account + '\'' +
                ", Charge=" + charge +
                ", Period=" + period +
                ", Min Sum=" + minSum +
                ", Need To Send=" + needToSend +
                ", Sent=" + sent +
                ", Last Sent Date=" + lastSent +
                '}';
    }
}
