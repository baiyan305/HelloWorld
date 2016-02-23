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

        int[] res = new int[n - k + 1]; // ���

        int p = 0;

        java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>(); // ˫��queue, ������linkedlist��. Ҳ������Dequeue

        for (int i = 0; i < nums.length; i++) {

            //���ڴ�СΪk, ���� i-k+1Ϊ��λ��i�ϵĴ���, �߳����д������Ԫ��, ��Ϊ�����Ǵ�β����ӵ�, ���������߳�ͷ����Ԫ��
            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1)
                queue.removeFirst();

            //�߳�����С�ڵ�ǰԪ�ص�Ԫ��, ����Ҫ��β���߳�, ����Ϊβ����Ԫ���ǰ���ɨ���˳����ӵĲ���,��СΪ�ݼ���ӵ�.
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.removeLast();

            // ��ӵ�β��.
            queue.addLast(i);

            if (i >= k-1)// ������δ��ȫչ��ʱ, ����¼Ԫ��.
                res[p++] = nums[queue.peekFirst()];
        }
        return res;
        */
    }

}
