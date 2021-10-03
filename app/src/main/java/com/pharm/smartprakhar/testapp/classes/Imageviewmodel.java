package com.pharm.smartprakhar.testapp.classes;

import android.app.Application;
import android.content.Intent;
import android.os.CountDownTimer;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pharm.smartprakhar.testapp.MainActivity;
import com.pharm.smartprakhar.testapp.Model.Banner;

import java.util.ArrayList;
import java.util.List;

public class Imageviewmodel extends ViewModel {
   Repository repo;



    public LiveData<Banner> getBannerlist() {

        return bannerlist;
    }
    public void Bannerloader()
    {
        if(bannerlist==null)
        {
            bannerlist=new MutableLiveData<>();
            repo=Repository.getRepository();
        bannerlist=    repo.Bannerextractor(this);

        }



    }




    public MutableLiveData<Banner> bannerlist;
    private CountDownTimer countDownTimer;
    long timetick=50000;

    public void startTimer() {
        view.startMusicPlayer();
        countDownTimer = new CountDownTimer(timetick, 1000) {

            public void onTick(long millisUntilFinished) {
                timetick=millisUntilFinished;
                int seconds = (int) (millisUntilFinished / 1000);

                int res = (int) (((float) seconds / 5000) * 100);

                if(seconds<=99){
                    view.onTimerChanged(res,String.format("%02d", seconds));
                }else {
                    view.onTimerChanged(res,String.format("%03d", seconds));
                }
            }
            public void onFinish() {
                view.onTimerChanged(0,"00");
                cancelCoutDownTimer();
            }
        }.start();
    }
    MainActivity view;
    private void cancelCoutDownTimer(){
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
        view.onFinish();
    }
    public void stopTimer(){
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void setView(MainActivity view) {
        this.view=view;
    }
}
