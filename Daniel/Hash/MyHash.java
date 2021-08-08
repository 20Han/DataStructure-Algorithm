import java.util.LinkedList;
import java.util.ListIterator;

public class MyHash<T> {
        private LinkedList<Node<T>>[] data;
        private int size;

        @SuppressWarnings("unchecked")
        public MyHash(int size)
        {
            this.size = size;
            data = (LinkedList<Node<T>>[])new LinkedList[size];
        }

        private class Node<T>
        {
            public String key;
            public T value;

            public Node(String key, T value)
            {
                this.key = key;
                this.value = value;
            }
        }
        private int getIndex(String key)
        {
            return Math.abs(key.hashCode()) % size;
        }

        public T get(String key)
        {
            int index = getIndex(key);
            if(data[index] == null)
            {
                return null;
            }
            ListIterator i = data[index].listIterator();
            while(i.hasNext())
            {
                Node<T> node = (Node<T>)i.next();
                if(node.key.equals(key))
                    return node.value;
            }
            return null;
        }
        public boolean put(String key, T value)
        {
            int index = getIndex(key);
            try
            {
                if(data[index] == null)
                {
                    data[index] = new LinkedList<Node<T>>();
                    data[index].add(new Node(key, value));
                    return true;
                }
                else
                {
                    ListIterator i = data[index].listIterator();
                    while(i.hasNext())
                    {
                        Node<T> node = (Node<T>)i.next();
                        if(node.key.equals(key))
                        {
                            node.value = value;
                            return true;
                        }
                    }
                    data[index].add(new Node(key, value));
                    return true;
                }
            }
            catch(Exception e)
            {
                return false;
            }
        }

        public boolean remove(String key)
        {
            int index = getIndex(key);
            if(data[index] != null)
            {
                ListIterator i = data[index].listIterator();
                while(i.hasNext())
                {
                    Node<T> node = (Node<T>)i.next();
                    if(node.key.equals(key))
                    {
                        data[index].remove(key);
                        return true;
                    }
                }
            }
            return false;
        }
    }
