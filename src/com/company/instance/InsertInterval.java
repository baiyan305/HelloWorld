package com.company.instance;

import com.company.support.Test;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by yanba_000 on 2/1/2016.
 */
public class InsertInterval implements Test {

    @Override
    public void execute() {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12, 16));

        List<Interval> list = insert(intervals, new Interval(4,9));
        for(Interval interval : list){
            System.out.println(interval.start + "--" + interval.end);
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Interval tmp = new Interval(newInterval.start, newInterval.end);
        int pos = 0;

        Iterator<Interval> iterator = intervals.iterator();
        while(iterator.hasNext()){
            Interval interval = iterator.next();
            if(tmp.end < interval.start){
                break;
            }else if(tmp.start > interval.end){
                pos++;
            }else{
                iterator.remove();
                tmp.start = Math.min(tmp.start, interval.start);
                tmp.end = Math.max(tmp.end, interval.end);
            }
        }

        intervals.add(pos, tmp);
        return intervals;
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

}
