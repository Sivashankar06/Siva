package hobby.siva.smsapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import hobby.siva.smsapplication.model.SMSModel;

public class MainActivity extends AppCompatActivity implements ViewContract {

    private RecyclerView mSmsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSmsListView = findViewById(R.id.sms_list_view);
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