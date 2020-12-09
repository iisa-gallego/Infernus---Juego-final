import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet{

	public static void main(String[] args) {
		PApplet.main("Principal");
		
	}
	
	//Instancias
	Kruguer kruguer; //personaje principal
	Nivel1 uno;		
	/*Nivel2 dos;
	Nivel3 tres;
	Nivel4 cuatro;
	Nivel5 cinco;
	Nivel6 seis;
	Nivel7 siete;
	Nivel8 ocho;
	Nivel9 nueve;*/
	
	
	PImage inicial;
	PImage cargar;
	boolean inicio, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9; //Para pasar de un nivel a otro
	boolean cargando;

	
	@Override
	public void settings() {
		size(1200,700);
	}
	
	@Override
	public void setup() {
		kruguer = new Kruguer (0,0,this);		 //Declarar la instancia 
		
		inicial = loadImage("Inicio.png");	
		cargar = loadImage("Cargando.png");
		
		uno = new Nivel1 (0,0,this);
		inicio=true;
		
	}
	
	@Override
	public void draw() {
		
		if (inicio == true) {
			image(inicial, 0, 0);
		}
		if (cargando==true) {
			image(cargar, 0, 0);
		}
		
		if (nivel1 == true) {
			uno.pintar(this);
			kruguer.pintar(this,0,350);
		}

	}
	
	@Override
	public void mousePressed() {
		if (dist(mouseX, mouseY, 745,450)<50) {
			cargando=true;
		}
	}
}