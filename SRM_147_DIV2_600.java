/*
Problem Statement
    
There are numMales males and numFemales females arranged in a circle. Starting from a given point, you count clockwise and remove the K'th person from the circle (where K=1 is the person at the current point, K=2 is the next person in the clockwise direction, etc...). After removing that person, the next person in the clockwise direction becomes the new starting point. After repeating this procedure numFemales times, there are no females left in the circle.
Given numMales, numFemales and K, your task is to return what the initial arrangement of people in the circle must have been, starting from the starting point and in clockwise order.
For example, if there are 5 males and 3 females and you remove every second person, your return String will be "MFMFMFMM".
Definition
    
Class:
PeopleCircle
Method:
order
Parameters:
int, int, int
Returns:
String
Method signature:
String order(int numMales, int numFemales, int K)
(be sure your method is public)
*/


public class PeopleCircle {
     public String order(int numMales, int numFeamles, int K) {
        if (numFeamles == 0 && numMales == 0) {
            return "";
        }
        ListNode headNode = createAllNode(numMales + numFeamles);
        int curFeamles = numFeamles;
        ListNode pNode = headNode;
        while (curFeamles > 0) {
            int curK = K;
            while (true) {
                if (pNode.delete == true) {
                    curK++;
                }
                if (curK == 1) {
                    break;
                }
                pNode = pNode.next;
                curK--;
            }
            pNode.delete = true;
            curFeamles--;
            if(curFeamles > 0) {
                while (pNode.delete == true) {
                    pNode = pNode.next;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        pNode = headNode;
        while (pNode.next != headNode) {
            if (pNode.delete == false) {
                sb.append("M");
            }
            else {
                sb.append("F");
            }
            pNode = pNode.next;
        }
        if (pNode.delete == false) {
            sb.append("M");
        }
        else {
            sb.append("F");
        }
        return sb.toString();
    }

    private ListNode createAllNode(int num) {
        ListNode head = new ListNode();
        int tempNum = num;
        ListNode pNode = head;
        while (tempNum > 1) {
            ListNode newNode = new ListNode();
            pNode.next = newNode;
            pNode = newNode;
            tempNum--;
        }
        pNode.next = head;
        return head;
    }
}

class ListNode {
    public boolean delete = false;
    public ListNode next;
    public ListNode() {
        this.delete = false;
        this.next = null;
    }
}
