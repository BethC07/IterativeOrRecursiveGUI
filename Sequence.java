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
        int result = 0;
        int total = 0;
        efficiencyCount = 0;
        for(int count = n; count > 0; count--) {
            result = (count - 1) * 2;
            total += result + (count - 2);
            System.out.println("Result: " + result + " Total: " + total);
            efficiencyCount++;
        }
        return total;
    }
    
    private static int computeRecursiveHelper(int n) {
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        return computeRecursive(n - 2) + (computeRecursive(n - 1) * 2);
    }
    
    public static int computeRecursive(int n){
        efficiencyCount = 0;
        return computeRecursiveHelper(n);
    }
    
    public static int getEfficiency() {
        return efficiencyCount;
    }
    
}
