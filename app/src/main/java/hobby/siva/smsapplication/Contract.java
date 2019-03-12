package hobby.siva.smsapplication;

import android.app.Activity;

import hobby.siva.smsapplication.model.SMSModel;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
public interface Contract {

    interface IModel {

        void readSMS(Activity actContext);
    }

    interface IView {

        void onNewMessage(SMSModel data);

        void animateMessage(int index);
    }

    interface IPresenter {

        void onActivityPause();

        void onActivityResume();

        void onNewIntent();
    }
}