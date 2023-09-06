package org.example;

import java.util.Date;

public class Formula {
    double x = 1.426, y = -1.220, z = 3.5;

    public double firstSolution(){
        return (2 * Math.cos(this.x - (Math.PI / 6))) / 0.5 + Math.pow(Math.sin(this.y), 2);
    }

    public double secondSolution(){
        return 1 + ((Math.pow(this.z, 2)) / (3 + Math.pow(this.z, 2)) / 5);
    }

    public static void main(String[] args) {
        Formula formula = new Formula();
        Date date = new Date();
        System.out.println("Перше рівняння a = " + formula.firstSolution());
        System.out.println("Друге рівняння b = " + formula.secondSolution());
        System.out.println("Дата: " + (date.getDay() + 3) + " " + (date.getMonth() + 1) + " " + (date.getYear() + 1900));
    }
}