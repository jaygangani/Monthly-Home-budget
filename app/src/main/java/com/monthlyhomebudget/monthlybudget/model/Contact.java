package com.monthlyhomebudget.monthlybudget.model;

public class Contact {
    private int id;
    private String Date;
    private String Description;
    private String Amount;
    private String Catagory;
    private String Endofdaybalance;

//    public Contact()
//    {
//        this.Date=Date;
//        this.Description=Description;
//        this.Amount=Amount;
//        this.Catagory=Catagory;
//        this.Endofdaybalance=Endofdaybalance;
//    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    public String getDescription()
    {
        return Description;
    }
    public void setDescription(String Description)
    {
        this.Description=Description;
    }
    public String getAmount()
    {
        return Amount;
    }
    public void setAmount(String Amount)
    {
        this.Amount=Amount;
    }
    public String getCatagory()
    {
        return Catagory;
    }
    public void setCatagory(String Catagory)
    {
        this.Catagory=Catagory;
    }
    public String getEndofdaybalance()
    {
        return Endofdaybalance;
    }
    public void setEndofdaybalance(String Endofdaybalance)
    {
        this.Endofdaybalance=Endofdaybalance;
    }
}
