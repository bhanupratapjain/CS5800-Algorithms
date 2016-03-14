package homework08.question01;

/**
 * Created by Bhanu on 12/03/2016.
 */
public class WordHashTable {

    /**
     * The Hash table.
     */
    public WordList[] hashTable;
    /**
     * The Hash table size.
     */
    public int hashTableSize;
    /**
     * The Used hash.
     */
    public int usedHash;

    /**
     * Instantiates a new Word hash table.
     */
    public WordHashTable(){
        this.hashTable = null;
        this.hashTableSize = 0;
        this.usedHash = 0;
    }

    /**
     * Instantiates a new Word hash table.
     *
     * @param size the size
     */
    public WordHashTable(int size){
        this.hashTableSize = size;
        this.hashTable = new WordList[this.hashTableSize];
        this.usedHash = 0;

        for(int i=0; i<this.hashTableSize;i++){
            this.hashTable[i] = new WordList();
        }
    }

    /**
     * Gets hash code.
     *
     * @param word the word
     * @return the hash code
     */
    public int getHashCode(String word) {
        int hashCode = 0;
        char[] inputWord = word.toCharArray();
        int i =0;
        while(i<inputWord.length){
            hashCode+= inputWord[i]* ++i*i;
        }
        hashCode%=this.hashTableSize;
        return hashCode;
    }

    /**
     * Insert.
     *
     * @param key   the key
     * @param value the value
     */
    public void insert(String key, int value){
        Word word = new Word(key,value);
        int hashCode = getHashCode(word.wordText);
        this.hashTable[hashCode].insertOrUpdate(word);
    }

    /**
     * Find int.
     *
     * @param key the key
     * @return the int
     * @throws Exception the exception
     */
    public int find(String key) throws Exception {
        int hashCode = getHashCode(key);
        return this.hashTable[hashCode].find(key);
    }

    /**
     * Delete.
     *
     * @param key the key
     * @throws Exception the exception
     */
    public void delete(String key) throws Exception {
        int hashCode = getHashCode(key);
        this.hashTable[hashCode].delete(key);
    }

    /**
     * Increase.
     *
     * @param key the key
     */
    public void increase(String key){
        int hashCode = getHashCode(key);
        this.hashTable[hashCode].increase(key);
    }

    /**
     * List all keys string.
     *
     * @return the string
     */
    public String listAllKeys(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<this.hashTableSize;i++){
            sb.append(hashTable[i].getAvailableKeyValues());
        }
        return sb.toString();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<this.hashTableSize;i++){
            sb.append("#Hash "+i+" #"+this.hashTable[i]+"#\n");
        }
        return sb.toString();
    }
}