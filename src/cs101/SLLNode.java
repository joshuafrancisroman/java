/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;

/*Roman, Joshua Francis
* 3CSD-34
* Lab Exercise 6
* 
* 
*/
public class SLLNode<T> {
        public T info; //generic class 'T' put into object 'info'
        public SLLNode<T> next;
        
        public SLLNode() //constructs empty node
        {
            next=null;
        }
        public SLLNode(T el)
        {
            info=el;
            next=null;
        }
        public SLLNode(T el,SLLNode<T> ptr)
        {
            info=el;
            next=ptr;
        }  
    }
    
    
    
    
    
    
    
    
    
    
    
    /*public T info; //T is a class. Where value is an object of class T which holds the value per node
    public SLLNode<T> next;//points to next node
    private SLLNode<T> head=null;
    private SLLNode<T> tail=null;
    public SLLNode() //create three different constructors that initializes the node 
    {
            info=null;
            next=null;
    }
    
    public SLLNode(T element) //element and pointer are passer parameters for value and next. Where the pointer is an object of SLLNode
    {
        info=element;
        next=null;
    }
    
    public SLLNode(T element,SLLNode<T> pointer)
    {
        info=element;
        next=pointer;
    }
    
    public void addToHead(T element)
    {
        //3 cases. No element,1 element,Many elements. case 2 and 3 is the same in here
        //if no element: the new head would create a node pointing to the old head, which is null then also update the tail
        //if there is an existing element/node: make new head and point it to old head no need to update others nor tail
        head=new SLLNode<>(element,head);//replaces the new head with the new element, which points to the old head
        if(tail==null)
            tail=head; // re initializes the tail if it was null.
    }
    
    public void addToTail(T element)
    {
        if(isEmpty())
            head=tail=new SLLNode<>(element);
        else
            tail=tail.next=new SLLNode<>(element);//points the older tail to a new tail then reinitializes the tail to the new one
    }
    
    @Override
    public String toString()
    {
        String s=""; SLLNode<T> temp;
        for(temp=head;temp!=null;temp=temp.next)
            s=s+temp.info+" ";
        return s;
    }
    
    public Boolean isEmpty()
    {
        if(tail==null)
            return true;
        else
            return false;
    }
    
    public double sumDouble()
    {
        SLLNode <Double> temp=(SLLNode <Double>) head;
        double sum=0;
        if(temp==null)
        {
            System.out.println("There are no values");
            return sum;
        }
        else
        {
            while(temp!=null)
            {
                sum+=temp.info;//
                temp=temp.next;
            }
        }
        return sum;
        
    }
    //use comparable because this is a generic class
    public void delete(T element) //deletes the first occurence of the element //can also return the element deleted to be safe //needs improvement
    {
        SLLNode<T> temp=head;
        if(temp==null)
            System.out.println("The value does not exist");
        else if(((Comparable)temp.info).compareTo(element)==0)//if head
        {
            head=head.next;
        }
        else //if more than one and it is in middle or tail(but the old tail still exists, so need to update the tail)
        {
            SLLNode<T> succ=temp.next;//succ=successor. can use the predecessor approach also
            while(succ!=null  && ((Comparable)succ.info).compareTo(element)!=0) //if succ.next and succ.value is null then succ is null else if 1 is not null then succ is not null(josh observation)
            {
                succ=succ.next;
                temp=temp.next;
            }
            if(succ==null)
                System.out.println("The value does not exist");
            else
            {
                temp.next=succ.next;
            }
        }
    }
    */


