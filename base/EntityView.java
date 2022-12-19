package base;

import java.awt.Graphics;
import java.awt.Rectangle;

public class EntityView implements Renderable{
	protected Entity entity;
	private Rectangle area;
	public EntityView(Entity e) {
		this.entity = e;
		area = new Rectangle(entity.getArea());
	}
	public void render(Graphics g) {
		g.clearRect(area.x, area.y, area.width, area.height);
		updateArea();
	}
	public boolean update() {
		return entity.update();
	}
	protected void updateArea() {
		area.setBounds(entity.getArea());
	}
}
