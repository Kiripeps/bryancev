import java.util.*;
public class Task3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¬ведите число дл€ проверки = ");
		int chisl = scanner.nextInt();
		System.out.println(checkPer(chisl));
	}

	public static boolean checkPer(int n) {
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                res += i;
            if (res > n)
                return false;
        }
        return (res == n);
    }
}
