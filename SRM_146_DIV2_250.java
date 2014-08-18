/*
Problem Statement
    
This task is about the scoring in the first phase of the die-game Yahtzee, where five dice are used. The score is determined by the values on the upward die faces after a roll. The player gets to choose a value, and all dice that show the chosen value are considered active. The score is simply the sum of values on active dice.
Say, for instance, that a player ends up with the die faces showing 2, 2, 3, 5 and 4. Choosing the value two makes the dice showing 2 active and yields a score of 2 + 2 = 4, while choosing 5 makes the one die showing 5 active, yielding a score of 5.
Your method will take as input a int[] toss, where each element represents the upward face of a die, and return the maximum possible score with these values.
Definition
    
Class:
YahtzeeScore
Method:
maxPoints
Parameters:
int[]
Returns:
int
Method signature:
int maxPoints(int[] toss)
(be sure your method is public)
*/

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
