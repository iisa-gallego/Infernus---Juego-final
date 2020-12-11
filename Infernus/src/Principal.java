
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Principal");
	}

//INSTANCIAS
	Kruger kruger;
	KrugerBarco krugerB;
	KrugerBarco sel; // el selector
	
	Dracma oro;	Dracma plata;
	
	Nivel1 uno; 	Nivel2 dos;		 Nivel3 tres; 
	Nivel4 cuatro;	Nivel5 cinco;	 Nivel6 seis;
	Nivel7 siete;	Nivel8 ocho; 	 Nivel9 nueve;
	
	Cerbero cerbero;
	
//ARREGLOS
	ArrayList<Villano> misCaballeros;
	ArrayList<Villano> misRemolinos;
	ArrayList<Villano> misFlechas;
//IMAGENSITAS
	PImage inicial;
	PImage cargar;
	PImage advertencia;
	PImage instrucciones;
	PImage text;

	boolean inicio; 
	boolean cargando; 
	int reloj;// Para que dure cierto tiempo la imagen de cargando
//BOLEAN PARA PASAR DE UN NIVEL AL OTRO
	int pantalla; 
	int xDescender, yDescender, xInstrucciones, yInstrucciones;
	
	
	@Override
	public void settings() {
		size(1200, 700);
	}

	public void setup() {
		//Coordenas del cuadro descender
		xDescender=615;
		yDescender=415;
		//Coordenas del cuadro instrucciones
		xInstrucciones=615;
		yInstrucciones=491;
		
		kruger = new Kruger(0, 0, this); // Declarar la instancia
		krugerB = new KrugerBarco (0,0, this);
		
		sel = null;
	
		plata = new Dracma (0 ,0, this);
		oro = new Dracma (0,0,this);
		
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
		misRemolinos.add(new MounstruoAire(1700, 150, this));
		misRemolinos.add(new MounstruoAire(1700, 400, this));
		//Villano nivel 2
		misFlechas = new ArrayList<Villano>();
		misFlechas.add(new ArmaCentauro(1000, 50, this));
		misFlechas.add(new ArmaCentauro(1000, 300, this));
		misFlechas.add(new ArmaCentauro(1000, 550, this));
		//Villano nivel 3
		cerbero = new Cerbero(925,0,this);
	
		//Tiempo de imagen cargando
		reloj = 0;

		//imagenes diferentes a los niveles
		inicial = loadImage("Inicio.png");
		cargar = loadImage("Cargando.png");
		advertencia = loadImage("Cuidado.png");
		instrucciones = loadImage("Instrucciones.png");
		text = loadImage("TextoDracma.png");

//LAS PANTALLAS
		inicio = true;
		uno = new Nivel1(0, 0, this);
		dos = new Nivel2(0, 0, this);
		tres = new Nivel3(0,0, this);
		cuatro = new Nivel4(0,0, this);
		cinco = new Nivel5(0,0, this);
		seis = new Nivel6(0, 0, this);
		siete = new Nivel7(0, 0, this);
		ocho = new Nivel8(0, 0, this);
		nueve = new Nivel9(0, 0, this);

	}

	public void draw() {	
//PANTALLA DE INICIO
		switch (pantalla) {
		case 0:
			image(inicial, 0, 0);
			if (dist(mouseX, mouseY, 745, 415) < 40) {// Para que marque cuando estoy sobre el botón de play
				strokeWeight(5);
				stroke(255);
				noFill();
				rect(615, 415, 253, 56, 15);
			}
			if (dist(mouseX, mouseY, 745, 520) < 40) {// Para que marque cuando estoy sobre el botón de instrucciones
				strokeWeight(5);
				stroke(255);
				noFill();
				rect(xInstrucciones, yInstrucciones, 253, 56, 15);
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
			boolean pintarDracma=true;
			uno.pintar(this);
			image (text,0,10);
			if (pintarDracma=true) {
				plata.pintar1(this);
			}
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
			if (kruger.getX()>1000) {
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
			if (kruger.getX()>1000) {//INSERTAR QUE DEBE PASAR PARA SEGUIR AL OTRO NIVEL
				pantalla=4;
				kruger.reset();
			}
			break;
//NIVEL3
		case 4:
			tres.pintar(this);
			kruger.pintar(this);
			cerbero.pintar(this);
			cerbero.mover();
			
			if (kruger.getX()>1000) {//INSERTAR QUE DEBE PASAR PARA SEGUIR AL OTRO NIVEL
				pantalla=5;
				kruger.reset();
			}
			
			break;
//NIVEL4
		case 5:
			cuatro.pintar(this);
			kruger.pintar(this);
			
			if (kruger.getX()>1000) {//INSERTAR QUE DEBE PASAR PARA SEGUIR AL OTRO NIVEL
				pantalla=7;
				kruger.reset();
			}	
			break;
//NIVEL5
		case 6:
			cinco.pintar(this);
			krugerB.pintar(this);
			
			break;
//NIVEL6
		case 7:
			seis.pintar(this);
			kruger.pintar(this);
			
			if (kruger.getX()>1000) {//INSERTAR QUE DEBE PASAR PARA SEGUIR AL OTRO NIVEL
				pantalla=8;
				kruger.reset();
			}	
			break;
//NIVEL7
		case 8:
			siete.pintar(this);
			kruger.pintar(this);	
			for (int i = 0; i < misFlechas.size(); i++) {
				misFlechas.get(i).pintar(this); // Llamo el pintar de cada clase que tenga un comportamiento
				misFlechas.get(i).mover();

				if (dist(kruger.getX(), kruger.getY(), misFlechas.get(i).getX(),misFlechas.get(i).getY()) < 100) {//Mensaje de cuidado
					image(advertencia, -10, 350);
				}
				
				if (dist(kruger.getX(), kruger.getY(), misFlechas.get(i).getX(),misFlechas.get(i).getY()) < 50) {//El choque y se devuelve
					kruger.setX(10);
				}
			}
			if (kruger.getX()>1000) {//INSERTAR QUE DEBE PASAR PARA SEGUIR AL OTRO NIVEL
				pantalla=9;
				kruger.reset();
			}		
			break;
//NIVEL8
		case 9:
			ocho.pintar(this);
			kruger.pintar(this);
			
			if (kruger.getX()>1000) {//INSERTAR QUE DEBE PASAR PARA SEGUIR AL OTRO NIVEL
				pantalla=10;
				kruger.reset();
			}	
			break;
//NIVEL9
		case 10:
			nueve.pintar(this);
			kruger.pintar(this);
			break;
//PANTALLA DE INSTRUCCIONES
		case 11:
			image(instrucciones, 0, 0);
			if(dist(mouseX, mouseY, 50, 30)<30) {
				stroke(100);
				strokeWeight(2);
				noFill();
				rect(35, 25, 65, 28);
				if(dist(mouseX, mouseY, 50, 30)<10) {
					pantalla=0;
				}
			}
			break;
		default:
			break;
		}
	}

	public void mousePressed() {
		if (dist(mouseX, mouseY, 745, 415) < 50) {// botón descender/jugar
			pantalla = 1;
		}
		if (dist(mouseX, mouseY, 745, 520) < 50) {// botón instrucciones
			pantalla = 11;
		}
		
	
		if (dist(mouseX, mouseY, krugerB.getX(), krugerB.getY())<krugerB.dist()) {
			sel = krugerB;
		}
	}

	@Override
	public void mouseDragged() {
	if(sel!=null) {
		sel.setX(mouseX);
		sel.setY(mouseY);
		}
	}
	
	@Override
	public void mouseReleased() {
	sel = null;
	}
	
	public void keyPressed() {
		kruger.mover(this);
	}

}