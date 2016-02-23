package com.company.instance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by yanba_000 on 2/17/2016.
 */
public class CloneGraph implements com.company.support.Test {

    @Override
    public void execute() {

    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Stack<UndirectedGraphNode> stack = new Stack<>();  //store original node
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();  //map original node to clone node

        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        stack.push(node);
        map.put(node, head);

        while(!stack.isEmpty()){
            //current node in original graph
            UndirectedGraphNode cur = stack.pop();

            //search all neighbors
            for(UndirectedGraphNode neighbor : cur.neighbors){
                if(!map.containsKey(neighbor)){
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newNeighbor);
                    stack.push(neighbor);
                }

                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }

        return head;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

}
