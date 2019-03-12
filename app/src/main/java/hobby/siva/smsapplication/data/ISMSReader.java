package hobby.siva.smsapplication.data;

import android.app.Activity;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
public interface ISMSReader {

    void readSMS(Activity actContext);

    interface ISMSResponder {
        void onMessageReadComplete();
    }
}
