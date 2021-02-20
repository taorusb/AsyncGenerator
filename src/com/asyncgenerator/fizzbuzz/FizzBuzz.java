package com.asyncgenerator.fizzbuzz;

import java.util.concurrent.CompletableFuture;

public class FizzBuzz {

    private int num;

    public FizzBuzz(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("The number must not be less than or equal to zero.");
        }
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void fizz(int n) {
        if (n % 3 == 0) {
            if (n % 5 == 0) {
                CompletableFuture.runAsync(this::buzzFizz).join();
                return;
            }
            System.out.print("fizz, ");
            return;
        }
        CompletableFuture.runAsync(() -> buzz(n)).join();
    }

    public void buzz(int n) {
        if (n % 5 == 0) {
            System.out.print("buzz, ");
            return;
        }
        CompletableFuture.runAsync(() -> num(n)).join();
    }

    public void buzzFizz() {
        System.out.print("fizzbuzz, ");
    }

    public void num(int n) {
        System.out.print(n + ", ");
    }
}

