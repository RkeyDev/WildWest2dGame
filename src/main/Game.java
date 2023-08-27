package main;

public class Game implements Runnable{
    GameWindow window;
    GamePanel gamePanel;
    private final int FPS_SET = 120;
    private Thread gameThread;
    private final int UPS_SET = 200;
    //initializing the game
    public Game(){
        gamePanel = new GamePanel();
        window = new GameWindow(gamePanel);
        initilizeGameThread();
    }
    public void updateGame(){
        gamePanel.repaint();
    }
    public void initilizeGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previouseTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while(true){
            long currentTime = System.nanoTime();
            deltaU += (currentTime - previouseTime)/timePerUpdate;
            deltaF += (currentTime - previouseTime)/timePerFrame;
            previouseTime = currentTime;
            if(deltaU >= 1){
                updateGame();
                updates++;
                deltaU--;
            }
            if(deltaF >=1){
                deltaF--;
                frames ++;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS "+ updates);
                frames = 0;
                updates = 0;
            }
        }
    }
}
