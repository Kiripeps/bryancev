import java.util.*;
public class Task1{
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Введите слово");
		String a=scanner.nextLine();
		System.out.println("Введите кол-во повторов");
		int repeats=scanner.nextInt(); 
	System.out.println(repeat(a,repeats));
	}
	public static String repeat(String a, int repeats) {
		String repeat = "";
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < repeats; j++) {
				repeat += a.charAt(i);
			}
		}
		return repeat;
	}
}