package jp.float1251.rectz.tween;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import jp.float1251.rectz.component.PositionComponent;
import jp.float1251.rectz.component.RectRenderComponent;

public class ShapeRenderSystem extends EntitySystem {

    private final ShapeRenderer renderer;
    private final Camera camara;
    private Engine engine;

    public ShapeRenderSystem(ShapeRenderer renderer, Camera camara) {
        this.renderer = renderer;
        this.camara = camara;
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
        this.engine = engine;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        ImmutableArray<Entity> arr = engine.getEntitiesFor(
                Family.all(PositionComponent.class).one(RectRenderComponent.class).get());
        renderer.setProjectionMatrix(camara.combined);
        for (Entity entity : arr) {
            RectRenderComponent rc = entity.getComponent(RectRenderComponent.class);
            PositionComponent pos = entity.getComponent(PositionComponent.class);
            renderer.begin(rc.type);
            renderer.setColor(rc.color);
            renderer.rect(pos.position.x, pos.position.y,
                    rc.width, rc.height);
            renderer.end();
        }
    }
}
