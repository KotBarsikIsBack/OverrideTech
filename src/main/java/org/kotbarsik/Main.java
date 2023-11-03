package org.kotbarsik;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        try {
         int date = checkDate();

           int startYear = Constants.MOEX_RATE.length - (Constants.CURRENT_YEAR - date);
           double startMoney = Constants.EXPENSES * 25;
           double startMoex = startMoney / Constants.MOEX_RATE[startYear];

            System.out.println(startMoex);

            for (int i = startYear; i <= Constants.MOEX_RATE.length; i++ ){
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