/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1;

/**
 *
 * @author Admin
 */
abstract public class Employee implements Comparable<Employee>{
    String id;
    String fullName;
    double salary;
    
    
    
    public Employee(String idEmployee, String fullName, double salary){
        this.id = idEmployee;
        this.fullName = fullName;
        this.salary = salary;
    }
    /**
     * @return the manNV
     */
    public String getID() {
        return id;
    }

    /**
     * @return the hoTen
     */
    public String getName() {
        return fullName;
    }

    /**
     * @return the luong
     */
    public double getSalary() {
        return salary;
    }
    
    abstract public double getInCome();
    public double getTax(){
        double incomeTax = 0;
        if(getInCome()<9000000){
            incomeTax = 0;
        }else
            if(getInCome()<15000000){
                incomeTax = 0.1;
            }else{
                incomeTax = 0.12;
            }
        return incomeTax;
    }
    
    public void output(){
        System.out.println("****************************************************");
        System.out.println("Ma nhan vien: " + getID().toUpperCase() +
                "\nHo ten nhan vien: " + getName() +
                "\nLuong: " + (getInCome() - getInCome()*getTax())/1000000 + "trieu dong");
        System.out.println("****************************************************");
    }
    
    @Override
    public int compareTo(Employee other){
        int compareName = this.fullName.compareTo(other.fullName);
        if(compareName>0)
            return 1;
        if(compareName<0)
            return -1;
        else
            return 0;
    }
    
}
