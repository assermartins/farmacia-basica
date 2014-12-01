package br.edu.ifgoiano.farmacia.test;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifgoiano.farmacia.model.Usuario;

public class TestaListaUsuarios {
	
	public static void main(String[] args) {
		Usuario usu1 = new Usuario();
		Usuario usu2 = new Usuario();
		
		usu1.setNome("Meia Sola");
		usu2.setNome("Virgulino");
		
		List <Usuario> usus = new ArrayList<>();
		usus.add(usu1);
		usus.add(usu2);
		
		for (Usuario usuario : usus) {
			System.out.println(usuario.getNome());
		}
		
	}

}
