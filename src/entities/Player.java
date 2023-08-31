package entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import main.GamePanel;

public class Player extends Entity{
    //player movement
    public static int animationTick = 0;
    public static int animationIndex = 0;

    private float playerSpeed = 2.0f;
    private boolean left,right,up,down;
    private boolean movingLeft = false,movingUp = false,movingRight = false,movingDown = false;
    private String frontIdle = "player-front-idle.png";
    private String backIdle = "player-back-idle.png";
    private String[] frontWalk = {"player-front-1.png","player-front-2.png"};
    private String[] backWalk = {"player-back-1.png","player-back-2.png"};
    private String[] rightWalk = {"player-right-1.png","player-right-2.png"};
    private String[] leftWalk = {"player-left-1.png","player-left-2.png"};
    private String currentAnimation = frontIdle;


    private Image playerImage;

    public Player(){
        super(0, 0, 200, 200);
        
        System.out.println(playerImage);
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

    public void drawPlayer(Graphics g){
       //animation direction
        movingLeft = false;
        movingRight = false;
        movingUp = false;
        movingDown = false;
        
        //moving the character
        if(left){
            x-=playerSpeed; //move left
            currentAnimation = leftWalk[0]; //set left idle animation
            movingLeft = true;//left walk animation
            
        }else if(right){
            x+=playerSpeed;//move right 
            currentAnimation = rightWalk[0];//set right idle animation
            movingRight = true; //right walk animation
        }
        if(up){
            y-=playerSpeed;// move up
            currentAnimation = backIdle;//set back idle animation
            movingUp = true;//back walk animation
        }else if(down){
            y+=playerSpeed;//move down
            currentAnimation = frontIdle;//set front idle animation
            movingDown = true;//front walk animation

        }
        animationTick++;
        if(animationTick >20*2){
            if(animationIndex !=1){
                animationIndex = 1;
            }else{
                animationIndex = 0;
            }
            animationTick = 0;
        }
        //System.out.println(movingLeft + " " +movingUp +" " +movingRight +" " +movingDown);
        if(movingLeft){
                playerImage = new ImageIcon("src/res/" + leftWalk[animationIndex]).getImage();//left walk animation 
        }else if(movingUp){
                playerImage = new ImageIcon("src/res/" + backWalk[animationIndex]).getImage(); //back walk animation

        }else if(movingRight){
            playerImage = new ImageIcon("src/res/" + rightWalk[animationIndex]).getImage(); //right walk animation

        }else if(movingDown){
                playerImage = new ImageIcon("src/res/" + frontWalk[animationIndex]).getImage(); //front walk animation

        }
        else{
                playerImage = new ImageIcon("src/res/" + currentAnimation).getImage();//idle animation
        }

        g.drawImage(playerImage, x, y, (int)(width*GamePanel.SCALE), (int)(height*GamePanel.SCALE),null); //draw the character
    }
}
