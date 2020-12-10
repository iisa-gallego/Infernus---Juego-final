import processing.core.PApplet;

public abstract class Villano {

	protected int x,y;
	
	
	public Villano() {
		this.x = (int) (Math.random()*200); 
		this.y = (int) (Math.random()*600);
	}
	public Villano (int x, int y) {
		this.x=x;
		this.y=y;
		}
	public abstract void pintar(PApplet app);
	
	public void mover() {
		x++;
		y++;	
	}
}
