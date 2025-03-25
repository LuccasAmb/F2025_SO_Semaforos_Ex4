package controller;

import java.util.concurrent.Semaphore;

public class Corrida extends Thread{
	
	private int equipe;
	private String carro;
	private int voltas = 0;
	private int melhorTempo = Integer.MAX_VALUE;
	private static Semaphore correndo = new Semaphore(5);
	private static Semaphore[] equipesCorrendo = new Semaphore[7];
	
	static {
	    for (int i = 0; i < 7; i++) {
	        equipesCorrendo[i] = new Semaphore(1);
	    }
	}

	public Corrida(int equipe, String carro) {
		this.equipe = equipe;
		this.carro = carro;
	}

	@Override
	public void run() {
		try {
			correndo.acquire();
			equipesCorrendo[equipe].acquire();
			while(voltas < 3) {
				int tempoVolta = (int) (Math.random() * 10) + 50;
				if (tempoVolta < melhorTempo) {
	                melhorTempo = tempoVolta;
	            }
				voltas++;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			 System.out.println(carro + " da equipe #" + (equipe+1) + " concluiu suas voltas. Melhor tempo: " + melhorTempo + "s");
			 correndo.release();
			equipesCorrendo[equipe].release();
		}
		
	}

	public int getEquipe() {
		return equipe;
	}

	public String getCarro() {
		return carro;
	}

	public int getMelhorTempo() {
		return melhorTempo;
	}

	
	
	
	
	
}
