/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author luism
 */
public class Java_Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
   
        
        System.out.println("Enter the calculation: ");
        String userCalc = in.nextLine();
        
        String[] splitArray = userCalc.split(" ");
        
        ArrayList<String> userCaculationList = new ArrayList<>();
        for(int i = 0; i < splitArray.length; i++){
            userCaculationList.add(splitArray[i]);
        }
        
        
        
        
        System.out.println(userCaculationList);
        
        System.out.println(userCaculationList.get(0));
        
        
        
        
     
    }
    
    // checks to see if input is an operand
    public boolean isOp(String ch){
        
        if(ch.contains("+") || ch.contains("-") || ch.contains("*") || 
                ch.contains("/") || ch.contains("^") || ch.contains("(") || 
                ch.contains(")")){
            return true;
        }
        
        return false;
}
    
    // calculates the value of two numbers together
    public int operationCalc(int a, int b, String operator){
        
        if(operator.equals("^")){
            return (int)Math.pow(a,b);
        }
        else if(operator.equals("+")){
            return a + b;
        }
        else if(operator.equals("-")){
            return a - b;
        }
        else if(operator.equals("*")){
            return a *b;
        }
        else if(operator.equals("/")){
            return a / b;
        }
        else return -1;
    }

}

