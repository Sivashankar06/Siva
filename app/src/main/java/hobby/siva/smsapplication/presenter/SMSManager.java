package hobby.siva.smsapplication.presenter;

import android.Manifest;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import hobby.siva.smsapplication.Contract;
import hobby.siva.smsapplication.R;
import hobby.siva.smsapplication.pojo.SMS;
import hobby.siva.smsapplication.util.AlertUtil;
import hobby.siva.smsapplication.util.PermissionChecker;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
@Singleton
public class SMSManager implements Contract.IPresenter {

    public static final String READ_SMS_PERMISSION = Manifest.permission.READ_SMS;
    public static final int READ_SMS_PERMISSION_REQ_CODE = 6;

    private Activity mActContext;
    private final Contract.IModel mModel;
    private final Contract.IView mView;

    @Inject
    public SMSManager (Activity actContext, Contract.IView view, Contract.IModel model) {
        this.mActContext = actContext;
        this.mView = view;
        this.mModel = model;
    }

    @Override
    public void populateSMS() {
        mView.showPlaceHolderWithMessage(this.mActContext.getString(R.string.reading_sms));
        if(PermissionChecker.isPermissionAvailable(this.mActContext, READ_SMS_PERMISSION)){
            ArrayList<SMS> smsList = this.mModel.getSMS(this.mActContext);
            if(smsList.size() > 0){
                mView.hidePlaceHolderWithMessage();
                mView.setInitialMessages(smsList);
            } else {
                mView.showPlaceHolderWithMessage(this.mActContext.getString(R.string.no_sms));
            }
        } else {
            if(PermissionChecker.isPermissionRationale(this.mActContext, READ_SMS_PERMISSION)) {
                ActivityCompat.requestPermissions(this.mActContext, new String[] { READ_SMS_PERMISSION }, READ_SMS_PERMISSION_REQ_CODE);
            } else {
                AlertUtil.showAlert(this.mActContext, "Couldn't Read SMS", "Please provide permission to display your SMS.");
            }
        }
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