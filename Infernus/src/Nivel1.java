import processing.core.PApplet;
import processing.core.PImage;

public class Nivel1 {

	public int x;
	public int y;
	PImage escenario;
	PImage persona;

	public Nivel1(int x, int y, PApplet app) {// constructor
		this.x = x;
		this.y = y;
		escenario = app.loadImage("1.png");
		persona = app.loadImage("Persona1.png");
		
	}
	
	public void pintar(PApplet app) { // app cuenta como objeto de PApplet
		app.image(escenario, x, y);
	}
}
