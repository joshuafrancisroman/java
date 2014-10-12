/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;
/*Roman, Joshua Francis
* 3CSD-34
* Lab Exercise 7
* 
* 
*/
public class DLL<T> {
    private DLLNode<T> head , tail;
    public DLL()
    {
        head = tail = null;
    }
    public boolean isEmpty()
    {
        return head == null; //if (head == null) return true else false
    }
    
    public void addToHead(T el)
    {
        if(head != null)//if 1 or more nodes
        {
            head = new DLLNode<>(el,head,null);
            head.next.prev = head;
        }
        else
            head = tail = new DLLNode<>(el);
    }
    
    public void addToTail(T el)
    {
        if(head != null)
        {
            tail = new DLLNode<>(el,null,tail);
            tail.prev.next = tail;
        }
        else
            head = tail = new DLLNode<>(el);
    }
    
    public T deleteFromTail()
    {
        if(isEmpty()) //0 node
            return null;
        else
        {            
            T el = tail.info;
            if(head == tail) // one node
                head = tail = null;
            else //more than one node
            {
                tail = tail.prev;
                tail.next = null;            
            }
            return el;
        }
    }
    
    public String infoFwd()
    {
        String s = "forward:";
        DLLNode<T> temp = head;
        while(temp != tail.next)
        {
            s = s + temp.info +" ";
            temp = temp.next;
        }
        return s;
    }
    
    public String infoBwd()
    {
        String s = "backward:";
        DLLNode<T> temp = tail;
        while(temp != head.prev)
        {
            s = s + temp.info +" ";
            temp = temp.prev;
        }
        return s;
    }
    
    public void insertSorted(T el)
    {
        if(isEmpty() || ((Comparable)head.info).compareTo(el) >= 0) //if no nodes or head > el
            addToHead(el);
        else if(((Comparable)tail.info).compareTo(el) <= 0)
        {
            addToTail(el);
        }
        else //2 nodes or more
        {
            DLLNode<T> marcher = head;
            while(((Comparable)marcher.info).compareTo(el) <= 0) // can be < or <=. if first one, most recent to the left if latter most recent to the right
                marcher = marcher.next;
            marcher = marcher.prev;
            marcher.next = marcher.next.prev = new DLLNode(el, marcher.next, marcher);
        }
    }
    
    public void removeDups()
    {
        if(head == null || head.next==null)
            return;//0 or 1 node. absolutely no duplicates
        DLLNode<T> temp = head;
        while(temp.next != null)//2 or more nodes and at least 2 nodes not processed
        {
            if(temp.next.next == null && ((Comparable)temp.info).compareTo(temp.next.info)==0)//only 2 nodes unprocessed
            {                
                deleteFromTail();
            }
            else if(((Comparable)temp.info).compareTo(temp.next.info)==0)//at least 3 nodes unprocessed
            {
                temp.next = temp.next.next;
                temp.next.prev = temp;
                //dont iterate. need to check next immediate if duplicate
            }
            else
                temp = temp.next;//iterate if no duplicates
        }
    }
}
