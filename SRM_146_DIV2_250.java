import java.util.Arrays;

public class YahtzeeScore {
    public int maxPoints(int[] toss) {
        if (toss == null || toss.length == 0) {
            return 0;
        }
        Arrays.sort(toss);
        int max = 0;
        int curMax = 0;
        for (int i = 0; i < toss.length; i++) {
            if (i == 0 || toss[i] != toss[i - 1]) {
                curMax = toss[i];
            }
            int temp = i + 1;
            while (temp < toss.length && toss[temp] == toss[i]) {
                curMax += toss[temp];
                temp++;
            }
            i = temp - 1;
            max = Math.max(max, curMax);
        }
        return max;
    }
}
