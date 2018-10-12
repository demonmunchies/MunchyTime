// FYG

package com.example.demon_munchies.munchytime;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class FragmentAnalog extends Fragment
{

    ProgressBar seconds;
    ProgressBar minutes;
    ProgressBar hours;
    ProgressBar days;
    ProgressBar months;

    ClockView clockView;

    Timer timer;
    Handler handler;
    Runnable runnable;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.analog_fragment, container, false);

        seconds = (ProgressBar) view.findViewById(R.id.seconds);
        minutes = (ProgressBar) view.findViewById(R.id.minutes);
        hours = (ProgressBar) view.findViewById(R.id.hours);
        days = (ProgressBar) view.findViewById(R.id.days);
        months = (ProgressBar) view.findViewById(R.id.months);

        clockView = ((MainActivity)getActivity()).clockView;

        handler = new Handler();
        runnable = new Runnable()
        {
            @Override
            public void run()
            {
                if(true)
                {
                    seconds.setProgress(clockView.getSecond());
                    minutes.setProgress(clockView.getMinute());
                    hours.setProgress(clockView.getHour());
                    days.setProgress(clockView.getDay());
                    months.setProgress(clockView.getMonth());
                }
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                handler.post(runnable);
            }
        }, 1000, 1000);

        return view;
    }
}
