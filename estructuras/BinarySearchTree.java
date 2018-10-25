
public class BinarySearchTree <B extends Comparable<B>>{
    public   NodoArbolBinario root;
    private  String lookstack;
    public BinarySearchTree(){
            this.root = null;
    }

    public boolean isMember(B id){
        NodoArbolBinario current = root;
        while(current!=null){
            if(current.getData()==id){
                    return true;
            }else if(current.getData().compareTo((String)id)>0){
                    current = current.left;
            }else{
                    current = current.right;
            }
        }
        return false;
    }
    public NodoArbolBinario getMember(B id){
        NodoArbolBinario current = root;
        while(current!=null){
            if(current.getData()==id){
                    return current;
            }else if(current.getData().compareTo((String) id)>0){
                    current = current.left;
            }else{
                    current = current.right;
            }
        }
        return null;
    }
    
    public boolean delete(B id){
        NodoArbolBinario parent = root;
        NodoArbolBinario current = root;
        boolean isLeftChild = false;
        while(!current.getData().equals(id)){
            parent = current;
            if(current.getData().compareTo((String)id)>0){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }
            if(current ==null){
                return false;
            }
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild ==true){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if(current.right==null){
            if(current==root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left==null){
            if(current==root){
                root = current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if(current.left!=null && current.right!=null){

            //now we have found the minimum element in the right sub tree
            NodoArbolBinario successor = getSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }			
            successor.left = current.left;
        }		
        return true;		
    }

    public NodoArbolBinario getSuccessor(NodoArbolBinario deleleNode){
        NodoArbolBinario successsor =null;
        NodoArbolBinario successsorParent =null;
        NodoArbolBinario current = deleleNode.right;
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
            //successsorParent
        if(successsor!=deleleNode.right){
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }
    public void insert(B id){
        NodoArbolBinario newNode = new NodoArbolBinario(id);
        if(root==null){
            root = newNode;
            return;
        }
        NodoArbolBinario current = root;
        NodoArbolBinario parent = null;
        while(true){
            parent = current;
            if(current.getData().compareTo((String) id)>0){				
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
    public void display(){
        display(root);      
    }
    
    private void display(NodoArbolBinario root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.getData());
            display(root.right);
        }
    }
    
    public String displayIn(){
        lookstack = "";
        displayIn(root);
        return lookstack;
    }
    
    private void displayIn(NodoArbolBinario root){
        if(root!=null){
            displayIn(root.left);
            lookstack += root.getData();
            //System.out.print(" " + root.getData().getName());
            displayIn(root.right);
        }
    }
    
    public void displayPre(){
        displayPre(root);      
    }
    
    private void displayPre(NodoArbolBinario root){
        if(root!=null){
            System.out.print(" " + root.getData());
            displayPre(root.left);
            displayPre(root.right);
        }
    }
    
 
    
    public int findHeight(NodoArbolBinario current) {
    if (current == null) {
        return -1;
    }
        int lefth = findHeight(current.left);
        int righth = findHeight(current.right);

    if (lefth > righth) {
        return lefth + 1;
    } else {
        return righth + 1;
    }
    }

    
    
    

        
        
 

}

