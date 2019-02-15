package game;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Game g = new Game();

        ArrayList<component> allGameObjects = new ArrayList<>();

        Color dirt = new Color(163, 99, 60);
        Color grass = new Color(64, 183, 64);
        // Initialize game objects
        component groundOne = new component(0, g.HEIGHT*2/3, g.WIDTH, 30, dirt, null, null, null);
        component grassOne = new component(0, g.HEIGHT*2/3-10, g.WIDTH, 10, grass, null, null, null);
        component background = new component(0,0,0,0,null, null, null, "image");
        component groundTwo = new component(40, g.HEIGHT*1/3, 100, 30, dirt, null, null, null);

        try {
            background.setNormalState(Sprite.getSprite("BG.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        allGameObjects.add(background);
        Player player1 = new Player(0, g.HEIGHT*2/3-55, 50, 55, Color.RED, null, null, "image", 100,1,3);
        Player player2 = new Player2(Game.WIDTH-100, g.HEIGHT*2/3-55, 50, 55, Color.BLUE, null, null, "image", 100,1,3);
        try {
            player1.setNormalState(Sprite.getSprite("Will.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            player2.setNormalState(Sprite.getSprite("Adam_Left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        ((Player) player1).ground = groundOne;
        for(int z =0; z<=player1.lasersLimit; z++) {
            hotLaser laser = new hotLaser(-20, player1.getY()+25, 20, 5, Color.red, null, null, null);
            allGameObjects.add(laser);
            player1.lasers.add(laser);
            hotLaser laser2 = new hotLaser(-20, player2.getY()+25, 20, 5, Color.BLUE, null, null, null);
            player2.lasers.add(laser2);
            allGameObjects.add(laser2);
        }

        player1.ground.add(groundOne);
        player2.ground.add(groundOne);
        player1.ground.add(groundTwo);
        player2.ground.add(groundTwo);
        player1.enemy.add(player2);
        player2.enemy.add(player1);

        allGameObjects.add(groundOne);
        allGameObjects.add(grassOne);
        allGameObjects.add(groundTwo);
        allGameObjects.add(player1);
        allGameObjects.add(player2);

        // Add updatables and renderables
        for(component x : allGameObjects) {
            g.addRenderable(x);
            g.addUpdatable(x);
        }

        // Start

        g.Start();
    }

}
