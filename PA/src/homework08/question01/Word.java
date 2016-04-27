package homework08.question01;

import java.net.Inet4Address;
import java.util.ArrayList;

/**
 * Created by Bhanu on 12/03/2016.
 */
public class Word {

    /**
     * The Word text.
     */
    public String wordText;
    /**
     * The Count.
     */
    public int count;
    /**
     * The Next.
     */
    public Word next;

    public ArrayList<Integer> position;

    /**
     * Instantiates a new Word.
     */
    public Word() {
        this.wordText = null;
        this.count = 0;
        this.next = null;
        this.position = null;
    }

    /**
     * Instantiates a new Word.
     *
     * @param data  the data
     * @param count the count
     */
    public Word(String data, int count, int position) {
        this.wordText = data;
        this.count = count;
        this.next = null;
        if(this.position ==null){
            this.position = new ArrayList<Integer>();
            this.position.add(position);
        }else{
            this.position.add(position);
        }
    }

    public Word(String data, int count) {
        this.wordText = data;
        this.count = count;
        this.next = null;
    }
}