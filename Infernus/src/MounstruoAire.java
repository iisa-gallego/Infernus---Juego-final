import processing.core.PApplet;
import processing.core.PImage;

public class MounstruoAire extends Villano {
	PImage remolino;
	protected boolean estado0, estado1;

	public MounstruoAire(int x, int y, PApplet app) {
		super(x, y);
		remolino = app.loadImage("Remolino.png");
		this.estado0 = true;
		this.estado1 = false;
	}

	@Override
	public void pintar(PApplet app) {
		app.image(remolino, x, y);
		app.image(remolino, x, y+150);
		app.image(remolino, x, y+300);
		app.image(remolino, x, y+450);
		
	}
	
	@Override
	public void mover() {
		x-=5;
		if(x<=-50) {
			x=1000;
		}
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
