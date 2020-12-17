/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aleksa
 */
public class Users {
 
    String password;
    String email;
    double balance;
    int cvs;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCvs() {
        return cvs;
    }

    public void setCvs(int cvs) {
        this.cvs = cvs;
    }
    

    public Users(String password, String email, double balance, int cvs) {
        this.password = password;
        this.email = email;
        this.balance = balance;
        this.cvs = cvs;
    }
    
}
