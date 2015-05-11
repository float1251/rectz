package jp.float1251.rectz.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

import jp.float1251.rectz.Rectz;

/**
 * Created by takahiroiwatani on 2015/05/11.
 */
public class TitleScreen implements Screen{

    private final Rectz game;
    private Stage stage;
    private Texture img;

    public TitleScreen(Rectz game){
        this.game = game;
    }


    @Override
    public void show() {
        FitViewport viewport = new FitViewport(640, 960);
        stage = new Stage(viewport);
        img = new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(1, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();

        if(Gdx.input.isTouched()){
            Gdx.app.log("test", "touch");
            game.switchScreen(new GameScreen());
        }
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
