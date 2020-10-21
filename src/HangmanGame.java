import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame {

    /**
     *
     * @param args
     * @throws Exception needs when reading a text-file if an error comes up.
     */
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome To Hangman!");

        /**
         *  File dictionary gives you a library to randomly generate a word from.
         *  Scanner textScanner reads and use the libarary as an input.
         */
        File dictionary = new File("/Users/NorrmanImac/IdeaProjects/HangmanGame2/dictionary.txt");
        Scanner textScanner = new Scanner(dictionary);

        /**
         * input is used from the user.
         */
        Scanner input = new Scanner(System.in);

        /**
         * The ArrayList holds all the words and checks if for the next line and stops.
         */
        ArrayList<String> words = new ArrayList<>();
        while (textScanner.hasNextLine()) {
            words.add(textScanner.nextLine());
        }

        /**
         * We need to get the String to a integer and use Math.random to generate the hidden word.
         * Make the char-Array to check the words from hiddenText.
         */
        String hiddenText = words.get((int) (Math.random() * words.size()));
        char[] textArray = hiddenText.toCharArray();

        /**
         * myAnswers is use to check if its in the textArray.
         */
        char[] myAnswers = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            myAnswers[i] = '?';
        }

        /**
         * Loop to be running until the game ends.
         * Lives is the number of try's the user get to find the word.
         */
        boolean finished = false;
        int lives = 10;


        while (finished == false) {
            System.out.println("************************");
            // Print the lenght of the hidden text
            System.out.println("\nThe hangman word is " + hiddenText.length() + " letters!");
            System.out.print("Guess the Word: ");

            /**
             * String letter gets the word the user enters and checks if its a valid input.
             * The user can only enter one letter, not a number nor "abc" only one letter.
             * Character class is calls to check if the input is a number or not.
             * letter.charAt(0) sees only the first letter, and skips spaces.
             */
            String letter = input.next();
            // Check for valid input
            while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                System.out.println("Error Input - Try Again");
                letter = input.next();
            }

            /**
             * Check if letter is in the word.
             * boolean found count true if the input letter is = to any of the letters in the hidden word.
             * If the letter is not in the word one life is taken away.
             */
            boolean found = false;
            for (int i = 0; i < textArray.length; i++) {
                if (letter.charAt(0) == textArray[i]) {
                    myAnswers[i] = textArray[i];
                    found = true;
                }
            }
            if (!found) {
                lives--;
                System.out.println("Wrong Letter");
            }

            /**
             * If ? the letter of the word is not guessed.
             * If or when user get boolean to true the game is done.
             */
            boolean done = true;
            for (int i = 0; i < myAnswers.length; i++) {
                if (myAnswers[i] == '?') {
                    System.out.print(" _");
                    done = false;
                } else {
                    System.out.print(" " + myAnswers[i]);
                }
            }

            /**
             * Print out the HangMan graphics. And the lives left.
             */
            System.out.println("\n" + "Lives Left: " + lives);
            drawHangman(lives);


            /**
             * Check if the game ends. if boolean done gets true the game ends.
             * If lives gets to 0 the game ends.
             * finished gets true either or you win or lose the game ends.
             */
            if (done) {
                System.out.println("\nWOW!!!! Congrats You Found the Word!");
                finished = true;
            }
            if (lives <= 0) {
                System.out.println("You are dead!");
                finished = true;
                System.out.println("The hidden word is: " + hiddenText);
            }
        }
    }


    private static void drawHangman(int lives) {
        /**
         * HangMan graphics from outerspace!
         * The if statment use the lives counter to generate its outerspace graphics.
         * @param lives
         */
        if (lives == 10) {
            System.out.println("|----------");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
        } else if (lives == 9) {
            System.out.println("|----------");
            System.out.println("|    |     ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
        } else if (lives == 8) {
            System.out.println("|----------");
            System.out.println("|    |     ");
            System.out.println("|    &     ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
        } else if (lives == 7) {
            System.out.println("|----------");
            System.out.println("|    |     ");
            System.out.println("|    &     ");
            System.out.println("|    O     ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
        } else if (lives == 6) {
            System.out.println("|----------");
            System.out.println("|    |     ");
            System.out.println("|    &     ");
            System.out.println("|    O     ");
            System.out.println("|   -|     ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
        } else if (lives == 5) {
            System.out.println("|----------");
            System.out.println("|    |     ");
            System.out.println("|    &     ");
            System.out.println("|    O     ");
            System.out.println("|   -|-    ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
        } else if (lives == 4) {
            System.out.println("|----------");
            System.out.println("|    |     ");
            System.out.println("|    &     ");
            System.out.println("|    O     ");
            System.out.println("|   -|-    ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
        } else if (lives == 3) {
            System.out.println("|----------");
            System.out.println("|    |     ");
            System.out.println("|    &     ");
            System.out.println("|    O     ");
            System.out.println("|  --|--   ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
        } else if (lives == 2) {
            System.out.println("|----------");
            System.out.println("|    |     ");
            System.out.println("|    &     ");
            System.out.println("|    O     ");
            System.out.println("|  --|--   ");
            System.out.println("|   /      ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
        } else if (lives == 1) {
            System.out.println("|----------");
            System.out.println("|    |     ");
            System.out.println("|    &     ");
            System.out.println("|    O     ");
            System.out.println("|  --|--   ");
            System.out.println("|   /|     ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
        } else {
            System.out.println("|----------");
            System.out.println("|    |     ");
            System.out.println("|    &     ");
            System.out.println("|    X     ");
            System.out.println("|  --|--   ");
            System.out.println("|   /|     ");
            System.out.println("|          ");
            System.out.println("|          ");
            System.out.println("|          ");
        }
    }
}