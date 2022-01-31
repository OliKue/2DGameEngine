package gameengine.display;

import gameengine.entities.EntityManager;
import gameengine.entities.Player;
import gameengine.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Interface {

    private static final Interface OBJ= new Interface();
    private Interface(){}
    public static Interface getInstance(){
        return OBJ;
    }

    BufferedImage lifeBarBorder = Assets.getInstance().lifeBar;
    BufferedImage manaBarBorder = Assets.getInstance().manaBar;

    //128 px max
    int currentLifePx;

    //96 px max
    int currentManaPx;

    public void tick(){

        currentLifePx = (int) (((float) EntityManager.getPlayer().getLife()/(float) EntityManager.getPlayer().getMAX_LIFE())*128);
        currentManaPx = (int) (((float) EntityManager.getPlayer().getMana()/(float) EntityManager.getPlayer().getMAX_MANA())*96);

    }
    public void render(Graphics g){
        // Life
        g.drawImage(lifeBarBorder,0,0,null);
        g.setColor(Color.RED);
        for(int x = 17; x<currentLifePx+17; x++){
            g.drawLine(x,16,x,32);
        }

        // Mana
        g.drawImage(manaBarBorder,0,48,null);
        g.setColor(Color.BLUE);
        for(int x = 13; x<currentManaPx+13; x++){
            g.drawLine(x,60,x,73);
        }
    }

}
