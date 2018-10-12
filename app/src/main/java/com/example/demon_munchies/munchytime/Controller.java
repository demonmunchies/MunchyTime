// FYG

package com.example.demon_munchies.munchytime;

import java.util.ArrayList;

public class Controller
{
    private TimeModel tm;
    private ClockView view;

    public Controller(TimeModel tm)
    {
        this.tm = tm;
    }

    public void setView(ClockView view)
    {
        this.view = view;
    }

    public void updateView()
    {
        this.view.setSecond(this.tm.getSeconds());
        this.view.setMinute(this.tm.getMinutes());
        this.view.setHour(this.tm.getHours());
        this.view.setDay(this.tm.getDays());
        this.view.setMonth(this.tm.getMonths());
        this.view.setYear(this.tm.getYears());
    }

    public void updateClock()
    {
        this.tm.selfUpdate();
    }

    public void changeSecond(int s)
    {
        this.tm.setSeconds(this.tm.getSeconds() + s);
        this.tm.checkEdges();
    }

    public void changeMinute(int m)
    {
        this.tm.setMinutes(this.tm.getMinutes() + m);
        this.tm.checkEdges();
    }

    public void changeHour(int h)
    {
        this.tm.setHours(this.tm.getHours() + h);
        this.tm.checkEdges();
    }

    public void changeDay(int d)
    {
        this.tm.setDays(this.tm.getDays() + d);
        this.tm.checkEdges();
    }

    public void changeMonth(int m)
    {
        this.tm.setMonths(this.tm.getMonths() + m);
        this.tm.checkEdges();
    }

    public void changeYear(int y)
    {
        System.out.println(this.tm.getYears());
        this.tm.setYears(this.tm.getYears() + y);
        System.out.println(this.tm.getYears());
    }

    public TimeModel getTm()
    {
        return this.tm;
    }

}
