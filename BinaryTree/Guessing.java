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

    public static String getCorrectAnswer(String phrase)
    {
        return null;
    }

    public static void play(BTNode current)
    {
        while (!current.isLeaf())
        {
            if (query((String)current.getData()))
            {
                current = current.getLeft();
            }
            else
            {
                current = current.getRight();
            }

            System.out.println("My guess is " + current.getData() + " . ");
            if (!query("Am I Right?"))
            {
                learn(current);
            }
            else
            {
                System.out.println("I is good!");
            }
        }
    }

    public static void learn(BTNode current)
    {
        Scanner scan = new Scanner(System.in);
        Object guessAnimal = current.getData();
        String correctAnimal = "";

        System.out.println("What is the correct animal?");
        boolean done = false;

        try
        {
            correctAnimal = scan.nextLine();
            if (correctAnimal.matches("\\d"))
            {
                do
                {
                    System.out.println("Please enter a real animal, thanks");
                    correctAnimal = scan.nextLine();
                }while ( !correctAnimal.matches("\\d"));
            }

        } catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }

        System.out.println("What question can be used to distinguish these animals?");
        String newQuestion = "";

        try
        {
            newQuestion = scan.nextLine();
        } catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }

        System.out.println("Does the 'correct animal' answer Yes or No to the preceding question?");
        String questionAnswer = "";

        try
        {
            questionAnswer = scan.nextLine();
        } catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }

        if (questionAnswer.toLowerCase().equals("yes"))
        {
            current.setData(newQuestion);
            current.setLeft(new BTNode(correctAnimal, null, null));
            current.setRight(new BTNode(guessAnimal, null, null));
        }
        else
        {
            current.setData(newQuestion);
            current.setLeft(new BTNode(guessAnimal, null, null));
            current.setRight(new BTNode(correctAnimal, null, null));
        }
    }
}

class GuessGame
{
    public static void main(String[] argsgs)
    {
        Guessing guess = new Guessing();
        Guessing.beginningTree();
    }
}
