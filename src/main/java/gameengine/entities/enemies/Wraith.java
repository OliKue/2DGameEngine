package gameengine.entities.enemies;

import gameengine.Game;
import gameengine.entities.Creature;
import gameengine.entities.Entity;
import gameengine.entities.EntityManager;
import gameengine.entities.Player;
import gameengine.graphics.Animation;
import gameengine.graphics.Assets;
import gameengine.graphics.GameCamera;
import gameengine.world.WorldManager;

import java.awt.*;
import java.util.ArrayList;

public class Wraith extends Creature {

    private ArrayList<Animation> animations = new ArrayList<>();

    private final Animation animation_idle = new Animation(150, Assets.getInstance().wraith_01_idle);
    private final Animation animation_run = new Animation(100, Assets.getInstance().wraith_01_walk);

    private boolean ending = false;
    private int ticksUntilInactive = 50;
    private int tickCount;
    private final Animation animation_dying = new Animation(50, Assets.getInstance().wraith_01_dying);

    private int dmg = 5;


    private boolean attacking = false;
    private int ticksAttack = 50;
    private int tickCountAttack;
    private final Animation animation_attack = new Animation(100, Assets.getInstance().wraith_01_attack);

    private Animation animation = animation_idle;

    private boolean facingLeft = false;

    public Wraith(int x, int y, WorldManager.WorldKey world) {
        super(x, y, Assets.getInstance().wraith_01_idle[0].getWidth(), Assets.getInstance().wraith_01_idle[0].getHeight(), world);

        //Hitbox
        this.hitBox.x = 36;
        this.hitBox.width = 50;
        this.hitBox.y = 10;
        this.hitBox.height = 73;

        //Velocity
        this.xAcc = 0.2f;
        this.maxXVel = 3;

        this.yAcc = 0.2f;
        this.maxYVel = 3;

        //Add animations
        animations.add(animation_idle);
        animations.add(animation_run);
        animations.add(animation_dying);
        animations.add(animation_attack);

        // Life
        this.life = 10;


    }

    @Override
    public void tick() {
        if (ending) {
            yAcc = 0;
            xAcc = 0;
            yVel = 0;
            xVel = 0;
            tickCount++;
            if (tickCount > ticksUntilInactive) {
                this.active = false;
            }
        } else if (attacking) {
            //check damage
            checkAttack();
        } else {
            //Movement
            calculatePath();
            xNextPos = xPos + xVel;
            yNextPos = yPos + yVel;

            moveToNextPos();


        }
        // Animation
        updateAnimation();

    }

    private void checkAttack() {
        Player player = EntityManager.getPlayer();

        if (attacking ) {
            yVel = 0;
            xVel = 0;
            tickCountAttack++;
            if (tickCountAttack > ticksAttack) {
                tickCountAttack=0;
                this.attacking = false;
                if (player.getHitBox().intersects(getHitBox()) || getHitBox().intersects(player.getHitBox())) {
                    player.applyDmg(dmg);
                }
            }
        }


    }

    private void calculatePath() {
        int targetX = (int) EntityManager.getPlayer().getXPos();
        int targetY = (int) EntityManager.getPlayer().getYPos();
        Point target = new Point(targetX, targetY);
        Point position = new Point((int)xPos, (int)yPos);

        if (target.distance(position) < 5) {
            attacking = true;
        } else if(target.distance(position) < 500){
            calculatePathX();
            calculatePathY();
        }  else{
            slowDownX();
            slowDownY();
        }

    }

    private void calculatePathX() {
        int targetX = (int) EntityManager.getPlayer().getXPos();

        if (xPos > targetX) {
            facingLeft = true;
            if (xVel > 0) {
                slowDownX();
            } else {
                if (xVel > -maxXVel) {
                    xVel = xVel - xAcc;
                } else {
                    xVel = -maxXVel;
                }
            }
        } else if (xPos < targetX) {
            facingLeft = false;
            if (xVel < 0) {
                slowDownX();
            } else {
                if (xVel < maxXVel) {
                    xVel = xVel + xAcc;
                } else {
                    xVel = maxXVel;
                }
            }
        } else {
            //STOP
            slowDownX();
        }

    }

    private void calculatePathY() {
        int targetY = (int) EntityManager.getPlayer().getYPos();

        if (yPos > targetY) {
            if (yVel > 0) {
                slowDownY();
            } else {
                if (yVel > -maxYVel) {
                    yVel = yVel - yAcc;
                } else {
                    yVel = -maxYVel;
                }
            }
        } else if (yPos < targetY) {

            if (yVel < 0) {
                slowDownY();
            } else {
                if (yVel < maxYVel) {
                    yVel = yVel + yAcc;
                } else {
                    yVel = maxYVel;
                }
            }
        } else {
            //STOP
            slowDownY();
        }

    }

    private void updateAnimation() {
        if (ending) {
            animation = animation_dying;
        } else if(attacking){
            animation = animation_attack;
        }else if (xVel > xAcc || xVel < -xAcc) {
            animation = animation_run;
        } else {
            animation = animation_idle;
        }


        animation.tick();

        //Reset inactive
        for (Animation a : animations) {
            if (!(a == animation)) {
                a.reset();
            }
        }

    }

    @Override
    public void render(Graphics g) {

        int x = (int) xPos - GameCamera.getInstance().xOffset;
        int y = (int) yPos - GameCamera.getInstance().yOffset;

        if (facingLeft) {
            g.drawImage(animation.getCurrentFrame(), x + width, y, -width, height, null);
        } else {
            g.drawImage(animation.getCurrentFrame(), x, y, width, height, null);
        }

        if (Game.DRAW_HITBOX) {
            g.drawRect(x + hitBox.x, y + hitBox.y, hitBox.width, hitBox.height);
        }
    }

    @Override
    public void die() {
        ending = true;
    }
}
