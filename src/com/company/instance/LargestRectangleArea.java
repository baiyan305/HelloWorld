package com.company.instance;

import java.util.Arrays;
import java.util.Stack;
import com.company.support.*;

/**
 * Created by Yan on 3/23/15.
 */
public class LargestRectangleArea implements com.company.support.Test{

    @Override
    public void execute(){
        int[] height = {2,1,5,6,2,3};
        System.out.println(implement(height));
    }

    /*time complexity is n*n
    public int implement(int[] height) {
        int maxArea = 0;
        for(int i=0; i<height.length; i++){
            int leftPointer = i, rightPointer = i;
            while(leftPointer>0 && height[leftPointer-1] > height[i]){
                leftPointer -= 1;
            }
            while(rightPointer<height.length-1 && height[rightPointer+1] > height[i]){
                rightPointer += 1;
            }
            maxArea = Math.max(maxArea, height[i] * (rightPointer - leftPointer +1));
        }
        return maxArea;
    }
    */

    /*
     * time complexity is n*n
     * *
    private int implement(int[] height){
        int maxArea = 0;

        for(int i=0; i<height.length; i++){
            int minHeight = height[i];
            for(int j=i; j>=0; j--){
                minHeight = Math.min(height[j], minHeight);
                maxArea = Math.max(minHeight * (i-j+1), maxArea);
            }
        }

        return maxArea;
    }
    */


    public int implement(int[] height) {
        height = Arrays.copyOf(height, height.length + 1);

        int maxRect = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                int rect = height[stack.pop()] * (stack.isEmpty() ? i : (i-stack.peek()-1));
                maxRect = Math.max(maxRect, rect);
            }
            stack.push(i);
        }

        return maxRect;
    }

}
