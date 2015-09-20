package com.company.instance;

import com.company.support.Test;
import com.company.support.Point;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by Yan on 4/6/15.
 */
public class MaxPointsOnLine implements Test{
    @Override
    public void execute() {
        Point[] points = {new Point(84,250),new Point(0,0),new Point(1,0),new Point(0,-70),
                          new Point(0,-70),new Point(1,-1),new Point(21,10),new Point(42,90), new Point(-42,-230)};

        maxPoints(points);
    }

    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        if(points.length == 1) return 1;

        int max = 0;

        for(int i=0; i<points.length; i++){
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            Point start = points[i];
            int duplicate = 0;

            for(int j=0; j<points.length; j++){
                double slope = 0;

                if(start.x == points[j].x && start.y == points[j].y){
                    duplicate++;
                }else{
                    double diffY = points[j].y - start.y;
                    double diffX = points[j].x - start.x;

                    if(diffX == 0) slope = Integer.MAX_VALUE;
                    else slope = diffY/diffX;

                    System.out.println("slop between ("+start.x+","+start.y+") and ("+points[j].x+","+points[j].y+") is "+slope);

                    if(!map.containsKey(slope))map.put(slope,1);
                    else map.put(slope, map.get(slope)+1);
                }

            }

            if(map.size() == 0) {
                return duplicate;
            }else{
                for(Map.Entry<Double, Integer> entry : map.entrySet()){
                    if(max < (entry.getValue()+duplicate)) max = entry.getValue()+duplicate;
                }
            }

            map.clear();

            System.out.println(max);

        }

        return max;
    }
}
