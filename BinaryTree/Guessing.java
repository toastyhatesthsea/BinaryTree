package BinaryTree;

import java.util.NoSuchElementException;
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
        boolean returnAnswer = false;

        try
        {
            do
            {
                System.out.println(aStr);
                String answer = aScan.nextLine();
                if (answer.trim().toLowerCase().equals("yes") || answer.trim().toLowerCase().equals("no"))
                {
                    if (answer.trim().toLowerCase().equals("yes"))
                    {
                        returnAnswer = true;
                    }
                    done = true;
                }
            } while (!done);

        } catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
        return returnAnswer;
    }

    public static BTNode<String> beginningTree()
    {
        BTNode<String> root;
        BTNode<String> child;

        root = new BTNode<>("Are you a mammal?", null, null);

        child = new BTNode<>("Are you bigger than a cat?", new BTNode("Kangaroo", null, null), new BTNode("Mouse", null , null));
        root.setLeft(child);

        child = new BTNode<>("Do you live underwater?", new BTNode("Trout", null, null), new BTNode("Robin", null, null));
        root.setRight(child);
        return root;
    }
}
