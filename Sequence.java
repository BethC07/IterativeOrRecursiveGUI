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
            result = n * 2;
            total = result + (n - 1);
            System.out.println("Result: " + result + " Total: " + total);
            efficiencyCount++;
        }
        return result;
    }
    
    public static int computeRecursive(int n) {
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        efficiencyCount++;
        return n * 2 + computeRecursive(n - 1);
    }
    
    public static int getEfficiency() {
        return efficiencyCount;
    }
    
}
