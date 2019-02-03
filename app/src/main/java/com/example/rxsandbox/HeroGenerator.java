package com.example.rxsandbox;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class HeroGenerator {

    private String[] names = {"Eren", "Armin", "Mikasa", "Levi", "Reiner", "Berthold", "Annie", "Christa", "Historia", "Jean", "Connie", "Sasha", "Marco", "Hannes", "Mike", "Erwin", "Hanji", "Ymir"};
    private String[] lastnames = {"Ackerman", "Jaeger", "Arletto", "Broms", "Leonheart", "Reiss", "Tiber", "Springman", "Boltt", "Jean", "Smith"};
    private TimeGapProvider timeGapProvider;

    public HeroGenerator() {
        timeGapProvider = new TimeGapProvider();
    }

    private String getRandomName() {
        timeGapProvider.executeShortTimeGap();
        return names[new Random().nextInt((names.length - 1))];
    }

    private String getRandomLastName() {
        timeGapProvider.executeShortTimeGap();
        return lastnames[new Random().nextInt((lastnames.length - 1))];
    }

    public Observable<Hero> getHero() {
        final Hero newHero = new Hero(getRandomName(), getRandomLastName(), false);
        return new Observable<Hero>() {
            @Override
            protected void subscribeActual(Observer<? super Hero> observer) {
                observer.onNext(newHero);
            }
        };
    }

    public boolean isAValidHero() {
        timeGapProvider.executeMediumTimeGap();
        if(new Random().nextBoolean()) {
            return true;
        }
        return false;
    }
}
