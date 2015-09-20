package com.company.instance;

import com.company.support.Test;

import java.util.Queue;
import java.util.LinkedList;
/**
 * Created by Yan on 3/31/15.
 */
public class SurroundedRegions implements Test{

    private class Node{
        public int row, col;

        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    @Override
    public void execute() {
        char[][] input = {
                {'X','O','X','O','X'},
                {'O','X','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','X','O'}
        };



        for(int m=0; m<input.length; m++){ //row
            for(int n=0; n<input[0].length; n++){//col
                System.out.print("[" + m + "]" + "[" + n + "]:" + " " + input[m][n] +" ");
            }
            System.out.println();
        }

        System.out.println("----------");

        solve(input);

        for(int m=0; m<input[0].length; m++){ //row
            for(int n=0; n<input.length; n++){//col
                System.out.print(input[m][n] + " ");
            }
            System.out.println();
        }

    }

    private void solve(char[][] board) {


        //first and last row
        for(int i=0; i<board[0].length; i++){
            //first row
            BFS(board, new Node(0, i));
            //last row
            BFS(board, new Node(board.length-1, i));
        }

        //first and last column
        for(int j=0; j<board.length; j++){
            //first column
            BFS(board, new Node(j, 0));
            //last column
            BFS(board, new Node(j, board[0].length-1));
        }

        //to-do
        for(int m=0; m<board[0].length; m++){ //col
            for(int n=0; n<board.length; n++){
                if(board[m][n] == '#')board[m][n]='O';
                else if(board[m][n] == 'O')board[m][n]='X';
            }
        }
    }

    private void BFS(char[][] board, Node node){
        int row = node.row;
        int col = node.col;

        if(board[row][col] != 'O') return;

        board[row][col] = '#';

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(node);

        while(!queue.isEmpty()){
            Node root = queue.poll();
            int rootRow = root.row;
            int rootCol = root.col;

            //left
            if(rootCol>0 && board[rootRow][rootCol-1]=='O'){
                queue.offer(new Node(rootRow, rootCol-1));
                board[rootRow][rootCol-1] = '#';
            }

            //right
            if(rootCol<board[0].length-1 && board[rootRow][rootCol+1]=='O'){
                queue.offer(new Node(rootRow, rootCol+1));
                board[rootRow][rootCol+1] = '#';
            }

            //up
            if(rootRow>0 && board[rootRow-1][rootCol]=='O'){
                queue.offer(new Node(rootRow-1, rootCol));
                board[rootRow-1][rootCol] = '#';
            }
            //down
            if(rootRow<board.length-1 && board[rootRow+1][rootCol]=='O'){
                queue.offer(new Node(rootRow+1, rootCol));
                board[rootRow+1][rootCol] = '#';
            }
        }

    }

}
