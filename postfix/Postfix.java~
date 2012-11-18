/*
 * File Postfix.java
 */
package postfix;

import java.util.*;

/**
 * This is a class can evaluate postfix expressions
 * 
 * @author Zurn,Andrew and Xu,Runbo
 * @version Jan 31, 2011
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
   * @returns double the result of a postfix expression
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
  
  protected int precedence(char operator){
    if( operator == '(' ){
      return 0;
    }
    else if ( operator =='+' || operator =='-'){
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
  
  protected boolean isLeftToRightOperator(char c){
    return (c=='+' || c== '-' || c== '*' || c== '/' || c== '~');
  }
  
  public String infixToPostfix(String infixExpression) throws RuntimeException{
    String postFixExpression = new String();
    stack2=new Stack<Character>();
    int stackPrecedence;
    for(int i=0;i<infixExpression.length();i++){
      if(infixExpression.charAt(i)<='z' && infixExpression.charAt(i)>='a'){
        postFixExpression = postFixExpression + infixExpression.charAt(i);
      }
      else if (infixExpression.charAt(i) == '+' || infixExpression.charAt(i) == '-' ||
               infixExpression.charAt(i) =='*' ||infixExpression.charAt(i) == '/' ||
               infixExpression.charAt(i) =='~' ||infixExpression.charAt(i) == '(' ){
        char temp=infixExpression.charAt(i);
        while(temp!='#'){
          if(stack2.isEmpty()){
            stack2.push(infixExpression.charAt(i));
            temp='#';
          }
          else if(!stack2.isEmpty()){
            if( precedence(temp) > precedence(stack2.peek())){
              stack2.push(temp);
              temp='#';
            }
            else if( precedence(temp) < precedence(stack2.peek())){
              postFixExpression = postFixExpression + stack2.pop();
            }
            else if( precedence(temp) == precedence(stack2.peek())){
              if( isLeftToRightOperator(infixExpression.charAt(i))){
                postFixExpression = postFixExpression + stack2.pop();
                stack2.push(temp);
                temp='#';
              }
              else{
                stack2.push(temp);
                temp='#';
              }
            }
            else if (temp=='^'){
              stack2.push(temp);
              temp='#';
            }
            else if (temp == ')'){
              while ( stack2.peek() != '('){
                postFixExpression = postFixExpression + stack2.pop();
                if(stack2.isEmpty()){
                 throw new RuntimeException("Missing parenthesis!"); 
                }
              }
              stack2.pop();
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
    if( stack2.peek()=='('){
     throw new RuntimeException("Missing parenthesis!");
    }
  
    return postFixExpression;
  }
  
  
  
  
  
  
  
}