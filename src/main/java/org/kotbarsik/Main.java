package org.kotbarsik;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Main {

    public static void main(String[] args) {


        try {
         int date = checkDate();
         int startYear = Constants.MOEX_RATE.length - 1 - (Constants.CURRENT_YEAR - date);
         int startExpenses = Constants.EXPENSES;

         for (int i = Constants.INFLATION_RATE.length - 1; i >= startYear; i--){
             startExpenses = (int)Math.round(startExpenses / (1 + Constants.INFLATION_RATE[i]/100));
             //System.out.println(startExpenses);
         }

         int startMoney = (startExpenses * 25 * 12) + (startExpenses * 12);
         System.out.println("Начальная сумма вкладов: " + startMoney);

//           int startMoney = Constants.EXPENSES * 25 * 12 ; // 4%  12 month
//           BigDecimal startMoex = new BigDecimal(startMoney / Constants.MOEX_RATE[startYear]);
//           startMoex = startMoex.setScale(1, RoundingMode.HALF_UP);
//           System.out.println(startMoney);
//           System.out.println(startMoex);
         for (int i = startYear; i < Constants.MOEX_RATE.length; i++ ){
             System.out.println(date++);
            }




        } catch (InvalidInputException e){
            System.out.println(e.getMessage());
        }

    }


    public static int checkDate() throws InvalidInputException{

        Scanner scan = new Scanner(System.in);
        int date = scan.nextInt();

        if (date < 2002 || date > 2022)
            throw new InvalidInputException("Have no information");

        return date;
    }



}