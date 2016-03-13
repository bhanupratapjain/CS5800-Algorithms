package homework02.question01;

/**
 * Created by Bhanu on 12/03/2016.
 */
public class WordHashTable {

    public WordList[] hashTable;
    public int hashTableSize;
    public int usedHash;

    public WordHashTable(){
        this.hashTable = null;
        this.hashTableSize = 0;
        this.usedHash = 0;
    }

    /*Initialize the HashTable*/
    public WordHashTable(int size){
        this.hashTableSize = size;
        this.hashTable = new WordList[this.hashTableSize];
        this.usedHash = 0;

        for(int i=0; i<this.hashTableSize;i++){
            this.hashTable[i] = new WordList();
        }
    }

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

    public void insert(String key, int value){
        Word word = new Word(key,value);
        int hashCode = getHashCode(word.wordText);
        this.hashTable[hashCode].insertOrUpdate(word);
    }

    public int find(String key) throws Exception {
        int hashCode = getHashCode(key);
        return this.hashTable[hashCode].find(key);
    }

    public void delete(String key) throws Exception {
        int hashCode = getHashCode(key);
        this.hashTable[hashCode].delete(key);
    }

    public void increase(String key){
        int hashCode = getHashCode(key);
        this.hashTable[hashCode].increase(key);
    }

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