import processing.core.PApplet;
import processing.core.PImage;

public class Enemigonivel8 extends Villano {
	protected boolean estado0, estado1;
	
	PImage espada;
	PImage cabeza, fuego,moneda,veneno,hacha;
	
	int xespada,yespada,xcabeza,ycabeza,xfuego,yfuego,xmoneda,ymoneda,xveneno,yveneno,xhacha,yhacha;
	
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
		app.image(espada, xespada, yespada);
		
	}
	
	public void pintarcabeza(PApplet app) {
		app.image(espada, xcabeza, ycabeza);
		
	}
	
	public void pintarfuego(PApplet app) {
		app.image(espada, xfuego, yfuego);
		
	}
	
	public void pintarmoneda(PApplet app) {
		app.image(espada, xmoneda, ymoneda);
		
	}
	
	public void pintarveneno(PApplet app) {
		app.image(espada, xveneno, yveneno);
		
	}
	
	public void pintarhacha(PApplet app) {
		app.image(espada, xhacha, yhacha);
		
	}
	
	public void mover() {
		if (estado0) {
			estado1 = false;
			y += 3;
			if (y >= 570) {
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


//papitapapita

	@Override
	public void pintar(PApplet app) {
		// TODO Auto-generated method stub
		
	}
	

}
