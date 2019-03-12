package hobby.siva.smsapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import hobby.siva.smsapplication.Contract;
import hobby.siva.smsapplication.R;
import hobby.siva.smsapplication.SMSApplication;
import hobby.siva.smsapplication.di.DaggerUIComponent;
import hobby.siva.smsapplication.di.PresenterModule;
import hobby.siva.smsapplication.model.SMSModel;

public class MainActivity extends AppCompatActivity implements Contract.IView {

    private RecyclerView mSmsListView;

    @Inject
    Contract.IPresenter mPresenterInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSmsListView = findViewById(R.id.sms_list_view);
        DaggerUIComponent.builder()
                .presenterModule(new PresenterModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public void onNewMessage(SMSModel data) {

    }

    @Override
    public void animateMessage(int index) {

    }
}