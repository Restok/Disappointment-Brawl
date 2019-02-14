package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player2 extends Player {

    private boolean jumpAgain = false;


    public Player2(float x, float y, int width, int height, Color color, BufferedImage normalState, BufferedImage action, String type, int health, int damage, int movementSpeed) {
        super(x, y, width, height, color, normalState, action, type, health, damage, movementSpeed);
    }

    @Override
    public void control() {
        if(Input.leftPressed)
            this.setSpeedX(-movementSpeed);
        if(Input.upPressed){
            if(this.getSpeedY()==0 && boundaries())
                jump();
        }
        if(Input.rightPressed)
            this.setSpeedX(movementSpeed);
        if((!Input.leftPressed && Input.leftReleased) && ((!Input.rightPressed)&& Input.rightReleased))
            this.setSpeedX(0);
        if(Input.commaPressed && canAttackAgain)
            disappoint(enemy.get(0));
            canAttackAgain = false;
        if(!Input.commaPressed && Input.jReleased)
            canAttackAgain = true;
    }


}

