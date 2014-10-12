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
public class DLLNode<T> {
    public T info;
    public DLLNode<T> next, prev;
    
    public DLLNode()
    {
        prev = next = null;
    }
    
    public DLLNode(T el)
    {
        info = el; 
        prev = next = null;
    }
    
    public DLLNode(T el, DLLNode<T> n, DLLNode<T> p)
    {
        prev = p;
        next = n;
        info = el;
    }
}
