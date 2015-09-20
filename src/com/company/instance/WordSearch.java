package com.company.instance;

import com.company.support.Test;

/**
 * Created by Yan on 9/14/15.
 */
public class WordSearch implements Test {

    @Override
    public void execute() {
        char[] a = {'A','B','C','E'};
        char[] b = {'S','F','C','S'};
        char[] c = {'A','D','E','E'};

        char[][] board = new char[3][4];
        board[0] = a;
        board[1] = b;
        board[2] = c;

        System.out.print(exist(board, "ABCCED"));
    }

    public boolean exist(char[][] board, String word) {

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length;j++){
                System.out.println("起点 ["+i+"]["+j+"]:"+board[i][j]);
                if(search(board, word, 0, i, j)) return true;
            }
        }

        return false;
    }

    private boolean search(char[][]board, String word, int pos, int X, int Y){

        if((X>=0&&X<board.length)&&(Y>=0&&Y<board[0].length)){

            if(board[X][Y] == word.charAt(pos)){

                char temp = board[X][Y];
                board[X][Y] = '#';

                if(pos == word.length() -1) {
                    System.out.println("查找完毕，找到路线！");
                    return true;
                }

                System.out.println("当前点["+X+"]["+Y+"]匹配第"+pos+"个元素"+"，继续查找。");

                System.out.println("检查左");
                boolean left = false;
                left = search(board, word, pos+1, X, Y-1);
                System.out.println("检查上");
                boolean top = false;
                top = search(board, word, pos+1, X-1, Y);
                System.out.println("检查右");
                boolean right = false;
                right = search(board, word, pos+1, X, Y+1);
                System.out.println("检查下");
                boolean bottom = false;
                bottom = search(board, word, pos+1, X+1, Y);

                /*
                System.out.println("left:"+left);
                System.out.println("top:"+top);
                System.out.println("right:"+right);
                System.out.println("bottom:"+bottom);
                */
                if (left || top || right || bottom) return true;

                board[X][Y] = temp;
            }

        }

        return false;
    }

}
