package com.codegym.module2.kieudantruong.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;



import java.util.Date;


public class HelperMethod {
    private static final Scanner sc = new Scanner(System.in);

    private static final HelperMethod instance = new  HelperMethod();

    private HelperMethod(){}

    public static HelperMethod getInstance(){
        return instance;
    }


    public int readInt(String promt, int min, int max) {
        while (true) {
            System.out.print(promt);
            try {
                int value = Integer.parseInt(sc.nextLine());
                if (value < min || value > max) {
                    System.out.println(("Please make sure the data you enter is valid. "));
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println(
                        "❌ Your selection is in the wrong format. It must be between " + min + " and " + max + ".");
            }
        }
    }


    public String readString(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine().trim();
        if (input == null) {
            System.out.println("You haven't input anythings!");
        }
        return input;
    }


    public Date readDate (String prompt){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        while (true) {
            try {
                System.out.print(prompt);
                String input = sc.nextLine();
                return sdf.parse(input);
            } catch (ParseException e) {
               System.out.println("❌ Invalid date format. Please use dd/MM/yyyy");
            }
        }
    }

    public String readPhone(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String phone = sc.nextLine();
                if (!phone.matches("^(0|\\+84)(3[2-9]|5[6|8|9]|7[0|6-9]|8[1-5]|9[0-4|6-9])[0-9]{7}$")) {
                    continue;
                }
                return phone;
            } catch (Exception e) {
                System.out.println("❌ Invalid phone number format. Please enter a valid phone number.");
            }
        }
    }


    public String readEmail(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String email = sc.nextLine();
                if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                    continue;
                }
                return email;
            } catch (Exception e) {
                System.out.println("❌ Invalid email format. Please enter a valid email address.");
            }
        }
    }

   
}
