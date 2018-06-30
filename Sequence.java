/*
 * FileName: Week4GUI.java
 * Author: Beth Carmichael
 * Date: 06/14/2018
 * Purpose: 
 *
 *
 */
package iterativeorrecursivegui;

public class Sequence {
    static int efficiencyCount = 0;
    
    public static int computeIterative(int n) {
        //Function: ((n-1)*2) + (n-2)
        int result = 0;
        int total = 0;
        int firstTerm = 0;
        int secondTerm = 1;
        efficiencyCount = 0;
        
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        for(int count = 2; count <= n; count++) {
            total = firstTerm + (secondTerm * 2);
            result = total + (n - 2);
            System.out.println("Count: " + count + " Result: " + result + " Total: " + total);
            efficiencyCount++;
        }
        return result;
    }
    
    private static int computeRecursiveHelper(int n) {
        efficiencyCount++;
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        return computeRecursiveHelper(n - 2) + (computeRecursiveHelper(n - 1) * 2);
    }
    
    public static int computeRecursive(int n){
        efficiencyCount = 0;
        return computeRecursiveHelper(n);
    }
    
    public static int getEfficiency() {
        return efficiencyCount;
    }
    
}
