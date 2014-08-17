/*
Problem Statement
    
Sometimes when computer programs have a limited number of colors to use, they use a technique called dithering. Dithering is when you use a pattern made up of different colors such that when the colors are viewed together, they appear like another color. For example, you can use a checkerboard pattern of black and white pixels to achieve the illusion of gray.
You are writing a program to determine how much of the screen is covered by a certain dithered color. Given a computer screen where each pixel has a certain color, and a list of all the solid colors that make up the dithered color, return the number of pixels on the screen that are used to make up the dithered color. Each pixel will be represented by a character in screen. Each character in screen and in dithered will be an uppercase letter ('A'-'Z') representing a color.
Assume that any pixel which is a color contained in dithered is part of the dithered color.
Definition
    
Class:
ImageDithering
Method:
count
Parameters:
String, String[]
Returns:
int
Method signature:
int count(String dithered, String[] screen)
(be sure your method is public)

*/
import java.util.Map;
import java.util.HashMap;

public class ImageDithering {
	public int count(String dithered, String[] screen) {
		if (dithered == null || dithered.length() == 0 || screen == null || screen.length == 0) {
			return 0;
		}
		Map<Character, Boolean> colorMap = new HashMap<>();
		for (int i = 0; i < dithered.length(); i++) {
			if (!colorMap.containsKey(dithered.charAt(i))) {
				colorMap.put(dithered.charAt(i), true);
			} 
		}
		int result = 0;
		for (String str : screen) {
			for (int i = 0; i < str.length(); i++) {
				if (colorMap.containsKey(str.charAt(i))){
					result++;
				}
			} 
		}
		return result;
	}
}
