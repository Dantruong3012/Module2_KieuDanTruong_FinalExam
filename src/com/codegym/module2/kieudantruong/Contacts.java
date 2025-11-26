package com.codegym.module2.kieudantruong;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import com.codegym.module2.kieudantruong.helper.HelperMethod;

public class Contacts {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

   
    private static final String DATA_FOLDER = "data";
    private static final String FILE_NAME = "contacts.csv";

    private List<Users> contactList = new ArrayList<>();
    private HelperMethod helper;

    public Contacts(HelperMethod helper) {
        this.helper = HelperMethod.getInstance();
        
        loadDataFromFile();
    }

   
    public void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("⚠️ Danh bạ trống!");
            return;
        }
        System.out.println("\n--- DANH SÁCH LIÊN HỆ ---");
        System.out.printf("%-15s %-15s %-25s %-10s %-20s\n", "Số ĐT", "Nhóm", "Họ tên", "Giới tính", "Địa chỉ");
        System.out.println("-----------------------------------------------------------------------------------------");
        for (Users user : contactList) {
            System.out.printf("%-15s %-15s %-25s %-10s %-20s\n",
                    user.getPhoneNumber(), user.getGroup(), user.getFullName(), user.getGender(), user.getAddress());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    
    public void addNewContact() {
        System.out.println("Adding new contact...");
        String phoneNumbe = helper.readPhone("Vui lòng nhập số điện thoại: ");
        String contactGroup = helper.readString("Vui lòng nhập nhóm của danh bạ: ");
        String contactName = helper.readString("Vui lòng nhập tên: ");
        String gender = helper.readString("Vui lòng nhập giới tính: ");
        String address = helper.readString("Vui lòng nhập địa chỉ: ");
        Date birthday = helper.readDate("Vui lòng nhập ngày sinh (dd/MM/yyyy): ");
        String email = helper.readEmail("Vui lòng nhập email: ");

        Users newUser = new Users(phoneNumbe, contactGroup, contactName, gender, address, birthday, email);
        contactList.add(newUser);

        System.out.println("✅ Thêm vào bộ nhớ thành công (Nhớ chọn chức năng 7 để Lưu vào file)!");
    }

   
    public void updateContact() {
        System.out.println("\n--- CẬP NHẬT THÔNG TIN ---");
        Users userToUpdate = null;
        String phoneToFind = helper.readPhone("Nhập số điện thoại cần sửa: ");

    
        for (Users user : contactList) {
            if (user.getPhoneNumber().equals(phoneToFind)) {
                userToUpdate = user;
                break;
            }
        }

        if (userToUpdate == null) {
            System.out.println("❌ Không tìm thấy số điện thoại " + phoneToFind + " trong danh bạ!");
            return;
        }

        System.out.println("Đã tìm thấy: " + userToUpdate.getFullName());
        System.out.println("👉 Nhấn [Enter] để giữ nguyên thông tin cũ.");

        String newGroup = helper.readString("Nhập nhóm danh bạ mới: ");
        if (!newGroup.isEmpty())
            userToUpdate.setGroup(newGroup);

        String newName = helper.readString("Nhập tên mới: ");
        if (!newName.isEmpty())
            userToUpdate.setFullName(newName);

        String newGender = helper.readString("Nhập giới tính mới: ");
        if (!newGender.isEmpty())
            userToUpdate.setGender(newGender);

        String newAddress = helper.readString("Nhập địa chỉ mới: ");
        if (!newAddress.isEmpty())
            userToUpdate.setAddress(newAddress);

       
        System.out.println("Lưu ý: Ngày sinh và Email chưa hỗ trợ bỏ qua (Enter). Vui lòng nhập lại.");
        Date newBirthDayStr = helper.readDate("Nhập ngày sinh (dd/MM/yyyy): ");
        userToUpdate.setBirthDay(newBirthDayStr);

        String newEmail = helper.readEmail("Nhập email: ");
        userToUpdate.setEmail(newEmail);

        System.out.println("✅ Cập nhật thông tin trên bộ nhớ thành công!");
    }

   
    public void deleteContact() {
        System.out.println("\n--- XÓA LIÊN HỆ ---");
        String phoneToFind = helper.readPhone("Nhập số điện thoại cần xóa: ");
        Users userToDelete = null;

        for (Users user : contactList) {
            if (user.getPhoneNumber().equals(phoneToFind)) {
                userToDelete = user;
                break;
            }
        }

        if (userToDelete == null) {
            System.out.println("Không tìm thấy số điện thoại này!");
            return;
        }

        System.out.println("Đã tìm thấy: " + userToDelete.getFullName());
        String confirmation = helper.readString("Bạn có chắc chắn muốn xoá liên hệ này? (Y/N): ");

        if (confirmation.equalsIgnoreCase("Y")) {
            contactList.remove(userToDelete);
            System.out.println("Xoá liên hệ thành công!");
        } else {
            System.out.println("Đã huỷ thao tác xóa.");
        }
    }

    public void searchContact() {
        System.out.println("\n--- TÌM KIẾM ---");
        String keyword = helper.readString("Nhập Số điện thoại hoặc Họ tên để tìm: ").toLowerCase();

        boolean found = false;
        System.out.println("Kết quả tìm kiếm:");
        for (Users user : contactList) {
            if (user.getPhoneNumber().contains(keyword) || user.getFullName().toLowerCase().contains(keyword)) {
                System.out.println(user); 
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ Không tìm thấy liên hệ nào phù hợp!");
        }
    }

    
    public void readFromFileFunction() {
        System.out.println("\nCẢNH BÁO: Thao tác này sẽ XÓA TOÀN BỘ danh bạ đang có trong bộ nhớ");
        System.out.println("và nạp lại dữ liệu từ file " + FILE_NAME + ".");

        String confirm = helper.readString("Bạn có chắc chắn muốn thực hiện? (Y/N): ");

        if (confirm.equalsIgnoreCase("Y")) {
            loadDataFromFile(); 
            System.out.println("Đã cập nhật lại danh bạ từ file!");
        } else {
            System.out.println(" Đã hủy thao tác đọc file.");
        }
    }

    
    public void writeToFileFunction() {
        System.out.println("\nCẢNH BÁO: Thao tác này sẽ GHI ĐÈ toàn bộ dữ liệu trong file");
        System.out.println("bằng dữ liệu danh bạ hiện tại đang có.");

        String confirm = helper.readString("Bạn có chắc chắn muốn thực hiện? (Y/N): ");

        if (confirm.equalsIgnoreCase("Y")) {
            saveDataToFile(); 
            System.out.println("Đã lưu danh bạ vào file thành công!");
        } else {
            System.out.println("Đã hủy thao tác lưu file.");
        }
    }

    
    private String getFilePath() {
        File folder = new File(DATA_FOLDER);
        if (!folder.exists()) {
            folder.mkdir();
        }
        return DATA_FOLDER + File.separator + FILE_NAME;
    }

    private void loadDataFromFile() {
        File file = new File(getFilePath());
        if (!file.exists())
            return;

        contactList.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue;
                String[] data = line.split(",");
                
                if (data.length == 7) {
                    try {
                        Users user = new Users(
                                data[0].trim(), data[1].trim(), data[2].trim(),
                                data[3].trim(), data[4].trim(),
                                sdf.parse(data[5].trim()), data[6].trim());
                        contactList.add(user);
                    } catch (Exception e) {
                        System.out.println(" Lỗi định dạng dữ liệu trong file: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void saveDataToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(getFilePath()))) {
            for (Users user : contactList) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s",
                        user.getPhoneNumber(), user.getGroup(), user.getFullName(),
                        user.getGender(), user.getAddress(),
                        sdf.format(user.getBirthDay()), user.getEmail());

                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}