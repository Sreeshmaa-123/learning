package com.cg.oops;

import java.util.Scanner;

abstract class DesertItem {
    abstract public int getCost();
}

class Candy extends DesertItem {
    Scanner sc = new Scanner(System.in);
    int TotalCandies = 0;
    int DollarRupee = 60;

    public int addCandies(int candies) {
        this.TotalCandies += candies;
        return TotalCandies;
    }

    @Override
    public int getCost() {
        TotalCandies = sc.nextInt();
        return TotalCandies * DollarRupee;
    }
}

class Cookie extends DesertItem {
    Scanner sc = new Scanner(System.in);
    int TotalCookies = 0;
    int EuroRupee = 70;

    public int addCookies(int cookies) {
        this.TotalCookies += cookies;
        return TotalCookies;
    }

    @Override
    public int getCost() {
        TotalCookies = sc.nextInt();
        return TotalCookies * EuroRupee; // Corrected this line
    }
}

class Icecream extends DesertItem {
    Scanner sc = new Scanner(System.in);
    int TotalIcecream = 0;
    int costinRupees = 1;

    public int addIcecream(int icecream) {
        TotalIcecream += icecream;
        return TotalIcecream;
    }

    @Override
    public int getCost() {
        TotalIcecream = sc.nextInt();
        return TotalIcecream * costinRupees;
    }
}

public class DesertShop {
    Scanner sc = new Scanner(System.in);
    Candy candy = new Candy();
    Cookie cookie = new Cookie();
    Icecream icecream = new Icecream();

    private void selectRoles() {
        System.out.println("Enter your role customer or owner");
        String role;
        role = sc.next();
        roles(role);
    }

    private void roles(String role) {
        if (role.toUpperCase().equals("CUSTOMER")) {
            placeOrder();
        } else if (role.toUpperCase().equals("OWNER")) {
            addItems();
        } else
            System.out.println("Please enter valid details!");
    }

    private void addItems() {
        System.out.println("Choose items to add:");
        System.out.println("1.Candy\n2.Cookie\n3.Ice Cream");
        System.out.println("Enter your choice:");
        int ch;
        ch = sc.nextInt();
        addItemsOperation(ch);
    }

    private void addItemsOperation(int choice) {
        int amount; // Declare amount here
        int total = 0; // Initialize total here
        switch (choice) {
            case 1:
                System.out.println("Enter amount of candies");
                amount = sc.nextInt();
                total = candy.addCandies(amount);
                System.out.println("Candies added successfully" + total);
                break;
            case 2:
                System.out.println("Enter amount of cookies");
                amount = sc.nextInt();
                total = cookie.addCookies(amount);
                System.out.println("Cookies added successfully" + total);
                break;
            case 3:
                System.out.println("Enter amount of Icecream");
                amount = sc.nextInt();
                total = icecream.addIcecream(amount);
                System.out.println("Icecream added successfully" + total);
                break;
            default:
                System.out.println("please enter a valid number!");
                break;
        }
    }

    private void placeOrder() {
        System.out.println("Choose items to be placed:");
        System.out.println("1.Candy\n2.Cookie\n3.Icecream");
        System.out.println("Enter your choice:");
        int ch;
        ch = sc.nextInt();
        placeOrderOperation(ch);
    }

    private void placeOrderOperation(int choice) {
        int total = 0; // Initialize total here
        switch (choice) {
            case 1:
                System.out.println("Enter the amount of candies");
                total = candy.getCost();
                System.out.println("Candies placed successfully and total cost is: " + total);
                break;
            case 2:
                System.out.println("Enter amount of cookies");
                total = cookie.getCost();
                System.out.println("Cookies placed successfully and total cost is: " + total);
                break;
            case 3:
                System.out.println("Enter amount of Icecream");
                total = icecream.getCost();
                System.out.println("Icecream placed successfully and total cost is: " + total);
                break;
            default:
                System.out.println("please enter a valid number!");
                break;
        }
    }

    public static void main(String args[]) {
        DesertShop desert = new DesertShop();
        desert.selectRoles();
    }
}
