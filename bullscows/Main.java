
package bullscows;

import java.util.*;

public class Main {

    static Scanner read = new Scanner(System.in);
    static Random rnd = new Random();

    public static int lengthCode() {

        System.out.println("Input the length of the secret code:");

        int gameCodeLength = 0;
        if (read.hasNextInt()) {
            gameCodeLength = read.nextInt();
            System.out.println(gameCodeLength);

        } else {
            error();
        }
        return gameCodeLength;
    }


    public static int rangeCode(){

        System.out.println("Input the number of possible symbols in code:");
        int gameRangeLength = read.nextInt();
        System.out.println(gameRangeLength);
        return gameRangeLength;
    }


    public static StringBuilder codeGenerator (int lengthCode, int rangeCode){

        String stringBase = "0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuilder stringRange = new StringBuilder();
        StringBuilder passwordSigns = new StringBuilder();
        String digitsRange;

        for (int i = 0; i < rangeCode; ++i){
            stringRange.append(stringBase.charAt(i));
        }
        System.out.println("String range " + stringRange);

        StringBuilder gameCode = new StringBuilder();
        for (int i = 0; i < lengthCode; ++i){
            int randomDigit = rnd.nextInt(0,stringRange.length());
            gameCode.append(stringRange.charAt(randomDigit));
            stringRange.deleteCharAt(randomDigit);
        }
        System.out.println(gameCode);
        for (int i = 0; i < lengthCode; ++i){
            passwordSigns.append("*");
        }

        if (rangeCode < 10){
            digitsRange = ("(0-" + stringBase.charAt(rangeCode-1) + ")");
        } else if (rangeCode == 10){
            digitsRange = ("(0-9)");
        } else if (rangeCode < 36) {
            digitsRange = ("(0-9, a-" + stringBase.charAt(rangeCode-1) + ")");
        } else {
            digitsRange = ("(0-9, a-f)");
        }

        System.out.println("The secret is prepared: " + passwordSigns + " " + digitsRange);
        return gameCode;

    }

    public static void gameLoop (StringBuilder gameCode) {

        int bulls = 0;
        int cows = 0;
        int turn = 1;

        System.out.println("Okay, let's start a game!");

        while (bulls != gameCode.length()) {
            bulls = 0;
            cows = 0;
            System.out.println("Turn " + turn + ":");
            ++turn;

            String userInput = read.next();

            for (int i = 0; i < userInput.length(); ++i) {
                char userInputChar = userInput.charAt(i);

                // Check for bulls
                if (userInputChar == gameCode.charAt(i)) {
                    ++bulls;
                } else {
                    // Check for cows only if not a bull
                    for (int j = 0; j < gameCode.length(); ++j) {
                        if (userInputChar == gameCode.charAt(j)) {
                            ++cows;
                            break; // Break to avoid counting duplicates
                        }
                    }
                }
            }

            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s)");

        }

        System.out.println("Congratulations! You guessed the secret code.");


    }

    public static void error(){
        System.out.println("error");
        System.exit(1);

    }


    public static void main(String[] args) {

        int length = lengthCode();
        int range = rangeCode();

        if (length <= 0){
            error();
        }

        if (range < length){
            error();
        }

        if (range > 36){
            error();
        }


        StringBuilder gameCode = codeGenerator(length, range);

        System.out.println(gameCode);

        gameLoop(gameCode);

    }
}