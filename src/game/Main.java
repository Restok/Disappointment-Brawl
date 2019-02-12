package game;

import java.awt.*;
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

        component player1 = new Player(0, g.HEIGHT*2/3-150, 100, 150, Color.RED, null, null, null, 100,1,3);
        component player2 = new Player2(Game.WIDTH-100, g.HEIGHT*2/3-150, 100, 150, Color.BLUE, null, null, null, 100,1,3);
//        ((Player) player1).ground = groundOne;
        ((Player) player1).ground.add(groundOne);
        ((Player2) player2).ground.add(groundOne);

        allGameObjects.add(groundOne);
        allGameObjects.add(grassOne);
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
