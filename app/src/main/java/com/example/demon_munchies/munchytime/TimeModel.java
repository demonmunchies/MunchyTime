// FYG

package com.example.demon_munchies.munchytime;

import java.util.Calendar;

public class TimeModel
{
    private int seconds;
    private int minutes;
    private int hours;
    private int days;
    private int months;
    private int years;

    public TimeModel()
    {
        this.seconds = Calendar.getInstance().get(Calendar.SECOND);
        this.minutes = Calendar.getInstance().get(Calendar.MINUTE);
        this.hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        this.days = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        this.months = Calendar.getInstance().get(Calendar.MONTH);
        this.years = Calendar.getInstance().get(Calendar.YEAR);
    }

    public void selfUpdate()
    {
        seconds++;
        checkEdges();
    }

    public void checkEdges()
    {
        if(this.seconds > 59)
        {
            this.seconds = 0;
            this.minutes++;
        }
        if(this.minutes > 59)
        {
            this.minutes = 0;
            this.hours++;
        }
        if(this.hours > 23)
        {
            this.hours = 0;
            this.days++;
        }
        if(this.days > 30)
        {
            this.days = 1;
            this.months++;
        }
        if(this.months > 12)
        {
            this.months = 1;
            this.years++;
        }
    }

    @Override
    public String toString()
    {
        return this.seconds + " " + this.minutes + " " + this.hours + " " + this.days + " " + this.months + " " + this.years;
    }

    public int getSeconds()
    {
        return seconds;
    }

    public void setSeconds(int seconds)
    {
        this.seconds = seconds;
    }

    public int getMinutes()
    {
        return minutes;
    }

    public void setMinutes(int minutes)
    {
        this.minutes = minutes;
    }

    public int getHours()
    {
        return hours;
    }

    public void setHours(int hours)
    {
        this.hours = hours;
    }

    public int getDays()
    {
        return days;
    }

    public void setDays(int days)
    {
        this.days = days;
    }

    public int getMonths()
    {
        return months;
    }

    public void setMonths(int months)
    {
        this.months = months;
    }

    public int getYears()
    {
        return years;
    }

    public void setYears(int years)
    {
        this.years = years;
    }
}
