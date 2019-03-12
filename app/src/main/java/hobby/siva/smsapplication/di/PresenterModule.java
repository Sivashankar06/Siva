package hobby.siva.smsapplication.di;

import dagger.Module;
import dagger.Provides;
import hobby.siva.smsapplication.Contract;
import hobby.siva.smsapplication.model.SMSModel;
import hobby.siva.smsapplication.presenter.SMSManager;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 13/03/19
 */
@Module
public class PresenterModule {

    private Contract.IView mViewInterface;

    public PresenterModule(Contract.IView viewInterface) {
        this.mViewInterface = viewInterface;
    }

    @Provides
    public Contract.IView provideView() {
        return mViewInterface;
    }

    @Provides
    public Contract.IPresenter providePresenter(Contract.IView view, SMSModel model) {
        return new SMSManager(view, model);
    }
}
