package lld.atmv2.model;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Card {
    private String number;
    private String holderName;
    private int year;
    private int month;
    private int cvv;

    public Card(String number, String holderName, int year, int month, int cvv) {
        this.number = number;
        this.holderName = holderName;
        this.year = year;
        this.month = month;
        this.cvv = cvv;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
