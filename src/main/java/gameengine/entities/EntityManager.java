package gameengine.entities;

import gameengine.entities.enemies.Wraith;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private static final EntityManager OBJ = new EntityManager();
    private static Player player;
    private static ArrayList<Entity> entities = new ArrayList<>();

    private static int enemyCounter =0;

    private EntityManager(){
    }

    public static EntityManager getInstance(){
        return OBJ;
    }

    public void tick(){
        player.tick();

        for (Entity e: entities) {
            e.tick();
            if(!e.active && e instanceof Wraith){
                enemyCounter--;
            }
        }
        entities.removeIf(entity -> !entity.active);
        if(enemyCounter<2){
            addEntity(new Wraith((int) (player.xPos), (int) (player.yPos-200)));
        }
    }
    public void render(Graphics g){
        player.render(g);

        for (Entity e: entities) {
            e.render(g);
        }
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        EntityManager.player = player;
    }

    public void addEntity(Entity e){
        if(e instanceof Wraith){
            enemyCounter++;
        }
        entities.add(e);
    }

    public static ArrayList<Entity> getEntities() {
        return entities;
    }

    public float getPlayerHitboxXPos(){
        return EntityManager.player.xPos+EntityManager.player.hitBox.x;
    }
    public float getPlayerHitboxYPos(){
        return EntityManager.player.yPos+EntityManager.player.hitBox.y;
    }
}
