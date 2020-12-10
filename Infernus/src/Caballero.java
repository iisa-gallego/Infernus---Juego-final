import processing.core.PApplet;
import processing.core.PImage;

public class Caballero extends Villano {
	PImage caballero;
	protected boolean estado0, estado1;
	
	public Caballero(int x, int y,PApplet app) {
		super(x, y);
		caballero = app.loadImage("Caballero.png");
		this.estado0=true;
		this.estado1=false;
	}

	@Override
	public void pintar(PApplet app) {
		app.image(caballero, x, y);
	}
	
	public void mover () {
		if(estado0) {
			estado1=false;
			y++;
			if(y>=650) {
			estado1=true;
			}
		}
		if(estado1) {
			estado0=false;
			y--;
			if(y<=50) {
			estado0=true;
			}
		}
	}

}
