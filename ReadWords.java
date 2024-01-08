// import necessary packages
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReadWords {
    // to handle exceptions include throws
    public static String getRandomWord() throws IOException {
        // list that holds strings of a file
        List<String> listOfStrings
            = new ArrayList<String>();
       
        // load data from file
        BufferedReader bf = new BufferedReader(
            new FileReader("words.txt"));
       
        // read entire line as string
        String line = bf.readLine();
       
        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
       
        // closing bufferreader object
        bf.close();

        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);

        int rndNum = rnd.nextInt(array.length);

        return array[rndNum];
    }

    private static Random rnd = new Random();
}