/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Users;

/**
 *
 * @author Binay
 */
public class UserHandler {

    ArrayList<Users> usr = new ArrayList<>();

    public boolean login(String uName, String uPassword) {
        for (Users us : usr) {
            if (us.getUserName().equalsIgnoreCase(uName) && us.getPassword().equalsIgnoreCase(uPassword)) {
                return true;
            }
        }
        if (uName.equalsIgnoreCase("admin") && uPassword.equalsIgnoreCase("admin")) {
            return true;
        } else {
            return false;
        }
    }

    public Users findUser(String uName) {
        for (Users us : usr) {
            if (uName.equalsIgnoreCase(us.getUserName())) {
                return us;
            }
        }
        return null;
    }

    public boolean addUser(String uName, String uPass) {
        Users us = new Users(uName, uPass);
        if (findUser(uName) == null) {
            this.usr.add(us);
            return true;
        }
        return false;
    }
    
    public ArrayList<Users> listUsers() {
        if (usr != null) {
            for (Users us : usr) {
                System.out.println("*********************************");
                System.out.println("Account Name: "+us.getUserName());
                System.out.println("Account Number: "+us.getPassword());
                System.out.println("********************************");
            }
            return null;
        }
        System.out.println("There are no users.");
        return null;
    }
    
    public int deleteUser(String uName) {
        if (findUser(uName) != null) {
            Users us = findUser(uName);
            this.usr.remove(us);
            return 1;
        }
        return 0;
    }
}
