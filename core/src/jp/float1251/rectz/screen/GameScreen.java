package jp.float1251.rectz.screen;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

import jp.float1251.rectz.Rectz;
import jp.float1251.rectz.component.PositionComponent;
import jp.float1251.rectz.component.RectRenderComponent;
import jp.float1251.rectz.input.GameInputProcessor;
import jp.float1251.rectz.tween.ShapeRenderSystem;

public class GameScreen implements Screen {
    private final Rectz game;
    private final ShapeRenderer shapeRenderer;
    private FitViewport viewport;
    private Engine engine;
    private Entity player;

    public GameScreen(Rectz game) {
        this.game = game;
        viewport = new FitViewport(960, 640);
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void show() {
        engine = new Engine();
        engine.addSystem(new ShapeRenderSystem(new ShapeRenderer(), viewport.getCamera()));
        player = new Entity();
        player.add(new PositionComponent(100, 100));
        RectRenderComponent rc = new RectRenderComponent();
        rc.height = 200;
        rc.width = 20;
        rc.color = Color.RED;
        rc.type = ShapeRenderer.ShapeType.Filled;
        player.add(rc);
        engine.addEntity(player);
        Gdx.input.setInputProcessor(new GameInputProcessor(player, viewport.getCamera()));
    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0, 1, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        viewport.getCamera().update();
        if (engine != null) {
            engine.update(delta);
        }
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
