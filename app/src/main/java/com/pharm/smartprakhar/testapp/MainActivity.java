package com.pharm.smartprakhar.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.pharm.smartprakhar.testapp.Adapters.Adapter_test;
import com.pharm.smartprakhar.testapp.Common.MyApp;
import com.pharm.smartprakhar.testapp.Interfaces.Retrofittnterface;
import com.pharm.smartprakhar.testapp.Model.Banner;
import com.pharm.smartprakhar.testapp.classes.Imageviewmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static MediaPlayer mediaPlayer;
    private ProgressDialog mDialog;

    @BindView(R.id.circular_progress_bar)
    ProgressBar circular_progress_bar;
    @BindView(R.id.tv_popup_pickup)
    TextView tv_popup_pickup;
    @BindView(R.id.tvBID)
    TextView tvBID;
    @BindView(R.id.tvHeaderDistance)
    TextView tvHeaderDistance;
    @BindView(R.id.tvHeaderPayment)
    TextView tvHeaderPayment;
    @BindView(R.id.tvDistance)
    TextView tvDistance;
    @BindView(R.id.tvPayment)
    TextView tvPayment;
    @BindView(R.id.btnReject)
    Button btnReject;
    @BindView(R.id.tv_popup_drop)
    TextView tv_popup_drop;
    @BindView(R.id.tv_lefttoaccept)
    TextView tv_lefttoaccept;
    @BindView(R.id.tv_deliveryfee)
    TextView tv_deliveryfee;
    @BindView(R.id.tv_popup_cur)
    TextView tv_popup_cur;
    @BindView(R.id.tv_pickuptime)
    TextView tv_pickuptime;
    @BindView(R.id.tv_popup_droploc)
    TextView tv_popup_droploc;
    @BindView(R.id.tv_popup_pickuploc)
    TextView tv_popup_pickuploc;
    @BindView(R.id.tv_droptime)
    TextView tv_droptime;
    @BindView(R.id.tv_timer)
    TextView tv_timer;
    @BindView(R.id.tv_delivery_charge)
    TextView tv_delivery_charge;
    @BindView(R.id.tvTips) TextView tvTips;
    @BindView(R.id.ll_booking_popup)
    LinearLayout ll_booking_popup;

    @BindView(R.id.tvordertypeHandelers)
    TextView tvordertypeHandelers;
    @BindView(R.id.tvordertype)
    TextView tvordertype;
    @BindView(R.id.tv_date)
    TextView tv_date;
    @BindView(R.id.tv_OrderTime)
    TextView tv_OrderTime;
    @BindView(R.id.apiImage)
    ImageView imageView;





    Imageviewmodel imagemodel;
    private FontUtils fontUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        imagemodel= new ViewModelProvider(this).get(Imageviewmodel.class);
        imagemodel.setView(this);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
        } else {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
            window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
            window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
        ButterKnife.bind(this);
        initializeViews();



    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.clear();
    }

    /**
     * <h1>initializeViews</h1>
     * <p>Initialize the view(fonts and styles</p>
     */
    private void initializeViews() {
        Typeface ClanaproNarrNews, ClanaproNarrMedium;
        ClanaproNarrNews = Typeface.defaultFromStyle(Typeface.BOLD);
        ClanaproNarrMedium =Typeface.defaultFromStyle(Typeface.BOLD);
        tv_popup_pickup.setTypeface(ClanaproNarrNews);
        tvBID.setTypeface(ClanaproNarrNews);
        tvHeaderDistance.setTypeface(ClanaproNarrNews);
        tvHeaderPayment.setTypeface(ClanaproNarrNews);
        tvDistance.setTypeface(ClanaproNarrNews);
        tvPayment.setTypeface(ClanaproNarrNews);
        tvordertypeHandelers.setTypeface(ClanaproNarrNews);
        tvordertype.setTypeface(ClanaproNarrNews);
        btnReject.setTypeface(ClanaproNarrNews);
        tv_popup_drop.setTypeface(ClanaproNarrNews);
        tv_lefttoaccept.setTypeface(ClanaproNarrNews);
        tv_deliveryfee.setTypeface(ClanaproNarrNews);
        tv_popup_cur.setTypeface(ClanaproNarrMedium);
        tv_popup_pickuploc.setTypeface(ClanaproNarrNews);
        tv_pickuptime.setTypeface(ClanaproNarrNews);
        tv_popup_droploc.setTypeface(ClanaproNarrNews);
        tv_droptime.setTypeface(ClanaproNarrNews);
        tv_timer.setTypeface(ClanaproNarrMedium);
        tv_delivery_charge.setTypeface(ClanaproNarrMedium);
        tvTips.setTypeface(ClanaproNarrMedium);



        mDialog = new ProgressDialog(MainActivity.this);
        tv_OrderTime.setText("DATE & TIME");
        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnReject.getText().toString().equals("START"))
                {
                    btnReject.setText("STOP");
                    imagemodel.startTimer();
                }
                else
                {
                    btnReject.setText("START");
                    imagemodel.stopTimer();
                    if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }
                }



            }
        });

    }



    public void startMusicPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.ring);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }



    @Override
    protected void onPause() {
        super.onPause();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
        unregisterReceiver(mOrderUpdateReceiver);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mOrderUpdateReceiver, new IntentFilter("Timer"));
    }

    /**
     * This method is ask overlay permission on above android Q device
     * so, driver can see booking popup even app is in background or killed.
     */
    private BroadcastReceiver mOrderUpdateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };




    public void onError(String error) {

    }


    public void showProgressbar() {
        mDialog.setMessage("loading");
        mDialog.setCancelable(false);
        mDialog.show();
    }


    public void dismissProgressbar() {
        if (mDialog != null) {
            mDialog.dismiss();
            mDialog.cancel();
        }
    }


    public void onTimerChanged(int progress, String time) {
        long millis=Long.parseLong(time);
        String hms = String.format("%02d:%02d:%02d", TimeUnit.SECONDS.toHours(millis),
                TimeUnit.SECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.SECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1));
        tv_timer.setText(hms);
        circular_progress_bar.setProgress(progress);
    }


    public void onFinish() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        imageView.setVisibility(View.VISIBLE);
        imagemodel.Bannerloader();
        imagemodel.getBannerlist().observe(this, new Observer<Banner>() {
                    @Override
                    public void onChanged(Banner banner) {
                        Toast.makeText(getBaseContext(),banner.getBanner_name(),Toast.LENGTH_LONG).show();
                        Glide
                                .with(getBaseContext())
                                .load(banner.getBanner_image())
                                .into(imageView);

                    }
                });


    }

}
