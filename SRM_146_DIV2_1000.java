/*
Problem Statement
    
A well-known riddle goes like this: Four people are crossing an old bridge. The bridge cannot hold more than two people at once. It is dark, so they can't walk without a flashlight, and they only have one flashlight! Furthermore, the time needed to cross the bridge varies among the people in the group. For instance, let's say that the people take 1, 2, 5 and 10 minutes to cross the bridge. When people walk together, they always walk at the speed of the slowest person. It is impossible to toss the flashlight across the bridge, so one person always has to go back with the flashlight to the others. What is the minimum amount of time needed to get all the people across the bridge?
In this instance, the answer is 17. Person number 1 and 2 cross the bridge together, spending 2 minutes. Then person 1 goes back with the flashlight, spending an additional one minute. Then person 3 and 4 cross the bridge together, spending 10 minutes. Person 2 goes back with the flashlight (2 min), and person 1 and 2 cross the bridge together (2 min). This yields a total of 2+1+10+2+2 = 17 minutes spent.
You want to create a computer program to help you solve new instances of this problem. Given an int[] times, where the elements represent the time each person spends on a crossing, your program should return the minimum possible amount of time spent crossing the bridge.
Definition
    
Class:
BridgeCrossing
Method:
minTime
Parameters:
int[]
Returns:
int
Method signature:
int minTime(int[] times)
(be sure your method is public)
*/


/**
 * 思想： 比如： 1，2，3，4，5；  最优解一定是 先1，2（最小的两个） 过去，然后，1回来， 然后，4，5（最大的两个）过去，
 * 然后2回来， 这样就把最大的两个4，5送过去了， 大问题就变成了 解 1，2，3，4 的小问题， 然后我们可以用同样的思想去解答这个小问题，
 * 这样， 用递归的思想就很好写了
 * 为什么最优解一定是这样的： 我们可以把最坏的情况 1，2，3，4这样带一遍，会发现得出的就是最优解，然后如果碰到更好的情况；1,2,99,100,
 * 用这种方法， 就能省的更多，因为99，100，同时过去就能省去一个99.
 **/
import java.util.Arrays;

public class BridgeCrossing {
    public int minTime(int[] times) {
        if (times == null || times.length == 0) {
            return 0;
        }
        if (times.length == 1) {
            return times[0];
        }
        Arrays.sort(times);
        int[] result = new int[1];
        result[0] = 0;
        minTimeCore(times, result, times.length - 1);
        return result[0];
    }

    public void minTimeCore(int[] times, int[] result, int index) {
        if (index == 1) {
            result[0] += times[index];
            return;
        }
        if (index == 2) {
            result[0] += times[index] + times[index - 2] + times[index - 1];
            return;
        }
        result[0] += times[index] + times[0] + 2 * times[1];
        minTimeCore(times, result, index - 2);
    }
}
