package com.learning.algo.knapsack;

public class SackObject {
    public int position;
    public int value;

    public SackObject(int position, int value) {
        this.position = position;
        this.value = value;
    }

    @Override
    public String toString() {
        return value + ", ";
    }
}
