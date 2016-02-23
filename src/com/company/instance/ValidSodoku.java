package com.company.instance;

import com.company.support.Test;

import java.util.HashMap;

/**
 * Created by yanba_000 on 11/14/2015.
 */
public class ValidSodoku implements Test{

    @Override
    public void execute() {
        char[][] board = {
                {1,2,3,4,5,6,7,8,9},
                {7,8,9,1,2,3,6,5,4},
                {6,5,4,7,8,9,1,2,3},
                {3,1,2,6,4,5,9,7,8},
                {9,7,8,2,3,1,5,4,6},
                {5,4,6,8,9,7,3,1,2},
                {2,3,1,5,6,4,8,9,7},
                {8,9,7,3,1,2,4,6,5},
                {4,6,5,9,7,8,2,3,1}
        };

        boolean re = isValidSudoku(board);

        System.out.println(re);
    }

    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;

        HashMap<Character, Integer> map = new HashMap<>();

        //check row
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
                char c = board[row][col];
                if(c == '.')
                    continue;
                if(map.containsKey(c))
                    return false;
                else
                    map.put(c, 0);
            }
            map.clear();
        }

        //check column
        for(int col=0; col<board[0].length; col++){
            for(int row=0; row<board.length; row++) {
                char c = board[row][col];
                if(c == '.')
                    continue;
                if (map.containsKey(c))
                    return false;
                else
                    map.put(c, 0);
            }
            map.clear();
        }

        for(int i=0; i<3; i+=3){
            for(int j=0; j<3; j+=3){
                if(helper(i,j,board) == false)
                    return false;
            }
        }

        return true;
    }

    private boolean helper(int row, int col, char[][] board){

        HashMap<Character, Integer> map = new HashMap<>();

        for(int r=0; r<3; r++){
            for(int c=0; c<3; c++){
                char ch = board[row+r][col+c];
                if(c == '.')
                    continue;
                if (map.containsKey(ch))
                    return false;
                else
                    map.put(ch, 0);
            }
        }

        return true;
    }

}
