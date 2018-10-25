package sorts;
import java.util.ArrayList;
import org.tec.algo.search.*;
import org.tec.algo.sort.*;
import org.tec.datastructures.*;

public class RadixSort {
	
	public void radixArray( int[] a)
    {
        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[10];
        
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        
        while (m / exp > 0)
        {
            int[] bucket = new int[10];
 
            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            for (i = 0; i < n; i++)
                a[i] = b[i];
            exp *= 10;        
        }
    }    
    
    
	public static void radixArrayList(ArrayList a)
    {
        int i, m = (int) a.get(0), exp = 1, n = a.size();
        int[] b = new int[10];
        
        for (i = 1; i < n; i++)
            if ((int) a.get(i) > m)
                m = (int) a.get(i);
        
        while (m / exp > 0)
        {
            int[] bucket = new int[10];
 
            for (i = 0; i < n; i++)
                bucket[((int)a.get(i) / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[((int)a.get(i) / exp) % 10]] = (int) a.get(i);
            for (i = 0; i < n; i++)
                a.set(i, b[i]);
            exp *= 10;        
        }
    }
	
	///////////////////LinkedList
	public static void radixLinkedList(LinkedList a)
    {
        int i, m = (int) a.getAt(0).getData(), exp = 1, n = a.getSize();
        int[] b = new int[10];
        
        for (i = 1; i < n; i++)
            if ((int) a.getAt(i).getData() > m)
                m = (int) a.getAt(i).getData();
        
        while (m / exp > 0)
        {
            int[] bucket = new int[10];
 
            for (i = 0; i < n; i++)
                bucket[((int)a.getAt(i).getData() / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[((int)a.getAt(i).getData() / exp) % 10]] = (int) a.getAt(i).getData();
            for (i = 0; i < n; i++)
                a.getAt(i).setData(b[i]);		
            exp *= 10;        
        }
    }    
    ///////////////////////////doubleLinkedList
	public static void radixDoubleLinkedList(DoubleLinkedList a)
    {
        int i, m = (int) a.getAt(0).getData(), exp = 1, n = a.getSize();
        int[] b = new int[10];
        
        for (i = 1; i < n; i++)
            if ((int) a.getAt(i).getData() > m)
                m = (int) a.getAt(i).getData();
        
        while (m / exp > 0)
        {
            int[] bucket = new int[10];
 
            for (i = 0; i < n; i++)
                bucket[((int)a.getAt(i).getData() / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[((int)a.getAt(i).getData() / exp) % 10]] = (int) a.getAt(i).getData();
            for (i = 0; i < n; i++)
                a.getAt(i).setData(b[i]);		
            exp *= 10;        
        }
    }  
}