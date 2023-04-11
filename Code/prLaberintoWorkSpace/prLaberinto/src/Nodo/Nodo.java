package Nodo;


import java.util.ArrayList;

public class Nodo {
	private char estado;
	private int fil;
	private int col;
	private Nodo bestprev;
	private int g, f, h;
	ArrayList<Nodo> vecinos;
	private boolean gotpath;
	
	
	public Nodo(int fil, int col) {
		this.col = col;
		this.estado = ' ';
		this.fil = fil;
		g = f = h = -1;
		gotpath = false;
		bestprev = null;
		vecinos = new ArrayList<>();
	}

	public char getEstado() {
		return estado;
	}

	public int getFil() {
		return fil;
	}

	public int getCol() {
		return col;
	}
	
	public int getHeuristica() {
		return h;
	}
	
	public void setHeuristica(int c, int f) {
		h = DistanciaManhattan(fil, col, f, c);	
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	
	private int DistanciaManhattan(int f, int c, int fo, int co) {
		return Math.abs(f-fo) + Math.abs(c-co);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(estado);
		return sb.toString();
	}
}
