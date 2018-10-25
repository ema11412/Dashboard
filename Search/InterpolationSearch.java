package Search;

import org.tec.datastructures.*;
import java.util.Scanner;

/** Class InterpolationSearch **/
public class InterpolationSearch<T>
{
    /** interpolationSearch function **/
    public static <T extends Comparable<T>> int interpolationSearchArray(Integer[] sortedArray, Integer toFind)
    {
        int low = 0;
        int high = sortedArray.length - 1;
        int mid;
        while (sortedArray[low].compareTo(toFind)<=0 && sortedArray[high].compareTo(toFind) >= 0) 
        {
            if (sortedArray[high].equals(sortedArray[low]) ){
                System.out.println((low +high)/2);
                return (low + high)/2;}
            /** out of range is possible  here **/
             mid = low + ((toFind - sortedArray[low]) * (high - low)) / (sortedArray[high] - sortedArray[low]);  
 
             if (sortedArray[mid] < toFind)
                 low = mid + 1;
             else if (sortedArray[mid] > toFind)
                 high = mid - 1;
             else
                 return mid;
        }
        if (sortedArray[low] == toFind)
            return low;
           /** not found **/
        else
            return -1; 
    }    
    
    //////////////linkedList
     public static <T extends Comparable<T>> int interpolationSearchLinkedList(LinkedList<Integer> sortedArray, Integer toFind)
    {
        int low = 0;
        int high = sortedArray.getSize() - 1;
        int mid;
        while ((sortedArray.getAt(low).getData().compareTo(toFind)<=0) && ((sortedArray.getAt(high).getData()).compareTo(toFind) >= 0)) 
        {
            if (sortedArray.getAt(high).getData().equals(sortedArray.getAt(low).getData()) ){
                System.out.println((low +high)/2);
                return (low + high)/2;}
            /** out of range is possible  here **/
             mid = low + ((toFind - sortedArray.getAt(low).getData()) * (high - low)) / (sortedArray.getAt(high).getData() - sortedArray.getAt(low).getData());  
 
             if (sortedArray.getAt(mid).getData() < toFind)
                 low = mid + 1;
             else if (sortedArray.getAt(mid).getData() > toFind)
                 high = mid - 1;
             else
                 return mid;
        }
        if (sortedArray.getAt(low).getData() == toFind)
            return low;
           /** not found **/
        else
            return -1; 
    }    
     
     //////////////DoublelinkedList
     public static <T extends Comparable<T>> int interpolationSearchDoubleLinkedList(DoubleLinkedList<Integer> sortedArray, Integer toFind)
    {
        int low = 0;
        int high = sortedArray.getSize() - 1;
        int mid;
        while ((sortedArray.getAt(low).getData().compareTo(toFind)<=0) && ((sortedArray.getAt(high).getData()).compareTo(toFind) >= 0)) 
        {
            if (sortedArray.getAt(high).getData().equals(sortedArray.getAt(low).getData()) ){
                System.out.println((low +high)/2);
                return (low + high)/2;}
            /** out of range is possible  here **/
             mid = low + ((toFind - sortedArray.getAt(low).getData()) * (high - low)) / (sortedArray.getAt(high).getData() - sortedArray.getAt(low).getData());  
 
             if (sortedArray.getAt(mid).getData() < toFind)
                 low = mid + 1;
             else if (sortedArray.getAt(mid).getData() > toFind)
                 high = mid - 1;
             else
                 return mid;
        }
        if (sortedArray.getAt(low).getData() == toFind)
            return low;
           /** not found **/
        else
            return -1; 
    }    
    
    
}