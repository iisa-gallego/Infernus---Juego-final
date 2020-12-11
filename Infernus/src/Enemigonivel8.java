import processing.core.PApplet;
import processing.core.PImage;

public class Enemigonivel8 extends Villano {
	protected boolean estado0, estado1;
	
	PImage espada;
	PImage cabeza, fuego,moneda,veneno,hacha;
	
	
	
	public Enemigonivel8(int x, int y,PApplet app) {
		super(x, y);
		espada = app.loadImage("Flechas.png");
		cabeza = app.loadImage("cabeza.png");
		fuego = app.loadImage("fuego8.png");
		moneda = app.loadImage("monedafalsa.png");
		veneno = app.loadImage("veneno.png");
		hacha = app.loadImage("Hacha.png");
		this.estado0 = true;
		this.estado1 = false;
	
	}



	
	public void pintarespada(PApplet app) {
		app.image(espada, x, y);
		
	}
	
	public void pintarcabeza(PApplet app) {
		app.image(espada, x, y);
		
	}
	
	public void pintarfuego(PApplet app) {
		app.image(espada, x, y);
		
	}
	
	public void pintarmoneda(PApplet app) {
		app.image(espada, x, y);
		
	}
	
	public void pintarveneno(PApplet app) {
		app.image(espada, x, y);
		
	}
	
	public void pintarhacha(PApplet app) {
		app.image(espada, x, y);
		
	}




	@Override
	public void pintar(PApplet app) {
		// TODO Auto-generated method stub
		
	}
	

}
