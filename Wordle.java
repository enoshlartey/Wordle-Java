import java.util.Scanner;
import java.io.IOException;


public class Wordle {
    // Setting Text Colours
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m"; // Guess count indicator
    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";  // Correct letter and Position == Green
    public static final String YELLOW_BOLD = "\033[1;33m"; // Letter exists but wrong position == Yellow
    public static final String GREY_BOLD = "\033[1;37m"; // Letter doesn't exist at all == Grey
    public static final String WHITE_UNDERLINED = "\033[1;37m";  // WHITE
    //Background Colouring
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String CYAN_BACKGROUND = "\033[47m";
//
//
    // Main Program
    public static void main(String[] args) throws IOException {
        
        // Get a random word from a file. (you should not modify this)
        String answer = ReadWords.getRandomWord();
        

        //Guess Counter System 
        int countNum = 1;
        

        // Your game starts here
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a 5 letter guess? ");
        String wordGuess = scan.nextLine();

        
        // boolean lengthCheck = checkLength(wordGuess);
        String programWordGuess = wordGuess.toUpperCase();
        String programWordAnswer = answer.toUpperCase(); //Uppercasing the word to make usage in the program easier.
        letterInWord(programWordGuess, programWordAnswer);
        
        // checkWord(programWordAnswer, programWordGuess);
        boolean answerTruth = checkWord(programWordAnswer, programWordGuess);
        while((answerTruth==false) && (countNum<5))
        {
            // clearScreen();
            System.out.print("Enter a 5 letter guess? ");
            wordGuess=scan.nextLine();
            String programWordGuessIncorrect = wordGuess.toUpperCase();
            letterInWord(programWordGuessIncorrect, programWordAnswer);
            answerTruth = checkWord(programWordAnswer, programWordGuessIncorrect);
            countNum += 1;        
        }
        if(answerTruth == false){
            System.out.println("You lost. The answer was " + programWordAnswer.toLowerCase() +'.');
        }
        else {
            if(countNum<=1){
                System.out.println("You won. It took you " + countNum + " guess.");
            }
            else if(countNum>1) {
                System.out.println("You won. It took you " + countNum + " guesses.");
            }
        }
        //Uppercasing the word to make usage in the program easier. 

        
    }


    public static void letterColor(String colour, char letter) {    
        if (colour.equals("green"))
        {
            letterColorGreen(letter);
        }

        if (colour.equals("grey"))
        {
            letterColorGrey(letter);
        }

        if (colour.equals("yellow"))
        {
            letterColorYellow(letter);
        }
    }

    private static void letterColorGreen(char letter){
        System.out.println(GREEN_BOLD + letter + ANSI_RESET);
    }

    private static void letterColorYellow(char letter){
        System.out.println(YELLOW_BOLD + letter + ANSI_RESET);
    }

    private static void letterColorGrey(char letter){
        System.out.println(GREY_BOLD + letter + ANSI_RESET);
    }

    // Using the method below to clear the screen when the answer is incorrect to allow the user a clean working slate. 
    private static void clearScreen(){
        System.out.print("\033[H\033[2J");
    }

    private static boolean checkWord(String originWord, String inputWord) {
        if (originWord.equals(inputWord))
        {
            return true;
        }
        else {
            return false;
        }
    }

    // private static boolean checkLength(String inputWord){
    //     if (inputWord.length == 5)
    //     {
    //         return true;
    //     }
    //     else {
    //         return false;
    //     }
    // }


    // This method checks if the letter exists at any point in the word. 
    // It also checks to see if the letter is in the right position. 
    public static void letterInWord(String guessWord, String answerWord) {
        for (int e=0; e<guessWord.length(); e++) // Checking if the letter in the guess word exists at all in the answer word. 
        {
            String match = "";
            for (int f=0; f<answerWord.length(); f++)
            {
                // if (guessWord.charAt(e) == answerWord.charAt(f))
                // {
                //     existing = true;
                //     break;
                // }
                
                if ((guessWord.charAt(e) == answerWord.charAt(f)) && (guessWord.charAt(e) == answerWord.charAt(e)))
                {
                    match = "matchAt";
                    break;
                }
                else if((guessWord.charAt(e) == answerWord.charAt(f)))
                {
                    match = "notMatchAt";
                    break;
                }
            }

            if ((match == "matchAt") ){
                
                String colourGreen = "green";
                letterColor(colourGreen, guessWord.charAt(e));
            }
            else if(match == "notMatchAt" ) {
                String colourYellow = "yellow";
                letterColor(colourYellow, guessWord.charAt(e));
            } 
            else {
                String colourGrey = "grey";
                letterColor(colourGrey, guessWord.charAt(e));
            }

            //Checking if letters are in the right position
            // boolean positioned = false;
            // if(existing == true){
            //     for (int x=0; x<answerWord.length(); x++)
            //     {
            //         if (guessWord.charAt(x) == answerWord.charAt(x))
            //         {
            //             // System.out.println("Yes this exists at the right position: " + guessWord.charAt(x));
            //             positioned = true;
            //         }
            //     }
            // }
        
            
            // if (positioned == true) {
            //     String colourGreen = "green";
            //     letterColor(colourGreen, guessWord.charAt(e));
            // }
            // else if (positioned != true)
            // {
            //     String colourYellow = "yellow";
            //     letterColor(colourYellow, guessWord.charAt(e));
            // }
            // if (existing == true){
            //     String colourYellow = "yellow";
            //     letterColor(colourYellow, guessWord.charAt(e));
            // }
            // else if(existing == true && matching == false) {
            //     String colourGrey = "grey";
            //     letterColor(colourGrey, guessWord.charAt(e));
            // } 
            // else {
            //     String colourGrey = "grey";
            //     letterColor(colourGrey, guessWord.charAt(e));
            // }
        }
    }

    
}