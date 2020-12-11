import processing.core.PApplet;
import processing.core.PImage;

public class Dracma {
	
	public int x;
	public int y;
	PImage plata;
	PImage oro;

	public Dracma (int x, int y,PApplet app) {
		this.x = x;
		this.y = y;
		plata = app.loadImage("DracmaPlata.png");
		oro = app.loadImage("DracmaOro.png");
	}

	public void pintar1(PApplet app) {//Dracmas de plata del nivel 1
		app.image(plata, x, y);
	}
	
	public void pintar(int x, PApplet app) {
		app.image(oro, x, y);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
