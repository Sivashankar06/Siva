package hobby.siva.smsapplication.ui;

import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import javax.inject.Inject;

import hobby.siva.smsapplication.Contract;
import hobby.siva.smsapplication.R;
import hobby.siva.smsapplication.broadcast.SMSReceiver;
import hobby.siva.smsapplication.di.DaggerUIComponent;
import hobby.siva.smsapplication.di.PresenterModule;
import hobby.siva.smsapplication.pojo.SMS;
import hobby.siva.smsapplication.presenter.SMSManager;

public class MainActivity extends AppCompatActivity implements Contract.IView {

    private TextView mInfoTextView;
    private RecyclerView mSmsListView;
    private SMSAdapter mSmsAdapter;
    private SMSReceiver mSMSReceiver;

    @Inject Contract.IPresenter mPresenterInterface;

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
        mSMSReceiver = new SMSReceiver(mPresenterInterface);
        this.registerReceiver(mSMSReceiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == SMSManager.READ_SMS_PERMISSION_REQ_CODE){
            mPresenterInterface.onPermissionRequestFinished();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenterInterface.onActivityPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenterInterface.onActivityResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(mSMSReceiver);
    }

    @Override
    public void setInitialMessages(ArrayList<SMS> messages) {
        Collections.reverse(messages);
        mSmsAdapter.addAll(messages);
        mSmsListView.scrollToPosition(messages.size() - 1);
    }

    @Override
    public void showPlaceHolderWithMessage(String message) {
        mInfoTextView.setVisibility(View.VISIBLE);
        mSmsListView.setVisibility(View.GONE);
        mInfoTextView.setText(message);
    }

    @Override
    public void hidePlaceHolderWithMessage() {
        mInfoTextView.setVisibility(View.GONE);
        mSmsListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onNewMessage(ArrayList<SMS> newMessages) {
        mSmsAdapter.addAll(newMessages);
        mSmsListView.scrollToPosition(mSmsAdapter.getItemCount() - 1);
    }
}