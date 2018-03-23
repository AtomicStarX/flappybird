package Clases;

import Interfaz.Game;

public class FlappyMovement extends Thread {

    private int deltaTime;
    private boolean jump;
    private boolean stopJump = false;
    private boolean jumping = false;
    private final Game parent;
    public static boolean stopThread;
    private double timeIni ;
    private int yInit = 0;
    private static final int v0= -30;
    private static final int ACCELERATION = 9;
    private static final int TIME_FLAPPING = 5;

    public FlappyMovement(Game parent) {
        this.deltaTime = 10;
        this.parent = parent;
    }

    @Override
    public void run() {
        int varA = 1;
        stopThread = false;
        int x = Game.jFlappy.getLocation().x;
        yInit = Game.jFlappy.getLocation().y;
        timeIni = System.currentTimeMillis();
        while (true) {
            if (stopThread) {
                break;
            }
             if(jump){
                jump = false;
                jump();
            }   
            double time =(double) ((System.currentTimeMillis() - timeIni)/100f);
            int y = (int) (yInit + v0 + (0.5) * ACCELERATION * time * time);
            Game.jFlappy.setLocation(x, y);
            parent.validarChoqueTubos();
            parent.detectColision();
            
                  
        }
    }

    private void jump() {
       timeIni = System.currentTimeMillis();
       yInit = Game.jFlappy.getLocation().y;
       
    }
    public boolean isStopJump() {
        return stopJump;
    }

    public void setStopJump(boolean stopJump) {
        this.stopJump = stopJump;
    }

    public boolean isJump() {
        return jump;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public int getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(int deltaTime) {
        this.deltaTime = deltaTime;
    }

    public boolean isStopThread() {
        return stopThread;
    }

}
