package hobby.siva.smsapplication.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import javax.inject.Inject;

import hobby.siva.smsapplication.Contract;
import hobby.siva.smsapplication.R;
import hobby.siva.smsapplication.di.DaggerUIComponent;
import hobby.siva.smsapplication.di.PresenterModule;
import hobby.siva.smsapplication.pojo.SMS;
import hobby.siva.smsapplication.presenter.SMSManager;

public class MainActivity extends AppCompatActivity implements Contract.IView {

    private TextView mInfoTextView;
    private RecyclerView mSmsListView;
    private SMSAdapter mSmsAdapter;

    @Inject
    Contract.IPresenter mPresenterInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInfoTextView = findViewById(R.id.infoText);
        mSmsListView = findViewById(R.id.sms_list_view);
        mSmsAdapter = new SMSAdapter(this);
        mSmsListView.setLayoutManager(new LinearLayoutManager(this));
        mSmsListView.setAdapter(mSmsAdapter);
        DaggerUIComponent.builder()
                .presenterModule(new PresenterModule(this, this))
                .build()
                .inject(this);
        mPresenterInterface.populateSMS();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == SMSManager.READ_SMS_PERMISSION_REQ_CODE){
            mPresenterInterface.populateSMS();
        }
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
    public void setInitialMessages(ArrayList<SMS> messages) {
        mSmsAdapter.addAll(messages);
    }

    @Override
    public void showPlaceHolderWithMessage(String message) {
        mInfoTextView.setVisibility(View.VISIBLE);
        mInfoTextView.setText(message);
    }

    @Override
    public void hidePlaceHolderWithMessage() {
        mInfoTextView.setVisibility(View.GONE);
    }

    @Override
    public void onNewMessage(SMS message) {

    }

    @Override
    public void animateMessage(int index) {

    }
}