// FYG

package com.example.demon_munchies.munchytime;

import java.util.Stack;

public class CommandStacks
{
    private  static CommandStacks instance = null;

    public Stack<TimeCommand> undo;
    public Stack<TimeCommand> redo;

    private CommandStacks()
    {
        undo = new Stack<TimeCommand>();
        redo = new Stack<TimeCommand>();
    }

    public static CommandStacks getInstance()
    {
        if(instance == null)
        {
            instance = new CommandStacks();
        }
        return instance;
    }
}
