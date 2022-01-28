package gameengine.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    private static final Assets OBJ = new Assets();

    //Menu
    public BufferedImage menuScreen;

    // Mage
    public BufferedImage[] mage_idle = new BufferedImage[25];
    public BufferedImage[] mage_run = new BufferedImage[8];
    public BufferedImage[] mage_jump = new BufferedImage[7];
    public BufferedImage[] mage_attack = new BufferedImage[7];


    // Fire
    public BufferedImage[] fire_flying = new BufferedImage[4];
    public BufferedImage[] fire_end = new BufferedImage[2];

    // Mage
    public BufferedImage[] wraith_01_idle = new BufferedImage[12];
    public BufferedImage[] wraith_01_walk = new BufferedImage[12];
    public BufferedImage[] wraith_01_dying = new BufferedImage[15];
    public BufferedImage[] wraith_01_attack = new BufferedImage[12];


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
        menuScreen = ImageLoader.loadImage("/PNG/Menuscreen/Background.png");

        initTiles();
        initMageAnimations();
        initFireAnimations();
        initWraith_01();
    }

    public void initTiles() {
        tile12 = ImageLoader.loadImage("/PNG/Tiles/tile12.png");
        tile30 = ImageLoader.loadImage("/PNG/Tiles/tile30.png");
        tile31 = ImageLoader.loadImage("/PNG/Tiles/tile31.png");
        tile32 = ImageLoader.loadImage("/PNG/Tiles/tile32.png");
        tile52 = ImageLoader.loadImage("/PNG/Tiles/tile52.png");
        tile53 = ImageLoader.loadImage("/PNG/Tiles/tile53.png");
        tile55 = ImageLoader.loadImage("/PNG/Tiles/tile55.png");
    }

    public void initMageAnimations() {


        mage_idle[0] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle[1] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle[2] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle[3] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle[4] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle[5] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle[6] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle[7] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle[8] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle[9] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle[10] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");
        mage_idle[11] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle1.png");
        mage_idle[12] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle2.png");
        mage_idle[13] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle3.png");
        mage_idle[14] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle4.png");
        mage_idle[15] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle5.png");
        mage_idle[16] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle6.png");
        mage_idle[17] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle7.png");
        mage_idle[18] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle8.png");
        mage_idle[19] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle9.png");
        mage_idle[20] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle10.png");
        mage_idle[21] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle11.png");
        mage_idle[22] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle12.png");
        mage_idle[23] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle13.png");
        mage_idle[24] = ImageLoader.loadImage("/PNG/Character/Mage/Idle/idle14.png");


        mage_run[0] = ImageLoader.loadImage("/PNG/Character/Mage/Run/run1.png");
        mage_run[1] = ImageLoader.loadImage("/PNG/Character/Mage/Run/run2.png");
        mage_run[2] = ImageLoader.loadImage("/PNG/Character/Mage/Run/run3.png");
        mage_run[3] = ImageLoader.loadImage("/PNG/Character/Mage/Run/run4.png");
        mage_run[4] = ImageLoader.loadImage("/PNG/Character/Mage/Run/run5.png");
        mage_run[5] = ImageLoader.loadImage("/PNG/Character/Mage/Run/run6.png");
        mage_run[6] = ImageLoader.loadImage("/PNG/Character/Mage/Run/run7.png");
        mage_run[7] = ImageLoader.loadImage("/PNG/Character/Mage/Run/run8.png");


        mage_jump[0] = ImageLoader.loadImage("/PNG/Character/Mage/Jump/jump1.png");
        mage_jump[1] = ImageLoader.loadImage("/PNG/Character/Mage/Jump/jump2.png");
        mage_jump[2] = ImageLoader.loadImage("/PNG/Character/Mage/Jump/jump3.png");
        mage_jump[3] = ImageLoader.loadImage("/PNG/Character/Mage/Jump/jump4.png");
        mage_jump[4] = ImageLoader.loadImage("/PNG/Character/Mage/Jump/jump5.png");
        mage_jump[5] = ImageLoader.loadImage("/PNG/Character/Mage/Jump/jump6.png");
        mage_jump[6] = ImageLoader.loadImage("/PNG/Character/Mage/Jump/jump7.png");

        mage_attack[0] = ImageLoader.loadImage("/PNG/Character/Mage/Attack_Extra/attack_extra0.png");
        mage_attack[1] = ImageLoader.loadImage("/PNG/Character/Mage/Attack_Extra/attack_extra1.png");
        mage_attack[2] = ImageLoader.loadImage("/PNG/Character/Mage/Attack_Extra/attack_extra2.png");
        mage_attack[3] = ImageLoader.loadImage("/PNG/Character/Mage/Attack_Extra/attack_extra3.png");
        mage_attack[4] = ImageLoader.loadImage("/PNG/Character/Mage/Attack_Extra/attack_extra4.png");
        mage_attack[5] = ImageLoader.loadImage("/PNG/Character/Mage/Attack_Extra/attack_extra5.png");
        mage_attack[6] = ImageLoader.loadImage("/PNG/Character/Mage/Attack_Extra/attack_extra6.png");


    }

    public void initFireAnimations() {

        fire_flying[0] = ImageLoader.loadImage("/PNG/Character/Mage/Fire_Extra/fire_extra1.png");
        fire_flying[1] = ImageLoader.loadImage("/PNG/Character/Mage/Fire_Extra/fire_extra2.png");
        fire_flying[2] = ImageLoader.loadImage("/PNG/Character/Mage/Fire_Extra/fire_extra3.png");
        fire_flying[3] = ImageLoader.loadImage("/PNG/Character/Mage/Fire_Extra/fire_extra2.png");


        fire_end[0] = ImageLoader.loadImage("/PNG/Character/Mage/Fire_Extra/fire_extra4.png");
        fire_end[1] = ImageLoader.loadImage("/PNG/Character/Mage/Fire_Extra/fire_extra5.png");
    }

    public void initWraith_01() {
        wraith_01_idle[0] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Idle/Wraith_01_Idle_000.png");
        wraith_01_idle[1] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Idle/Wraith_01_Idle_001.png");
        wraith_01_idle[2] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Idle/Wraith_01_Idle_002.png");
        wraith_01_idle[3] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Idle/Wraith_01_Idle_003.png");
        wraith_01_idle[4] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Idle/Wraith_01_Idle_004.png");
        wraith_01_idle[5] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Idle/Wraith_01_Idle_005.png");
        wraith_01_idle[6] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Idle/Wraith_01_Idle_006.png");
        wraith_01_idle[7] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Idle/Wraith_01_Idle_007.png");
        wraith_01_idle[8] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Idle/Wraith_01_Idle_008.png");
        wraith_01_idle[9] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Idle/Wraith_01_Idle_009.png");
        wraith_01_idle[10] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Idle/Wraith_01_Idle_010.png");
        wraith_01_idle[11] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Idle/Wraith_01_Idle_011.png");

        wraith_01_walk[0] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Walking/Wraith_01_Moving Forward_000.png");
        wraith_01_walk[1] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Walking/Wraith_01_Moving Forward_001.png");
        wraith_01_walk[2] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Walking/Wraith_01_Moving Forward_002.png");
        wraith_01_walk[3] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Walking/Wraith_01_Moving Forward_003.png");
        wraith_01_walk[4] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Walking/Wraith_01_Moving Forward_004.png");
        wraith_01_walk[5] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Walking/Wraith_01_Moving Forward_005.png");
        wraith_01_walk[6] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Walking/Wraith_01_Moving Forward_006.png");
        wraith_01_walk[7] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Walking/Wraith_01_Moving Forward_007.png");
        wraith_01_walk[8] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Walking/Wraith_01_Moving Forward_008.png");
        wraith_01_walk[9] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Walking/Wraith_01_Moving Forward_009.png");
        wraith_01_walk[10] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Walking/Wraith_01_Moving Forward_010.png");
        wraith_01_walk[11] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Walking/Wraith_01_Moving Forward_011.png");

        wraith_01_attack[0] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Attacking/Wraith_01_Attack_000.png");
        wraith_01_attack[1] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Attacking/Wraith_01_Attack_001.png");
        wraith_01_attack[2] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Attacking/Wraith_01_Attack_002.png");
        wraith_01_attack[3] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Attacking/Wraith_01_Attack_003.png");
        wraith_01_attack[4] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Attacking/Wraith_01_Attack_004.png");
        wraith_01_attack[5] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Attacking/Wraith_01_Attack_005.png");
        wraith_01_attack[6] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Attacking/Wraith_01_Attack_006.png");
        wraith_01_attack[7] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Attacking/Wraith_01_Attack_007.png");
        wraith_01_attack[8] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Attacking/Wraith_01_Attack_008.png");
        wraith_01_attack[9] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Attacking/Wraith_01_Attack_009.png");
        wraith_01_attack[10] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Attacking/Wraith_01_Attack_010.png");
        wraith_01_attack[11] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Attacking/Wraith_01_Attack_011.png");

        wraith_01_dying[0] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_000.png");
        wraith_01_dying[1] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_001.png");
        wraith_01_dying[2] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_002.png");
        wraith_01_dying[3] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_003.png");
        wraith_01_dying[4] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_004.png");
        wraith_01_dying[5] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_005.png");
        wraith_01_dying[6] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_006.png");
        wraith_01_dying[7] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_007.png");
        wraith_01_dying[8] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_008.png");
        wraith_01_dying[9] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_009.png");
        wraith_01_dying[10] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_010.png");
        wraith_01_dying[11] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_011.png");
        wraith_01_dying[12] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_012.png");
        wraith_01_dying[13] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_013.png");
        wraith_01_dying[14] = ImageLoader.loadImage("/PNG/Enemies/Wraith_01/Dying/Wraith_01_Dying_014.png");

    }
}
