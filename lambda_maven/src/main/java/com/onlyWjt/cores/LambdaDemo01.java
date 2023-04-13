package com.onlyWjt.cores;

import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

public class LambdaDemo01 {
    public static void main(String[] args) {
        //匿名内部类只有一个抽象方法，就可以进行lamdba的形式简写
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是匿名内部类的方式启动一个线程");
            }
        }).start();
        new Thread(()->{
            System.out.println("这是lambda的方式启动一个线程");
        }).start();

        calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left+right;
            }
        });
        int i = calculateNum((left, right) -> {
            return left + right;
        });
        System.out.println(i);
        printNum(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value%2==0;
            }
        });
        //lambda的写法
        printNum(value-> {
            return value%2==0;
        });

    }
    public static int calculateNum(IntBinaryOperator operator){
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }
    public static void printNum(IntPredicate predicate){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            if(predicate.test(i)){
                System.out.println(i);
            }
        }
    }

}
