package com.company.instance;

import com.company.support.Test;

import java.util.Deque;

/**
 * Created by yanba_000 on 11/12/2015.
 */
public class SlidingWindowMaximum implements Test{

    @Override
    public void execute() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] max = maxSlidingWindow(nums, 3);

        for(int i : max)
            System.out.println(i);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return new int[]{};

        int len = nums.length;
        int win = 0;
        int[] res = new int[len-k+1];

        java.util.LinkedList<Integer> queue = new java.util.LinkedList<>();

        for(int i=0; i<nums.length; i++){

            while(!queue.isEmpty()&&queue.peekFirst()<i-k+1)
                queue.removeFirst();

            while(!queue.isEmpty()&&nums[i]>nums[queue.peekLast()])
                queue.removeLast();

            queue.add(i);

            if(i>=k-1)
                res[win++]=nums[queue.peekFirst()];
        }

        return res;

        /*
        if (nums.length == 0 || nums == null)
            return new int[]{};

        int n = nums.length;

        int[] res = new int[n - k + 1]; // 结果

        int p = 0;

        java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>(); // 双向queue, 这里用linkedlist了. 也可以用Dequeue

        for (int i = 0; i < nums.length; i++) {

            //窗口大小为k, 所以 i-k+1为在位置i上的窗口, 踢出所有窗口外的元素, 因为队列是从尾部添加的, 所以我们踢出头部的元素
            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1)
                queue.removeFirst();

            //踢出所有小于当前元素的元素, 这里要从尾部踢出, 是因为尾部的元素是按照扫描的顺序添加的并且,大小为递减添加的.
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.removeLast();

            // 添加到尾部.
            queue.addLast(i);

            if (i >= k-1)// 当窗口未完全展开时, 不记录元素.
                res[p++] = nums[queue.peekFirst()];
        }
        return res;
        */
    }

}
