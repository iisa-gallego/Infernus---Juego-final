import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet{

	public static void main(String[] args) {
		PApplet.main("Principal");
		
	}
	
	Nivel1 uno;
	PImage cero;
	boolean inicio;

	
	@Override
	public void settings() {
		size(1200,700);
	}
	
	@Override
	public void setup() {
		uno = new Nivel1 (0,0,this);
		cero = loadImage("0.png");
		inicio = true;
	}
	
	@Override
	public void draw() {
		if (inicio == true) {
			image(cero, 0, 0);
		}
		
		uno.pintar(this);
	}
}