// FYG

package com.example.demon_munchies.munchytime;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FragmentAnalog fragmentAnalog;
    FragmentDigital fragmentDigital;
    FragmentTime fragmentTime;

    Timer timer;
    Handler handler;
    Runnable runnable;

    Controller controller;
    ClockView clockView;

    boolean isTicking;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        controller = new Controller(new TimeModel());
        clockView = new ClockView(controller);
        controller.setView(clockView);

        CommandStacks.getInstance();

        handler = new Handler();
        runnable = new Runnable()
        {
            @Override
            public void run()
            {
                if(isTicking)
                {
                    System.out.println("Tick Tock goes the Clock");
                    controller.updateClock();
                    controller.updateView();
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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.analog:
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentAnalog = new FragmentAnalog();
                fragmentTransaction.replace(android.R.id.content, fragmentAnalog);
                fragmentTransaction.commit();
                isTicking = true;
                return true;
            case R.id.digital:
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentDigital = new FragmentDigital();
                fragmentTransaction.replace(android.R.id.content, fragmentDigital);
                fragmentTransaction.commit();
                isTicking = true;
                return true;
            case R.id.time:
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTime = new FragmentTime();
                fragmentTransaction.replace(android.R.id.content, fragmentTime);
                fragmentTransaction.commit();
                isTicking = false;
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
