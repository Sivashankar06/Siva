package hobby.siva.smsapplication;

import hobby.siva.smsapplication.model.SMSModel;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
public interface ViewContract {

    void onNewMessage(SMSModel data);
    void animateMessage(int index);
}