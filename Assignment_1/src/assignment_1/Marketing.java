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
public class Marketing extends Employee{
    private double sales;
    private double comminsion;
    public Marketing(String maNV, String hoTen, double luong) {
        super(maNV, hoTen, luong);
    }
    
    @Override
    public double getInCome(){
        return getSalary() + getSales()*getCommission(); 
    }

    /**
     * @param sales the doanhSo to set
     */
    public void setSales(double sales) {
        this.sales = sales;
    }

    /**
     * @param hueHong the hueHong to set
     */
    public void setCommission(double hueHong) {
        this.comminsion = hueHong;
    }

    /**
     * @return the doanhSo
     */
    public double getSales() {
        return sales;
    }

    /**
     * @return the hueHong
     */
    public double getCommission() {
        return comminsion;
    }
}
