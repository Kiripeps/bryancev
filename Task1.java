import java.util.*;

public class Task1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¬ведите a = ");
		int a = scanner.nextInt();
		System.out.println("¬ведите b = ");
		int b = scanner.nextInt();
		System.out.println("¬ведите c = ");
		int c = scanner.nextInt();
		task(a,b,c);
	}
	
	public static void task(int a, int b,int c){
		double discrim = b*b + 4*a*c;
		if(discrim<0) {
			int otv = 0;
			System.out.println("number of solution = " + otv);
		}
		if(discrim ==0) {
			int otv = 1;
			System.out.println("number of solution = " + otv);
		}
		if(discrim>0) {
			int otv = 2;
			System.out.println("number of solution = " + otv);
		}
	}
	
}