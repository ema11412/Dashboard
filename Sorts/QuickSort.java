package sorts;
import java.util.ArrayList;
import org.tec.algo.search.*;
import org.tec.algo.sort.*;
import org.tec.datastructures.*;

public class QuickSort {
    
	///para arrayList
  
    public static <T extends Comparable<T>> void sortArrayList(ArrayList<T> a) {
    	quicksort(a, 0, a.size()-1);
    }

    private static <T extends Comparable<T>> void quicksort (ArrayList<T> a, int i, int j) {
		if (i<j) {
		    int l = partition(a,i,j);
		    quicksort(a, i, l);
		    quicksort(a, l+1, j);
		}
    }

    private static <T extends Comparable<T>> int partition(ArrayList<T> a, int p, int q) {
		T x = a.get(p);
		int m = (p+q)/2;
		if ((a.get(p).compareTo(a.get(m))<=0 && a.get(m).compareTo(a.get(q))<=0) || (a.get(q).compareTo(a.get(m))<=0 && a.get(m).compareTo(a.get(p))<=0))
		    x = a.get(m);
		if ((a.get(p).compareTo(a.get(q))<=0 && a.get(q).compareTo(a.get(m))<=0) || (a.get(m).compareTo(a.get(q))<=0 && a.get(q).compareTo(a.get(p))<=0))
		    x = a.get(q);
		int i = p-1;
		int j = q+1;
		while (true) {
		    do i++; while (!(i>q || a.get(i).compareTo(x)>=0));
		    do j--; while (!(j<p || a.get(j).compareTo(x)<=0));
		    if (i<j) swap(a, i, j);
		    else return j;
		}
    }

    private static <T extends Comparable<T>> void swap (ArrayList<T> a, int i, int j) {
		T x;
		x = a.get(i);
		a.set(i, a.get(j)) ;
		a.set(j, x);
    }
    
    ///para array
    
    public static <T extends Comparable<T>> void sort(T[] a) {
    	quicksort(a, 0, a.length-1);
    }


    private static <T extends Comparable<T>> void quicksort (T[] a, int i, int j) {
		if (i<j) {
		    int l = partition(a,i,j);
		    quicksort(a, i, l);
		    quicksort(a, l+1, j);
		}
    }

    private static <T extends Comparable<T>> int partition(T[] a, int p, int q) {
		T x = a[p];
		int m = (p+q)/2;
		if ((a[p].compareTo(a[m])<=0 && a[m].compareTo(a[q])<=0) || (a[q].compareTo(a[m])<=0 && a[m].compareTo(a[p])<=0))
		    x = a[m];
		if ((a[p].compareTo(a[q])<=0 && a[q].compareTo(a[m])<=0) || (a[m].compareTo(a[q])<=0 && a[q].compareTo(a[p])<=0))
		    x = a[q];
		int i = p-1;
		int j = q+1;
		while (true) {
		    do i++; while (!(i>q || a[i].compareTo(x)>=0));
		    do j--; while (!(j<p || a[j].compareTo(x)<=0));
		    if (i<j) swap(a, i, j);
		    else return j;
		}
    }

    private static <T extends Comparable<T>> void swap (T[] a, int i, int j) {
		T x;
		x = a[i];
		a[i] = a[j];
		a[j] = x;
    }
    
    /// Para LinkedList 
   //*********************************************************************************************************************************
    ///////////////******************************************************************************************************
    public static <T extends Comparable<T>> void QuickSortLinkedList(LinkedList<T> a) {
    	Node<T> n = a.getHead();
    	quicksortLin(a, 0, a.getSize()-1, n);
    }

    private static <T extends Comparable<T>> void quicksortLin (LinkedList<T> a, int i, int j, Node<T> n) {
		if (i<j) {
		    int l = partitionLin(a,i,j, n);
		    quicksortLin(a, i, l, n);
		    quicksortLin(a, l+1, j, n);
		}
    }

