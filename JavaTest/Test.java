import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int a[] = new int[]{3,2,4,1};
        int b[] = new int[]{9,8,1,7,6,5,4,3,2,1};
        int x = 7;
        int[][] c = new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        String s = "ABA";
        String t = "eat"; 
        List<Integer> xx = new ArrayList<>();
        xx.add(5);
        xx.add(3);
        xx.add(4);
        xx.add(1);
        xx.add(1);
        new Solution().minimumPossibleSum(10, 12);
    }
}

class Solution {
    public void minimumPossibleSum(int n, int target) {
        if(n <= target / 2 || target == 1) {
        }
        else {
            int x = Math.min(n - target / 2, target - target / 2 - 1);
            long a = (1 + n + x) * (n + x) / 2;
            long b = (target / 2 + 1 + target / 2 + x) * x / 2;
        }

    }
}