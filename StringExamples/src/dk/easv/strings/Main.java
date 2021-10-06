package dk.easv.strings;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private class MorseTranslator{
        String orignal;
        String morse;
    }
    public void sayHello(){
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        int[][] ints = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(ints[1][1]);



        Object[] objects = new Object[9];
        objects[0] = "Hi";
        objects[1] = 65536;
        objects[2] = 65536.0;
        objects[3] = new Scanner(System.in);

        //int sum = ints[0] + objects[1];
        /*
        double d = (int)objects[0] + (double)objects[2];
        System.out.println(d);
        Main m = new Main();
        m.sayHello();

        double[] intArr = new double[5];
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(i + ": " + intArr[i]);
        }*/

        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("How many horses? >");
        int input = Integer.parseInt(sc.nextLine());
        String[] horses = new String[input];



        for (int i = 0; i < input; i++) {
            System.out.println("Name of horse " + i + ">");
            horses[i] = sc.nextLine();
        }



        for (int i = 0; i < horses.length; i++) {
            System.out.println("horse no. " + i + ": "+ horses[i]);
        }*/
	   // e7();
    }
    public static void e7(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input for exercise 7>");
        String input = sc.nextLine();
        String[] badNames = {"horse", "spores", "saddle", "hi"};
        String[] mask = {"*****", "******", "******", "**"};
        String output = input;
        for (int i = 0; i < badNames.length; i++) {
            output = output.replaceAll(badNames[i], mask[i]);
        }
/*
        String output = input
                .replaceAll("horse","*****")
                .replaceAll("spores","******")
                .replaceAll("saddle","******");*/
        System.out.println(output);
    }
    public static void e6(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input for exercise 6>");
        String input = sc.nextLine();
        String output = "";
        String[] characters = {"a", "b", "c", "d"};
        String[] morse = {".-", "---.", "-.-.", "-.."};

        for (int i = 0; i < input.length(); i++) {
            String current = input.charAt(i) + "";
            for (int k = 0; k < characters.length; k++) {
                if(characters[k].equals(current)){
                    output = output + morse[k] + "/";
                }
            }
        }
        System.out.println(output);
    }
    public static void e5(){
        Scanner sc = new Scanner(System.in);
        String input = "";
        while(input.length()<1)
        {
            System.out.print("Input for exercise 5>");
            input = sc.nextLine();

        }

        String output = "";

        boolean wasUpperCase = false;

        for (int i = 0; i < input.length(); i++) {
            String current = input.charAt(i) + "";
            if(wasUpperCase) {
                output = output + current.toLowerCase();
            }
            else{
                output = output + current.toUpperCase();
            }
            if(!current.equals(" "))
                wasUpperCase = !wasUpperCase;
        }

        System.out.println(output);
    }
    public static void e4(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input for exercise 4>");
        String input = sc.nextLine();
        String output = "";
        for (int i = input.length()-1; i >= 0; i--) {
            output = output + input.charAt(i);

        }
        System.out.println(output);
    }
    public static void e3(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input for exercise 3>");
        String input = sc.nextLine();

        String atString = input.charAt(0) + "";
        for (int i = 1; i < input.length(); i++) {
            atString = atString + "@" + input.charAt(i);
        }

        System.out.println(atString);
    }
    public static void e2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input for exercise 2>");
        String input = sc.nextLine();

        System.out.println(input.length());
    }

    public static void e1(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println("<" + input + ">");
    }
}
