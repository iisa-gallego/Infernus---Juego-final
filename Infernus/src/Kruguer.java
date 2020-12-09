import processing.core.PApplet;
import processing.core.PImage;

public class Kruguer {

	public int x;
	public int y;
	PImage kruguer;

	public Kruguer(int x, int y, PApplet app) {// constructor
		this.x = x;
		this.y = y;
		kruguer = app.loadImage("Kruguer.png");
		
	}
	
	public void pintar(PApplet app,int x, int y) { // app cuenta como objeto de PApplet
		app.image(kruguer, x, y);
	}
}
	
