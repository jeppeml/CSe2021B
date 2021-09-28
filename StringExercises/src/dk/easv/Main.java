package dk.easv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Assignments assignments = new Assignments();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Exercise 1:");
        System.out.print(">");
        String name = reader.readLine();



        assignments.exercise1(name);

    }
}
