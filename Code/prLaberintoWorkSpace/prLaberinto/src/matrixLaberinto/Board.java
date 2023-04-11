package matrixLaberinto;

import java.util.Random;

import nodo.Nodo;

public class Board {
	int FILAS = 60;
	int COLUMNAS = 80;
	double PorcentajeObs = 0.3;
	int NumObs;
	Nodo matrix[][];
	
	
	//Nodos
	Nodo init, goal;
	

	/**
	 * @param matrix
	 */
	public Board() {
		inicializarMatriz();
		NumObs = (int) (FILAS * COLUMNAS * (PorcentajeObs));
		GenerarObstaculos();
		GenerarFinal();
		GenerarInicio();
		asignarHeuristica();
		asignarvecinos();
	}
	
	private void inicializarMatriz() {
		matrix = new Nodo[FILAS][COLUMNAS];
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				matrix[i][j]=new Nodo(i, j);
			}
		}
	}

	public void GenerarObstaculos() {
		while (NumObs > 0) {
			Random rd = new Random();
			int cont = rd.nextInt((COLUMNAS * FILAS));
			boolean find = false;
			int i = 0;
			while (!find && i < FILAS) {
				int j = 0;
				while (!find && j < COLUMNAS) {
					if (cont == 0 && matrix[i][j].getEstado() != '*') {
						matrix[i][j].setEstado('*');
						NumObs--;
						find = !find;
					} else {
						cont--;
					}
					j++;
				}
				i++;
			}
		}
	}

	public void GenerarFinal() {
		Random rd = new Random();
		int y = rd.nextInt(COLUMNAS);
		int x = rd.nextInt(FILAS);

		if ( matrix[x][y].getEstado() !='*') {
			goal = matrix[x][y];
			matrix[x][y].setEstado('G');
		} else {
			throw new RuntimeException("ERROR la casilla final coincide con un obstaculo");
		}
	}

	public void GenerarInicio() {
		Random rd = new Random();
		int y = rd.nextInt(COLUMNAS);
		int x = rd.nextInt(FILAS);

		if ( matrix[x][y].getEstado()!='*' &&  matrix[x][y].getEstado()!='G') {
			init = matrix[x][y];
			matrix[x][y].setEstado('I');
		} else {
			throw new RuntimeException("ERROR la casilla inicial coincide con un obstaculo o casilla final");
		}
	}

	public int NumObstaculos() {
		int cont = 0;
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				if (matrix[i][j].getEstado()=='*') {
					cont++;
				}

			}

		}

		return cont;
	}

	public void getCasillaInicial() {
		System.out.println(init.getCol() +" "	+	init.getFil());
		

	}

	public void getCasillaFinal() {
		System.out.println(goal.getCol() +" "	+	goal.getFil());
	}

//	public void print() {
//		for (int i = 0; i < FILAS; i++) {
//			for (int j = 0; j < COLUMNAS; j++) {
//				System.out.print(matrix[i][j].toString() + " ");
//			}
//			System.out.println();
//		}
//
//	}
	
	public void asignarHeuristica() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				matrix[i][j].setHeuristica(goal.getCol(), goal.getFil());
			}
		}
	}
//	public void asignarvecinos() {
//		for (int i = 1; i < FILAS-1; i++) {
//			for (int j = 1; j < COLUMNAS-1; j++) {
//				matrix[i][j].asignarVecinos(matrix[i+1][j]);
//				matrix[i][j].asignarVecinos(matrix[i][j+1]);
//				matrix[i][j].asignarVecinos(matrix[i-1][j]);
//				matrix[i][j].asignarVecinos(matrix[i][j-1]);
//			}
//		}
//		matrix[0][0].asignarVecinos(matrix[1][0]);
//		matrix[0][0].asignarVecinos(matrix[0][1]);
//		matrix[FILAS-1][COLUMNAS-1].asignarVecinos(matrix[FILAS][COLUMNAS-2]);
//		matrix[FILAS-1][COLUMNAS-1].asignarVecinos(matrix[FILAS-2][COLUMNAS]);
//		matrix[0][COLUMNAS-1].asignarVecinos(matrix[1][COLUMNAS-1]);
//		matrix[0][COLUMNAS-1].asignarVecinos(matrix[0][COLUMNAS-2]);
//		matrix[FILAS-1][0].asignarVecinos(matrix[FILAS-2][0]);
//		matrix[FILAS-1][0].asignarVecinos(matrix[FILAS-1][1]);
//		for(int i = 1; i < FILAS-1; i++) {
//			matrix[i][0].asignarVecinos(matrix[i+1][0]);
//			matrix[i][0].asignarVecinos(matrix[i][1]);
//			matrix[i][0].asignarVecinos(matrix[i-1][0]);
//			
//			matrix[i][COLUMNAS-1].asignarVecinos(matrix[i+1][COLUMNAS-1]);
//			matrix[i][COLUMNAS-1].asignarVecinos(matrix[i][COLUMNAS-2]);
//			matrix[i][COLUMNAS-1].asignarVecinos(matrix[i-1][COLUMNAS-1]);
//		}
//		for(int j = 1; j < COLUMNAS-1; j++) {
//			matrix[0][j].asignarVecinos(matrix[0][j+1]);
//			matrix[0][j].asignarVecinos(matrix[1][j]);
//			matrix[0][j].asignarVecinos(matrix[0][j-1]);
//			
//			matrix[0][FILAS-1].asignarVecinos(matrix[FILAS-1][j+1]);
//			matrix[0][FILAS-1].asignarVecinos(matrix[FILAS-2][j]);
//			matrix[0][FILAS-1].asignarVecinos(matrix[FILAS-1][j-1]);
//		}
//	}

}
