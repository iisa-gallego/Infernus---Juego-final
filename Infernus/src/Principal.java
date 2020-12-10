
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Principal");

	}

	// Instancias
	Kruger kruger; // personaje principal
	Villano villanos;
	ArrayList<Villano> misVillanos;

	Nivel1 uno;
	/*
	 * Nivel2 dos; /*Nivel3 tres; Nivel4 cuatro; Nivel5 cinco; Nivel6 seis; Nivel7
	 * siete; Nivel8 ocho; Nivel9 nueve;
	 */

	PImage inicial;
	PImage cargar;
	boolean inicio, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9; // Para pasar de un nivel a
																							// otro
	boolean cargando;
	int reloj;// Para que dure cierto tiempo la image de cargando

	@Override
	public void settings() {
		size(1200, 700);
	}

	public void setup() {
		kruger = new Kruger(0, 0, this); // Declarar la instancia

		misVillanos = new ArrayList<Villano>();
		// Villano nivel 1
		misVillanos.add(new Caballero(350, 0, this));
		misVillanos.add(new Caballero(650, 530, this));
		misVillanos.add(new Caballero(950, 0, this));

		reloj = 0;

		inicial = loadImage("Inicio.png");
		cargar = loadImage("Cargando.png");

		uno = new Nivel1(0, 0, this);
		inicio = true;

	}

	public void draw() {
		if (inicio == true) {
			image(inicial, 0, 0);
			if (dist(mouseX, mouseY, 745, 450) < 50) {// Para que marque cuando estoy sobre el botón
				strokeWeight(5);
				stroke(255);
				noFill();
				rect(615, 415, 253, 56, 15);
			}
		}
		if (cargando == true) {
			image(cargar, 0, 0);
			reloj++;
			if (reloj == 100) {// que cambia al nivel 1
				reloj = 99;
				nivel1 = true;
			}
		}
//NIVEL 1
		if (nivel1 == true) {
			uno.pintar(this);
			kruger.pintar(this);
			for (int i = 0; i < misVillanos.size(); i++) {
				misVillanos.get(i).pintar(this); // Llamo el pintar de cada clase que tenga un comportamiento
				misVillanos.get(i).mover();
				
				if (dist(kruger.getX(), kruger.getY(), misVillanos.get(i).getX(),misVillanos.get(i).getY()) < 50) {
					kruger.setX(10);
			}
			}
		}
	}

	public void mousePressed() {
		if (dist(mouseX, mouseY, 745, 450) < 50) {// botón descender/jugar
			cargando = true;
		}
	}

	public void keyPressed() {
		kruger.mover(this);

	}

}