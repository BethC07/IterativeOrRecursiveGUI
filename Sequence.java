package sequence;

public class Sequence {

	private static int efficiencyNum;
	
	public static int computeIterative(int n) {
		
		if(n == 0) {
			efficiencyNum = 1;
			return 0;
		}
		else if(n == 1) {
			efficiencyNum = 2;
			return 1;
		}
		else {
			
			efficiencyNum = 3;
			int a = 0;
			int b = 1;
			int nextTerm = 0;
			
			for(int x = 2; x <= n; x++) {
				
				nextTerm = (b * 2) + a;
				a = b;
				b = nextTerm;
				efficiencyNum++;
				
			}
			return nextTerm;
		}
	}
	
	public static int computeRecursive(int n) {
		efficiencyNum = 0;
		return Sequence.initRecursion(n);
	}
	
	private static int initRecursion(int n) {
		
		efficiencyNum++;
		
		if(n == 0) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		else {
			int retVal = (Sequence.initRecursion(n - 1) * 2) + (Sequence.initRecursion(n - 2));
			return retVal;
		}
	}
	
	public static int getEfficiency() {
		return efficiencyNum;
	}
	
}
