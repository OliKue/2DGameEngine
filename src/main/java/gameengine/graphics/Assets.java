package gameengine.graphics;

import java.awt.image.BufferedImage;

public class Assets {
    private static final Assets OBJ = new Assets();

    // Mage
    public BufferedImage[] mage_idle_left = new BufferedImage[25];
    public BufferedImage[] mage_idle_right = new BufferedImage[25];
    public BufferedImage[] mage_run_right = new BufferedImage[8];
    public BufferedImage[] mage_run_left = new BufferedImage[8];
    public BufferedImage[] mage_jump_left = new BufferedImage[7];
    public BufferedImage[] mage_jump_right = new BufferedImage[7];

    //Tiles
    public BufferedImage tile12;
    public BufferedImage tile30;
    public BufferedImage tile31;
    public BufferedImage tile32;
    public BufferedImage tile52;
    public BufferedImage tile53;
    public BufferedImage tile55;


    private Assets() {
        this.init();
    }

    public static Assets getInstance() {
        return OBJ;
    }

    public void init() {
        tile12 = ImageLoader.loadImage("/PNG/Tiles/tile12.png");
        tile30 = ImageLoader.loadImage("/PNG/Tiles/tile30.png");
        tile31 = ImageLoader.loadImage("/PNG/Tiles/tile31.png");
        tile32 = ImageLoader.loadImage("/PNG/Tiles/tile32.png");
        tile52 = ImageLoader.loadImage("/PNG/Tiles/tile52.png");
        tile53 = ImageLoader.loadImage("/PNG/Tiles/tile53.png");
        tile55 = ImageLoader.loadImage("/PNG/Tiles/tile55.png");

        mage_idle_right[0] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle_right[1] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle_right[2] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle_right[3] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle_right[4] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle_right[5] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle_right[6] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle_right[7] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle_right[8] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle_right[9] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle_right[10] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle_right[11] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle1.png");
        mage_idle_right[12] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle2.png");
        mage_idle_right[13] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle3.png");
        mage_idle_right[14] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle4.png");
        mage_idle_right[15] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle5.png");
        mage_idle_right[16] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle6.png");
        mage_idle_right[17] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle7.png");
        mage_idle_right[18] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle8.png");
        mage_idle_right[19] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle9.png");
        mage_idle_right[20] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle10.png");
        mage_idle_right[21] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle11.png");
        mage_idle_right[22] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle12.png");
        mage_idle_right[23] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle13.png");
        mage_idle_right[24] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");


        mage_idle_left[0] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL14.png");
        mage_idle_left[1] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL14.png");
        mage_idle_left[2] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL14.png");
        mage_idle_left[3] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL14.png");
        mage_idle_left[4] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL14.png");
        mage_idle_left[5] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL14.png");
        mage_idle_left[6] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL14.png");
        mage_idle_left[7] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL14.png");
        mage_idle_left[8] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL14.png");
        mage_idle_left[9] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL14.png");
        mage_idle_left[10] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL14.png");
        mage_idle_left[11] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL1.png");
        mage_idle_left[12] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL2.png");
        mage_idle_left[13] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL3.png");
        mage_idle_left[14] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL4.png");
        mage_idle_left[15] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL5.png");
        mage_idle_left[16] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL6.png");
        mage_idle_left[17] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL7.png");
        mage_idle_left[18] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL8.png");
        mage_idle_left[19] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL9.png");
        mage_idle_left[20] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL10.png");
        mage_idle_left[21] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL11.png");
        mage_idle_left[22] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL12.png");
        mage_idle_left[23] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL13.png");
        mage_idle_left[24] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idleL14.png");


        mage_run_right[0] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/run1.png");
        mage_run_right[1] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/run2.png");
        mage_run_right[2] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/run3.png");
        mage_run_right[3] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/run4.png");
        mage_run_right[4] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/run5.png");
        mage_run_right[5] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/run6.png");
        mage_run_right[6] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/run7.png");
        mage_run_right[7] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/run8.png");

        mage_run_left[0] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/runL1.png");
        mage_run_left[1] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/runL2.png");
        mage_run_left[2] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/runL3.png");
        mage_run_left[3] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/runL4.png");
        mage_run_left[4] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/runL5.png");
        mage_run_left[5] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/runL6.png");
        mage_run_left[6] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/runL7.png");
        mage_run_left[7] =  ImageLoader.loadImage("/PNG/Character/Mage/Run/runL8.png");

        mage_jump_left[0] =  ImageLoader.loadImage("/PNG/Character/Mage/Jump/jumpL1.png");
        mage_jump_left[1] =  ImageLoader.loadImage("/PNG/Character/Mage/Jump/jumpL2.png");
        mage_jump_left[2] =  ImageLoader.loadImage("/PNG/Character/Mage/Jump/jumpL3.png");
        mage_jump_left[3] =  ImageLoader.loadImage("/PNG/Character/Mage/Jump/jumpL4.png");
        mage_jump_left[4] =  ImageLoader.loadImage("/PNG/Character/Mage/Jump/jumpL5.png");
        mage_jump_left[5] =  ImageLoader.loadImage("/PNG/Character/Mage/Jump/jumpL6.png");
        mage_jump_left[6] =  ImageLoader.loadImage("/PNG/Character/Mage/Jump/jumpL7.png");

        mage_jump_right[0] =  ImageLoader.loadImage("/PNG/Character/Mage/Jump/jump1.png");
        mage_jump_right[1] =  ImageLoader.loadImage("/PNG/Character/Mage/Jump/jump2.png");
        mage_jump_right[2] =  ImageLoader.loadImage("/PNG/Character/Mage/Jump/jump3.png");
        mage_jump_right[3] =  ImageLoader.loadImage("/PNG/Character/Mage/Jump/jump4.png");
        mage_jump_right[4] =  ImageLoader.loadImage("/PNG/Character/Mage/Jump/jump5.png");
        mage_jump_right[5] =  ImageLoader.loadImage("/PNG/Character/Mage/Jump/jump6.png");
        mage_jump_right[6] =  ImageLoader.loadImage("/PNG/Character/Mage/Jump/jump7.png");
    }


}
