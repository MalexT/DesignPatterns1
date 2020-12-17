/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import User.Users;
import java.util.ArrayList;
import java.util.List;
import payment.DebitCard;
import payment.PayPal;
import payment.Payments;

/**
 *
 * @author Aleksa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Users> users1 = new ArrayList<>();
        users1.add(new Users("1234", "test", 500, 423));
        users1.add(new Users("12345", "test", 100, 423));
        users1.add(new Users("123", "test", 50, 423));
        
        Payments p = new PayPal(users1);
        p.execute();
        System.out.println("");
//        p = new DebitCard(users1);
//        p.execute();
    }
    
}
