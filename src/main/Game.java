package main;

public class Game implements Runnable{
    GameWindow window;
    GamePanel gamePanel;
    //Define FPS and UPS variables
    private final int FPS_SET = 120;
    private Thread gameThread;
    private final int UPS_SET = 200;

    //initializing the game 
    public Game(){
        gamePanel = new GamePanel();
        window = new GameWindow(gamePanel);
        startingGameThread();
    }
    //update the game 
    public void updateGame(){
        gamePanel.repaint();
    }
    //starting the game thread
    public void startingGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    //the game loop
    @Override
    public void run() {
        //Define the time interval per frame and per update in nanoseconds
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        //Keep track of the previous time in nanoseconds
        long previouseTime = System.nanoTime(); 

        //Initialize counters for frames and updates
        int frames = 0;
        int updates = 0;

        //Keep track of the last time FPS and UPS were checked
        long lastCheck = System.currentTimeMillis(); 

        //Accumulated time for updates and frames
        double deltaU = 0;
        //double deltaF = 0;

        //Main game loop
        while(true){
            //Get the current time in nanoseconds
            long currentTime = System.nanoTime();
            //Calculate the time elapsed since the previous iteration
            deltaU += (currentTime - previouseTime)/timePerUpdate;
            //deltaF += (currentTime - previouseTime)/timePerFrame;

            //Update game logic if the time for an update has come
            previouseTime = currentTime;
            if(deltaU >= 1){
                updateGame();
                updates++;
                deltaU--;
            }

            /* 
            if(deltaF >=1){
                deltaF--;
                frames ++;
            }
            */

            //check and display FPS and UPS every second
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS "+ updates);
                frames = 0;
                updates = 0;
            }
        }
    }
}
