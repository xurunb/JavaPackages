/*
 * File Postfix.java
 */
package postfix;

import java.util.*;

/**
 * This is a class can evaluate postfix expressions
 * 
 * @author Zurn,Andrew and Xu,Runbo
 * @version Feb 7, 2011
 */
public class Postfix {
  // TreeMap<Character,Double> values associates characters with values
  private TreeMap<Character,Double> values;
  // Stack<Double> stack is used in evaluating postfix expressions
  private Stack<Double> stack;
  private Stack<Character> stack2;
  /**
   * Constructs a new Postfix objects
   * @param values uses a TreeMap for values and characters
   */
  public Postfix(TreeMap<Character,Double> values) {
    this.values=values;
  }
  /**
   * Will evaluate a postfix expression and return a double
   * @param expression string to be processed
   * @throws ArithmeticException used when an exception should be thrown
   * @return double the result of a postfix expression
   */
  public double evaluate(String expression) throws ArithmeticException {
    stack=new Stack<Double>();
    for(int i=0;i<expression.length();i++){
      if(expression.charAt(i)<='z' && expression.charAt(i)>='a'){
        double temp=values.get(expression.charAt(i));
        stack.push(temp);
      }
      else if(expression.charAt(i)=='+'){
        double temp2=stack.pop();
        if(stack.empty()){
          throw new ArithmeticException();
        }
        else{
          double temp1=stack.pop();
          double temp3=temp1+temp2;
          stack.push(temp3);
        }
      }
      else if(expression.charAt(i)=='-'){
        double temp2=stack.pop();
        if(stack.empty()){
          throw new ArithmeticException();
        }
        else{
          double temp1=stack.pop();
          double temp3=temp1-temp2;
          stack.push(temp3);
        }
      }
      else if(expression.charAt(i)=='*'){
        double temp2=stack.pop();
        if(stack.empty()){
          throw new ArithmeticException();
        }
        else{
          double temp1=stack.pop();
          double temp3=temp1*temp2;
          stack.push(temp3);
        }
      }
      else if(expression.charAt(i)=='/'){
        double temp2=stack.pop();
        if(stack.empty()){
          throw new ArithmeticException();
        }
        else{
          if(temp2==0){
            throw new ArithmeticException();
          }
          else{
            double temp1=stack.pop();
            double temp3=temp1/temp2;
            stack.push(temp3);
          }
        }
      }
      else if(expression.charAt(i)=='^'){
        double temp2=stack.pop();
        if(stack.empty()){
          throw new ArithmeticException();
        }
        else{
          double temp1=stack.pop();
          double temp3=Math.pow(temp1,temp2);
          stack.push(temp3);
        }
      }
      else if(expression.charAt(i)=='~'){
        double temp=stack.pop();
        stack.push(-temp);
      }
      else{
        throw new ArithmeticException();
      }
    }
    double temp4=stack.pop();
    if(!stack.empty()){
      throw new ArithmeticException(); 
    }
    return temp4;
    
  }
  
  /**
   * this method will check and return the level of precedence of an operator
   * @param operator the operator to be checked
   * @return int the level of precedence of the object
   */
  protected int precedence(char operator){
    if ( operator =='+' || operator =='-'){
      return 1;
    }
    else if ( operator == '*' ||operator == '/'){
      return 2;
    }
    else if ( operator == '~' || operator =='^'){
      return 3;
    }
    return -1;
  }
  
  /**
   * this method will determine a character is a left to right operator
   * @param c the character to be checked
   * @return boolean true if the character is a left to right operator, else if false
   */
  protected boolean isLeftToRightOperator(char c){
    return (c=='+' || c== '-' || c== '*' || c== '/' || c== '~');
  }
  
  /**
   * this method will convert a string in infix notation to postfix
   * @param infixExpression the infix expression
   * @return boolean the converted string
   * @throws RuntimeExceptions will be thrown for illegal character and parathesis use
   */
  public String infixToPostfix(String infixExpression) throws RuntimeException{
    String postFixExpression = "";
    stack2=new Stack<Character>();
    for(int i=0;i<infixExpression.length();i++){
      if(infixExpression.charAt(i)<='z' && infixExpression.charAt(i)>='a'){
        postFixExpression = postFixExpression + infixExpression.charAt(i);
      }
      else if (infixExpression.charAt(i) == '+' || infixExpression.charAt(i) == '-' ||
               infixExpression.charAt(i) =='*' ||infixExpression.charAt(i) == '/' ||
               infixExpression.charAt(i) =='~' ||infixExpression.charAt(i) == '('
                 ||infixExpression.charAt(i) == '^' ||infixExpression.charAt(i) == ')'  ){
        char temp=infixExpression.charAt(i);
        if(temp=='('){
         stack2.push(temp);
         temp='#';
        }
        while(temp!='#'){
          if(stack2.isEmpty()){
            if(temp==')'){
              throw new RuntimeException("Missing parenthesis!");
            }
            stack2.push(infixExpression.charAt(i));
            temp='#';
          }
          else if(!stack2.isEmpty()){
            if (temp != ')') {
            if( precedence(temp) > precedence(stack2.peek())){
              stack2.push(temp);
              temp='#';
            }
            else if( precedence(temp) < precedence(stack2.peek())){
              postFixExpression = postFixExpression + stack2.pop();
              if(stack2.isEmpty()){
                stack2.push(infixExpression.charAt(i));
                temp='#';
              }
            }
            
            else if( precedence(temp) == precedence(stack2.peek())){
              if( isLeftToRightOperator(temp) && temp!='('){
                postFixExpression = postFixExpression + stack2.pop();
                stack2.push(temp);
                temp='#';
              }
              else{ // for ^
                stack2.push(temp);
                temp='#';
              }
            }
            else if (temp=='^'){
              stack2.push(temp);
              temp='#';
            }
          }
            else if (temp == ')') {
              while ( stack2.peek() != '('){
                postFixExpression = postFixExpression + stack2.pop();
                if(stack2.isEmpty()){
                  throw new RuntimeException("Missing parenthesis!"); 
                }
              }
              stack2.pop();
              temp='#';
            }
          }
        }
      }
      else{
        throw new RuntimeException("Illegal Character detected!");
      }
    }
    while(!stack2.isEmpty() && stack2.peek()!='('){
      postFixExpression = postFixExpression + stack2.pop();
    }
    if(!stack2.isEmpty()){
      if( stack2.peek()=='('){
      throw new RuntimeException("Missing parenthesis!");
    }
    }
    
    return postFixExpression;
  }
  
  
  
  
  /**
   * this is to run the Postfix from the command line with the set expression (a*b+c^d)/(x+y*(q-r))
   */
  public static void main(String[] args){
    TreeMap<Character,Double> values=new TreeMap<Character,Double>();
    for(char c='a';c<'z';c++) {
      values.put(c,1.0*(c-'a'));
    }
    Postfix test = new Postfix(values);
    System.out.println(test.infixToPostfix("(a*b+c^d)/(x+y*(q-r))"));
    
  
  }
}