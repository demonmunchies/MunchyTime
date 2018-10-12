// FYG

package com.example.demon_munchies.munchytime;

import android.app.Fragment;
import android.app.VoiceInteractor;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Timer;

public class FragmentTime extends Fragment
{

    ClockView clockView;

    Button secP;
    Button secM;
    Button minP;
    Button minM;
    Button hourP;
    Button hourM;
    Button dayP;
    Button dayM;
    Button monthP;
    Button monthM;
    Button yearP;
    Button yearM;

    Button redo;
    Button undo;

    Timer timer;
    Handler handler;
    Runnable runnable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.time_fragment, container, false);

        clockView = ((MainActivity)getActivity()).clockView;

        secP = (Button) view.findViewById(R.id.secondP);
        secP.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TimeCommand tc = new TimeCommand(1, "SECONDS", clockView.getController());
                tc.doIt();
                CommandStacks.getInstance().undo.push(tc);
            }
        });
        secM = (Button) view.findViewById(R.id.secondM);
        secM.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TimeCommand tc = new TimeCommand(-1, "SECONDS", clockView.getController());
                tc.doIt();
                CommandStacks.getInstance().undo.push(tc);
            }
        });
        minP = (Button) view.findViewById(R.id.minuteP);
        minP.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
            TimeCommand tc = new TimeCommand(1, "MINUTES", clockView.getController());
            tc.doIt();
            CommandStacks.getInstance().undo.push(tc);
            }
        });
        minM = (Button) view.findViewById(R.id.minuteM);
        minM.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TimeCommand tc = new TimeCommand(-1, "MINUTES", clockView.getController());
                tc.doIt();
                CommandStacks.getInstance().undo.push(tc);
            }
        });
        hourP = (Button) view.findViewById(R.id.hourP);
        hourP.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TimeCommand tc = new TimeCommand(1, "HOURS", clockView.getController());
                tc.doIt();
                CommandStacks.getInstance().undo.push(tc);
            }
        });
        hourM = (Button) view.findViewById(R.id.hourM);
        hourM.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TimeCommand tc = new TimeCommand(-1, "HOURS", clockView.getController());
                tc.doIt();
                CommandStacks.getInstance().undo.push(tc);
            }
        });
        dayP = (Button) view.findViewById(R.id.dayP);
        dayP.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TimeCommand tc = new TimeCommand(1, "DAYS", clockView.getController());
                tc.doIt();
                CommandStacks.getInstance().undo.push(tc);
            }
        });
        dayM = (Button) view.findViewById(R.id.dayM);
        dayM.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TimeCommand tc = new TimeCommand(-1, "DAYS", clockView.getController());
                tc.doIt();
                CommandStacks.getInstance().undo.push(tc);
            }
        });
        monthP = (Button) view.findViewById(R.id.monthP);
        monthP.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TimeCommand tc = new TimeCommand(1, "MONTHS", clockView.getController());
                tc.doIt();
                CommandStacks.getInstance().undo.push(tc);
            }
        });
        monthM = (Button) view.findViewById(R.id.monthM);
        monthM.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TimeCommand tc = new TimeCommand(-1, "MONTHS", clockView.getController());
                tc.doIt();
                CommandStacks.getInstance().undo.push(tc);
            }
        });
        yearP = (Button) view.findViewById(R.id.yearP);
        yearP.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TimeCommand tc = new TimeCommand(1, "YEARS", clockView.getController());
                tc.doIt();
                CommandStacks.getInstance().undo.push(tc);
            }
        });
        yearM = (Button) view.findViewById(R.id.yearM);
        yearM.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TimeCommand tc = new TimeCommand(-1, "YEASR", clockView.getController());
                tc.doIt();
                CommandStacks.getInstance().undo.push(tc);
            }
        });

        redo = (Button) view.findViewById(R.id.redo);
        redo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    TimeCommand tc = CommandStacks.getInstance().redo.pop();
                    tc.doIt();
                    CommandStacks.getInstance().undo.push(tc);
                }
                catch(Exception e)
                {

                }

            }
        });
        undo = (Button) view.findViewById(R.id.undo);
        undo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
                {
                    try
                    {
                        TimeCommand tc = CommandStacks.getInstance().undo.pop();
                        tc.undoIt();;
                        CommandStacks.getInstance().redo.push(tc);
                    }
                    catch(Exception e)
                    {

                    }
            }
        });

        return view;
    }
}
