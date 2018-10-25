package sorts;

import java.lang.*;
import org.tec.algo.search.*;
import org.tec.algo.sort.*;
import org.tec.datastructures.*;
import java.util.ArrayList;

public class MergeSort<T> {
    
	
	//////////////////////////////////para arrays
	
    
    public static <T extends Comparable<T>> void sort(T[] a) {
	mergesort(a, 0, a.length-1);
    }
    
   
    private static <T extends Comparable<T>> void mergesort (T[] a, int i, int j) {
	if (j-i < 1) return;
	int mid = (i+j)/2;
	mergesort(a, i, mid);
	mergesort(a, mid+1, j);
	merge(a, i, mid, j);
    }

   
    private static <T extends Comparable<T>> void  merge(T[] a, int p, int mid, int q) {

	Object[] tmp = new Object[q-p+1]; 
	int i = p;
	int j = mid+1;
	int k = 0;
	while (i <= mid && j <= q) {
	    if (a[i].compareTo(a[j])<=0)
		tmp[k] = a[i++];
	    else
		tmp[k] = a[j++];
	    k++;
	}
	if (i <= mid && j > q) {
	    while (i <= mid) 
		tmp[k++] = a[i++];
	} else {
	    while (j <= q)
		tmp[k++] = a[j++];
	}
	for (k = 0; k < tmp.length; k++) {
	    a[k+p] = (T)(tmp[k]); 
	}
    }
    
    ////////////////// para array list
    public static <T extends Comparable<T>> void sortArrayList(ArrayList<T> a) {
    	mergesortArrayList(a, 0, a.size()-1);
        }
        
    	private static <T extends Comparable<T>> void mergesortArrayList (ArrayList<T> a, int i, int j) {
    	if (j-i < 1) return;
    	int mid = (i+j)/2;
    	mergesortArrayList(a, i, mid);
    	mergesortArrayList(a, mid+1, j);
    	mergeArrayList(a, i, mid, j);
        }

        // Merge method
        // Here we need to allocate a new array, but Java does not allow allocating arrays of a generic type
        // As a work-around we allocate an array of type Object[] the use type casting
        // This would usually generate a warning, which is suppressed
        private static <T extends Comparable<T>> void  mergeArrayList(ArrayList<T> a, int p, int mid, int q) {

    	Object[] tmp = new Object[q-p+1]; 
    	int i = p;
    	int j = mid+1;
    	int k = 0;
    	while (i <= mid && j <= q) {
    	    if (a.get(i).compareTo(a.get(j))<=0)
    		tmp[k] = a.get(i++);
    	    else
    		tmp[k] = a.get(j++);
    	    k++;
    	}
    	if (i <= mid && j > q) {
    	    while (i <= mid) 
    		tmp[k++] = a.get(i++);
    	} else {
    	    while (j <= q)
    		tmp[k++] = a.get(j++);
    	}
    	for (k = 0; k < tmp.length; k++) {
    	    a.set(k+p, (T)(tmp[k])) ; // this is the line that woudl generate the warning 
    	}
        }
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////para linkedList////////////////////////////////////////
        public static <T extends Comparable<T>> void MergeSortLinkedList(LinkedList<T> list) {
        	Node<T> n = list.getHead();
        	mergesortLinked(list, 0, list.getSize()-1, n);
            }
            
        	private static <T extends Comparable<T>> void mergesortLinked (LinkedList<T> a, int i, int j, Node<T> n) {
        	if (j-i < 1) return;
        	int mid = (i+j)/2;
        	mergesortLinked(a, i, mid,n);
        	mergesortLinked(a, mid+1, j, n);
        	mergeLinked(a, i, mid, j, n);
            }

            // Merge method
            // Here we need to allocate a new array, but Java does not allow allocating arrays of a generic type
            // As a work-around we allocate an array of type Object[] the use type casting
            // This would usually generate a warning, which is suppressed
            private static <T extends Comparable<T>> void  mergeLinked(LinkedList<T> a, int p, int mid, int q, Node<T> n) {

        	Object[] tmp = new Object[q-p+1]; 
        	int i = p;
        	int j = mid+1;
        	int k = 0;
        	while (i <= mid && j <= q) {
        	    if(a.getAt(i).getData().compareTo(a.getAt(j).getData())<=0)
        		tmp[k] = a.getAt(i++).getData();
        	    else
        		tmp[k] = a.getAt(j++).getData();
        	    k++;
        	}
        	if (i <= mid && j > q) {
        	    while (i <= mid) 
        		tmp[k++] = a.getAt(i++).getData();
        	} else {
        	    while (j <= q)
        		tmp[k++] = a.getAt(j++).getData();
        	}
        	for (k = 0; k < tmp.length; k++) {
        		a.getAt(k+p).setData((T)tmp[k]);
            }
            }   
            
            //////////////////////////////////////////
            ///////////////////////////////////////////
            /////////Para doubleLinkedList
            public static <T extends Comparable<T>> void MergeSortDoubleLinkedList(DoubleLinkedList<T> list) {
            	Node<T> n = list.getHead();
            	mergesortDoubleLinked(list, 0, list.getSize()-1, n);
                }
                
            	private static <T extends Comparable<T>> void mergesortDoubleLinked (DoubleLinkedList<T> a, int i, int j, Node<T> n) {
            	if (j-i < 1) return;
            	int mid = (i+j)/2;
            	mergesortDoubleLinked(a, i, mid,n);
            	mergesortDoubleLinked(a, mid+1, j, n);
            	mergeDoubleLinked(a, i, mid, j, n);
                }

                // Merge method
                // Here we need to allocate a new array, but Java does not allow allocating arrays of a generic type
                // As a work-around we allocate an array of type Object[] the use type casting
                // This would usually generate a warning, which is suppressed
                private static <T extends Comparable<T>> void  mergeDoubleLinked(DoubleLinkedList<T> a, int p, int mid, int q, Node<T> n) {

            	Object[] tmp = new Object[q-p+1]; 
            	int i = p;
            	int j = mid+1;
            	int k = 0;
            	while (i <= mid && j <= q) {
            	    if(a.getAt(i).getData().compareTo(a.getAt(j).getData())<=0)
            		tmp[k] = a.getAt(i++).getData();
            	    else
            		tmp[k] = a.getAt(j++).getData();
            	    k++;
            	}
            	if (i <= mid && j > q) {
            	    while (i <= mid) 
            		tmp[k++] = a.getAt(i++).getData();
            	} else {
            	    while (j <= q)
            		tmp[k++] = a.getAt(j++).getData();
            	}
            	for (k = 0; k < tmp.length; k++) {
            		a.getAt(k+p).setData((T)tmp[k]);
                }
                }   
}
