package game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import game.Main;
public class Game {
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    private String gameName = "Disappointment Brawl";
    private Canvas game = new Canvas();

    private Input input;

    private ArrayList<Updatable> updatables = new ArrayList<>();
    private ArrayList<Renderable> renderables = new ArrayList<>();

    //NEW
    public void addUpdatable(Updatable u) {
        updatables.add(u);
    }

    //NEW
    public void removeUpdatable(Updatable u) {
        updatables.remove(u);
    }

    // NEW
    public void addRenderable(Renderable r) {
        renderables.add(r);
    }

    // NEW
    public void removeRenderable(Renderable r) {
        renderables.remove(r);
    }

    public void Start() {
        // Initialize window
        Dimension gameSize = new Dimension(Game.WIDTH, Game.HEIGHT);
        JFrame gameWindow = new JFrame(gameName);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(gameSize);
        gameWindow.setResizable(false);
        gameWindow.setVisible(true);
        game.setSize(gameSize);
        game.setMinimumSize(gameSize);
        game.setMaximumSize(gameSize);
        game.setPreferredSize(gameSize);
        gameWindow.add(game);
        gameWindow.setLocationRelativeTo(null); // makes the window centered on screen

        // Initialize input
        input = new Input();
        game.addKeyListener(input);
        // Game loop
        boolean running = true;

        final int TICKS_PER_SECOND = 60; // NEW
        final int TIME_PER_TICK = 1000/TICKS_PER_SECOND; //NEW
        final int MAX_FRAMESKIPS = 5; //NEW

        long nextGameTick = System.currentTimeMillis(); //NEW
        int loops; // NEW
        float interpolation; //NEW

        long timeAtLastFPSCheck = 0; //  NEW
        int ticks = 0; // NEW

        while (running)
        {
            //update();  //NEW  for testing remove
            //render(1.0f); //NEW for testing remove

            // Updating

            loops = 0; // NEW
            // NEW
            while(System.currentTimeMillis() > nextGameTick && loops < MAX_FRAMESKIPS) {
                update();
                ticks++;

                nextGameTick += TIME_PER_TICK;
                loops++;
            }

            // Rendering
            // NEW
            interpolation= (float) (System.currentTimeMillis() + TIME_PER_TICK - nextGameTick)
                    / (float) TIME_PER_TICK;
            render(interpolation);

            // FPS Check NEW
            if (System.currentTimeMillis() - timeAtLastFPSCheck >= 1000) {
                gameWindow.setTitle(gameName + " - FPS: " + ticks);
                ticks = 0;
                timeAtLastFPSCheck = System.currentTimeMillis();
            }


        }
        // Game end
    }

    // NEW
    private void update() {
        for(Updatable u : updatables) {
            u.update(input);
        }

    }

    // NEW
    private void render(float interpolation) {
        // We want to use double buffered rendering
        // the next frame is prerendered which prevents
        // flickering

        BufferStrategy b = game.getBufferStrategy();
        if (b == null) {
            game.createBufferStrategy(2);
            return;
        }
        Graphics2D g = (Graphics2D)b.getDrawGraphics();
        g.clearRect(0, 0, game.getWidth(), game.getHeight());

        for(Renderable r : renderables) {
            r.render(g, interpolation);
        }

        g.dispose();
        b.show();
        Toolkit.getDefaultToolkit().sync();

    }

    // NEW
    /*
    public static void main(String[] args) {
        Game g = new Game();
        g.renderables.add(new Renderable() {
            @Override
            public void render(Graphics2D g, float interpolation) {
                g.setColor(Color.RED);
                g.drawRect(300, 200, 50, 100);
            }
        });

        g.Start();
    }
    */


}
