package com.example.rxsandbox

import android.app.IntentService
import android.content.Intent
import io.reactivex.Observer
import io.reactivex.subjects.PublishSubject

class AllowenceService() : IntentService("AllowenceService") {

    private val allowencePublishSubject = PublishSubject.create<Boolean>()

    override fun onHandleIntent(intent: Intent?) {

    }

    fun subscribeForAllowenceEmission(observer: Observer<Boolean>) {

    }
}