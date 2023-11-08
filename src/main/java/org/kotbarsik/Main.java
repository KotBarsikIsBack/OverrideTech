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

         int startMoney = (startExpenses * 25 * 12) + (startExpenses * 3 * 12); // начальный капитал на вклад + текущий год

         System.out.println("Начальная сумма вкладов: " + startMoney);

         System.out.println("Расходы на месяц: " + startExpenses);
         startMoney -= startExpenses; // расходы на текущий год
         System.out.println("Начальная сумма вкладов c вычетом денег на жизнь в текущий год: " + startMoney);

         double startMoex = startMoney / Constants.MOEX_RATE[startYear];
         System.out.println("Начальное кол-во акций мосбиржи: " + startMoex);

         double moex = startMoex * 1.15; // доходы за год
         System.out.println("Доходы на текущий год: " + moex);

         int expenses = (int)(startExpenses * Constants.INFLATION_RATE[startYear]);
         System.out.println("Траты на следующий год: " + expenses + ". В месяц: " + expenses/12);


//           int startMoney = Constants.EXPENSES * 25 * 12 ; // 4%  12 month
//           BigDecimal startMoex = new BigDecimal(startMoney / Constants.MOEX_RATE[startYear]);
//           startMoex = startMoex.setScale(1, RoundingMode.HALF_UP);
//           System.out.println(startMoney);
//           System.out.println(startMoex);


         for (int i = startYear + 1; i < Constants.MOEX_RATE.length; i++ ){
             System.out.println(++date);
             calculatePercent( moex, expenses, i);
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

    public static double calculatePercent(double moex, int expenses, int index) {
        //double percent = 0;

        int money = (int)(moex * Constants.MOEX_RATE[index]);
        System.out.println("Прирост акций 15%:" + money);
        double percent = money * 0.04;
        System.out.println("Доступные траты: " + percent + ". В месяц: " + percent / 12);
        money -= expenses;
        System.out.println("Остаток денег на вклад: " + money);
        double newExpenses = expenses * Constants.INFLATION_RATE[index];
        System.out.println("Траты не следующий год: " + newExpenses + ". В месяц: " + newExpenses/12);
        return newExpenses;

       // return Math.round(percent * 2) / 2.0;
    }

}