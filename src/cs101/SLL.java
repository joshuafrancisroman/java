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
public class SLL<T>{
    private SLLNode<T> head,tail;
    
    public SLL()
    {
        head=tail=null;
    }
    
    public boolean isEmpty()
    {
        return head==null; //if head is not null, then the expression is TRUE else it is FALSE
    }
    
    public void addToHead(T el) //2 Case. If empty OR 1 and/or more nodes.
    {
        head = new SLLNode<>(el,head); //case 1 and 2. 
        if(tail==null)//case 1
            tail=head;
    }
    
    public T seeHead() //for stack purpose
    {
        return head.info;
    }
    
    public void addToTail(T el)
    {
        if(head==null)
            head = tail = new SLLNode<>(el);
        else
            tail = tail.next = new SLLNode<>(el);
    }
    
    public T deleteFromHead()//3 Case. 0,1,N
    {
        if(isEmpty())
            return null; //case 1
        else
        {
            T el = head.info;
            if(head == tail)//case 2
                head = tail = null;
            else //case 3
                head=head.next;
            return el;
        }
    }
    
    public T deleteFromTail()
    {
        if(isEmpty())
            return null;
        else
        {
            T el = tail.info;
            if(head == tail)
                head = tail = null;
            else
            {
                SLLNode<T> p;//marcher for predecessor
                for(p = head;p.next != tail; p = p.next);//p marches until it is second from the last
                tail = p;
                tail.next = null;
            }
            return el;
        }
          
    }
    
    public SLLNode<T> getNode(T el)// finds if the element exists then returns its node
    {
        SLLNode<T> p;
        for(p = head; p!=null && ((Comparable)p.info).compareTo(el)!=0; p = p.next); //marches to find the element while not null
        return p;
    }
    
    @Override
    public String toString()
    {
        SLLNode<T> p;
        String s="";
        for(p=head;p!=null;p=p.next)
            s=s+p.info.toString() +" ";
        return s;
    }
    
    public boolean isInList(T el)//returns true : if el is in list
    {
        return getNode(el) != null;
    }
    
    public void insertAfterNode(T el, SLLNode<T> ptr) // insert after a specific node 
    {
        if(ptr != null)// checks if ptr is an existing node. i.e is not empty
        {
            if(ptr == tail) 
                addToTail(el); //need to ask why this works without instantiating object
            else
                ptr.next = new SLLNode<>(el, ptr.next);
        }
                
    }
    
    public void insertAfterElt(T ELold, T ELnew)
    {
        SLLNode<T> p;
        p = getNode(ELold);
        if(p!=null) //element does not exist
            insertAfterNode(ELnew, p);
    }
    
    public T delete(T el)//deletes the first occurence of the element
    {
        if(isEmpty())
            return null;
        else if(isInList(el))//checks if the value even exists in the node
        {
            if(((Comparable)el).compareTo(head.info)==0) // if element is in head.
                return deleteFromHead();
            else if(((Comparable)el).compareTo(tail.info)==0)// if element is in tail
                return deleteFromTail();
            SLLNode<T> pred = head, curr = head.next;
            while(((Comparable)curr.info).compareTo(el)!=0) //marches until it finds el
            {
                curr=curr.next;
                pred=pred.next;
            }
            pred.next = curr.next;
            return el;
        }
        else
            return null;
    }
    
    public void insertDesc(T el) // with bug if two consecutive same
    {
        if(isEmpty())
            addToHead(el);
        else if(((Comparable)head.info).compareTo(el)<=0)
            addToHead(el);
        else if(((Comparable)tail.info).compareTo(el)>=0)
            addToTail(el);
        else
        {
            SLLNode<T> temp = head.next, pred=head;
            while( temp!=null && ((Comparable)temp.info).compareTo(el)>0)
            {
                pred=pred.next;
                temp=temp.next;
            }
            pred.next = new SLLNode<>(el,pred.next);
            
        }
    }
    
    public void insertAsc(T el)
    {
        if(isEmpty())
            addToHead(el);
        else if(((Comparable)head.info).compareTo(el)>=0)
            addToHead(el);
        else if(((Comparable)tail.info).compareTo(el)<=0)
            addToTail(el);
        else
        {
            SLLNode<T> temp = head.next, pred=head;
            while( temp!=null && ((Comparable)temp.info).compareTo(el)<0)
            {
                pred=pred.next;
                temp=temp.next;
            }
            pred.next = new SLLNode<>(el,pred.next);
            
        }
    }
    
    public int count()
    {
        int ctr=0;
        for(SLLNode<T> temp = head; temp!=null;temp=temp.next, ctr++);
        return ctr;
    }
    
    public void shuffle()
    {
        int rand;
        int temp=0;
        SLLNode<T> ttemp = head, ttemp2, external = head;
        while(temp!=count())
        {
            
            ttemp2 = head; //some random node
            rand = (int)(Math.random()*count());
            while(rand!=0)
            {
                ttemp2=ttemp2.next;
                rand-=1;
            }
            T placeholder = ttemp.info;
            ttemp.info = ttemp2.info;
            ttemp2.info = placeholder;
            temp++;
            ttemp= ttemp.next;
        }
    }
    
    public SLL<T> copyTheDups() //runs only if the list is sorted.
    {
        SLL<T> list = new SLL<>();
        if(head == tail);// 0 node or 1 node. 
        else //at least 2 nodes
        {
            SLLNode<T> pred = head; //marches behind. predecessor node
            SLLNode<T> temp = head.next; //marches ahead
            while(temp!=null)
            {
                if(((Comparable)temp.info).compareTo(pred.info)==0)//if two immediate values are the same then add to list.
                    list.addToTail(temp.info);
                temp = temp.next; //iteration statements
                pred = pred.next;
            }
        }
        return list;
    }
    
}
