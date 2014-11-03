/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;


/*ROMAN, JOSHUA FRANCIS
 *CS101  3CSD-34
 *LAB EXERCISE 11
 * Oct 23 2014
 */
public class Queue<T>
{
    private int front, rear;
    private Object[] que; //cannot create array of generics
    private int queueMax = 100;
    
    public Queue()
    {
        que = new Object[queueMax + 1];
    }
    
    public void clear()
    {
        front = rear = 1;
    }
    
    public boolean isFull()
    {
        if(rear + 1 == front || ( front == 1 && rear == queueMax ) )
            return true;
        else
            return false;
    }
    
    public boolean isEmpty()
    {
        return front == rear;
    }
    
    public void enqueue(T element)
    {
        if(isFull())
            System.out.println("Enqueue Overflow Error");
        else
        {
            que[rear] = element;
            rear += 1;
            if( rear > queueMax)
                rear = 1;
        }
    }
    
    public T dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Dequeue Underflow Error");
            return null;
        }
        else
        {
            T deqElt = (T) que[front];
            front += 1;
            if(front > queueMax)
                front = 1;
            return deqElt;
        }
    }
    
    public T front()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
            return null;
        }
        else
            return (T)que[front];
    }
}
