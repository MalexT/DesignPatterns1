/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment;

import User.Users;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksa
 */
abstract public class Payments {

    double totalCost;
    int choice;
    int amount;

    public void show() {
        System.out.println("Welcome to the shop.\nPlease choose your product.");
        System.out.println("1.Motherboard $50");
        System.out.println("2.CPU $60");
        System.out.println("3.Graphics card $70");
    }

    abstract protected void payment();

    abstract protected void input() throws Exception;

    abstract protected boolean validationSelection();

    abstract protected boolean validation();

    abstract protected double checkBalance();

    abstract protected void select() throws Exception;

    public void execute() {

        show();
        try {
            select();
        } catch (Exception ex) {
            System.out.println("Invalid selection.");
            return;
        }
        if (!validationSelection()) {
            System.out.println("Validation selection failed.");
            return;
        }
        payment();
        try {
            input();
        } catch (Exception ex) {
            System.out.println("Invalid input.");
            return;
        }
        if (!validation()) {
            System.out.println("Validation failed.");
            return;
        }
        if (checkBalance() >= 0.00) {
            System.out.println("Payment was successful.");
            System.out.println("Amount left: " + checkBalance());
            System.out.println("");
        } else {
            System.out.println("Payment was not successful. Not enough funds. " + checkBalance());
        }

    }
}
