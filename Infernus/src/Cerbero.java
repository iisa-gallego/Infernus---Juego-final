import processing.core.PApplet;
import processing.core.PImage;

public class Cerbero extends Villano {
	PImage cerbero;
	protected boolean estado0, estado1;
	
	public Cerbero(int x, int y,PApplet app) {
		super(x, y);
		cerbero = app.loadImage("Cerbero.png");
		this.estado0 = true;
		this.estado1 = false;
	}

	@Override
	public void pintar(PApplet app) {
		app.image(cerbero, x, y);

	}
	public void mover() {
		if (estado0) {
			estado1 = false;
			y += 5;
			if (y >= 550) {
				estado1 = true;
			}
		}
		if (estado1) {
			estado0 = false;
			y -= 5;
			if (y <= 20) {
				estado0 = true;
			}
		}
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
