package Spy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

class Solution {
    public int solution(String[][] clothes) {
        MyHash<ArrayList<String>> hash = new MyHash<ArrayList<String>>(30);
        ArrayList<String> kind_list = new ArrayList<String>();
        int result = 1;

        for(int i=0; i<clothes.length; i++)
        {
            String[] list = clothes[i];
            String name = list[0];
            String kind = list[1];
            if(!kind_list.contains(kind))
                kind_list.add(kind);

            ArrayList<String> clothes_in_kind = hash.get(kind);
            if(clothes_in_kind == null)
                clothes_in_kind = new ArrayList<String>();
            clothes_in_kind.add(name);
            hash.put(kind, clothes_in_kind);
        }
        for(String kind : kind_list)
        {
            ArrayList<String> clothes_in_kind = hash.get(kind);
            result *= clothes_in_kind.size()+1;
        }
        result -= 1;
        return result;
    }
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
}
