import processing.core.PApplet;
import processing.core.PImage;

public class Enemigonivel8 extends Villano {
	protected boolean estado0, estado1;

	PImage espada;
	PImage cabeza, fuego, moneda, veneno, hacha;

	int xespada, yespada, xcabeza, ycabeza, xfuego, yfuego, xmoneda, ymoneda, xveneno, yveneno, xhacha, yhacha;

	public Enemigonivel8(int x, int y, PApplet app) {
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

	public void moverespada() {
		if (estado0) {
			estado1 = false;
			yespada += 3;
			if (y >= 720) {
				estado1 = true;
			}
		}
		if (estado1) {
			estado0 = false;
			yespada = -50;
			if (y <= 40) {
				estado0 = true;
			}
		}
	}
	
	public void movercabeza() {
		if (estado0) {
			estado1 = false;
			ycabeza += 3;
			if (y >= 720) {
				estado1 = true;
			}
		}
		if (estado1) {
			estado0 = false;
			ycabeza = -50;
			if (y <= 40) {
				estado0 = true;
			}
		}
	}
	
	public void moverfeugo() {
		if (estado0) {
			estado1 = false;
			yfuego += 3;
			if (y >= 720) {
				estado1 = true;
			}
		}
		if (estado1) {
			estado0 = false;
			yfuego = -50;
			if (y <= 40) {
				estado0 = true;
			}
		}
	}

	public void moverveneno() {
		if (estado0) {
			estado1 = false;
			yveneno += 3;
			if (y >= 720) {
				estado1 = true;
			}
		}
		if (estado1) {
			estado0 = false;
			yveneno = -50;
			if (y <= 40) {
				estado0 = true;
			}
		}
	}
	
	public void moverhacha() {
		if (estado0) {
			estado1 = false;
			yhacha += 3;
			if (y >= 720) {
				estado1 = true;
			}
		}
		if (estado1) {
			estado0 = false;
			yhacha = -50;
			if (y <= 40) {
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
