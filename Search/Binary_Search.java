package Search;

import org.tec.datastructures.*;

public class Binary_Search<T>  {
	
	/** * Busca un valor numerico dentro de un arreglo numerico... * previamente ordenado usando el metodo de busqueda binaria * * @param arreglo con los elementos; dato a buscar * @return posicion del elemento buscado, en caso de no existir retorna -1 */
	public static <T extends Comparable<T>> Integer busquedaBinariaArray(T[] vector, T dato){
		int n = vector.length; 
		int centro,inf=0,sup=n-1; 
		
		while(inf<=sup){ 
			centro=(sup+inf)/2; 
			if(vector[centro]==dato){ 
                            System.out.println(centro);
                            return centro;} 
                        else 
                            if(dato.compareTo(vector [centro])<0 ){ 
                                sup=centro-1;  
                            }
                            else { 
                                inf=centro+1; 
                            } 
                } 
                return -1; 
        } 
        
        
        /** * Busca un valor numerico dentro de un arreglo numerico... * previamente ordenado usando el metodo de busqueda binaria * * @param arreglo con los elementos; dato a buscar * @return posicion del elemento buscado, en caso de no existir retorna -1 */
	public static <T extends Comparable<T>> int busquedaBinariaLinkedList(LinkedList<T> list, T dato){
		int n = list.getSize(); 
		int centro,inf=0,sup=n-1; 
		
		while(inf<=sup){ 
			centro=(sup+inf)/2; 
			if(list.getAt(centro).getData()==dato){ 
                            System.out.println(centro);
                            return centro;} 
                        else 
                            if(dato.compareTo(list.getAt(centro).getData())<0 ){ 
                                sup=centro-1;  
                            }
                            else { 
                                inf=centro+1; 
                            } 
                } 
                return -1; 
        } 
        
        public static <T extends Comparable<T>> int busquedaBinariaDoubleLinkedList(DoubleLinkedList<T> list, T dato){
		int n = list.getSize(); 
		int centro,inf=0,sup=n-1; 
		
		while(inf<=sup){ 
			centro=(sup+inf)/2; 
			if(list.getAt(centro).getData()==dato){ 
                            System.out.println(centro);
                            return centro;} 
                        else 
                            if(dato.compareTo(list.getAt(centro).getData())<0 ){ 
                                sup=centro-1;  
                            }
                            else { 
                                inf=centro+1; 
                            } 
                } 
                return -1; 
        } 
}
