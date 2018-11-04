package BinaryTree;

import java.util.Scanner;

public class Guessing
{


    public static void instruct()
    {
        System.out.println("Welcome to the animal guessing game");
        System.out.println("You will be given a series Yes or No questions");

    }

    public static boolean query(String aStr)
    {
        Scanner aScan = new Scanner(System.in);
        boolean done = false;

        try
        {
            System.out.println(aStr);
            String answer = aScan.nextLine();
            if (answer.substring(0, 1).toLowerCase().equals("y") || answer.substring(0, 1).toLowerCase().equals("n"))
            {
                done = true;
            }
        }catch ( !done)
        {

        }
    }
}
