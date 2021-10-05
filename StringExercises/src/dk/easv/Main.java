package dk.easv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        Assignments assignments = new Assignments();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Exercise 1:");
        System.out.print(">");
        String name = reader.readLine();



        assignments.exercise1(name);

        ArrayList<CharMorse> cmList = new ArrayList<>();
        cmList.add(new CharMorse("a", ".-"));
        cmList.add(new CharMorse("b", ".--"));
        cmList.add(new CharMorse(" ", ""));
        String str = "ab b";
        String morse = "";
        for(int i=0;i<str.length();i++){
            String currentChar = str.charAt(i)+"";
            for (CharMorse cm:cmList) {
                if (cm.getCharacter().equals(currentChar)){
                    morse = morse + cm.getMorseCode();
                    morse+="/";
                }
            }
        }
        System.out.println(morse);

        HashMap<Character, String> hm = new HashMap<>();
        hm.put('a', ".-");
        hm.put('e', ".");
        hm.put('t', "-");

        String drink ="tea";
        String morseOut = "";
        for(int i=0;i<drink.length();i++){
            morseOut+=hm.get(drink.charAt(i));
        }
        System.out.println(morseOut);
    }
}
