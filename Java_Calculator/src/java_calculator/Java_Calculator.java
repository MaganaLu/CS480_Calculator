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
        
        ArrayList<String> userCalculationList = new ArrayList<>();
        for(int i = 0; i < splitArray.length; i++){
            userCalculationList.add(splitArray[i]);
        }
        
        
        solve(userCalculationList);
        
        System.out.println(userCalculationList);
        
        System.out.println(userCalculationList.get(0));
        
        
        
        
     
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
    
    public static int solve(ArrayList<String> userCalculationList){
        //expression = calculate();
        // calculate = computation
        
        computation(userCalculationList, "^");
        computation(userCalculationList, "+");
        computation(userCalculationList, "-");
        computation(userCalculationList, "*");
        computation(userCalculationList, "/");
        
        
        return Integer.parseInt(userCalculationList.get(0));
        
        
    }
    
    //perform operation on ArrayLiost and new ArrayList
    public static ArrayList<String> computation(ArrayList<String> userCalculationList, String operand){
        for(int i = 0; i < userCalculationList.size(); i++){
            if(userCalculationList.get(i).equals(operand)){
                
                int a = Integer.parseInt(userCalculationList.get(i-1));
                int b = Integer.parseInt(userCalculationList.get(i+1));
                
                userCalculationList.set(i-1, Integer.toString(operationCalc(a,b,operand)));
                
                // remove the elemenst in the list except for the first one
                userCalculationList.remove(i);
                userCalculationList.remove(i);
                
                // go back down to the last element if the elemnt was an operand
                i--;
                
            }
        }
        return userCalculationList;
    }
    
    
    // calculates the value of two numbers together
    public static int operationCalc(int a, int b, String operand){
        
        if(operand.equals("^")){
            return (int)Math.pow(a,b);
        }
        else if(operand.equals("+")){
            return a + b;
        }
        else if(operand.equals("-")){
            return a - b;
        }
        else if(operand.equals("*")){
            return a *b;
        }
        else if(operand.equals("/")){
            return a / b;
        }
        else return -1;
    }
    
    

}

