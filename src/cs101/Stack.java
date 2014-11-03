/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101;
/*Roman, Joshua Francis
* 3CSD-34
* Lab Exercise 8 and 9
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
        if(e.length()==0)
            return "";
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
                operand.push(concat(a, arr[ctr--], b));//concatenates ( A insertOperator B )
            }
               
        }
        //+ - 1.7 * / ^ 2 4 3 6 19 
        // ( ( 1.7 - ( ( ( 2 ^ 4 ) / 3 ) * 6 ) ) + 19 ) 
        
        infix = operand.pop().toString();
        return infix;
    }
    
    public static double evalPrefix(String e)
    {
        if(e.length() == 0)
            return -1;
        String arr[] = e.split(" ");        
        int ctr = arr.length-1;
        Stack<String> operand = new Stack<>(); //numerical values
        double infix=0;
        while(ctr >= 0) //right to left reading
        {
            if(!(arr[ctr].charAt(0)=='*' || arr[ctr].charAt(0)=='-' || arr[ctr].charAt(0)=='+' || arr[ctr].charAt(0)=='/' || arr[ctr].charAt(0)=='^'))
                operand.push(arr[ctr--]);
            else
            {
                String a = operand.pop(); //topmost
                String b = operand.pop(); //second topmost                
                operand.push(String.valueOf(evaluate(Double.parseDouble(a),arr[ctr--],Double.parseDouble(b))));
            }
               
        }
        //+ - 1.7 * / ^ 2 4 3 6 19 
        // ( ( 1.7 - ( ( ( 2 ^ 4 ) / 3 ) * 6 ) ) + 19 ) 
        
        infix = Double.parseDouble(operand.pop().toString());
        return infix;
    }
    
    
    public static String infixToPrefix(String e)
    {
        if(e.length()==0)//if empty string
            return "";
        String prefix="";
        String arr[] = e.split(" ");
        Stack<Object> operator = new Stack<>();
        Stack<Object> operand = new Stack<>();
        for(int x=arr.length-1; x>=0; x--)
        {
            if(!(arr[x].charAt(0)=='(' || arr[x].charAt(0)==')' || arr[x].charAt(0)=='/' || arr[x].charAt(0)=='+' || arr[x].charAt(0)=='-' || arr[x].charAt(0)=='*'|| arr[x].charAt(0)=='^' || arr[x].charAt(0)=='(' || arr[x].charAt(0)==')'))
                operand.push(arr[x]); //puts all operand to stack
            else //all non operand
            {
                
                if(arr[x].charAt(0)=='(') //if see an open parenthesis. pop til find closing partner
                    //push all popped to operand stack
                {
                    while(operator.peak().toString().compareTo(")")!=0)
                        operand.push(operator.pop());
                    operator.pop(); //pop the closing but not push to operand
                }
                else
                {   //since this is RIGHT to LEFT notation, the incoming '+' must be greater than instack '+'
                    //so incoming should have greater precedence if same operation
                    //sinks the incoming operator downward till it is not lowest. highest top. lowest bottom.                
                    while((!operator.isEmpty()) && (incomingRL(arr[x].charAt(0)) < instackRL(operator.peak().toString().charAt(0))))
                        operand.push(operator.pop());
                    operator.push(arr[x]); //push the incoming to stack
                }
            }
        }
        
        while(!operator.isEmpty())
            operand.push(operator.pop());
        while(!operand.isEmpty())
            prefix = prefix + " " + operand.pop().toString();
        prefix = prefix.substring(1, prefix.length());
        return prefix;
    }
    
    private static int instackLR(char operator)
    {
        switch(operator)
        {
            case '+':
            case '-': return 2;
            case '*':
            case '/': return 4;
            case '^': return 5;
            case ')': 
            case '(': return 0;
            default : return -1;
        }
    }
    
    private static int incomingLR(char operator)
    {
        switch(operator)
        {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 3;
            case '^': return 6;
            case ')':
            case '(': return 9;
            default : return -1;
            
        }
    }
    
    private static int incomingRL(char operator)
    {
        switch(operator)
        {
            case '+':
            case '-': return 2;
            case '*':
            case '/': return 4;
            case '^': return 5;
            case ')': 
            case '(': return 9;
            default : return -1;
        }
    }
    
    private static int instackRL(char operator)
    {
        switch(operator)
        {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 3;
            case '^': return 6;
            case ')':
            case '(': return 0;
            default : return -1;
            
        }
    }
    
    private static String concat(String a, String operator, String b)
    {
        String s="";
        s = "( " + a + " " + operator + " " + b + " )";
        return s;
    }
    
    private static double evaluate(double a,String operator, double b)
    {
        double ans = 1;
        switch(operator.charAt(0))
        {
            case '*': ans = a * b; break;
            case '-': ans = a - b; break;
            case '+': ans = a + b; break;
            case '/': ans = a / b; break;
            case '^': ans = (double) Math.pow((double)a,(double) b); break;
            default: ans = 0;
        }
        return ans;
    }
    
    
    public static String infixToPostfix(String e)
    {
        if(e.length()==0)
            return "";
        String arr[] = e.split(" ");
        Stack<String> operator = new Stack<>();
        String postfix="";
        for(int x = 0; x<arr.length; x++)
        {
            if(!(arr[x].charAt(0)=='(' || arr[x].charAt(0)==')' || arr[x].charAt(0)=='/' || arr[x].charAt(0)=='+' || arr[x].charAt(0)=='-' || arr[x].charAt(0)=='*'|| arr[x].charAt(0)=='^' || arr[x].charAt(0)=='(' || arr[x].charAt(0)==')'))
                postfix = postfix + " " + arr[x];
            else
            {
                if(arr[x].charAt(0)==')')
                {
                    while(operator.peak().toString().compareTo("(")!=0)
                        postfix = postfix + " " + operator.pop();
                    operator.pop();
                }
                else
                {
                    while((!operator.isEmpty()) && (incomingLR(arr[x].charAt(0)) < instackLR(operator.peak().toString().charAt(0))))
                        postfix = postfix + " " + operator.pop();
                    operator.push(arr[x]);
                }
            }
        }
        while(!operator.isEmpty())
            postfix = postfix + " " + operator.pop();
        postfix = postfix.substring(1, postfix.length());
        return postfix;
    }
    
    public static double evalPostfix(String e)
    {
        if(e.length() == 0)
            return -1;
        String arr[] = e.split(" ");        
        int ctr = 0;
        Stack<String> operand = new Stack<>(); //numerical values
        double infix=0;
        while(ctr < arr.length) //right to left reading
        {
            if(!(arr[ctr].charAt(0)=='*' || arr[ctr].charAt(0)=='-' || arr[ctr].charAt(0)=='+' || arr[ctr].charAt(0)=='/' || arr[ctr].charAt(0)=='^'))
                operand.push(arr[ctr++]);
            else
            {
                String b = operand.pop(); //topmost
                String a = operand.pop(); //second topmost                
                operand.push(String.valueOf(evaluate(Double.parseDouble(a),arr[ctr++],Double.parseDouble(b))));
            }
               
        }
        //+ - 1.7 * / ^ 2 4 3 6 19 
        // ( ( 1.7 - ( ( ( 2 ^ 4 ) / 3 ) * 6 ) ) + 19 ) 
        
        infix = Double.parseDouble(operand.pop().toString());
        return infix;
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
