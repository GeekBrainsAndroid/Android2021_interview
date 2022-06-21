package com.company;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        int number = 0;
        do{
            try{
                System.out.print("Please input digit:");
                Scanner in = new Scanner(System.in);
                number = in.nextInt();
                ValidateNumber validator = new ValidateNumber(number);
                validator.validate1().validate5(); // Проверка
            }
            // Первыми идут детальные исключения
            catch(More5Exception|Less1Exception e){
                System.out.println("Please input correct mark!");
            }
            // Затем идут общие исключения
            catch(Exception e){
                System.out.println("Something wrong!");
            }
            finally{
                System.out.format("You input %d \n\r", number);
            }
        }while(number != 3);
    }
}

