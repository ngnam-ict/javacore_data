/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Assignment_1 {

    /**
     * @param args the command line arguments
     */
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Employee> list = new ArrayList<>();
    public static void main(String[] args) {
        // TODO code application logic here
        int choose;
        boolean check = true;
        while(check){
            System.out.println("****************************************************");
            System.out.println("1.Nhap danh sach nhan vien");
            System.out.println("2.Xuat danh sach nhan vien");
            System.out.println("3.Tim va hien thi nhan vien theo ma");
            System.out.println("4.Xoa nhan vien theo ma");
            System.out.println("5.Cap nhap thong tin nhan vien theo ma");
            System.out.println("6.Tim cac nhan vien theo khoang luong");
            System.out.println("7.Sap xep nhan vien theo ho va ten");
            System.out.println("8.Sap xep nhan vien theo thu nhap");
            System.out.println("9.Xuat 5 nhan vien co thu nhap cao nhat");
            System.out.println("0.Ket thuc");
            System.out.println("****************************************************");
            System.err.print("Nhap so can chon:");
            choose = Integer.parseInt(scanner.nextLine());
            
            switch(choose){
                case 1:{
                    enterEmployee();
                    break;
                }
                case 2:{
                    exportEmployee();
                    break;
                }
                case 3:{
                    searchByID();
                    break;
                }
                case 4:{
                    deleteByID();
                    break;
                }
                case 5:{
                    updateByID();
                    break;
                }
                case 6:{
                    searchBySalary();
                    break;
                }
                case 7:{
                    sortByName();
                    break;
                }
                case 8:{
                    sortBySalary();
                    break;
                }
                case 9:{
                    exportTop5Salary();
                    break;
                }
                case 0:{
                    check = false;
                    break;
                }
            }
        }  
    }
    public static void enterEmployee(){
        System.err.print("Nhap so nhan vien can them: ");
        int soNV = Integer.parseInt(scanner.nextLine());
        String idPattern = "TT\\w{8}||TP\\w{8}||tt\\w{8}||tp\\w{8}";
        String id;
        String fullName;
        double sales;
        double commission;
        double responsibleWage;
        double salary;
        for (int i = 0; i < soNV; i++) {
            System.out.println("Nhap thong tin nhan vien thu " + (i+1) +": ");
            while (true) {                   
                System.err.print("Nhap ma nhan vien: ");
                id = scanner.nextLine().trim();
                if(id.matches(idPattern)){
                    int count = 0;
                    for (int j = 0; j < list.size(); j++) {
                        Employee get = list.get(j);
                        if(id.equalsIgnoreCase(list.get(j).id)){
                            count++;
                        }
                    }
                    if(count==0){
                        break;
                    }
                    else{
                        System.out.println("Ban nhap trung ma, moi nhap lai!");
                    }
                }else{
                    System.out.println("Ban nhap sai, moi nhap lai!");
                }
            }
            System.err.print("Nhap ten nhan vien: ");
            fullName = scanner.nextLine();
            System.err.print("Nhap luong nhan vien: ");
            salary = Double.parseDouble(scanner.nextLine());
            
            
            if(id.substring(0,2).equalsIgnoreCase("TT")){
                Marketing emMar = new Marketing(id,fullName, salary);
                System.err.print("Nhap doanh so cua thang: ");
                sales = Double.parseDouble(scanner.nextLine());
                emMar.setSales(sales);
                System.err.print("Nhap ti le hue hong(0.?): ");
                commission = Double.parseDouble(scanner.nextLine());
                emMar.setCommission(commission);
                list.add(emMar);
            }
            if(id.substring(0,2).equalsIgnoreCase("TP")){
                Manager emMan = new Manager(id, fullName, salary);
                System.err.print("Nhap luong trach nhiem cua truong phong: ");
                responsibleWage = Double.parseDouble(scanner.nextLine());
                emMan.setResponsibleWage(responsibleWage);
                list.add(emMan);
            }           
        }
    }
    
    //Xuat danh sach nhan vien
    public static void exportEmployee(){
        System.out.println("Danh Sach Nhan Vien!");
        for (int i = 0; i < list.size(); i++) {
            Employee get = list.get(i);
            get.output();
        }
    }
    //Tim kiem nhan vien theo ma
    public static void searchByID(){
        System.err.print("Nhap ma nhan vien can tim: ");
        String idNhanVien = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            Employee get = list.get(i);
            if(idNhanVien.equalsIgnoreCase(list.get(i).id)){
                get.output();
            }
        }
    }
    //Xoa nhan vien theo ma
    public static void deleteByID(){
        System.err.print("Nhap ma nhan vien can xoa: ");
        String idNhanVien = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            Employee get = list.get(i);
            if(idNhanVien.equalsIgnoreCase(list.get(i).id)){
                list.remove(i);
            }
        }
    }
    //Cap nhat thong tin nhan vien theo ma
    public static void updateByID(){
        
        System.err.print("Nhap ma nhan vien can tim: ");
        String id = scanner.nextLine();
        String fullName;
        double sales;
        double commission;
        double responsibleWage;
        double salary;
        for (int i = 0; i < list.size(); i++) {
            Employee get = list.get(i);
            if(id.equalsIgnoreCase(list.get(i).id)){
                System.err.print("Nhap ten nhan vien: ");
                fullName = scanner.nextLine();
                System.err.print("Nhap luong nhan vien: ");
                salary = Double.parseDouble(scanner.nextLine());
            
                if(id.substring(0,2).equalsIgnoreCase("TT")){
                    Marketing nvTT = new Marketing(id,fullName, salary);
                    System.err.print("Nhap doanh so cua thang: ");
                    sales = Double.parseDouble(scanner.nextLine());
                    nvTT.setSales(sales);
                    System.err.print("Nhap ti le hue hong(0.?): ");
                    commission = Double.parseDouble(scanner.nextLine());
                    nvTT.setCommission(commission);
                    list.set(i, nvTT);
                }
                if(id.substring(0,2).equalsIgnoreCase("TP")){
                    Manager nvTP = new Manager(id, fullName, salary);
                    System.err.print("Nhap luong trach nhiem cua truong phong: ");
                    responsibleWage = Double.parseDouble(scanner.nextLine());
                    nvTP.setResponsibleWage(responsibleWage);
                    list.set(i, nvTP);
                }
            }
        }
    }
    //tim kiem nhan vien theo khoang luong
    public static void searchBySalary(){
        System.out.println("Nhap khoang luong muon tim!");
        System.err.print("Nhap luong nho nhat: ");
        double minSalary = Double.parseDouble(scanner.nextLine());
        System.err.print("Nhap luong lon nhat: ");
        double maxSalary = Double.parseDouble(scanner.nextLine());
        
        for (int i = 0; i < list.size(); i++) {
            Employee get = list.get(i);
            double salary = list.get(i).getInCome() - list.get(i).getInCome()*list.get(i).getTax();
            if(minSalary < salary && salary < maxSalary){
                get.output();
            }
        }
    }
    //Sap xep nhan vien theo ten
    public static void sortByName(){
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            Employee get = list.get(i);
            get.output();
        }
    }
    //Sap xep nhan vien theo thu nhap
    public static void sortBySalary(){
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if(list.get(i).getInCome() < list.get(j).getInCome()){
                    Collections.swap(list, i, j);
                }
            }
        }
    }
    //Lay ra top 5 nhan vien co thu nhap cao nhat
    public static void exportTop5Salary(){
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if(list.get(i).getInCome() < list.get(j).getInCome()){
                    Collections.swap(list, i, j);
                }
            }
        }
        System.out.println("Danh Sach Nhan Vien Top 5 Thu Nhap Cao Nhat!");
        for (int i = 0; i < 5; i++) {
            Employee get = list.get(i);
            get.output();
        }
    }    
}
