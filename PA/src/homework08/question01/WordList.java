package homework08.question01;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by Bhanu on 12/03/2016.
 */
public class WordList {

    private Word head;
    private Word tail;
    private int size;


    /**
     * Instantiates a new Word list.
     */
/*Using Sentinel to Have an Empty Node as Header.
    * Initially the WordList will be empty and the head will point to the last Node.*/
    public WordList() {
        this.head = new Word();
        this.tail = head;
    }

    /**
     * Insert at start.
     *
     * @param word the word
     */
/*This will insertOrUpdate at the beginning of the WordList after the head*/
    public void insertAtStart(Word word) {
        if (size == 0) {
            head.next = word;
            tail = word;
            ++size;
        } else {
            word.next = head.next;
            head.next = word;
            ++size;
        }
    }

    /**
     * Insert at end.
     *
     * @param word the word
     */
/*This will insertOrUpdate at the last of the worldList*/
    public void insertAtEnd(Word word) {
        if (size == 0) {
            head.next = word;
            tail = word;
            ++size;
        } else {
            tail.next = word;
            tail = word;
            ++size;
        }
    }

    /**
     * Remove from start.
     *
     * @param key the key
     */
    public void removeFromStart(String key) {

        if (size > 0) {
            head.next = head.next.next;
            --size;
        }
    }

    /**
     * Insert or update.
     *
     * @param word the word
     */
/*This will check if the given word is already in the list*/
    public void insertOrUpdate(Word word) {
        if (size == 0) {
            insertAtStart(word);
        } else {
            Word currentWord = head.next;
            while (currentWord != null) {
                if (StringUtils.equals(currentWord.wordText, word.wordText)) {
                    currentWord.count = word.count;
                    currentWord.position.addAll(word.position);
                    break;
                }
                currentWord = currentWord.next;
            }
        }
    }

    /**
     * Find int.
     *
     * @param key the key
     * @return the int
     * @throws Exception the exception
     */
/*Finds the count for the key given*/
    public int find(String key) throws Exception {
        int count = 0;
        if (size == 0) {
            throw new Exception("Key not Found");
        } else {
            Word currentWord = head.next;
            while (currentWord != null) {
                if (StringUtils.equals(currentWord.wordText, key)) {
                    count = currentWord.count;
                    break;
                }
                currentWord = currentWord.next;
            }
        }
        return count;
    }


    /**
     * Delete.
     *
     * @param key the key
     * @throws Exception the exception
     */
    public void delete(String key) throws Exception {
        boolean deleted = false;
        if (size == 1) {
            head.next = null;
            tail = head;
            --size;
            deleted = true;
        } else {
            Word currentWord = head.next;
            Word previousWord = head;
            while (currentWord != null) {
                if (currentWord == tail && StringUtils.equals(currentWord.wordText, key)) {
                    previousWord.next = null;
                    tail = previousWord;
                    --size;
                    deleted = true;
                    break;
                } else if (StringUtils.equals(currentWord.wordText, key)) {
                    previousWord.next = currentWord.next;
                    --size;
                    deleted = true;
                    break;
                }
                previousWord = currentWord;
                currentWord = currentWord.next;
            }
        }
        if (!deleted) {
            throw new Exception("Key not Found");
        }
    }

    /**
     * Increase.
     *
     * @param key the key
     */
    public void increase(String key) {
        boolean keyFound = false;
        if (size == 0) {
            Word word = new Word(key, 1);
            insertAtStart(word);
            keyFound = true;
        } else {
            Word currentWord = head.next;
            while (currentWord != null) {
                if (StringUtils.equals(currentWord.wordText, key)) {
                    ++currentWord.count;
                    keyFound = true;
                    break;
                }
                currentWord = currentWord.next;
            }
            if (!keyFound) {
                Word word = new Word(key, 1);
                insertAtEnd(word);
            }
        }
    }

    public String toString() {
        Word word = head;
        String s = null;
        while (word != null) {
            s += "| Word: " + word.wordText + "; Count: " + word.count + " |";
            word = word.next;
        }
        return s;
    }

    /**
     * Gets available key values.
     *
     * @return the available key values
     */
    public StringBuilder getAvailableKeyValues() {
        StringBuilder sb = new StringBuilder();
        if (size > 0) {
            Word currentWord = head.next;
            while (currentWord != null) {
                sb.append("Key: ");
                sb.append(currentWord.wordText);
                sb.append("; Value: ");
                sb.append(currentWord.count);
                sb.append("; Position: ");
                sb.append(currentWord.position);
                sb.append("\n");
                currentWord = currentWord.next;
            }
        }
        return sb;
    }
}
