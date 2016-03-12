package by.tvoibanki.domain;

import javax.persistence.*;

@Entity
@Table
public class Bank {

    @Column @Id
    private Long id;
    private String name;
    private int usdBuyRate;
    private int usdSellRate;
    private int eurBuyRate;
    private int eurSellRate;
    private int rubBuyRate;
    private int rubSellRate;
    private double eurTousdConversion;
    private double eurTorubConversion;
    private double usdTorubConversion;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUsdBuyRate() {
        return usdBuyRate;
    }

    public void setUsdBuyRate(int usdBuyRate) {
        this.usdBuyRate = usdBuyRate;
    }

    public int getUsdSellRate() {
        return usdSellRate;
    }

    public void setUsdSellRate(int usdSellRate) {
        this.usdSellRate = usdSellRate;
    }

    public int getEurBuyRate() {
        return eurBuyRate;
    }

    public void setEurBuyRate(int eurBuyRate) {
        this.eurBuyRate = eurBuyRate;
    }

    public int getEurSellRate() {
        return eurSellRate;
    }

    public void setEurSellRate(int eurSellRate) {
        this.eurSellRate = eurSellRate;
    }

    public int getRubBuyRate() {
        return rubBuyRate;
    }

    public void setRubBuyRate(int rubBuyRate) {
        this.rubBuyRate = rubBuyRate;
    }

    public int getRubSellRate() {
        return rubSellRate;
    }

    public void setRubSellRate(int rubSellRate) {
        this.rubSellRate = rubSellRate;
    }

    public double getEurTousdConversion() {
        return eurTousdConversion;
    }

    public void setEurTousdConversion(double eurTousdConversion) {
        this.eurTousdConversion = eurTousdConversion;
    }

    public double getEurTorubConversion() {
        return eurTorubConversion;
    }

    public void setEurTorubConversion(double eurTorubConversion) {
        this.eurTorubConversion = eurTorubConversion;
    }

    public double getUsdTorubConversion() {
        return usdTorubConversion;
    }

    public void setUsdTorubConversion(double usdTorubConversion) {
        this.usdTorubConversion = usdTorubConversion;
    }
}
