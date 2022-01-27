package gameengine.entities;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private static final EntityManager OBJ = new EntityManager();
    private static Player player;
    private static ArrayList<Entity> entities = new ArrayList<>();

    private EntityManager(){
    }

    public static EntityManager getInstance(){
        return OBJ;
    }

    public void tick(){
        player.tick();

        for (Entity e: entities) {
            e.tick();
        }
        entities.removeIf(entity -> !entity.active);
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
