package jp.float1251.rectz.screen;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by takahiroiwatani on 2015/05/11.
 */
public class GameScreen implements Screen {
    private Engine engine;
    private FitViewport viewport;

    @Override
    public void show() {
        engine = new Engine();
        viewport = new FitViewport(640, 960);
    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0, 1, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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

    }
}
