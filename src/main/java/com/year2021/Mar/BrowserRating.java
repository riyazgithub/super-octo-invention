package com.year2021.Mar;

import com.year2021.helper.maxStack;

public class BrowserRating {
    public static void main(String[] args) {
        maxStack maxStack = new maxStack(7);
        maxStack.push(5);
        maxStack.push(0);
        maxStack.push(2);
        maxStack.push(4);
        maxStack.push(6);
        maxStack.push(3);
        maxStack.push(10);

        System.out.println("Max Rating "+ maxStack.maxRating());

        maxStack.pop();
        System.out.println("Clicking back button");
        System.out.println("Maximum Rating "+ maxStack.maxRating());

    }
}
