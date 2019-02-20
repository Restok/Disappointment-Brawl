package game;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random fun = new Random();
//
        Scanner scanner = new Scanner(System.in);

        int lasersLimit= 0;
        int playerSpeed= 0;

        int platformNum = 0;

        System.out.println("Welcome to this severely broken but kind of playable game");
        System.out.println("As you play, look at the variables and player behavior to see if you can figure out how the code works!");
        System.out.println("Player 1 Controls: WASD to move, J to shoot");
        System.out.println("Player 2 Controls: Arrow keys to move, comma to shoot");
        System.out.println("How many platforms do you want to generate? (Recommended: 3-10)");
        System.out.print("Enter a whole number:");
        platformNum = scanner.nextInt();

        System.out.println("How many projectiles should each player be able to fire? (Recommended 1 - 3)");
        System.out.print("Enter a whole number:");
        lasersLimit = scanner.nextInt();
        System.out.println("How fast should each player be able to move? (Recommended: 3)");
        System.out.print("Enter a whole number:");
        playerSpeed = scanner.nextInt();


        int[] Xs = new int[platformNum];
        float[] Ys = new float[platformNum];
        int[] widths = new int[platformNum];
        int[] heights = new int[platformNum];
        Game g = new Game();

        ArrayList<component> allGameObjects = new ArrayList<>();


        // Initialize game







        Color dirt = new Color(163, 99, 60);
        Color grass = new Color(64, 183, 64);

        component groundOne = new component(0, g.HEIGHT*2/3, g.WIDTH, 30, dirt, null, null, null);
        component grassOne = new component(0, g.HEIGHT*2/3-10, g.WIDTH, 10, grass, null, null, null);
        component background = new component(0,0,0,0,null, null, null, "image");

        try {
            background.setNormalState(Sprite.getSprite("BG.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        allGameObjects.add(background);
        Player player1 = new Player(0, g.HEIGHT*2/3-55, 50, 55, Color.RED, null, null, "image", 40,1,playerSpeed);
        Player player2 = new Player2(Game.WIDTH-100, g.HEIGHT*2/3-55, 50, 55, Color.BLUE, null, null, "image", 40,1,playerSpeed);
        player1.lasersLimit = lasersLimit;
        player2.lasersLimit = lasersLimit;
        player2.hpBar.setX(Game.WIDTH-20-player2.hpBar.getWidth());
        try {
            player2.gameOver.setNormalState(Sprite.getSprite("p2Wins.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        component p1HP = new component(1, Game.HEIGHT/4-9,25,300-18, Color.GREEN, null, null, "image");
        component p2HP = new component(Game.WIDTH-131, Game.HEIGHT/4-9,25,300-18, Color.GREEN, null, null, "image");
        try {
            p1HP.setNormalState(Sprite.getSprite("p1HP.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            p2HP.setNormalState(Sprite.getSprite("p2HP.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        allGameObjects.add(p2HP);
        allGameObjects.add(p1HP);

        allGameObjects.add(player1.hpBar);
        allGameObjects.add(player2.hpBar);


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
            hotLaser laser = new hotLaser(-100, player1.getY()+25, 20, 5, Color.red, null, null, null);
            allGameObjects.add(laser);
            player1.lasers.add(laser);
            hotLaser laser2 = new hotLaser(-100, player2.getY()+25, 20, 5, Color.BLUE, null, null, null);
            player2.lasers.add(laser2);
            allGameObjects.add(laser2);
        }

        component p1X = new text(20, Game.HEIGHT/1.3f,0,0,Color.black,null, null, null);
        ((text) p1X).dataSource.add(player1);
        ((text) p1X).dataSource.add(player2);
        ((text) p1X).field = "Player 1 X";
        allGameObjects.add(p1X);
        component p1Y = new text(20, Game.HEIGHT/1.25f,0,0,Color.black,null, null, null);
        ((text) p1Y).dataSource.add(player1);
        ((text) p1Y).dataSource.add(player2);
        ((text) p1Y).field = "Player 1 Y";
        allGameObjects.add(p1Y);
        component p1Xs = new text(20, Game.HEIGHT/1.2f,0,0,Color.black,null, null, null);
        ((text) p1Xs).dataSource.add(player1);
        ((text) p1Xs).dataSource.add(player2);
        ((text) p1Xs).field = "Player 1 X-Velocity";
        allGameObjects.add(p1Xs);
        component p1Ys = new text(20, Game.HEIGHT/1.15f,0,0,Color.black,null, null, null);
        ((text) p1Ys).dataSource.add(player1);
        ((text) p1Ys).dataSource.add(player2);
        ((text) p1Ys).field = "Player 1 Y-Velocity";
        allGameObjects.add(p1Ys);
        component p2X = new text(300, Game.HEIGHT/1.3f,0,0,Color.black,null, null, null);
        ((text) p2X).dataSource.add(player1);
        ((text) p2X).dataSource.add(player2);
        ((text) p2X).field = "Player 2 X";
        allGameObjects.add(p2X);
        component p2Y = new text(300, Game.HEIGHT/1.25f,0,0,Color.black,null, null, null);
        ((text) p2Y).dataSource.add(player1);
        ((text) p2Y).dataSource.add(player2);
        ((text) p2Y).field = "Player 2 Y";
        allGameObjects.add(p2Y);

        component p2Xs = new text(300, Game.HEIGHT/1.2f,0,0,Color.black,null, null, null);
        ((text) p2Xs).dataSource.add(player1);
        ((text) p2Xs).dataSource.add(player2);
        ((text) p2Xs).field = "Player 2 X-Velocity";
        allGameObjects.add(p2Xs);
        component p2Ys = new text(300, Game.HEIGHT/1.15f,0,0,Color.black,null, null, null);
        ((text) p2Ys).dataSource.add(player1);
        ((text) p2Ys).dataSource.add(player2);
        ((text) p2Ys).field = "Player 2 Y-Velocity";
        allGameObjects.add(p2Ys);
        for(int x =0; x<platformNum; x++){

            Ys[x] = Game.HEIGHT / (1.8f+fun.nextFloat()*2.5f);
            widths[x] = fun.nextInt(50)+50;
            Xs[x] = fun.nextInt(g.WIDTH-widths[x]);
            heights[x] = fun.nextInt(20)+10;

            component ground = new component(Xs[x], Ys[x], widths[x], heights[x], dirt, null, null, null);
            component groundGrass = new component(Xs[x], Ys[x]-heights[x], widths[x], heights[x], grass, null, null, null);
            player1.ground.add(ground);
            player2.ground.add(ground);
            allGameObjects.add(ground);
            allGameObjects.add(groundGrass);

        }
        player1.ground.add(groundOne);
        player2.ground.add(groundOne);
        player1.enemy.add(player2);
        player2.enemy.add(player1);



        allGameObjects.add(groundOne);
        allGameObjects.add(grassOne);
        allGameObjects.add(player1);
        allGameObjects.add(player2);

        allGameObjects.add(player1.gameOver);
        allGameObjects.add(player2.gameOver);
        // Add updatables and renderables



        for(component x : allGameObjects) {
            g.addRenderable(x);
            g.addUpdatable(x);
        }

        // Start

        g.Start();
    }

}
