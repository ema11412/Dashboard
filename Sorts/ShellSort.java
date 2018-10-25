package sorts;
import java.util.ArrayList;
import org.tec.algo.search.*;
import org.tec.algo.sort.*;
import org.tec.datastructures.*;

public class ShellSort<E> {
	
	//para arrays
	public static <E extends Comparable<E>> void shellArray(E[] v) {
        final int N = v.length;
        int incremento = N;
        do {
            incremento = incremento / 2;
            for (int k = 0; k < incremento; k++) {
                for (int i = incremento + k; i < N; i += incremento) {
                    int j = i;
                    while (j - incremento >= 0 && v[j].compareTo(v[j - incremento]) < 0) {
                        E tmp = v[j];
                        v[j] = v[j - incremento];
                        v[j - incremento] = tmp;
                        j -= incremento;
                    }
                }
            }
        } while (incremento > 1);
    }
	
	//para arraylist
	public static <E extends Comparable<E>> void shellArrayList(ArrayList<E> v) {
        final int N = v.size();
        int incremento = N;
        do {
            incremento = incremento / 2;
            for (int k = 0; k < incremento; k++) {
                for (int i = incremento + k; i < N; i += incremento) {
                    int j = i;
                    while (j - incremento >= 0 && v.get(j).compareTo(v.get(j-incremento)) < 0) {
                        E tmp = v.get(j);
                        v.set(j, v.get(j-incremento));
                        v.set(j-incremento, tmp);
                        j -= incremento;
                    }
                }
            }
        } while (incremento > 1);
    }
	
	//para linkedlist
	
	public static <E extends Comparable<E>> void shellLinked(LinkedList<E> list) {
        final int N = list.getSize();
        int incremento = N;
        do {
            incremento = incremento / 2;
            for (int k = 0; k < incremento; k++) {
                for (int i = incremento + k; i < N; i += incremento) {
                    int j = i;
                    while (j - incremento >= 0 && list.getAt(j).getData().compareTo(list.getAt(j-incremento).getData()) < 0) {
                        E tmp = list.getAt(j).getData();
                        list.getAt(j).setData(list.getAt(j-incremento).getData());			    
                        list.getAt(j-incremento).setData(tmp);
                        j -= incremento;
                    }
                }
            }
        } while (incremento > 1);
    }
	
	////////DoubleLinkedList
	public static <E extends Comparable<E>> void shellDoubleLinked(DoubleLinkedList<E> list) {
        final int N = list.getSize();
        int incremento = N;
        do {
            incremento = incremento / 2;
            for (int k = 0; k < incremento; k++) {
                for (int i = incremento + k; i < N; i += incremento) {
                    int j = i;
                    while (j - incremento >= 0 && list.getAt(j).getData().compareTo(list.getAt(j-incremento).getData()) < 0) {
                        E tmp = list.getAt(j).getData();
                        list.getAt(j).setData(list.getAt(j-incremento).getData());			    
                        list.getAt(j-incremento).setData(tmp);
                        j -= incremento;
                    }
                }
            }
        } while (incremento > 1);
    }
	

}
