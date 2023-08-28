package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class GamePanel extends JPanel {
    private Dimension dimension = new Dimension(500, 500); //creating a 500X500 dimension object

    //player movement
    private int x=0,y=0;
    private float speed = 2.0f;
    private boolean left,right,up,down;

    public GamePanel(){
        this.setPreferredSize(dimension);
    }

    
    //setters for the directions

    public void setLeft(boolean left) {
        this.left = left; 
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
        
    }

    //the paint component to draw the rectangle on the screen
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //moving the character
        if(left){
            x-=speed; //move left
        }else if(right){
            x+=speed;//move right 
        }
        if(up){
            y-=speed;// move up
        }else if(down){
            y+=speed;//move down
        }

        g.fillRect(x, y, 50, 50); //drawing a filled rectangle
        
    }
}
