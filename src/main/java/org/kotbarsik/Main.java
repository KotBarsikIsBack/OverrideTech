package org.kotbarsik;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        try {
            checkDate();
        } catch (InvalidInputException e){
            System.out.println(e.getMessage());
        }


    }


    public static void checkDate() throws InvalidInputException{

        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        if (number < 2002 || number > 2022)
            throw new InvalidInputException("Have no information");

    }



}