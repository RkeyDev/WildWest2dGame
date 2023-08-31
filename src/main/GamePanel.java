package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entities.Player;


public class GamePanel extends JPanel {
    private final float WIDTH=500,HEIGHT=500; //width and height of the window
    public static final float SCALE =1.0f; //the scale of the game

    private Dimension dimension = new Dimension((int)(WIDTH*SCALE),(int)(HEIGHT*SCALE)); //creating a 500X500 dimension object
    
    Player player;
    Game game;
    public GamePanel(){
        player = new Player();
        this.setPreferredSize(dimension);
    }

    
    public void OnFocousLoss(){
        player.setUp(false);
        player.setLeft(false);
        player.setDown(false);
        player.setRight(false);
    }

    //the paint component
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        player.drawPlayer(g); //drawing the player
        
    }
}
