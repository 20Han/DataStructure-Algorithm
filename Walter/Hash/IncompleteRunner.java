import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        MyHash<String, Integer> map = new MyHash<>(100000);

        addArrayToMap(map, participant);

        addArrayToMap(map, completion);

        for (MyHash.MyNode<String, Integer> node : map.getNodes()) {
            if (node.value % 2 != 0)
                return node.key;
        }

        return answer;
    }
    
    
    public void addArrayToMap(MyHash<String, Integer> map, String[] arr) {
        for (String s : arr) {
            Integer count = map.get(s);

            if (count == null) {
                map.put(s, 1);
            } else map.put(s, ++count);
        }
    }
    
    public static class MyHash<K, V> {
        private final ArrayList<LinkedList<MyNode<K, V>>> data;
        private final int size;

        public MyHash(int size) {
            this.data = new ArrayList<>(size);
            this.size = size;

            for (int i = 0; i < this.size; i++) {
                data.add(null);
            }
        }

        private int convertHashCodeToIndex(int hashCode) {
            int index = hashCode % size;
            return index < 0 ? index * -1 : index;
        }

        public void put(K key, V value) {
            int index = convertHashCodeToIndex(key.hashCode());

            LinkedList<MyNode<K, V>> collisionList = null;

            try {
                collisionList = data.get(index);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (collisionList == null) {
                collisionList = new LinkedList<>();
                data.set(index, collisionList);
            }

            MyNode<K, V> node = findNode(collisionList, key);

            if (node == null)
                collisionList.addLast(new MyNode<>(key, value));
            else
                node.value = value;
        }

        public V get(K key) {
            int index = convertHashCodeToIndex(key.hashCode());

            LinkedList<MyNode<K, V>> collisionList = data.get(index);

            MyNode<K, V> node = findNode(collisionList, key);

            return node == null ? null : node.value;
        }

        public List<MyNode<K, V>> getNodes() {
            ArrayList<MyNode<K, V>> nodes = new ArrayList<>();

            for (LinkedList<MyNode<K, V>> myNodes : data) {
                if (myNodes != null)
                    nodes.addAll(myNodes);
            }

            return nodes;
        }

        private MyNode<K, V> findNode(LinkedList<MyNode<K, V>> collisionList, K key) {
            if (collisionList == null) return null;

            for (MyNode<K, V> myNode : collisionList) {
                if (myNode.key.equals(key))
                    return myNode;
            }

            return null;
        }

        public static class MyNode<K, V> {
            final K key;
            V value;

            public MyNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
