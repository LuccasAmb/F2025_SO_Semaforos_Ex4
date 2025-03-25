package view;

import br.edu.fateczl.sort.MergeSort;
import controller.Corrida;

public class Main {

	public static void main(String[] args) {
		
		Corrida[] carros = new Corrida[14];
		
		for(int i = 0; i < 7; i++) {
			carros[i] = new Corrida(i, "Ferrari");
			carros[i+1] = new Corrida(i, "Celta");
			carros[i].start();
			carros[i+1].start();
			
		}
		
		MergeSort merge = new MergeSort();
		
		

	}

}
