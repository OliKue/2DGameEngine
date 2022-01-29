package gameengine.display;

import gameengine.Game;
import gameengine.graphics.Assets;
import gameengine.graphics.Text;
import gameengine.input.MouseManager;

import java.awt.*;

public class Menu {
    private static final Menu OBJ= new Menu();
    public static Menu getInstance(){
        return OBJ;
    }

    private final Rectangle playBtn = new Rectangle(24,563,250,109);
    private final Rectangle exitBtn = new Rectangle(24,693,250,109);

    public void tick(Game game){
        if(MouseManager.getInstance().isLeftPressed()){

            if(playBtn.contains(MouseManager.getInstance().getPosition())){
                game.gameState=Game.GameStates.GAME;
            }
            if(exitBtn.contains(MouseManager.getInstance().getPosition())){
                System.exit(0);
            }

        }

    }
    public void render(Graphics g){
        g.drawImage(Assets.getInstance().menuScreen, 0, 0, null);
        Text.drawString(g,"Play",149, 617, true, Color.WHITE, Assets.getInstance().font56);
        Text.drawString(g,"Exit",149, 747, true, Color.BLACK, Assets.getInstance().font56);

        g.drawRect(playBtn.x,playBtn.y,playBtn.width,playBtn.height);
        g.drawRect(exitBtn.x,exitBtn.y,exitBtn.width,exitBtn.height);
    }


}
