package com.example.rxsandbox;

import java.util.Random;

public class TimeGapProvider {

    public void executeShortTimeGap() {
        try {
            Thread.sleep(new Random().nextInt(3000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void executeMediumTimeGap() {
        try {
            Thread.sleep(new Random().nextInt(9000) + 3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void executeLongTimeGap() {
        try {
            Thread.sleep(new Random().nextInt(27000) + 9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
