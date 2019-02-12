package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class component implements Updatable, Renderable {
    private float x;
    private float y;
    private int width;
    private int height;
    private Color color;
    private BufferedImage normalState;
    private BufferedImage action;
    private String type;
    private float speedX = 0;
    private float speedY = 0;

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }


    public component(float x, float y, int width, int height, Color color, BufferedImage normalState, BufferedImage action, String type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.normalState = normalState;
        this.action = action;
        this.type = type;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BufferedImage getNormalState() {
        return normalState;
    }

    public void setNormalState(BufferedImage normalState) {
        this.normalState = normalState;
    }

    public BufferedImage getAction() {
        return action;
    }

    public void setAction(BufferedImage action) {
        this.action = action;
    }


    @Override
    public void render(Graphics2D g, float interpolation) {
        g.setColor(this.color);

        if(type == "image")
            g.drawImage(normalState, (int)this.x, (int)this.y, null);
        else
            g.fillRect((int)this.x, (int)this.y, this.width, this.height);

    }

    @Override
    public void update(Input input) {
        this.x += speedX;
        this.y += speedY;

    }

    public boolean crashWith(component otherobj){
        float myleft = this.x;
        float myright = this.x + (this.width);
        float mytop = this.y;
        float mybottom = this.y + (this.height);
        float otherleft = otherobj.getX();
        float otherright = otherobj.x + (otherobj.width);
        float othertop = otherobj.y;
        float otherbottom = otherobj.y + (otherobj.height);
        boolean crash = true;
        if ((mybottom < othertop) ||
                (mytop > otherbottom) ||
                (myright < otherleft) ||
                (myleft > otherright)) {
            crash = false;
        }
        return crash;
    }
}
