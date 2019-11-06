/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_calculator;

import java.util.ArrayList;
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

        System.out.println("Enter the calculation with spaces after each character: ");
        String userCalc = in.nextLine();

        String[] splitArray = userCalc.split(" ");
        //correctInCheck(splitArray);

        ArrayList<String> userCalculationList = new ArrayList<>();
        for (String splitArray1 : splitArray) {
            userCalculationList.add(splitArray1);
        }

        solve(userCalculationList);

        System.out.println(userCalculationList);

        System.out.println(userCalculationList.get(0));
    }

    // checks to see if input is an operand
    public boolean isOp(String ch) {

        return ch.contains("+") || ch.contains("-") || ch.contains("*")
                || ch.contains("/") || ch.contains("^") || ch.contains("(")
                || ch.contains(")");
    }

    public static int solve(ArrayList<String> userCalculationList) {
        
        parentheses(userCalculationList);
        
        computation(userCalculationList, "^");
        computation(userCalculationList, "+");
        computation(userCalculationList, "-");
        computation(userCalculationList, "*");
        computation(userCalculationList, "/");

        return Integer.parseInt(userCalculationList.get(0));
    }

    public static ArrayList<String> parentheses(ArrayList<String> userCalculationList) {

        for (int i = 0; i < userCalculationList.size(); i++) {
            if (userCalculationList.get(i).equals("(")) {
                int start = 1;
                int end = 0;

                for (int x = i + 1; x < userCalculationList.size(); x++) {
                    if (userCalculationList.get(x).equals("(")) {
                        start = start + 1;
                    } else if (userCalculationList.get(x).equals(")")) {
                        end = end + 1;

                        if (start == end) {
                            ArrayList<String> parenthesesAList = new ArrayList<>();

                            for (int k = i + 1; k < x; k++) {
                                parenthesesAList.add(userCalculationList.get(k));
                            }
                            // runs the solve method within the new array
                            userCalculationList.set(i, Integer.toString(solve(parenthesesAList)));

                            for (int m = i + 1; m <= x; m++) {
                                userCalculationList.remove(i + 1);
                            }
                            break;
                        }
                    }
                }
            }
        }
        return userCalculationList;
    }

    //perform operation on ArrayLiost and new ArrayList
    public static ArrayList<String> computation(ArrayList<String> userCalculationList, String operand) {
        for (int i = 0; i < userCalculationList.size(); i++) {

            // check to see if the element was an operand
            if (userCalculationList.get(i).equals(operand)) {

                int a = Integer.parseInt(userCalculationList.get(i - 1));
                int b = Integer.parseInt(userCalculationList.get(i + 1));

                // the set method is used to set an element in ana ArrayList on the specified index
                userCalculationList.set(i - 1, Integer.toString(operationCalc(a, b, operand)));

                // remove the elemenst in the list except for the first one
                userCalculationList.remove(i);
                userCalculationList.remove(i);

                // go back down to the last element if the elemnt was an operand
                i--;

            }
        }
        return userCalculationList;
    }
    
    /*    public static void correctInCheck(String[] splitArray){
    for(int i = 0; 1 < splitArray.length; i++){
    if(){
    
    }
    }
    
    }*/

    // calculates the value of two numbers together
    public static int operationCalc(int a, int b, String operand) {

        switch (operand) {
            case "^":
                return (int) Math.pow(a, b);
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return -1;
        }
    }

}
