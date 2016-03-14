package homework08.question01;

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

    /**
     * Instantiates a new Word.
     */
    public Word(){
        this.wordText = null;
        this.count = 0;
        this.next = null;
    }

    /**
     * Instantiates a new Word.
     *
     * @param data  the data
     * @param count the count
     */
    public Word(String data, int count) {
        this.wordText = data;
        this.count = count;
        this.next = null;
    }
}