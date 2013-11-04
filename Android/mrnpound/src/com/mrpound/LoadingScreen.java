package com.mrpound;

import com.mrpound.framework.Game;
import com.mrpound.framework.Graphics;
import com.mrpound.framework.Screen;
import com.mrpound.framework.Graphics.PixmapFormat;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
	public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("backgroundredone.png", PixmapFormat.RGB565);
        Assets.logo = g.newPixmap("logoredone.png", PixmapFormat.ARGB4444);
        Assets.mainMenu = g.newPixmap("mainmenuredone.png", PixmapFormat.ARGB4444);
        Assets.buttons = g.newPixmap("buttonsredone.png", PixmapFormat.ARGB4444);
        Assets.help1 = g.newPixmap("help1redone.png", PixmapFormat.ARGB4444);
        Assets.help2 = g.newPixmap("help2redoneredone.png", PixmapFormat.ARGB4444);
        Assets.help3 = g.newPixmap("help3redone.png", PixmapFormat.ARGB4444);
        Assets.numbers = g.newPixmap("nredone.png", PixmapFormat.ARGB4444);
        Assets.ready = g.newPixmap("readyredone.png", PixmapFormat.ARGB4444);
        Assets.pause = g.newPixmap("pausemenuredone.png", PixmapFormat.ARGB4444);
        Assets.gameOver = g.newPixmap("gameoverredone.png", PixmapFormat.ARGB4444);
        Assets.headUp = g.newPixmap("headupredone.png", PixmapFormat.ARGB4444);
        Assets.headLeft = g.newPixmap("headleftredone.png", PixmapFormat.ARGB4444);
        Assets.headDown = g.newPixmap("headdownredone.png", PixmapFormat.ARGB4444);
        Assets.headRight = g.newPixmap("headrightredone.png", PixmapFormat.ARGB4444);
        Assets.tail = g.newPixmap("tailredone.png", PixmapFormat.ARGB4444);
        Assets.stain1 = g.newPixmap("stain1redone.png", PixmapFormat.ARGB4444);
        Assets.stain2 = g.newPixmap("stain2redone.png", PixmapFormat.ARGB4444);
        Assets.stain3 = g.newPixmap("stain3redone.png", PixmapFormat.ARGB4444);
        Assets.click = game.getAudio().newSound("clickredone.ogg");
        Assets.eat = game.getAudio().newSound("eatredone.ogg");
        Assets.bitten = game.getAudio().newSound("bittenredone.ogg");
        Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game));
    }
    
    @Override
	public void present(float deltaTime) {

    }

    @Override
	public void pause() {

    }

    @Override
	public void resume() {

    }

    @Override
	public void dispose() {

    }
}
