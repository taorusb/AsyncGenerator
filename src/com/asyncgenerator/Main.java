package com.asyncgenerator;

import com.asyncgenerator.fizzbuzz.FizzBuzz;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1, true);
        FizzBuzz fizzBuzz = new FizzBuzz(15, semaphore);

        IntStream.rangeClosed(1, fizzBuzz.getNum())
                .forEach(num -> {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    CompletableFuture.runAsync(() -> fizzBuzz.fizz(num));
                });
    }
}