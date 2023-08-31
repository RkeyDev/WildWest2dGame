package entities;

public abstract class Entity {

    //entity position and size variables
    protected int x,y; 
    protected int width,height;

    //entity constructor
    public Entity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }   
}
