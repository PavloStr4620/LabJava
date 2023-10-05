package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formula {
    double x = 1.426;
    double y = -1.220;
    double z = 3.5;

    public double calculatorA(){
        return (2 * Math.cos(this.x - (Math.PI / 6))) / 0.5 + Math.pow(Math.sin(this.y), 2);
    }

    public double calculatorB(){
        return 1 + ((Math.pow(this.z, 2)) / (3 + Math.pow(this.z, 2)) / 5);
    }

    public static void main(String[] args) {
        Formula formula = new Formula();
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String simpleData = simpleDateFormat.format(date);

        System.out.println("Перше рівняння a = " + formula.calculatorA());
        System.out.println("Друге рівняння b = " + formula.calculatorB());
        System.out.println("Дата: " + simpleData);
    }
}