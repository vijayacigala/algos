package com.learning.algo.knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    private static int MAX = 22;
    static Stack<SackObject> sack = new Stack<>();
    public static void main(String[] args) {

//        List<Integer> set = new ArrayList<Integer>() {{ add(6); add(9); }};
//        List<Integer> set = new ArrayList<Integer>() {{ add(22);}};
        List<Integer> set = new ArrayList<Integer>() {{add(10); add(1);  add(5); add(2); add(6); add(9); add(3);}};

        getSack(set, MAX, 0, 0);

        if(!sack.isEmpty()) {
            System.out.println("Solution : ");
            sack.forEach(System.out::println);
        } else {
            System.out.println("No solution");
        }
    }


    static int getSack(List<Integer> set, int max, int startPos, int currentTotal) {

        if(startPos > (set.size() -1)) {

            if(sack.size() > 2) {
                SackObject pop = sack.pop();
                currentTotal -= pop.value;
                System.out.println("Popped : " + pop);

                pop = sack.pop();
                currentTotal -= pop.value;
                System.out.println("Popped : " + pop);
                System.out.println("Peek : " + (sack.peek().position));

                return getSack(set, max, pop.position + 1, currentTotal);
            } else {
                sack.clear();
                return 0;
            }
        }

        System.out.println("position " + startPos + " number " + set.get(startPos) + " current total " + currentTotal);
        sack.forEach(System.out::print);
        System.out.println("*");

        if((set.get(startPos) + currentTotal) <= max) {
            currentTotal += set.get(startPos);
            sack.push(new SackObject(startPos, set.get(startPos)));
            if(currentTotal == max) {
                return 0;
            } else {
                return getSack(set, max, ++startPos, currentTotal);
            }
        } else {
            SackObject pop = sack.pop();
            currentTotal -= pop.value;
            System.out.println("Popped : " + pop);
            return getSack(set, max, pop.position + 1, currentTotal);
        }
    }



}
