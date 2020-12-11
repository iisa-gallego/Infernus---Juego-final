
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Principal");

	}

//INSTANCIAS
	Kruger kruger;
	Nivel1 uno;
	Nivel2 dos; 
	/*Nivel3 tres; Nivel4 cuatro; Nivel5 cinco; Nivel6 seis; */
	Nivel7 siete;
	 /*siete; Nivel8 ocho; Nivel9 nueve;
	 */
//ARREGLOS
	ArrayList<Villano> misCaballeros;
	ArrayList<Villano> misRemolinos;
//IMAGENSITAS
	PImage inicial;
	PImage cargar;
	PImage advertencia;

	boolean inicio; 
	boolean cargando; 
	int reloj;// Para que dure cierto tiempo la imagen de cargando
//BOLEAN PARA PASAR DE UN NIVEL AL OTRO
	int pantalla; 

	@Override
	public void settings() {
		size(1200, 700);
	}

	public void setup() {
		kruger = new Kruger(0, 0, this); // Declarar la instancia
	
		// Villano nivel 1
		misCaballeros = new ArrayList<Villano>();
		misCaballeros.add(new Caballero(350, 0, this));
		misCaballeros.add(new Caballero(650, 530, this));
		misCaballeros.add(new Caballero(950, 0, this));
		//Villano nivel 2
		misRemolinos = new ArrayList<Villano>();
		misRemolinos.add(new MounstruoAire(1000, 50, this));
		misRemolinos.add(new MounstruoAire(1000, 250, this));
		misRemolinos.add(new MounstruoAire(1000, 500, this));
		misRemolinos.add(new MounstruoAire(1500, 150, this));
		misRemolinos.add(new MounstruoAire(1500, 400, this));
	
		//Tiempo de imagen cargando
		reloj = 0;

		//imagenes diferentes a los niveles
		inicial = loadImage("Inicio.png");
		cargar = loadImage("Cargando.png");
		advertencia = loadImage("Cuidado.png");

//LAS PANTALLAS
		inicio = true;
		uno = new Nivel1(0, 0, this);
		dos = new Nivel2(0, 0, this);
		siete = new Nivel7(0, 0, this);

	}

	public void draw() {	
//PANTALLA DE INICIO
		switch (pantalla) {
		case 0:
			image(inicial, 0, 0);
			if (dist(mouseX, mouseY, 745, 450) < 50) {// Para que marque cuando estoy sobre el bot�n
				strokeWeight(5);
				stroke(255);
				noFill();
				rect(615, 415, 253, 56, 15);
			}
			break;
//PANTALLA DE CARGANDO
		case 1:
			image(cargar, 0, 0);
			reloj++;
			if (reloj == 100) {// que cambia al nivel 1
				reloj = 99;
				pantalla = 2;
			}
			break;
//NIVEL 1	
		case 2:
			uno.pintar(this);
			kruger.pintar(this);
			for (int i = 0; i < misCaballeros.size(); i++) {
				misCaballeros.get(i).pintar(this); // Llamo el pintar de cada clase que tenga un comportamiento
				misCaballeros.get(i).mover();

				if (dist(kruger.getX(), kruger.getY(), misCaballeros.get(i).getX(),misCaballeros.get(i).getY()) < 100) {//Mensaje de cuidado
					image(advertencia, -10, 350);
				}
				
				if (dist(kruger.getX(), kruger.getY(), misCaballeros.get(i).getX(),misCaballeros.get(i).getY()) < 50) {//El choque y se devuelve
					kruger.setX(10);
				}
			}
			if (kruger.getX()>1050) {
				pantalla=3;
				kruger.reset();
			}
			break;
//NIVEL 2
		case 3:
			dos.pintar(this);
			kruger.pintar(this);
			for (int i = 0; i < misRemolinos.size(); i++) {
				misRemolinos.get(i).pintar(this); // Llamo el pintar de cada clase que tenga un comportamiento
				misRemolinos.get(i).mover();

				if (dist(kruger.getX(), kruger.getY(), misRemolinos.get(i).getX(),misRemolinos.get(i).getY()) < 100) {//Mensaje de cuidado
					image(advertencia, -10, 350);
				}
				
				if (dist(kruger.getX(), kruger.getY(), misRemolinos.get(i).getX(),misRemolinos.get(i).getY()) < 50) {//El choque y se devuelve
					kruger.setX(10);
				}
			}
			if (kruger.getX()>1050) {
				pantalla=7;
				kruger.reset();
			}
			break;
//NIVEL3
		case 4:
			
			break;
//NIVEL4
		case 5:
			
			break;
//NIVEL5
		case 6:
			
			break;
//NIVEL6
		case 7:
			siete.pintar(this);
			kruger.pintar(this);	
			break;
//NIVEL7
		case 8:
						
			break;
		default:
			break;
		}
	}

	public void mousePressed() {
		if (dist(mouseX, mouseY, 745, 450) < 50) {// bot�n descender/jugar
			pantalla = 1;
		}
	}

	public void keyPressed() {
		kruger.mover(this);
	}

}