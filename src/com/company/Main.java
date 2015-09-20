package com.company;

import java.util.*;
import java.util.LinkedList;

import com.company.instance.*;
import com.company.instance.LinkedListNode;
import com.company.support.Test;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
        Test test = new WordSearch();
        test.execute();
    }

    static private int findMin(int[] num) {
        int low = 0, high = num.length-1;

        while(low<high){
            int mid = low + ((high-low)/2);
            if(num[mid] < num[high]) high = mid;
            else if(num[mid] > num[high])low = mid + 1;
        }

        return num[low];
    }

    static private LinkedListNode removeDuplicate(LinkedListNode head, int value){
        LinkedListNode prev = null;
        LinkedListNode cur = head;
        LinkedListNode newhead = head;

        while(cur!= null){
            if(cur.data == value){
                if(prev == null){
                    newhead = cur.next;
                    cur = cur.next;
                }else{
                    prev.next = cur.next;
                    cur = cur.next;
                }
            }else{
                prev = cur;
                cur = cur.next;
            }

        }

        return newhead;
    }

    private static int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<String>();

        for(int i=0; i<tokens.length; i++){
            String cur = tokens[i];
            switch(cur.charAt(0)){
                case '+':
                    stack.push( String.valueOf(Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop())) );
                    break;
                case '-':
                    int num2 = Integer.parseInt(stack.pop());
                    int num1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num1 - num2));
                    break;
                case '*':
                    stack.push( String.valueOf( Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop()) ) );
                    break;
                case '/':
                    int divisor = Integer.parseInt(stack.pop());
                    int dividend = Integer.parseInt(stack.pop());
                    stack.push( String.valueOf((Integer) (dividend/divisor)) );
                    break;
                default:
                    stack.push(cur);
                    break;
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private static int removeDuplicate(int[] A){
        int steps = 0;

        for(int i=1; i<A.length; i++){
            if(A[i] == A[i-1]) steps++;

            if(steps > 0){
                A[i-steps] = A[i];
            }
        }

        int newLength = A.length - steps;

        return newLength;
    }

    static class MinStack {

        LinkedList<Integer> stack = new LinkedList<Integer>();
        LinkedList<Integer> minstack = new LinkedList<Integer>();

        public void push(int x) {
            stack.add(x);
            if(minstack.isEmpty()) {
                minstack.add(x);
            }else {
                if(x<=minstack.peekLast())minstack.add(x);
            }
        }

        public void pop() {
            if(stack.isEmpty()) return;

            System.out.println("1111:"+minstack.peekLast());
            System.out.println("2222:"+stack.peekLast());

            if(minstack.peekLast().intValue() == stack.peekLast().intValue()){
                minstack.pollLast();
                System.out.println("minstack pop");
            }

            //minstack.pollLast();
            stack.pollLast();
        }

        public int top() {
            if(stack.isEmpty()) return 0;
            else return stack.peekLast();
        }

        public int getMin() {
            if(minstack.isEmpty()) return 0;
            else return minstack.peekLast();
        }
    }


    private static int[] candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);

        //increasing
        for(int i=1; i<ratings.length; i++){
            if( ratings[i] > ratings[i-1] ) {
                candy[i] = candy[i-1]+1;
            }
        }

        //decreasing
        for(int j=ratings.length-2; j>=0; j--){
            if(ratings[j] > ratings[j+1]){
                if( ((j-1>=0)) && (ratings[j-1]<ratings[j]) ){
                    candy[j] = Math.max(candy[j], candy[j-1]+1);
                }else{
                    candy[j] = candy[j+1]+1;
                }
            }
        }

        //int sum = 0;
        //for(int k=0; k<candy.length; k++) sum+=candy[k];

        return candy;
    }

    private static List<List<Integer>> threeSum(int[] num){
        List resultList = new ArrayList<ArrayList>();
        Arrays.sort(num);
        int length = num.length;
        for(int i=0; i<length-2;){
            int j=i+1, k=length-1;
            while(j<k){
                int sum = num[i]+num[j]+num[k];
                if(sum==0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    resultList.add(list);
                    do{
                        j++;
                    }while(num[j]==num[j-1]);
                    do{
                        k--;
                    }while(num[k]==num[k+1]);
                }else if(sum>0){
                    do{
                        k--;
                    }while(num[k]==num[k+1]);
                }else{
                    do{
                        j++;
                    }while(num[j]==num[j-1]);
                }
            }

            do{
                i++;
            }while(num[i] == num[i-1]);

        }

        return resultList;
    }

    private static int[] findMedian(int A[], int B[]){
        int indexA=0, indexB=0, indexAB=0;
        int[] AB = new int[A.length+B.length];

        while( (indexA<A.length) && (indexB<B.length) ){
            if(A[indexA] < B[indexB]){
                AB[indexAB] = A[indexA];
                indexA++;
                indexAB++;
            }else if(A[indexA] > B[indexB]){
                AB[indexAB] = B[indexB];
                indexB++;
                indexAB++;
            }else{
                AB[indexAB] = A[indexA];
                indexA++;
                indexAB++;
                AB[indexAB] = B[indexB];
                indexB++;
                indexAB++;
            }
        }

        if(indexA<A.length){
            for(;indexA<A.length;indexA++){
                AB[indexAB] = A[indexA];
                indexAB++;
            }
        }

        if(indexB<B.length){
            for(;indexB<B.length;indexB++){
                AB[indexAB] = B[indexB];
                indexAB++;
            }
        }

        double median;

        if( (AB.length % 2) == 0 ){
            int medianIndex = AB.length/2;
            median = ((double)AB[medianIndex-1] + (double)AB[medianIndex])/2.0;
        }else{
            int medianIndex = AB.length/2;
            median = (double)AB[medianIndex];
        }

        System.out.println(median);

        return AB;
    }

    private static int[] plusOne(int[] digits){

        boolean plusOne = false;
        int i=digits.length-1;
        for(; i>=0; i--){
            int cur = digits[i];

            if(!plusOne){
                if( cur>=0 && cur <9){
                    digits[i] = cur+1;
                    break;
                }
                else{
                    digits[i] = 0;
                    plusOne = true;
                }
            }else{
                if( cur>=0 && cur <9){
                    digits[i] = cur+1;
                    plusOne = false;
                    break;
                }else{
                    digits[i] = 0;
                }
            }

        }

        if(plusOne && i==-1){
            int[] re = new int[digits.length+1];
            re[0] = 1;

            return re;
        }

        return digits;
    }

    private static int findMajority(int[] num){

        int majority = 0;

        for(int i=0; i<32; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int current : num) {
                if((current & (1<<i)) == 0) count0++;
                else count1++;
            }

            if(count1 > count0){
                majority = (majority | (1<<i) );
            }

        }


        return majority;
    }

    private static int maxProfit(int[] prices){
        if(prices == null) return 0;
        if(prices.length == 0) return 0;

        int lowest = prices[0], profit = 0;

        for(int i=1; i<prices.length; i++){
            int current = prices[i];

            if(current > lowest + profit) profit = current - lowest;
            else if(current < lowest) lowest = current;
        }

        return profit;
    }

    private static boolean validParentheses(String s){
        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);

            if(cur=='(' || cur=='[' || cur=='{'){      //Left parentheses, push into stack.
                stack.push(cur);
            }
            else{                                      //Right parentheses, compare with top element of stack.
                if(stack.isEmpty()) return false;      //If stack is empty and current character is right parentheses, it is invalid.
                if(samePair(stack.peek(), cur)){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        if(stack.isEmpty()) return true;
        else return false;

    }

    private static boolean samePair(char topInStack, char cur){
        if(topInStack == '('){
            if(cur == ')') return true;
            else return false;
        }

        if(topInStack == '['){
            if(cur == ']') return true;
            else return false;
        }

        if(topInStack == '{'){
            if(cur == '}') return true;
            else return false;
        }

        return false;
    }

    public static int findSameMin(int[] A, int[] B){

        Arrays.sort(A);
        Arrays.sort(B);

        int indexA = 0;
        int indexB = 0;

        while(indexA < A.length && indexB < B.length){
            int headOfA = A[indexA];
            int headOfB = B[indexB];

            if(headOfA == headOfB){
                return headOfA;
            }else if(headOfA < headOfB){
                indexA++;
            }else {
                indexB++;
            }
        }

        return -1;
    }

    public static int findEquilibrium(int[][] matrix){
        int numOfRow = matrix.length;
        int numOfColumn = matrix[0].length;

        // Store sum of rows.
        // sumOfRow[0] is sum of row 0
        // sumOfRow[1] is sum of row 0 + row 1
        // sumOfRow[2] is sum of row 0 + row 1 + row 2
        // ...
        int[] sumOfRow = new int[numOfRow];

        // Similar to sumOfRow
        int[] sumOfColumn = new int[numOfColumn];

        // set value for sumOfRow
        int sum_row = 0;
        for(int i=0; i<numOfRow; i++){
            for(int j=0; j<numOfColumn; j++){
                sum_row += matrix[i][j];
            }
            sumOfRow[i] = sum_row;
        }

        //for(int x=0; x< sumOfRow.length; x++) System.out.println(sumOfRow[x]);

        // set value for sumOfColumn
        int sum_column = 0;
        for(int m=0; m<numOfColumn; m++){
            for(int n=0; n<numOfRow; n++){
                sum_column += matrix[n][m];
            }
            sumOfColumn[m] = sum_column;
        }

        for(int y=0; y< sumOfColumn.length; y++) System.out.println(sumOfColumn[y]);

        // Find equilibrium of row
        java.util.LinkedList<Integer> equilibruimOfRow = new java.util.LinkedList<Integer>();
        for(int p=1; p<numOfRow-1; p++){
            int sumAbove = sumOfRow[p-1];
            int sumBelow = sumOfRow[numOfRow-1] - sumOfRow[p];

            if(sumAbove == sumBelow) {
                System.out.println("row point:"+p);
                equilibruimOfRow.add(p);
            }
        }

        // Find equilibrium of column
        java.util.LinkedList<Integer> equilibruimOfColumn = new java.util.LinkedList<Integer>();
        for(int q=1; q<numOfColumn-1; q++){
            int sumLeft = sumOfColumn[q-1];
            int sumRight = sumOfColumn[numOfColumn-1] - sumOfColumn[q];

            if(sumLeft == sumRight){
                System.out.println("column point:"+q);
                equilibruimOfColumn.add(q);
            }
        }

        return (equilibruimOfRow.size() * equilibruimOfColumn.size());

    }

    public static String firstReaptingCharacter(String s){
        HashMap map = new HashMap<Character, Boolean>();

        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                if((Boolean)map.get(cur) == false) map.put(cur, true);
            }else{
                map.put(cur, false);
            }
        }

        Iterator it = map.entrySet().iterator();
        String re = null;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            re = Character.toString((Character)pair.getKey());
        }

        return re;
    }

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle){
        if(triangle == null) return 0;

        int[] sum = new int[triangle.size()+1];

        for(int i=triangle.size()-1; i>=0; i--){
            for(int j=0; j<triangle.get(i).size(); j++){
                List currentList = triangle.get(i);
                sum[j] = (Integer)(currentList.get(j)) + Math.min(sum[j], sum[j+1]);
            }

            for(int x=0; x<sum.length; x++)System.out.print(sum[x]+" ");
            System.out.println();
        }

        return sum[0];
    }

    /*
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null) return 0;

        return getMinimumChildSum(0, 0, triangle);
    }

    private static int getMinimumChildSum( int nodeIndex, int rowIndex, ArrayList<ArrayList<Integer>> triangle){
        if( rowIndex > (triangle.size()-1) ) return 0;

        int leftChildSum = getMinimumChildSum(nodeIndex, rowIndex+1, triangle);
        int rightChildSum = getMinimumChildSum(nodeIndex+1, rowIndex+1, triangle);

        int valueOfNode = (Integer)triangle.get(rowIndex).get(nodeIndex);

        return leftChildSum <= rightChildSum ? (valueOfNode+leftChildSum) : (valueOfNode+rightChildSum);
    }
    */


    public static String longestPalindrome(String s) {

        if(s == null) return null;

        int maxLengthSoFar = 0;
        String maxStringSoFar = null;

        for(int i=0; i<s.length(); i++){

            String oddSubString = findPalindrome(s, i, i);
            if(oddSubString.length() > maxLengthSoFar){
                maxLengthSoFar = oddSubString.length();
                maxStringSoFar = oddSubString;
            }

            String evenSubString = findPalindrome(s, i, i+1);
            if(evenSubString.length() > maxLengthSoFar){
                maxLengthSoFar = evenSubString.length();
                maxStringSoFar = evenSubString;
            }
        }

        return maxStringSoFar;
    }
    private static String findPalindrome(String s, int cLeft, int cRight){
        while(cLeft>=0 && cRight<=s.length()-1){
            if(s.charAt(cLeft) != s.charAt(cRight)) break;

            cLeft--;
            cRight++;
        }

        return s.substring(cLeft+1, cRight);
    }


        /*
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.print();



        int[][] matrix = new int[6][6];
        matrix[0][0] = 9;
        matrix[0][1] = 3;
        matrix[0][2] = 6;
        matrix[0][3] = 9;
        matrix[0][4] = 8;
        matrix[0][5] = 2;

        matrix[1][0] = 7;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[1][3] = 8;
        matrix[1][4] = 3;
        matrix[1][5] = 1;

        matrix[2][0] = 2;
        matrix[2][1] = 4;
        matrix[2][2] = 4;
        matrix[2][3] = 5;
        matrix[2][4] = 1;
        matrix[2][5] = 9;

        matrix[3][0] = 3;
        matrix[3][1] = 7;
        matrix[3][2] = 8;
        matrix[3][3] = 1;
        matrix[3][4] = 2;
        matrix[3][5] = 3;

        matrix[4][0] = 8;
        matrix[4][1] = 2;
        matrix[4][2] = 5;
        matrix[4][3] = 9;
        matrix[4][4] = 3;
        matrix[4][5] = 7;

        matrix[5][0] = 0;
        matrix[5][1] = 1;
        matrix[5][2] = 0;
        matrix[5][3] = 3;
        matrix[5][4] = 9;
        matrix[5][5] = 8;

        matrix[5][0] = 0;
        matrix[5][1] = 1;
        matrix[5][2] = 0;
        matrix[5][3] = 3;
        matrix[5][4] = 9;
        matrix[5][5] = 8;

        printMatrix(matrix, 6);
        rotateMatrix(matrix, 6);
        printMatrix(matrix, 6);
        */

    static private void printMatrix(int[][] matrix, int n){
        out.println("matrix:");
        for(int row = 0; row < n; row++){
            out.print("[");
            for(int column = 0; column < n-1; column++){
                out.print(matrix[row][column]+" ");
            }
            out.print(matrix[row][n-1]);
            out.print("]");
            out.print("\n");
        }
    }

    static private void rotateMatrix(int[][] matrix, int n){
        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n-layer-1;

            for(int i=first; i<last; i++){
                int offset = i - first;

                //save top edge
                int top = matrix[first][i];

                // top <- left
                matrix[first][i] = matrix[last-offset][first];

                // left <- bottom
                matrix[last-offset][first] = matrix[last][last-offset];

                // bottom <- right
                matrix[last][last-offset] = matrix[i][last];

                // right <- top
                matrix[i][last] = top;
            }

        }
    }

    static private int countCompression(String str) {
        int size = 0;
        int count = 1;
        int countChar = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == countChar) {
                count++;
            } else {
                size = size + 1 + String.valueOf(count).length();
                count = 1;
                countChar = str.charAt(i);
            }
        }

        size = size + 1 + String.valueOf(count).length();

        return size;
    }

    static private String compress(String str){
        String compressedStr = "";
        int count=1;
        char countChar = str.charAt(0);

        for(int i=1; i<str.length(); i++){
            if(countChar == str.charAt(i)){
                count++;
            }else{
                compressedStr = compressedStr + countChar + count;
                countChar = str.charAt(i);
                count = 1;
            }
        }

        compressedStr = compressedStr + countChar + count;

        System.out.println(compressedStr);
        System.out.println(str);

        if(compressedStr.length() >= str.length()) return str;
        else return compressedStr;
    }

    public static String reverseWords(String s) {

        StringBuilder builder = new StringBuilder();

        //edge case
        if(s == null) return null;
        if(s.length() == 0) return "";

        int strLength = s.length();

        //left edge
        int leftEdge = -1;
        for(int i=0; i<strLength; i++){
            if(s.charAt(i) != ' ') {
                leftEdge = i;
                break;
            }
        }

        if(leftEdge == -1) return "";

        //right edge
        int rightEdge = -1;
        for(int j = s.length() -1; j>=0; j--){
            if(s.charAt(j) != ' '){
                rightEdge = j;
                break;
            }
        }

        if(rightEdge == leftEdge) return Character.toString(s.charAt(leftEdge));

        int wordStart = rightEdge;
        int wordEnd = 0;
        for(int k = rightEdge-1; k>=leftEdge; k--){

            char c = s.charAt(k);

            if(c != ' '){
                if(s.charAt(k+1) == ' '){
                    wordStart = k;
                }
            }else{
                if(s.charAt(k+1) != ' '){
                    wordEnd = k+1;

                    for(int m=wordEnd; m<=wordStart; m++){
                        builder.append(s.charAt(m));
                    }

                    builder.append(' ');
                }
            }

        }

        for(int n=leftEdge; n<=wordStart; n++){
            builder.append(s.charAt(n));
        }

        return builder.toString();
    }

    /*
        ArrayList<Integer> sublist1 = new ArrayList<Integer>();
        ArrayList<Integer> sublist2 = new ArrayList<Integer>();
        ArrayList<Integer> sublist3 = new ArrayList<Integer>();

        sublist1.add(-1);
        sublist2.add(2);
        sublist2.add(3);
        sublist3.add(-10);
        sublist3.add(8);
        sublist3.add(3);

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        list.add(sublist1);
        list.add(sublist2);
        list.add(sublist3);

        System.out.println(minimumTotal(list));
        */
}