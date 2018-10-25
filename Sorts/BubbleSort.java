package Sorts;

import java.util.ArrayList;

import org.tec.algo.search.*;
import org.tec.algo.sort.*;
import org.tec.datastructures.*;

/**
 * 
 * @author Bryan
 *
 * @param <E>
 */

///para arrays
public class BubbleSort<E> {

	public static<E extends Comparable<E>> void bubbletArray(E[] arr) {
	    for (int j = arr.length - 1; j >= 0; j--) {
	        for (int i = 1; i <= j; i++) {
	            if (arr[i-1].compareTo(arr[i]) > 0) {
	                E tmp = arr[i-1];
	                arr[i-1] = arr[i];
	                arr[i] = tmp;
	            }
	        }
	    }
	}
	
///para array list
	public static <E extends Comparable<E>>void bubbleArrayList(ArrayList<E> arr)
	{
		for(int j=0;j<arr.size();j++){
			
			for(int i=j+1;i<arr.size();i++){
				if((arr.get(i)).compareTo(arr.get(j))<0){
					
					E t = arr.get(j);
					arr.set(j, arr.get(i));
					arr.set(i, t);
				}
			}
		}
	  }
	
/// para listas enlazadas
	public static <T extends Comparable<T>>void bubbleLinkedList(LinkedList<T> list){
		Node<T> head = list.getHead();
		bubbleLinked(head);
	}
	
	public static <T extends Comparable<T>>void bubbleDoubleLinkedList(DoubleLinkedList<T> list){
		Node<T> head = list.getHead();
		bubbleLinked(head);
	}
	
	public static <T extends Comparable<T>>void bubbleLinked(Node<T> head)
	{
	        Node<T> i, j;
	        i = head;
	        T temp;
	        
	        {
	            for (i = head; i!=null; i=i.getNext()) // bubble sort outer loop
	            {
	                for (j=i.getNext(); j!=null; j= j.getNext()) {
	                    if ((i.getData()).compareTo(j.getData())>0)
	                    {
	                        temp = i.getData();
	                        i.setData(j.getData());
	                        j.setData(temp);
	                    }
	                }
	            }
	        }
	  }
}

