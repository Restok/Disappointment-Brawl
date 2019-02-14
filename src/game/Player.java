package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends component {
    private int damage;
    public int health;
    public int movementSpeed;
    private float gravity = 0f;
    public ArrayList<component> ground = new ArrayList<>();
    public ArrayList<Player> enemy = new ArrayList<>();
    public ArrayList<hotLaser> lasers = new ArrayList<>();
    public int lasersLimit = 2;
    public int increment = 0;
    public boolean canAttackAgain = true;

    public boolean isFalling() {
        return falling;
    }


    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    private boolean falling;

    public Player() {
    }

    public Player(float x, float y, int width, int height, Color color, BufferedImage normalState, BufferedImage action, String type, int health, int damage, int movementSpeed) {
        super(x, y, width, height, color, normalState, action, type);
        this.damage = damage;
        this.health = health;
        this.movementSpeed = movementSpeed;
    }



    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public void control(){

        if(Input.APressed)
            this.setSpeedX(-movementSpeed);
        if(Input.WPressed){
            if(this.getSpeedY()==0 && boundaries())
                jump();
        }
        if(Input.DPressed)
            this.setSpeedX(movementSpeed);
        if((!Input.APressed && Input.AReleased) && ((!Input.DPressed)&& Input.DReleased))
            this.setSpeedX(0);
        if(Input.jPressed &&canAttackAgain)
            disappoint(enemy.get(0));
        if(!Input.jPressed&&Input.jReleased)
            canAttackAgain = true;
    }

    public void jump(){
        this.setSpeedY(-8);

    }
    public boolean boundaries(){
        boolean canJump = false;
        if(this.getX() < 0)
            setX(0);
        else if(this.getX()>Game.WIDTH-this.getWidth())
            setX(Game.WIDTH-this.getWidth());

        for(component g : ground){
            if(g.crashWith(this)) {
                setSpeedY(0);
                gravity = 0f;
                canJump = true;
            }
            else
                gravity = 0.25f;
        }
        return canJump;
    }

    @Override
    public void update(Input input) {
        super.update(input);
        boundaries();
        control();

        this.setSpeedY((this.getSpeedY() + this.gravity));
        this.setY(this.getY()+this.getSpeedY());
        this.setX(this.getX()+this.getSpeedX());
    }
    public void disappoint(Player otherplayer){
        canAttackAgain = false;

        hotLaser laser= lasers.get(increment%lasersLimit);
        System.out.println(increment%lasersLimit);

        increment +=1;

        laser.setX(this.getX());
        laser.setY(this.getY()+50);
        if(otherplayer.getX()<this.getX()){
            laser.setSpeedX(-10);

        }
        else{
            laser.setSpeedX(10);
        }

    }

}
