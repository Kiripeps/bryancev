import java.util.*;
public class Task6 {

	public static void main(String[] args) {
        System.out.println(same(new int[] {1,3,4,4,4}, new int[] {2,5,7}));
        System.out.println(same(new int[] {9,8,7,6}, new int[] {4,4,3,1}));
        System.out.println(same(new int[] {2}, new int[] {3,3,3,3}));
    }

    private static boolean same(int[] a1, int[] a2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int k: a1) {
            set1.add(k);
        }

        for (int l: a2) {
            set2.add(l);
        }

        return set1.size() == set2.size();
	}

}
