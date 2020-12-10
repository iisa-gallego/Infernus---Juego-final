import processing.core.PApplet;
import processing.core.PImage;

public class Kruger {

	public int x;
	public int y;
	PImage kruguer;

	public Kruger(int x, int y, PApplet app) {// constructor
		this.x = 10;
		this.y = 350;
		kruguer = app.loadImage("Kruguer.png");
		
	}
	
	public void pintar(PApplet app) { // app cuenta como objeto de PApplet
		app.image(kruguer, x, y);
	}
	
	public void mover(PApplet app) {//mover con las teclas
		switch (app.key) {
		case 'd':
			this.x+=30;
			break;
		case 'a':
			this.x-=30;
			break;
		case 's':
			this.y+=30;
			break;
		case 'w':
			this.y-=30;
			break;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public static int getY() {
		return y;
	}
}
	
