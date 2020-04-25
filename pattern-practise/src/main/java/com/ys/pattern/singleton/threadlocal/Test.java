package com.ys.pattern.singleton.threadlocal;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/29 11:23
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+":");
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());
        t1.start();
        t2.start();

        Thread t3 = new Threadxx();
        t3.start();
        System.out.println("End");
    }
}
class ExectorThread implements Runnable {
    @Override
    public void run() {
        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+":"+singleton);
    }
}

class Threadxx extends Thread{
    @Override
    public void run() {
        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+":"+singleton);
    }
}
