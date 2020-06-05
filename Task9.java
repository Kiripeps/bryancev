import java.util.Scanner;
public class Task9 {

	public static void main(String[] args) {
		System.out.println("Пример работы:");
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));
        System.out.println("Приведите число:");
        Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.println(nextPrime(a));
    }

    private static int nextPrime(int num) {
        boolean prime = true;
        int next = num;
        while (true) {
            prime = true;
            for (int i = 2; i < next - 1; i++) {
                if (next % i == 0) prime = false;
            }
            if (prime) return next;
            next++;
        }
	}

}
