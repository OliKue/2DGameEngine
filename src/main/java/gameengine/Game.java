package gameengine;

import gameengine.display.Display;
import gameengine.display.Interface;
import gameengine.display.Menu;
import gameengine.entities.EntityManager;
import gameengine.entities.Player;
import gameengine.entities.enemies.Wraith;
import gameengine.graphics.GameCamera;
import gameengine.input.KeyManager;
import gameengine.tile.Tile;
import gameengine.world.BackgroundManager;
import gameengine.world.WorldManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    public final static boolean DRAW_HITBOX = false;

    public static int playerSpawnX = 250;
    public static int playerSpawnY = WorldManager.getInstance().getActiveWorld().getHeight() * Tile.TILEHEIGTH - 200;

    public static int width = 1600, height = 900;
    public static String title = "gameengine.Game";

    private Display display;
    private boolean running = false;
    private Thread thread;

    public GameStates gameState = GameStates.MENU;

    public enum GameStates {
        MENU,
        GAME
    }

    public void init() {
        this.display = new Display(title, width, height);

        EntityManager.setPlayer(new Player(playerSpawnX, playerSpawnY, WorldManager.getInstance().getActiveWorldKey()));

        EntityManager.getInstance().addEntity(new Wraith(48, WorldManager.getInstance().getActiveWorld().getHeight() * Tile.TILEHEIGTH - 150, WorldManager.getInstance().getActiveWorldKey()));


//        EntityManager.getInstance().addEntity(new Wraith(300, World.getInstance().getHeight() * Tile.TILEHEIGTH - 300));
    }

    @Override
    public void run() {

        init();

        // FPS
        int fps = 60;
        double timePerTick = 1000000000d / fps;

        double delta = 0;
        long lastTime = System.nanoTime();


        long timer = 0;
        int ticks = 0;

        while (running) {
            // FPS
            long now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1.0) {
                tick();
                render();

                ticks++;
                delta -= 1.0;
            }

            if (timer >= 1000000000) {
                //System.out.println("FPS: " + ticks);

                ticks = 0;
                timer = 0;
            }

        }
        stop();
    }

    private void tick() {


        switch (gameState) {
            case GAME:
                GameCamera.getInstance().tick();
                EntityManager.getInstance().tick();
                BackgroundManager.getInstance().tick();
                Interface.getInstance().tick();
                //Change to Menu
                if (KeyManager.getInstance().escapeReleased) {
                    gameState = GameStates.MENU;
                    KeyManager.getInstance().escapeReleased = false;
                }
                break;
            case MENU:
                Menu.getInstance().tick(this);
                //Change to Game
                if (KeyManager.getInstance().escapeReleased || KeyManager.getInstance().keys[KeyEvent.VK_P]) {
                    gameState = GameStates.GAME;
                    KeyManager.getInstance().escapeReleased = false;
                }
                break;
        }

    }

    private void render() {
        BufferStrategy bs = display.getCanvas().getBufferStrategy();

        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();


        //Clear
        g.clearRect(0, 0, width, height);
        //Draw new
        switch (gameState) {
            case GAME:
                BackgroundManager.getInstance().render(g);
                GameCamera.getInstance().render(g);
                EntityManager.getInstance().render(g);
                Interface.getInstance().render(g);
                break;
            case MENU:
                Menu.getInstance().render(g);

                break;

        }
        bs.show();
        g.dispose();
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
