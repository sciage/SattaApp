package com.example.sattaapp.di.rxbus;

import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

/**
 * Created by amitshekhar on 06/02/17.
 */

public class RxBus {

    public RxBus() {
    }

    private final Relay<Object> _bus = PublishRelay.create().toSerialized();
   // private final Relay<Object> _bus = BehaviorRelay.create().toSerialized();

    public void send(Object o) {
        _bus.accept(o);
    }

    public Flowable<Object> asFlowable() {
        return _bus.toFlowable(BackpressureStrategy.LATEST);
    }

    public boolean hasObservers() {
        return _bus.hasObservers();
    }
}
