package com.company.instance;

import java.util.*;


/**
 * Created by yanba_000 on 2/21/2016.
 */
public class ReconstructItinerary implements com.company.support.Test {

    @Override
    public void execute() {
        String[][] tickets = {
                {"JFK","SFO"},
                {"JFK","ATL"},
                {"SFO","ATL"},
                {"ATL","JFK"},
                {"ATL","SFO"}
        };

        System.out.println(findItinerary(tickets));
    }

    public List<String> findItinerary(String[][] tickets) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0; i<tickets.length; i++){
            String from = tickets[i][0];
            String dest = tickets[i][1];

            if(!map.containsKey(tickets[i][0]))
                map.put(from, new ArrayList<String>());
            map.get(from).add(dest);
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet())
            Collections.sort(entry.getValue());


        List<String> list = new ArrayList<>();
        list.add("JFK");

        dfs(map, list, tickets.length + 1);
        return list;
    }

    private boolean dfs(HashMap<String, List<String>> map, List<String> list, int len){
        if(list.size() == len)
            return true;

        String start = list.get(list.size()-1);
        List<String> dests = map.get(start);
        if(dests == null)
            return false;

        for(int i=0; i<dests.size(); i++){
            String dest = dests.get(i);
            dests.remove(i);
            list.add(dest);
            if(dfs(map, list, len))
                return true;
            list.remove(list.size() -1);
            dests.add(i, dest);
        }

        return false;
    }


}
