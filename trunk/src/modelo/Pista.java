package modelo;

import java.util.ArrayList;

public class Pista {
	/*
	 * carga la pista desde el archivo XML pasado por par�metro
	 */
	public void cargarPista(String ubicacion){
		//@todo
	}
	
	/*
	 * crea una pista aleatoria en base a la dificultad, hardcodeada en ints :D
	 * fuera de joda: pensar c�mo dejarlo m�s lindo
	 */
	public void aleatoria(int dificultad){
		switch (dificultad){
		case 1 : this.aleatoriaFacil(); break;
		case 2 : this.aleatoriaMedia(); break;
		case 3 : this.aleatoriaDificil(); 
		}
	}
	
	/*
	 * devuelve el tipo de terreno en la posici�n pasada como par�metro
	 */
	public Terreno getTerreno(Posicion posicion){
		//@todo
		return null;
	}
	
	/*
	 * devuelve la lista de obstaculos, ordenada por posicion.y
	 * o devuelve una lista de listas de obstaculos (una por carril), ordenada
	 */
	public ArrayList<Obstaculo> getObstaculos(){
		//@todo
		return null;
	}
	
	private void aleatoriaDificil() {
		// TODO Auto-generated method stub
		
	}

	private void aleatoriaMedia() {
		// TODO Auto-generated method stub
		
	}

	private void aleatoriaFacil() {
		// TODO Auto-generated method stub
		
	}
	
	
}
