package homework02.question01;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Bhanu on 10/03/2016.
 */
public class HashText {

    public void test(){
        WordHashTable hashTable = new WordHashTable(11);
        hashTable.insert("abc",1);
        hashTable.insert("def",6);
        hashTable.insert("Def",55);
        System.out.println(hashTable);
        try {
            System.out.println(hashTable.find ("des"));
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

    public void hashTextFile(String fileLoaction){
        try (BufferedReader br = new BufferedReader(new FileReader(fileLoaction)))
        {
            WordHashTable hashTable = new WordHashTable(200);
            String sCurrentLine=null;
            while ((sCurrentLine=br.readLine()) != null) {
                String[] stringArray = sCurrentLine.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                for(String input : stringArray){
                    if (StringUtils.isNoneEmpty(input)) {
                        try {
                            int count = hashTable.find(input);
                            hashTable.insert(input,++count);
                        } catch (Exception e) {
                            hashTable.insert(input,1);
                            System.out.println("Creating New Entry with key: "+input);
                        }
                    }
                }
            }
            System.out.println(hashTable.listAllKeys());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        HashText ht = new HashText();
        //ht.test();
        ht.hashTextFile("C:\\Users\\Bhanu\\IdeaProjects\\CS5800-Algorithms\\PA\\src\\homework02\\question01\\test.txt   ");
    }
}
