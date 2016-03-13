package homework02.question01;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bhanu on 10/03/2016.
 */
public class HashText {

    public void test() {
        WordHashTable hashTable = new WordHashTable(11);
        hashTable.insert("abc", 1);
        hashTable.insert("def", 6);
        hashTable.insert("Def", 55);
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
        hashTable.increase("aaa");
        System.out.println(hashTable);
        System.out.println(hashTable.listAllKeys());
    }

    public void hashTextFile(String fileLoaction) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileLoaction))) {
            String sCurrentLine = null;
            List<String> stringList = new ArrayList<String>();
            while ((sCurrentLine = br.readLine()) != null) {
                stringList.addAll(Arrays.asList(sCurrentLine.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+")));
            }
            WordHashTable hashTable = new WordHashTable(getPrime(stringList.size()));
            for (String input : stringList) {
                if (StringUtils.isNoneEmpty(input)) {
                    try {
                        int count = hashTable.find(input);
                        hashTable.insert(input, ++count);
                    } catch (Exception e) {
                        System.out.println("Creating new Word with key: " + input);
                        hashTable.insert(input, 1);
                    }

                }
            }
            System.out.println(hashTable.listAllKeys());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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

    public static void main(String[] args) {
        HashText ht = new HashText();
        //ht.test();
        ht.hashTextFile("C:\\Users\\Bhanu\\IdeaProjects\\CS5800-Algorithms\\PA\\src\\homework02\\question01\\test.txt");
    }
}
