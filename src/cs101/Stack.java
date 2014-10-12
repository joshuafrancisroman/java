/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;
/*Roman, Joshua Francis
* 3CSD-34
* Lab Exercise 8
* 
* 
*/
public class Stack<T>{
    private int top = 0;
    private final static int stackMax = 100;
    private Object[] stk = new Object[stackMax+1];//not using index 0. So from 1-stackMax indeces //cant instantiate a generic array
    
    public Stack()
    {
        
    }
    
    public void clear()
    {
        top = 0;
    }
    
    public boolean isEmpty()
    {
        return top == 0;
    }
    
    public void push(T el)
    {
        if( top != stackMax)
            stk[++top] = el;
        else
            System.out.println("Stack Push Overflow Error");
    }
    
    public T pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack Pop Underflow Error");
            return null;
        }
        else
            return (T)stk[top--];
    }
    
    public T peak()
    {
        if(isEmpty())
        {
            System.out.println("Stack is Empty");
            return null;
        }
        else
            return (T)stk[top];
    }
    
    public static String prefixToInfix(String e)
    {
        String arr[] = e.split(" ");        
        int ctr = arr.length-1;
        Stack<String> operand = new Stack<>(); //numerical values
        String infix="";
        while(ctr >= 0) //right to left reading
        {
            if(!(arr[ctr].charAt(0)=='*' || arr[ctr].charAt(0)=='-' || arr[ctr].charAt(0)=='+' || arr[ctr].charAt(0)=='/' || arr[ctr].charAt(0)=='^'))
                operand.push(arr[ctr--]);
            else
            {
                String a = operand.pop(); //topmost
                String b = operand.pop(); //second topmost                
                //operand.push(concat(a, arr[ctr--], b));//concatenates ( A insertOperator B )
                operand.push(String.valueOf(evaluate(Float.parseFloat(a),arr[ctr--],Float.parseFloat(b))));
            }
               
        }
        //+ - 1.7 * / ^ 2 4 3 6 19 
        // ( ( 1.7 - ( ( ( 2 ^ 4 ) / 3 ) * 6 ) ) + 19 ) 
        
        infix = operand.pop().toString();
        return infix;
    }
    
    private static String concat(String a, String operator, String b)
    {
        String s="";
        s = "( " + a + " " + operator + " " + b + " )";
        return s;
    }
    
    private static float evaluate(float a,String operator, float b)
    {
        float ans = 1;
        switch(operator.charAt(0))
        {
            case '*': ans = a * b; break;
            case '-': ans = a - b; break;
            case '+': ans = a + b; break;
            case '/': ans = a / b; break;
            case '^': ans = (float) Math.pow((double)a,(double) b); break;
            default: ans = 0;
        }
        return ans;
    }
    
    
    
    /*private SLL<T> stack;
    public Stack()
    {
        stack = new SLL<>();
    }
    
    public void push(T el)
    {
        stack.addToHead(el);
        
    }
    
    public T pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack underflow");
            return null;
        }
        return stack.deleteFromHead();
    }
    
    public T peak()
    {
        if(isEmpty())
        {
            System.out.println("Stack underflow");
            return null;
        }
        return stack.seeHead();
    }
    
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }
    
    public void clear()
    {
        stack = new SLL<>();
    */

    
}
