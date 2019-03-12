package hobby.siva.smsapplication.presenter;

import javax.inject.Inject;
import javax.inject.Singleton;

import hobby.siva.smsapplication.Contract;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
@Singleton
public class SMSManager implements Contract.IPresenter {

    private final Contract.IModel mModel;
    private final Contract.IView mView;

    @Inject
    public SMSManager (Contract.IView view, Contract.IModel model) {
        this.mView = view;
        this.mModel = model;
    }

    @Override
    public void onActivityPause() {

    }

    @Override
    public void onActivityResume() {

    }

    @Override
    public void onNewIntent() {

    }
}
