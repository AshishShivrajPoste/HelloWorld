package com.ashish.edu.timertask;

import java.util.Timer;
import java.util.TimerTask;

public class Alarm {
    Timer timer;

    public Alarm(int seconds) {
        timer = new Timer();  //At this line a new Thread will be created
        timer.schedule(new RemindTask(), seconds*1000); //delay in milliseconds
    }

    class RemindTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("ReminderTask is completed by Java timer");
            timer.cancel(); //Not necessary because we call System.exit
            //System.exit(0); //Stops the AWT thread (and everything else)
        }
    }

    public static void main(String args[]) {
        System.out.println("Java timer is about to start");
        Alarm reminderBeep = new Alarm(10);
        System.out.println("Remindertask is scheduled with Java timer.");
    }
}
