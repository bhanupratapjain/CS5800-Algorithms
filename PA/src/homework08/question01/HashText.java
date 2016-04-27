package homework08.question01;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bhanu on 10/03/2016.
 */
public class HashText {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        HashText ht = new HashText();
        //ht.test();
        String inputFile = "C:\\Users\\Bhanu\\IdeaProjects\\CS5800-Algorithms\\PA\\" +
                "src\\homework08\\question01\\input\\test_input.txt";
        String outputFileLocation = "C:\\Users\\Bhanu\\IdeaProjects\\CS5800-Algorithms\\PA\\" +
                "src\\homework08\\question01\\output\\";
        ht.hashTextFile(inputFile, outputFileLocation);
    }

    /**
     * Test.
     */
    public void test() {
        WordHashTable hashTable = new WordHashTable(11);
        hashTable.insert("abc", 1, 0);
        hashTable.insert("def", 6, 0);
        hashTable.insert("Def", 55, 0);
        System.out.println(hashTable);
        try {
            System.out.println(hashTable.find("des"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            hashTable.delete("Abc");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        hashTable.increase("aaa");
        System.out.println(hashTable);
        System.out.println(hashTable.listAllKeys());
    }

    /**
     * Hash text file.
     *
     * @param loaction     the loaction
     * @param fileLoaction the file loaction
     */
    public void hashTextFile(String loaction, String fileLoaction) {
        try (BufferedReader br = new BufferedReader(new FileReader(loaction))) {
            String sCurrentLine = null;
            List<String> stringList = new ArrayList<String>();
            while ((sCurrentLine = br.readLine()) != null) {
                stringList.addAll(Arrays.asList(sCurrentLine.replaceAll("[^a-zA-Z ]", "").split("\\s+")));
            }
            WordHashTable hashTable = new WordHashTable(getPrime(stringList.size()));
            int positionCount = 1;
            for (String input : stringList) {
                if (StringUtils.isNoneEmpty(input)) {
                    try {
                        int count = hashTable.find(input);
                        hashTable.insert(input, ++count, ++positionCount);
                    } catch (Exception e) {
                        System.out.println("Creating new Word with key: " + input);
                        hashTable.insert(input, 1, ++positionCount);
                    }
                }
            }
            String hashingOutput = hashTable.listAllKeys();
            System.out.println(hashingOutput);
            createOutputFile(hashingOutput, fileLoaction);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Create output file.
     *
     * @param content      the content
     * @param fileLoaction the file loaction
     */
    public void createOutputFile(String content, String fileLoaction) {

        System.out.println("Creating OutputFile");
        File file = new File(fileLoaction + "test_out_" + System.currentTimeMillis() + ".txt");
        try (FileOutputStream fop = new FileOutputStream(file)) {

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets prime.
     *
     * @param number the number
     * @return prime prime
     */
    public int getPrime(int number) {
        System.out.println("Current Size: " + number);
        while (true) {
            if (isPrime(number)) {
                System.out.println("New Size: " + number);
                return number;
            }
            ++number;
        }
    }

    /**
     * Is prime boolean.
     *
     * @param n the n
     * @return the boolean
     */
/*checks whether an int is prime or not*/
    public boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}
