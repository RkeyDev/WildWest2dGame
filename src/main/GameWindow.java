package main;

import javax.swing.JFrame;
import java.awt.Dimension;
public class GameWindow extends JFrame{
    Dimension dimension = new Dimension(500, 500); //creating a 500X500 dimension object
    public GameWindow(){

       //setting up the window
       setSize(dimension); 
       setResizable(false);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

       //setting the window to be visible
       setVisible(true); 
    }
}
