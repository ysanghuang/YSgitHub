package com.gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {


        Battercake battercake;

        battercake = new BaseBattercake();

        battercake = new EggDecorator(battercake);

        battercake = new EggDecorator(battercake);

        battercake = new SauageDecorator(battercake);

        System.out.println(battercake.getMsg() + ",总价" + battercake.getPrice());

    }
}
