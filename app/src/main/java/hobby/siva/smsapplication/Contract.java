package hobby.siva.smsapplication;

import android.app.Activity;

import java.util.ArrayList;

import hobby.siva.smsapplication.model.SMSModel;
import hobby.siva.smsapplication.pojo.SMS;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
public interface Contract {

    interface IModel {

        ArrayList<SMS> getSMS(Activity actContext);
    }

    interface IView {

        void onNewMessage(SMSModel data);

        void animateMessage(int index);
    }

    interface IPresenter {

        void populateSMS();

        void onActivityPause();

        void onActivityResume();

        void onNewIntent();
    }
}