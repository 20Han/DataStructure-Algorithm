package StackQueue.Frinter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private class Document
    {
        int location;
        int priority;
        private Document(int location, int priority)
        {
            this.location = location;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        Queue<Document> source_queue = new LinkedList<Document>();
        for(int i=0; i<priorities.length; i++)
        {
            source_queue.add(new Document(i, priorities[i]));
        }

        int deleted_documents = 0;
        while(true)
        {
            Document curr = source_queue.poll();
            Iterator<Document> iter = source_queue.iterator();
            boolean isDeleted = true;
            while(iter.hasNext())
            {
                if(curr.priority < iter.next().priority)
                {
                    source_queue.add(curr);
                    isDeleted = false;
                    break;
                }
            }
            if(isDeleted)
            {
                deleted_documents++;
                if(curr.location == location)
                    return deleted_documents;
            }
        }
    }
}
