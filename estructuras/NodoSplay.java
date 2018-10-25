package Arboles;
//Nodo splay
class NodoSplay <B extends Comparable<B>>{
  private B datos;
  NodoSplay Hiz;
  NodoSplay Hde;
  
  public NodoSplay (B data){
	    datos = data;
	    Hiz = null;
	    Hde = null;
	  }
  public String getData(){
      return (String) datos;
  }
  public void setData(B data){
      datos = data;
  }
  
  
  
}