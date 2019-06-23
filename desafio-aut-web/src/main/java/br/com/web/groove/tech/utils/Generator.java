package br.com.web.groove.tech.utils;

import java.util.Random;

/**
 * Classe que contem metodos de geracao de dados aleatorias.
 * 
 * @author Matheus
 *
 */
public class Generator {

	public static String gerarStringAleatoria() {
		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";

		Random random = new Random();

		String armazenaChaves = "";
		int index = -1;
		for (int i = 0; i < 7; i++) {
			index = random.nextInt(letras.length());
			armazenaChaves += letras.substring(index, index + 1);
		}
		return armazenaChaves;
	}

}
