package gameengine.entities.staticEntities;

import gameengine.entities.Entity;
import gameengine.entities.EntityManager;
import gameengine.graphics.Animation;
import gameengine.graphics.Assets;
import gameengine.graphics.GameCamera;
import gameengine.world.WorldManager;

import java.awt.*;

public class Portal extends Entity {

    Animation animation;
    WorldManager.WorldKey targetWorldKey;
    int nextWorldSpawnX, nextWorldSpawnY;
    private Point center;


    public Portal(int xPos, int yPos, WorldManager.WorldKey world, WorldManager.WorldKey targetWorldKey, int nextWorldSpawnX, int nextWorldSpawnY) {

        super(xPos, yPos, Assets.getInstance().portal[0].getWidth(), Assets.getInstance().portal[0].getHeight(), world);

        animation = new Animation(100, Assets.getInstance().portal);

        this.targetWorldKey = targetWorldKey;
        this.nextWorldSpawnX = nextWorldSpawnX;
        this.nextWorldSpawnY = nextWorldSpawnY;

        center = new Point(xPos + width / 2, yPos + height / 2);


    }

    @Override
    public void tick() {
        if (EntityManager.getPlayer().getHitBox().contains(center)) {
            WorldManager.getInstance().changeWorld(targetWorldKey);
            EntityManager.getPlayer().teleport(nextWorldSpawnX, nextWorldSpawnY);
            EntityManager.getPlayer().world = targetWorldKey;
        }
        animation.tick();
    }

    @Override
    public void render(Graphics g) {
        int x = (int) xPos - GameCamera.getInstance().xOffset;
        int y = (int) yPos - GameCamera.getInstance().yOffset;

        g.drawImage(animation.getCurrentFrame(), x, y, width, height, null);

    }
}
