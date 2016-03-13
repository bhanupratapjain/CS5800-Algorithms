package homework02.question01;

/**
 * Created by Bhanu on 12/03/2016.
 */
public class Word {

    public String wordText;
    public int count;
    public Word next;

    public Word(){
        this.wordText = null;
        this.count = 0;
        this.next = null;
    }

    public Word(String data, int count) {
        this.wordText = data;
        this.count = count;
        this.next = null;
    }
}