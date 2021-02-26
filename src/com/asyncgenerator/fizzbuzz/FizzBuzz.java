package com.asyncgenerator.fizzbuzz;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

public class FizzBuzz {

    private int num;
    private final Semaphore semaphore;

    public FizzBuzz(int num, Semaphore semaphore) {
        if (num <= 0) {
            throw new IllegalArgumentException("The number must not be less than or equal to zero.");
        }
        this.semaphore = semaphore;
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void fizz(int n) {

        if (n % 3 == 0) {
            if (n % 5 == 0) {
                CompletableFuture.runAsync(this::buzzFizz);
                return;
            }
            System.out.print("fizz, ");
            semaphore.release();
            return;
        }
        CompletableFuture.runAsync(() -> buzz(n));
    }

    public void buzz(int n) {
        if (n % 5 == 0) {
            System.out.print("buzz, ");
            semaphore.release();
            return;
        }
        CompletableFuture.runAsync(() -> num(n));
    }

    public void buzzFizz() {
        System.out.print("fizzbuzz, ");
        semaphore.release();
    }

    public void num(int n) {
        System.out.print(n + ", ");
        semaphore.release();
    }
}