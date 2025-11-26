package com.codegym.module2.kieudantruong;

import com.codegym.module2.kieudantruong.helper.HelperMethod;

public class DashBord {
    private HelperMethod helper;
    private Contacts contacts;

    public DashBord(HelperMethod helper , Contacts contacts) {
        this.helper = helper;
        this.contacts = contacts;
    }

    public void displayDashBord() {
        boolean running = true;
        while (running) {
            System.out.println("------ CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ------");
            System.out.println("chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Xem danh sách.");
            System.out.println("2. Thêm mới.");
            System.out.println("3. Cập nhật.");
            System.out.println("4. Xoá.");
            System.out.println("5. Tìm kiếm.");
            System.out.println("6. Đọc từ file.");
            System.out.println("7. Ghi vào file.");
            System.out.println("8. Thoát.");

            int selection = helper.readInt("Chức năng: ", 1, 8);

            switch (selection) {
                case 1:
                    contacts.displayContacts();
                    break;
                case 2:
                    contacts.addNewContact();
                    break;
                case 3:
                    contacts.updateContact();
                    break;
                case 4:
                    contacts.deleteContact();
                    break;
                case 5:
                    contacts.searchContact();
                    break;

                case 6:
                    contacts.readFromFileFunction(); 
                    break;
                case 7:
                    contacts.writeToFileFunction(); 
                    break;

                case 8:
                    System.out.println("Đã thoát khỏi bảng điều khiển. ");
                    running = false;
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ!");
                    break;
            }
        }
    }
}
