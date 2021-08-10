import java.util.ArrayList;
import java.util.LinkedList;

class HashTable<K,V>{
    private final int hashTableSize;
    private final LinkedList<Pair>[] hashArray;
    private final ArrayList<K> keyset = new ArrayList<>();

    public HashTable() {
        hashTableSize = 10000;
        hashArray = new LinkedList[hashTableSize];
        for(int i = 0; i<hashTableSize; i++){
            hashArray[i] = new LinkedList<>();
        }
    }

    public HashTable(int hashTableSize){
        this.hashTableSize = hashTableSize;
        hashArray = new LinkedList[hashTableSize];
        for(int i = 0; i<hashTableSize; i++){
            hashArray[i] = new LinkedList<>();
        }
    }

    public V get(K key){
        int hashCode = hashCode(key);

        for(Pair pair : hashArray[hashCode]){
            if(pair.key.equals(key))
                return pair.value;
        }

        return null;
    }

    public void put(K key, V value) {
        int hashCode = hashCode(key);

        for(Pair pair : hashArray[hashCode]){
            if(pair.key.equals(key)) {
                pair.value = value;
                return;
            }
        }

        hashArray[hashCode].add(new Pair(key, value));
        keyset.add(key);
    }

    public void remove(K key) {
        int hashCode = hashCode(key);

        for(Pair pair : hashArray[hashCode]){
            if(pair.key.equals(key)) {
                hashArray[hashCode].remove(pair);
                keyset.remove(key);
            }
        }
    }

    public ArrayList<K> keySet(){
        return keyset;
    }

    private int hashCode(K key) {
        return Math.abs(key.hashCode()) % hashTableSize;
    }

    class Pair{
        K key;
        V value;

        public Pair(
                K key,
                V value
        ) {
            this.key = key;
            this.value = value;

        }
    }
}
