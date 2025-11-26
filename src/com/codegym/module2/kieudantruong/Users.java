package com.codegym.module2.kieudantruong;

import java.util.Date;

public class Users {

   private String phoneNumber;
   private String group;
   private String fullName;
   private String gender;
   private Date birthDay;
   private String address;
   private String email;

   public Users(String phoneNumber, String group, String fullName, String gender, String address, Date birthDay, String email) {
    this.phoneNumber = phoneNumber;
    this.group = group;
    this.fullName = fullName;
    this.gender = gender;
    this.address = address;
    this.birthDay = birthDay;
    this.email = email;
   }

   public String getPhoneNumber() {
    return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
   }

   public String getGroup() {
    return group;
   }

   public void setGroup(String group) {
    this.group = group;
   }

   public String getFullName() {
    return fullName;
   }

   public void setFullName(String fullName) {
    this.fullName = fullName;
   }

   public String getGender() {
    return gender;
   }

   public void setGender(String gender) {
    this.gender = gender;
   }

   public String getAddress() {
    return address;
   }

   public void setAddress(String address) {
    this.address = address;
   }

   public Date getBirthDay() {
    return birthDay;
   }

   public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
   }

   public String getEmail() {
    return email;
   }

   public void setEmail(String email) {
    this.email = email;
   }

   @Override
   public String toString() {
       return "---------------------------" + "\n" +
               "Nhóm     : " + group + "\n" +
               "Họ tên   : " + fullName + "\n" +
               "Giới tính: " + gender + "\n" +
               "Địa chỉ  : " + address;
   }

}
