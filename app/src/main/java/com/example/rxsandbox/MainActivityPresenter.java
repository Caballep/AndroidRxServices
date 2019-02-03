package com.example.rxsandbox;

import android.content.Intent;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class MainActivityPresenter {

    private AnalyticsService analyticsService;
    private HeroProviderService heroProviderService;
    private AllowenceService allowenceService;

    public MainActivityPresenter(MainActivity activity) {
        StartBasicServices(activity);
        initializeServiceObservers();
    }

    private void StartBasicServices(MainActivity activity) {
        if(analyticsService == null) {
            analyticsService = new AnalyticsService();
            Intent analyticsIntent = new Intent(activity, AnalyticsService.class);
            activity.startService(analyticsIntent);
        }
        if(heroProviderService == null) {
            heroProviderService = new HeroProviderService();
            Intent heroProviderIntent = new Intent(activity, HeroProviderService.class);
            activity.startService(heroProviderIntent);
        }
        if(allowenceService == null) {
            allowenceService = new AllowenceService();
            Intent allowenceIntent = new Intent(activity, AllowenceService.class);
            activity.startService(allowenceIntent);
        }
    }

    private void initializeServiceObservers() {
        initializeAllowenceObserver();
        initializeHeroObserver();
    }

    private void initializeHeroObserver() {
        Observer<Hero> heroObserver = new Observer<Hero>() {
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

        heroProviderService.subscribeForHeroEmissions(heroObserver);
    }

    private void initializeAllowenceObserver() {
        Observer<Boolean> allowenceObserver = new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Boolean b) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }
}
