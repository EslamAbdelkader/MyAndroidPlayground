package com.example.eslam.myplayground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxActivity extends AppCompatActivity {

    private Button showDateButton;
    private TextView dateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

        showDateButton = (Button) findViewById(R.id.showDateButton);
        dateTextView = (TextView) findViewById(R.id.dateTextView);

        showDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCounting(dateTextView);
            }
        });
    }

    private void startCounting(final TextView textView){
        Observable<String> observable = Observable.unsafeCreate(new ObservableSource<String>() {
            Calendar calendar = Calendar.getInstance();
            Date currentTime = calendar.getTime();

            @Override
            public void subscribe(final Observer<? super String> observer) {
                final Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        currentTime = Calendar.getInstance().getTime();
                        String formattedTime = String.format("%02d:%02d:%02d", currentTime.getHours(), currentTime.getMinutes(), currentTime.getSeconds());
                        observer.onNext(formattedTime);
                    }
                }, currentTime, 1000);
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {
                return String.format("%s Test",s);
            }
        });

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String string) {
                textView.setText(string);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
