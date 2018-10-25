package Estructuras;


public class Cola<T> 
{
    private Node<T> head;
    private int size;
    /////////////////////////////////////////////////////////
    public void doubleLinkedList(){
        this.head = null;
        this.size = 0;
    }
    public Node<T> Peek() 
    {
        return this.head;
    }
    

    
    public void encolar( T data )
    {
        Node<T> ultimo = new Node<T>( data );
        this.size++;
        Node<T> current = this.head;
        if (head == null)
            head = ultimo;
        else
        {
            while (current.getNext() != null)
                current = current.getNext();
            current.setNext( ultimo );
            ultimo.setPrevious(current);
        }
    }
    

    

    
    public  desencolar(){

        Node<T> current = head;
        Node<T> current1 = head;
        current = current.getNext();
        head = current;
        head.setPrevious(null);
        size--;
        return this.current1;
    }
    


    
    public String toString()
    {
		String datos = "";
		Node<T> current = head;
		while( current.getNext() != null )
		{
			if(current.getData() == ""){
				current = current.getNext();
			}else{
			datos += current.getData() + ";";
			current = current.getNext();
			}
		}
		if(current.getData() != ""){
		datos += current.getData();
		datos += ";";
		}
		return datos;
		
    }
}
