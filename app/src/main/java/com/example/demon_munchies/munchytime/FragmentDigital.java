// FYG

package com.example.demon_munchies.munchytime;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class FragmentDigital extends Fragment
{

    TextView seconds;
    TextView minutes;
    TextView hours;
    TextView days;
    TextView months;
    TextView years;

    ClockView clockView;

    Timer timer;
    Handler handler;
    Runnable runnable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.digital_fragment, container, false);

        clockView = ((MainActivity)getActivity()).clockView;

        seconds = (TextView) view.findViewById(R.id.digitalSecond);
        minutes = (TextView) view.findViewById(R.id.digitalMinutes);
        hours = (TextView) view.findViewById(R.id.digitalHours);
        days = (TextView) view.findViewById(R.id.digitalDays);
        months = (TextView) view.findViewById(R.id.digitalMonths);
        years = (TextView) view.findViewById(R.id.digitalYears);

        handler = new Handler();
        runnable = new Runnable()
        {
            @Override
            public void run()
            {
                if(true)
                {
                    seconds.setText("Seconds: " + clockView.getSecond());
                    minutes.setText("Minutes: " + clockView.getMinute());
                    hours.setText("Hours: " + clockView.getHour());
                    days.setText("Days: " + clockView.getDay());
                    months.setText("Months: " + clockView.getMonth());
                    years.setText("Years: " + clockView.getYear());
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
