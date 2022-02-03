package gameengine.entities;

import gameengine.Game;
import gameengine.display.Interface;
import gameengine.entities.enemies.Wraith;
import gameengine.entities.projectiles.FireBow;
import gameengine.graphics.Animation;
import gameengine.graphics.Assets;
import gameengine.graphics.GameCamera;
import gameengine.input.KeyManager;
import gameengine.sound.SoundManager;
import gameengine.world.WorldManager;
import gameengine.world.levels.BaseWorld;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends Creature {

    private ArrayList<Animation> animations = new ArrayList<>();

    private boolean facingLeft = false;

    private final Animation animation_idle = new Animation(150, Assets.getInstance().mage_idle);
    private final Animation animation_run = new Animation(100, Assets.getInstance().mage_run);
    private final Animation animation_jump = new Animation(50, Assets.getInstance().mage_jump);
    private final Animation animation_attack = new Animation(100, Assets.getInstance().mage_attack);

    private Animation animation = animation_idle;

    private int attack_cd = 35;
    private int attack_cdCount = 0;
    private boolean attack_rdy = true;
    private boolean attacking = false;
    private int attackManaCost = 20;


    private boolean ending = false;
    private int ticksUntilInactive = 50;
    private int tickCount;
    private final Animation animation_dying = new Animation(100, Assets.getInstance().mage_dying);

    private boolean hurting = false;
    private int ticksHurt = 20;
    private int tickCountHurt;
    private final Animation animation_hurting = new Animation(100, Assets.getInstance().mage_hurt);

    // Stats
    public int PLAYER_MAX_LIFE = 50;
    public int PLAYER_MAX_MANA = 50;


    public Player(int x, int y, WorldManager.WorldKey world) {
        super(x, y, Assets.getInstance().mage_idle[0].getWidth(), Assets.getInstance().mage_idle[0].getHeight(), world);

        //Hitbox
        this.hitBox.x = 41;
        this.hitBox.width = 51;
        this.hitBox.y = 55;
        this.hitBox.height = 56;

        //Velocity
        this.xAcc = 0.5f;
        this.maxXVel = 10;

        this.yAcc = 30f;
        this.maxYVel = 20;

        //Add animations
        animations.add(animation_idle);
        animations.add(animation_run);
        animations.add(animation_jump);
        animations.add(animation_attack);

        this.MAX_LIFE = PLAYER_MAX_LIFE;
        this.life = MAX_LIFE;
        this.lifeRegen = 5;
        this.MAX_MANA = PLAYER_MAX_MANA;
        this.mana = MAX_MANA;
        this.manaRegen = 20;

    }

    @Override
    public void tick() {
        if (ending) {
            yVel = 0;
            xVel = 0;
            tickCount++;
            if (tickCount > ticksUntilInactive) {
                WorldManager.getInstance().changeWorld(WorldManager.WorldKey.baseWorld);
                xPos = BaseWorld.xSpawn;
                yPos = BaseWorld.ySpawn;

                ending = false;
                tickCount = 0;
                life = PLAYER_MAX_LIFE;
            }
        }
        if (hurting) {
            tickCountHurt++;
            if (tickCountHurt > ticksHurt) {
                hurting = false;
                tickCountHurt = 0;
            }
        }


        checkOnGround();
        // Movement
        if (falling || jumping) {
            if (yVel < maxYVel) {
                yVel = yVel + GRAVITY;
            }
        } else {
            yVel = 0;
            if (jumpDelayTicks > 0) {
                jumpDelayTicks--;
            }
        }

        // Attack cooldown
        if (!attack_rdy) {
            attack_cdCount++;
            if (attack_cd < attack_cdCount) {
                attack_rdy = true;
                attack_cdCount = 0;
                attacking = false;
                mana -= attackManaCost;
                EntityManager.getInstance().addEntity(new FireBow((int) xPos, (int) yPos, facingLeft, world));
                updateAnimation();
            }
        }
        getInput();

        xNextPos = xPos + xVel;
        yNextPos = yPos + yVel;


        moveToNextPos();
        GameCamera.getInstance().centerOnEntity(this);

        // Animation
        updateAnimation();
        //Interface
        Interface.getInstance().tick();
        //Regen
        regen();

    }

    private void updateAnimation() {
        if (ending) {
            animation = animation_dying;
        } else if (hurting) {
            animation = animation_hurting;
        } else if (attacking) {
            animation = animation_attack;
        } else if (jumping) {
            animation = animation_jump;
        } else if (xVel > xAcc || xVel < -xAcc) {
            animation = animation_run;
        } else {
            animation = animation_idle;
        }

        animation.tick();

        //Reset inactive Animations
        for (Animation a : animations) {
            if (!(a == animation)) {
                a.reset();
            }
        }

    }

    private void getInput() {

        //Attack
        if (KeyManager.getInstance().keys[KeyEvent.VK_E] && attack_rdy) {
            if (mana >= attackManaCost) {
                attack_rdy = false;
                attacking = true;
                SoundManager.getInstance().setFile("fireBowStart");
                SoundManager.getInstance().play();
            }
        }
        //JUMP
        if (KeyManager.getInstance().keys[KeyEvent.VK_SPACE] || KeyManager.getInstance().keys[KeyEvent.VK_W]) {
            if (!jumping && jumpDelayTicks == 0) {
                yVel = yVel - yAcc;
                jumping = true;
                jumpDelayTicks = jumpDelay;
            }
        }

        if (KeyManager.getInstance().keys[KeyEvent.VK_A]) {
            //LEFT
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
        } else if (KeyManager.getInstance().keys[KeyEvent.VK_D]) {
            //RIGHT
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

    @Override
    public void applyDmg(int dmg) {
        super.applyDmg(dmg);
        hurting = true;
    }
}
