import java.util.Arrays;

public class Task8 {

	public static void main(String[] args) {
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("100100100"));
        System.out.println(longestZero("11111"));
    }

    private static String longestZero(String s) {
        try {
            String[] split = s.split("1+");
            Arrays.sort(split);
            return split[split.length-1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
	}
}
