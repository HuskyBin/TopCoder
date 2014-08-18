/*
Problem Statement
    
Given the width and height of a rectangular grid, return the total number of rectangles (NOT counting squares) that can be found on this grid.
For example, width = 3, height = 3 (see diagram below):
 __ __ __
|__|__|__|
|__|__|__|
|__|__|__|
In this grid, there are 4 2x3 rectangles, 6 1x3 rectangles and 12 1x2 rectangles. Thus there is a total of 4 + 6 + 12 = 22 rectangles. Note we don't count 1x1, 2x2 and 3x3 rectangles because they are squares.
Definition
    
Class:
RectangularGrid
Method:
countRectangles
Parameters:
int, int
Returns:
long
Method signature:
long countRectangles(int width, int height)
(be sure your method is public)
*/
public class RectangularGrid {
    public long countRectangles(int width, int height) {
        if (width <= 0 || height <= 0) {
            return 0;
        }
        long result = 0;
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                if (i == j) {
                    continue;
                }
                result += (width - i + 1) * (height - j + 1);
            }
        }
        return result;
    }
}
