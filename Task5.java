import java.util.Scanner;
public class Task5 {

	public static void main(String[] args) {
		System.out.println("Пример работы:");
        System.out.println(HexCode("#CD5C5C"));
        System.out.println(HexCode("#eaecee"));
        System.out.println(HexCode("#CD5C58C"));
        System.out.println(HexCode("#CD5C5Z"));
        System.out.println(HexCode("#CD5C5C"));
        System.out.println("Приведите строку:");
        Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		System.out.println(HexCode(a));
	}

    public static boolean HexCode(String s) {
        return s.matches("#[a-fA-F0-9]{6}");
    }
}
