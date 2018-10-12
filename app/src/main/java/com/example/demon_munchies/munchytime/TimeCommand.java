// FYG

package com.example.demon_munchies.munchytime;

public class TimeCommand implements Command
{

    private int payload;
    String type;
    private Controller controller;

    public TimeCommand(int payload, String type, Controller controller)
    {
        this.payload = payload;
        this.type = type;
        this.controller = controller;
        System.out.println("Command made!");
    }

    @Override
    public void doIt()
    {
        if(this.type.equals("SECONDS"))
        {
            controller.changeSecond(this.payload);
        }
        else if(this.type.equals("MINUTES"))
        {
            controller.changeMinute(this.payload);
        }
        else if(this.type.equals("HOURS"))
        {
            controller.changeHour(this.payload);
        }
        else if(this.type.equals("DAYS"))
        {
            controller.changeDay(this.payload);
        }
        else if(this.type.equals("MONTHS"))
        {
            controller.changeMonth(this.payload);
        }
        else if(this.type.equals("YEARS"))
        {
            controller.changeYear(this.payload);
        }
        else
        {
            // Empty Else
        }
    }

    @Override
    public void undoIt()
    {
        if(this.type.equals("SECONDS"))
        {
            controller.changeSecond(this.payload*-1);
        }
        else if(this.type.equals("MINUTES"))
        {
            controller.changeMinute(this.payload*-1);
        }
        else if(this.type.equals("HOURS"))
        {
            controller.changeHour(this.payload*-1);
        }
        else if(this.type.equals("DAYS"))
        {
            controller.changeDay(this.payload*-1);
        }
        else if(this.type.equals("MONTHS"))
        {
            controller.changeMonth(this.payload*-1);
        }
        else if(this.type.equals("YEARS"))
        {
            controller.changeYear(this.payload*1);
        }
        else
        {
            // Empty Else
        }
    }
}
