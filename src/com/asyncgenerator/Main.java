package com.asyncgenerator;

import com.asyncgenerator.fizzbuzz.FizzBuzz;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        FizzBuzz fizzBuzz = new FizzBuzz(15);

        IntStream.rangeClosed(1, fizzBuzz.getNum())
                .forEach(x -> CompletableFuture.runAsync(() -> fizzBuzz.fizz(x)).join());
    }
}