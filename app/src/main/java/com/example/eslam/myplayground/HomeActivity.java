package com.example.eslam.myplayground;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity {
    private final String HANDLER_TAG = "HANDLER-TAG";
    private final String RX_TAG = "RX-TAG";
    private final int REQUEST_CODE_ENABLE_ADMIN = 100;
    Queue<Observer> observers;
    Handler handler1;
    Handler handler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setAllowEnterTransitionOverlap(false);
        getWindow().setAllowReturnTransitionOverlap(false);
        getWindow().setExitTransition(new Slide(Gravity.RIGHT));
        setContentView(R.layout.activity_home);
//        testStringDef();
//        testRX();
//        testHandlers();

        findViewById(R.id.animationActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, AnimationActivity.class));
            }
        });

        findViewById(R.id.circleImageActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CircleImageActivity.class));
            }
        });

        findViewById(R.id.fragmentsActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, FragmentsActivity.class));
            }
        });

        findViewById(R.id.scrollToolbarActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ScrollToolbarActivity.class));
            }
        });

        findViewById(R.id.spinnerActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, SpinnerActivity.class),
                        ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this).toBundle());
            }
        });

        findViewById(R.id.mySharedImageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SharedElementActivity.class);
                String transitionName = getString(R.string.transition_shared_element_0);
                View mySharedImageView = findViewById(R.id.mySharedImageView);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(HomeActivity.this,
                                mySharedImageView,
                                transitionName);
                startActivity(intent, options.toBundle());
            }
        });

        findViewById(R.id.tabActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MyTabActivity.class));
            }
        });

        findViewById(R.id.clockActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ClockActivity.class));
            }
        });

        findViewById(R.id.rxActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, RxActivity.class));
            }
        });

        findViewById(R.id.gifActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, GifActivity.class));
            }
        });

        findViewById(R.id.factoryResetButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                factoryReset();
            }
        });

        findViewById(R.id.launchModeActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LaunchModeActivity.class));
            }
        });

        findViewById(R.id.contentButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ContentUtils.printContent();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    private void factoryReset() {
        /*DevicePolicyManager devicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName deviceAdmin = new ComponentName(this, WipeDataReceiver.class);
        if (!devicePolicyManager.isAdminActive(deviceAdmin)) {
            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, deviceAdmin);
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "Process will remove user installed applications, settings, wallpaper and sound settings. Are you sure you want to wipe device?");
            startActivityForResult(intent, REQUEST_CODE_ENABLE_ADMIN);
        } else {
            devicePolicyManager.wipeData(0);
        }*/
    }

    private void testHandlers() {

        handler1 = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.i(HANDLER_TAG, "Handler 1 receiving message with arg " + msg.arg1);
            }
        };
        handler2 = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.i(HANDLER_TAG, "Handler 2 receiving message with arg " + msg.arg1);
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                handler1.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i(HANDLER_TAG, "Runnable to handler1");
                    }
                });
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                handler2.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i(HANDLER_TAG, "Runnable to handler2");
                    }
                });
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = Message.obtain();
                message.arg1 = 1;
                handler1.sendMessage(message);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                Message message = Message.obtain();
                message.arg1 = 2;
                handler2.sendMessage(message);
            }
        }).start();

    }

    private void testRX() {
        observers = new ConcurrentLinkedQueue<>();
        DisposableObserver myObserver = new DisposableObserver() {
            @Override
            public void onNext(Object o) {
                Log.i(RX_TAG, "in Next: " + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        Observable observable = Observable.unsafeCreate(new ObservableSource() {
            @Override
            public void subscribe(@NonNull Observer observer) {
                Log.i("RX-TAG", "in subscribe: " + Thread.currentThread().getName());
                for (Observer observer1 : observers) {
                    observers.add(observer);
                    observer1.onNext(new Object());
                    observer1.onComplete();
                }
            }
        });
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myObserver);

    }

    private void testStringDef() {
//        MyClass myClass = new MyClass("asdf");     // Gives a compilation error
//        MyClass myClass = new MyClass("eslam");     // Gives a compilation error
        MyClass myClass = new MyClass(Name.ESLAM);
        myClass.setName(Name.AHMED);
        String name = myClass.getName();
        Log.i(getClass().getSimpleName(), name);
    }
}
