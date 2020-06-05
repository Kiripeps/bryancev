import java.util.Scanner;
public class Task4 {

	public static void main(String[] args) {
		System.out.println("Пример работы:");
		System.out.println(flipEndChars("Freedom, equality, information. Shockvelenwriter"));
		System.out.println("Введите свою строку:");
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		System.out.println(flipEndChars(a));
	}
	
    public static String flipEndChars(String s) {
        if(s.length()<2)
            return "Incompatible.";

        if(s.charAt(0)==s.charAt(s.length()-1))
            return "Two's a pair.";

        char[] chars = s.toCharArray();
        char a = chars[0];
        chars[0] = chars[s.length()-1];
        chars[s.length()-1] = a;
        return String.valueOf(chars);
    }
}
