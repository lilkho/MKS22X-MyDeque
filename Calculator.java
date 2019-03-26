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
        if (tokens[i].equals("+")) {
          nums.addLast(nums.removeLast()+nums.removeLast());
        } else if (tokens[i].equals("-")) {
          double sec = nums.removeLast();
          nums.addLast(nums.removeLast()-sec);
        } else if (tokens[i].equals("*")) {
          nums.addLast(nums.removeLast()*nums.removeLast());
        } else if (tokens[i].equals("/")) {
          double sec = nums.removeLast();
          nums.addLast(nums.removeLast()/sec);
        } else if (tokens[i].equals("%")) {
          double sec = nums.removeLast();
          nums.addLast(nums.removeLast()%sec);
        } else {
          nums.addLast(Double.parseDouble(tokens[i]));
        }
      }
      return nums.getLast();
    }

}
