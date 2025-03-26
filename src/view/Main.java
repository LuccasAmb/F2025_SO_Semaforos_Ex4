package view;

import java.util.Arrays;
import java.util.Comparator;

import br.edu.fateczl.sort.MergeSort;
import controller.Corrida;

public class Main {

	public static void main(String[] args) {
		
		Corrida[] carros = new Corrida[14];
		
		for(int i = 0; i < 7; i++) {
			carros[i * 2] = new Corrida(i, "Ferrari");
			carros[i * 2 + 1] = new Corrida(i, "Celta");
			carros[i * 2].start();
			carros[i * 2 +1].start();
			
		}
		

		for (Corrida carro : carros) {
            try {
                carro.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Arrays.sort(carros, Comparator.comparingInt(Corrida::getMelhorTempo));

        System.out.println("\n GRID DE LARGADA:");
        for (int i = 0; i < carros.length; i++) {
            System.out.println((i + 1) + "º - " + carros[i].getCarro() + " da equipe #" + (carros[i].getEquipe() + 1) 
                               + " - Melhor volta: " + carros[i].getMelhorTempo() + "s");
        }
		
		

	}

}
