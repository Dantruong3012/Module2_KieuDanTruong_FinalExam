package com.codegym.module2.kieudantruong;

import com.codegym.module2.kieudantruong.helper.HelperMethod;

public class Main {
    public static void main(String[] args) {
         HelperMethod helper = HelperMethod.getInstance();
         Contacts contacts = new Contacts(helper);
         DashBord  dashBord = new DashBord(helper, contacts);
         dashBord.displayDashBord();

    }
}
