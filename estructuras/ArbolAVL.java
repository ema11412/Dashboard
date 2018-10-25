
import java.io.File;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.*;

//Arbol AVl
public class ArbolAVL <B extends Comparable<B>>{
	String impresor="";
	NodoAVL A;
	boolean Hh;
	//Guarda las rotaciones en un archivo
	
	//Inserta un elemento en el arbol
	public void Insercion (B data){
		if ((!Miembro (data,A))){
			NodoAVL info = new NodoAVL(data);
			A=InsertarBalanceado(A,info);
		}
		else
			System.out.println("Error autor repetido");
	}
	//Auxiliar de Insercion
	NodoAVL InsertarBalanceado(NodoAVL R, NodoAVL Nodo){
		NodoAVL N1;
		NodoAVL info = Nodo;
		if (ArbolVacio(R)){
			R= info;
			Hh=true;
		}
		else
                    // 2 > 1 = true
                    //("u".compareTo("d")>0)
			if (R.getData().compareTo(Nodo.getData()) >0){
				R.Izquierdo=InsertarBalanceado(R.Izquierdo,Nodo);
				if (Hh)
					switch(R.Factbalance){
						case 1:{
							R.Factbalance= 0;
							Hh=false;
						}	
						break;
						case 0:
							R.Factbalance= -1; 
						break;
						//se reestructura ya que pasaria a valer-2 y se desequilibra a la izq
						case -1:{
							N1=R.Izquierdo;
							if (N1.Factbalance== -1){   
								R = RotacionIzquierdaIzquierda(R,N1);
							}
							else{
								R = RotacionIzquierdaDerecha(R,N1);
							}
							Hh = false;
						}
						break;
					}		
			}
			else{	
			if (Nodo.getData().compareTo(R.getData()) >0){
				R.Derecho=InsertarBalanceado(R.Derecho, Nodo);
				if (Hh)
				switch(R.Factbalance){
					case -1:
						R.Factbalance=0;
						Hh=false;	
					break;
					case 0:
						R.Factbalance=1; 
					break;
					//se reestructura ya que pasaria a valer-2 y se desequilibra a la izq
					case 1:{
						N1=R.Derecho;
						if (N1.Factbalance==1){
							R = RotacionDerechaDerecha(R,N1);
						}
						else{
							R = RotacionDerechaIzquierda(R,N1);
						}
						Hh = false;
					}
					break;
				}	
				
			}
			else{
				System.out.println("Error: No se pueden numeros iguales");
				Hh = false;
			}
		}
	return R;	
	}
	//retorna si esta vacio
	boolean ArbolVacio(NodoAVL R){
		return (R == null);
	}
	//rota a la derecha
	NodoAVL RotacionDerechaDerecha(NodoAVL N, NodoAVL N1){
		N.Derecho = N1.Izquierdo;
		N1.Izquierdo = N;
		if (N1.Factbalance==1) {
			N.Factbalance=0;
			N1.Factbalance=0;
		}
		else{
			N.Factbalance = 1;
			N1.Factbalance = -1;
		}
		N= N1;
		return N;
	}
	
	NodoAVL RotacionDerechaIzquierda(NodoAVL N, NodoAVL N1){
		NodoAVL N2;
		N2 = N1.Izquierdo;
		N.Derecho = N2.Izquierdo;
		N2.Izquierdo=N;
		N1.Izquierdo=N2.Derecho;
		N2.Derecho=N1;
		if (N2.Factbalance==1){
			N.Factbalance=-1;
		}
		else{
			N.Factbalance=0;
		}
		if (N2.Factbalance==-1)
			N1.Factbalance=1;
		else
			N1.Factbalance=0;
		N2.Factbalance=0;
		N=N2;
		return N;
	}
	
	NodoAVL RotacionIzquierdaIzquierda(NodoAVL N, NodoAVL N1){
		N.Izquierdo = N1.Derecho;
		N1.Derecho = N;
		if (N1.Factbalance==-1){
			N.Factbalance=0;
			N1.Factbalance=0;
		}
		else{
			N.Factbalance=-1;
			N1.Factbalance=1;
		}
		N=N1;
		return N;
	}
	
	NodoAVL RotacionIzquierdaDerecha(NodoAVL N, NodoAVL N1){
		NodoAVL N2;
		N2=N1.Derecho;
		N.Izquierdo=N2.Derecho;
		N2.Derecho=N;
		N1.Derecho=N2.Izquierdo;
		N2.Izquierdo=N1;
		if (N2.Factbalance==1)
			N1.Factbalance=-1;
		else
			N1.Factbalance=0;
		if (N2.Factbalance==-1)
			N.Factbalance=1;
		else
			N.Factbalance=0;
		N2.Factbalance=0;
		N=N2;
		return N;
	}
	//Para verificar si esta el autor
	boolean Miembro(B data, NodoAVL R){
		NodoAVL Aux = R;
		boolean miembro = false;
		while (Aux != null){
			if (data==Aux.getData()){
				miembro = true;
				Aux = null;
			}

                        if (((String)data).compareTo(Aux.getData()) >0)
                                Aux = Aux.Derecho;
                        else{
                                Aux = Aux.Izquierdo;
                                if (Aux == null)
                                        miembro = false;
                        }
			
		}
		return miembro;
	}
	//busca la cantidad de nodos de un arbol avl
	int CantidadNodosAVL(NodoAVL A){
		int cont = 0;
		if (A == null) 
			cont = cont;
		else{
			cont = cont + 1 + CantidadNodosAVL(A.Izquierdo) + CantidadNodosAVL(A.Derecho);
		}
		return cont;
	}
	//altura	
	public int Altura(NodoAVL raiz){
		if (raiz == null)
		return 0;
		else
		return	1 + Math.max(Altura(raiz.Izquierdo), Altura(raiz.Derecho));
	}
        
        
        public void PostOrdenAVL()
        {
            PostOrdenAVL (A);
        }
	//Despliega la informacion en Postorden
	private void PostOrdenAVL (NodoAVL Nodo){
		if (Nodo == null){
			return ;
		}
		else{
			PostOrdenAVL (Nodo.Izquierdo);
			PostOrdenAVL (Nodo.Derecho);
			impresor=impresor+"Autor: "+Nodo.getData();
		}
	}
        
        public void InordenAVL()
        {
            InordenAVL (A);
        }
	//Despliega la informacion en Inorden
	private void InordenAVL (NodoAVL Nodo){
		if (Nodo == null)
			return;
		else{
			InordenAVL (Nodo.Izquierdo);
			System.out.print(Nodo.getData()+"  ");
			InordenAVL (Nodo.Derecho);
		}
	}
	

	
    public String get(B data){
        NodoAVL current = A;
        while(current!=null){
            if(current.getData()==data){
            	
                return current.getData();
            }else 
            	if(current.getData().compareTo((String)data) > 0){
                    current = current.Izquierdo;
            }else{
                    current = current.Derecho;
            }
        }
        return null;
    }    
        
    
	
	
}