package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;

public class Gnomos {
		private double x; 
		private double y;
		private int ancho; 
		private int alto; 
		private int direccion;
		private double bordeInferior;
		private double bordeSuperior;
		private double bordeIzq;
		private double bordeDer;
		private Random random = new Random();
		private Boolean seCayo;
		Image img1;
		

		public Gnomos(double x, double y, int ancho, int alto, int direccion) {
		this.x = x;
		this.y = y; 
		this.ancho = ancho; 
		this.alto = alto; 
		this.direccion = direccion; 
		this.bordeInferior= this.y + this.alto/2;
		this.bordeSuperior= this.y - this.alto/2;
		this.bordeIzq = this.x - this.ancho / 2;
		this.bordeDer = this.x + this.ancho/2;
		this.seCayo = false;
		img1 = Herramientas.cargarImagen("gnomo2.png");
	}
		public void dibujarGnomos(Entorno entorno) {
			entorno.dibujarImagen(img1, this.x, this.y, 0.0);
			//entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0 , Color.red);

		}
		
		public int azar(Entorno entorno) {
			return -1 + (2 * random.nextInt());
				
		}
		public void actualizarBordes() {
		    this.bordeInferior = this.y + this.alto / 2;
		    this.bordeSuperior = this.y - this.alto / 2;
		    this.bordeIzq = this.x - this.ancho / 2;
		    this.bordeDer = this.x + this.ancho / 2;
		}

		//public void azar(Entorno entorno) {
		//	if (Math.random() < 0.5) { 
		 //       this.x -= 0.5* direccion;
		//    } else {                                              //UNA FORMA DEL AZAR, HAY QUE MODIFICARLA PARA QUE ANDE BIEN
		 //       this.x += 0.5* direccion;
		  //  }
		//}
		public void mover(Entorno entorno) {
		    // Movimiento horizontal
		    if (direccion == -1) {
		        this.x -= 0.25;
		    } else if (direccion == 1) {
		        this.x += 0.25;
		    }
		    // Actualiza los bordes después de moverse
		    actualizarBordes();
		}
		

		public void caer() {
			this.y += 1; //la velocidad en la que baja en el eje y 
			seCayo=true;
		}
		public void cambioDireccion() {  //para que las tortugas ser mantengan en la misma isla
			if(seCayo) {
			if (direccion == -1) { 
				direccion = 1;
		    } else if (direccion == 1) { 
		    	direccion = -1;
		    }
			seCayo= false;
			}
	
		}
		public void ubicacionGnomo() {
			x += direccion;
		}
		
		public boolean colisionaAbajoGnomo(Islas[] islas) {
		    for (Islas isla : islas) {
		        if (isla != null) {
		            // Verificar si el gnomo está horizontalmente alineado con la isla
		            boolean colisionX = this.bordeDer >= isla.getBordeIzq() && 
		                                this.bordeIzq <= isla.getBordeDer();
		            // Verificar si la distancia entre el borde inferior del gnomo y el borde superior de la isla es pequeña
		            boolean colisionY = Math.abs(this.bordeInferior - isla.getBordeSuperior()) < 1;
		            // Si ambas condiciones se cumplen, hay colisión
		            if (colisionX && colisionY) {
		               // System.out.println("Colisión de gnomo detectada con isla en: " + isla.getX() + ", " + isla.getY());
		                return true; // Hay colisión
		            }
		        }
		    }
		    return false; // No hay colisión		    			    
		}
		public double getX() {
			return x;
		}
		public void setX(double x) {
			this.x = x;
		}
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y = y;
		}
		public double getAncho() {
			return ancho;
		}
		public void setAncho(int ancho) {
			this.ancho = ancho;
		}
		public double getAlto() {
			return alto;
		}
		public void setAlto(int alto) {
			this.alto = alto;
		}
		public int getDireccion() {
			return direccion;
		}
		public void setDireccion(int direccion) {
			this.direccion = direccion;
		}
		public double getBordeInferior() {
			return bordeInferior;
		}
		public void setBordeInferior(double bordeInferior) {
			this.bordeInferior = bordeInferior;
		}
		public double getBordeSuperior() {
			return bordeSuperior;
		}
		public void setBordeSuperior(double bordeSuperior) {
			this.bordeSuperior = bordeSuperior;
		}
		public double getBordeIzq() {
			return bordeIzq;
		}
		public void setBordeIzq(double bordeIzq) {
			this.bordeIzq = bordeIzq;
		}
		public double getBordeDer() {
			return bordeDer;
		}
		public void setBordeDer(double bordeDer) {
			this.bordeDer = bordeDer;
		}
		public Random getRandom() {
			return random;
		}
		public void setRandom(Random random) {
			this.random = random;
		}
		
	}

		
		
