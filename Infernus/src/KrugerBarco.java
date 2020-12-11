import processing.core.PApplet;
import processing.core.PImage;

public class KrugerBarco {
	public int x;
	public int y;
	PImage kruguerB;

	public KrugerBarco(int x, int y, PApplet app) {// constructor
		this.x = 10;
		this.y = 350;
		kruguerB = app.loadImage("KrugerBarco.png");
	}
	
	public void pintar(PApplet app) { // app cuenta como objeto de PApplet
		app.image(kruguerB, x, y);
	}
	
	public void mover(PApplet app) {//mover con las teclas
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
