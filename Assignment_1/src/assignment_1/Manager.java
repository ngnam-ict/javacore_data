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
public class Manager extends Employee{
    private double responsibleWage;
    
    public Manager(String id, String fullName, double salary) {
        super(id, fullName, salary);
    }
    @Override
    public double getInCome(){
        return getSalary() + getResponsibleWage();
    }

    /**
     * @return the luongTrachNhiem
     */
    public double getResponsibleWage() {
        return responsibleWage;
    }

    /**
     * @param responsibleWage the luongTrachNhiem to set
     */
    public void setResponsibleWage(double responsibleWage) {
        this.responsibleWage = responsibleWage;
    }
}
