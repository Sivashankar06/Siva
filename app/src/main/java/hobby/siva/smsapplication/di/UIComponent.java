package hobby.siva.smsapplication.di;

import javax.inject.Singleton;

import dagger.Component;
import hobby.siva.smsapplication.Contract;
import hobby.siva.smsapplication.ui.MainActivity;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 13/03/19
 */
@Singleton
@Component(modules = { PresenterModule.class })
public interface UIComponent {

    void inject(MainActivity mainActivity);

    Contract.IPresenter getPresenter();

}