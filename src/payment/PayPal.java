/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment;

import User.Users;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aleksa
 */
public class PayPal extends Payments {

    private List<Users> u;
    private String choice1;
    private String email;
    private String password;
    private Users user;
    private String amount1;

    public PayPal(List<Users> u) {
        this.u = u;
    }

    @Override
    protected void payment() {
        System.out.println("PayPal: please insert your email and password");

    }

    @Override
    protected void input() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("email: ");
        email = reader.readLine();
        System.out.println("password: ");
        password = reader.readLine();
    }

    @Override
    protected boolean validationSelection() {
        try {
            choice = Integer.parseInt(choice1);
            amount = Integer.parseInt(amount1);
            switch (choice) {
                case 1:
                    totalCost = 50 * amount;
                    System.out.println("Excellent choice! " + amount + "(Motherboard)");
                    break;
                case 2:
                    totalCost = 60 * amount;
                    System.out.println("Nice! " + amount + "(CPU)");
                    break;
                case 3:
                    totalCost = 70 * amount;
                    System.out.println("Use it wisely! " + amount + "(Graphic card)");
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    protected void select() throws Exception {
        System.out.println("Select product: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        choice1 = reader.readLine();
        System.out.println("Select amount: ");
        amount1 = reader.readLine();
    }

    @Override
    protected boolean validation() {
        for (Users u1 : u) {
            System.out.println(u1.getBalance());
            if (u1.getEmail().equals(this.email) && u1.getPassword().equals(this.password)) {
                user = u1;
                return true;
            }
        }
        return false;
    }

    @Override
    protected double checkBalance() {
        if (user.getBalance() - totalCost > 0) {
            for (Users u1 : u) {
                if (u1.getEmail().equals(this.email) && u1.getPassword().equals(this.password)) {
                    user = u1;
                    user.setBalance(u1.getBalance() - totalCost);
                    u1 = user;
                    return u1.getBalance() - totalCost;
                }
            }
        }
        return user.getBalance() - totalCost;
    }

}
