import java.io.*;
import java.util.*;

public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] tokens = s.split(" ",s.length());
      MyDeque<Double> nums = new MyDeque<Double>();
      for (int i=0;i<tokens.length;i++) {
        if (tokens[i].equals('+') || tokens[i].equals('-')
        || tokens[i].equals('*') || tokens[i].equals('/')
        || tokens[i].equals('%')) {

        } else {
          nums.addLast(Double.parseDouble(tokens[i]));
        }
      }
      System.out.println(nums);
      return 0;
    }

    public static void main(String[] args) {
      System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
}