    private static <T extends Comparable<T>> int partitionLin(LinkedList<T> a, int p, int q, Node<T> n) {
		T x = a.getAt(p).getData();
		int m = (p+q)/2;
		if ((a.getAt(p).getData().compareTo(a.getAt(m).getData())<=0 && (a.getAt(m).getData().compareTo(a.getAt(q).getData())<=0) || a.getAt(q).getData().compareTo(a.getAt(m).getData())<=0 && a.getAt(m).getData().compareTo(a.getAt(p).getData())<=0))
		    x = a.getAt(m).getData();
		if ((a.getAt(p).getData().compareTo(a.getAt(q).getData())<=0 && a.getAt(q).getData().compareTo(a.getAt(m).getData())<=0) || (a.getAt(m).getData().compareTo(a.getAt(q).getData())<=0 && a.getAt(q).getData().compareTo(a.getAt(p).getData())<=0))
		    x = a.getAt(q).getData();
		int i = p-1;
		int j = q+1;
		while (true) {
		    do i++; while (!(i>q ||a.getAt(i).getData().compareTo(x)>=0));
		    do j--; while (!(j<p || a.getAt(j).getData().compareTo(x)<=0));
		    if (i<j) swapLin(a, i, j, n);
		    else return j;
		}
    }

    private static <T extends Comparable<T>> void swapLin (LinkedList<T> a, int i, int j, Node<T> n) {
		T x;
		x = a.getAt(i).getData();
		a.getAt(i).setData(a.getAt(j).getData());
		a.getAt(j).setData(x);		
    }
    
  /// Para LinkedList 
    //*********************************************************************************************************************************
     ///////////////******************************************************************************************************
     public static <T extends Comparable<T>> void QuickSortDoubleLinkedList(DoubleLinkedList<T> a) {
     	Node<T> n = a.getHead();
     	quicksortDoubleLin(a, 0, a.getSize()-1, n);
     }

     private static <T extends Comparable<T>> void quicksortDoubleLin (DoubleLinkedList<T> a, int i, int j, Node<T> n) {
 		if (i<j) {
 		    int l = partitionDoubleLin(a,i,j, n);
 		    quicksortDoubleLin(a, i, l, n);
 		    quicksortDoubleLin(a, l+1, j, n);
 		}
     }

     private static <T extends Comparable<T>> int partitionDoubleLin(DoubleLinkedList<T> a, int p, int q, Node<T> n) {
 		T x = a.getAt(p).getData();
 		int m = (p+q)/2;
 		if ((a.getAt(p).getData().compareTo(a.getAt(m).getData())<=0 && (a.getAt(m).getData().compareTo(a.getAt(q).getData())<=0) || a.getAt(q).getData().compareTo(a.getAt(m).getData())<=0 && a.getAt(m).getData().compareTo(a.getAt(p).getData())<=0))
 		    x = a.getAt(m).getData();
 		if ((a.getAt(p).getData().compareTo(a.getAt(q).getData())<=0 && a.getAt(q).getData().compareTo(a.getAt(m).getData())<=0) || (a.getAt(m).getData().compareTo(a.getAt(q).getData())<=0 && a.getAt(q).getData().compareTo(a.getAt(p).getData())<=0))
 		    x = a.getAt(q).getData();
 		int i = p-1;
 		int j = q+1;
 		while (true) {
 		    do i++; while (!(i>q ||a.getAt(i).getData().compareTo(x)>=0));
 		    do j--; while (!(j<p || a.getAt(j).getData().compareTo(x)<=0));
 		    if (i<j) swapDoubleLin(a, i, j, n);
 		    else return j;
 		}
     }

     private static <T extends Comparable<T>> void swapDoubleLin (DoubleLinkedList<T> a, int i, int j, Node<T> n) {
 		T x;
 		x = a.getAt(i).getData();
 		a.getAt(i).setData(a.getAt(j).getData());
 		a.getAt(j).setData(x);		
     }
    
   
	    	
    
}
