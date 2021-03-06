package com.permissionnanny.dagger;

/**
 *
 */
public class MockComponentFactory {

    public static AppComponent getAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new MockAppModule())
                .build();
    }

    public static MockContextComponent getContextComponent() {
        return DaggerMockContextComponent.builder()
                .appComponent(getAppComponent())
                .contextModule(new MockContextModule())
                .build();
    }

    public static MockActivityComponent getActivityComponent() {
        return DaggerMockActivityComponent.builder()
                .appComponent(getAppComponent())
                .contextModule(new MockContextModule())
                .activityModule(new MockActivityModule())
                .build();
    }
}
