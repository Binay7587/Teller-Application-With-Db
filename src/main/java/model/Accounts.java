/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package model;

/**
 *
 * @author Binay
 */
public class Accounts {

    private int accNumber;
    private String accName;
    private int accBalance;

    public Accounts(int accNumber, String accName, int accBalance) {
        this.accNumber = accNumber;
        this.accName = accName;
        this.accBalance = accBalance;
    }
    
    public int getAccNumber() {
        return accNumber;
    }

    public String getAccName() {
        return accName;
    }

    public int getAccBalance() {
        return accBalance;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public void setAccBalance(int accBalance) {
        this.accBalance = accBalance;
    }

}