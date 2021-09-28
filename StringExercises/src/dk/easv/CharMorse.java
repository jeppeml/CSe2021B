package dk.easv;

public class CharMorse {
    private String character;
    private String morseCode;

    public CharMorse(String character, String morseCode) {
        this.character = character;
        this.morseCode = morseCode;
    }

    public String getCharacter() {
        return character;
    }

    public String getMorseCode() {
        return morseCode;
    }
}
