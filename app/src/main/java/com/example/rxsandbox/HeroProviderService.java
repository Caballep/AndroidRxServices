package com.example.rxsandbox;

import android.app.IntentService;
import android.content.Intent;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class HeroProviderService extends IntentService {

    private PublishSubject<Hero> heroPublishSubject = PublishSubject.create();
    HeroGenerator heroGenerator = new HeroGenerator();
    private boolean isWaitingForPreviousHero = false;

    public HeroProviderService() {
        super("HeroProviderService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        while(true) {
            if(!isWaitingForPreviousHero) {
                Hero newHero = generateHero();
                heroPublishSubject.onNext(newHero);
                isWaitingForPreviousHero = true;
            }
        }

    }

    public void subscribeForHeroEmissions(Observer<Hero> heroObserver) {
        heroPublishSubject.subscribe(heroObserver);
    }

    private Hero generateHero() {

        final Observer<Hero> heroObserver = new Observer<Hero>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Hero hero) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        heroGenerator.getHero().subscribe();

    }

}
