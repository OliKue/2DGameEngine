package gameengine.entities;

import gameengine.graphics.Animation;
import gameengine.graphics.Assets;
import gameengine.graphics.GameCamera;
import gameengine.input.KeyManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends Creature {

    private ArrayList<Animation> animations = new ArrayList<>();

    private boolean facingLeft = false;

    private final Animation animation_idle_left = new Animation(150, Assets.getInstance().mage_idle_left);
    private final Animation animation_idle_right = new Animation(150, Assets.getInstance().mage_idle_right);
    private final Animation animation_run_left = new Animation(100, Assets.getInstance().mage_run_left);
    private final Animation animation_run_right = new Animation(100, Assets.getInstance().mage_run_right);
    private final Animation animation_jump_right = new Animation(50, Assets.getInstance().mage_jump_right);
    private final Animation animation_jump_left = new Animation(50, Assets.getInstance().mage_jump_left);


    private Animation animation = animation_idle_right;

    public Player(int x, int y) {
        super(x, y, 128, 128);

        //Hitbox
        this.hitBox.x = 21;
        this.hitBox.width = 51;
        this.hitBox.y = 55;
        this.hitBox.height = 56;

        //Velocity
        this.xAcc = 0.5f;
        this.maxXVel = 10;

        this.yAcc = 30f;

        //Add animations
        animations.add(animation_idle_left);
        animations.add(animation_idle_right);
        animations.add(animation_run_left);
        animations.add(animation_run_right);
        animations.add(animation_jump_right);
        animations.add(animation_jump_left);
    }

    @Override
    public void tick() {
        checkOnGround();
        // Movement
        if (falling || jumping) {
            yVel = yVel + GRAVITY;
        } else {
            yVel = 0;
            if (jumpDelayTicks > 0) {
                jumpDelayTicks--;
            }
        }
        getInput();

        xNextPos = xPos + xVel;
        yNextPos = yPos + yVel;


        moveToNextPos();
        GameCamera.getInstance().centerOnEntity(this);

        // Animation
        updateAnimation();
    }

    private void updateAnimation() {
        if (jumping) {
            if (facingLeft) {
                animation = animation_jump_left;
            } else {
                animation = animation_jump_right;
            }
        } else if (xVel > xAcc || xVel < -xAcc) {
            if (facingLeft) {
                animation = animation_run_left;
            } else {
                animation = animation_run_right;
            }
        } else {
            if (facingLeft) {
                animation = animation_idle_left;
            } else {
                animation = animation_idle_right;
            }
        }

        animation.tick();

        //Reset inactive
        for (
                Animation a : animations) {
            if (!(a == animation)) {
                a.reset();
            }
        }

    }

    private void getInput() {
        //JUMP
        if (KeyManager.getInstance().keys[KeyEvent.VK_SPACE] || KeyManager.getInstance().keys[KeyEvent.VK_W]) {
            if (!jumping && jumpDelayTicks == 0) {
                yVel = yVel - yAcc;
                jumping = true;
                jumpDelayTicks = jumpDelay;
            }
        }
//        //FLY
//        if (KeyManager.getInstance().keys[KeyEvent.VK_UP]) {
//            if (!jumping && jumpDelayTicks == 0) {
//                yVel = yVel - yAcc;
//            }
//        }

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
        g.drawImage(animation.getCurrentFrame(), (int) xPos - GameCamera.getInstance().xOffset, (int) yPos - GameCamera.getInstance().yOffset, null);
    }

    protected void checkOnGround() {
        int ty = (int) (yPos + hitBox.y + hitBox.height + 1);
        if (isCollisionVertical(ty)) {
            jumping = false;
            falling = false;
        } else {
            falling = true;
        }
    }

}
