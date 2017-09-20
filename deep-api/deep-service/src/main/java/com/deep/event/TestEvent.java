package com.deep.event;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Created by yangliuhua on 2017-6-27.
 */
public class TestEvent {

    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        eventBus.register(new Object() {

            @Subscribe
            public void lister(Integer integer) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s from int%n", integer);
            }

            @Subscribe
            public void lister(Long integer) {
                System.out.printf("%s from long%n", integer);
            }
        });

        eventBus.post(1);
        eventBus.post(1L);
        System.out.println(11111);

/*        AsyncEventBus asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(3));
        asyncEventBus.register(new Object() {

            @Subscribe
            public void lister(Integer integer) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s from int%n", integer);
            }

            @Subscribe
            public void lister(Long integer) {
                System.out.printf("%s from long%n", integer);
            }
        });

        asyncEventBus.post(1);
        asyncEventBus.post(1L);
        System.out.println(11111);*/
    }
}
