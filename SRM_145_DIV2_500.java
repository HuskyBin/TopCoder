/*
Problem Statement
    
You are writing firmware for an exercise machine. Each second, a routine in your firmware is called which decides whether it should display the percentage of the workout completed. The display does not have any ability to show decimal points, so the routine should only display a percentage if the second it is called results in a whole percentage of the total workout.
Given a String time representing how long the workout lasts, in the format "hours:minutes:seconds", return the number of times a percentage will be displayed by the routine. The machine should never display 0% or 100%.
Definition
    
Class:
ExerciseMachine
Method:
getPercentages
Parameters:
String
Returns:
int
Method signature:
int getPercentages(String time)
(be sure your method is public)
*/
public class ExerciseMachine {

    public int getPercentages(String time) {
        if (time == null || time.length() == 0) {
            return 0;
        }
        int seconds = 0;
        String[] digitStr = time.split(":");
        seconds += Integer.valueOf(digitStr[0]) * 60 * 60;
        seconds += Integer.valueOf(digitStr[1]) * 60;
        seconds += Integer.valueOf(digitStr[2]);
        double eachSecond = seconds / 100.0;
        int result = 0;
        for (int i = 1; i < 100; i++) {
            if ((eachSecond * i) - (int)(eachSecond * i) == 0.0) {
                result++;
            } 
        }
        return result;
    }
}
