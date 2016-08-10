import java.util.Map;
import java.util.HashMap;

public class Fibber {

	Map<Integer, Integer> memo = new HashMap<Integer,Integer>();
	
	public int fib(int n) {

		if (n == 0 || n == 1) {
			return n;
		}
		
		if (memo.containsKey(n)){
			return memo.get(n);
		}
		
		int tmp = fib(n-1) + fib (n-2);
		
		//Memoisation
		memo.put(n,tmp);
		return tmp;

	}
	
	public static void main(String [] args) {
		System.out.println("Hi");
		Fibber F = new Fibber();
		int a = F.fib(10);
		System.out.println("a = " + a);
	}
}

