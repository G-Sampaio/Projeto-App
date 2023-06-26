package aplicacao;

import sublime_main.Jogador;
import sublimeDAO.jogadorDAO;
import java.util.Scanner;


public class main {
	private static Scanner input= new Scanner(System.in);
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Jogador jogador= new Jogador();		
		jogadorDAO jogadorDao = new jogadorDAO();
		
		System.out.print("DIGITE O NOME DO JOGADOR: ");
		
		String nome = input.nextLine();
		jogador.setNome(nome);
		
		System.out.println("DIGITE O APELIDO DO JOGADOR");
		String nickname = input.nextLine();
		
		jogador.setNickname(nickname);		
		jogadorDao.salvar(jogador);
		
		// Atualizar contato
		
		Jogador p1 = new Jogador();
		p1.setNome("Lourival Sampaio");
		p1.setNickname("Foxtrot");		
		p1.setId(1);
		
		//jogadorDao.atualizar(p1);
		
		//Deletar Contato por id
		
		//jogadorDAO.deletar(2);
		
		//Visualizar Registros
		
		//for(Jogador j : jogadorDAO.getJogador()) {
			//System.out.printf("\nJogador: "+j.getNome() + " || Apelido: "+j.getNickname());
		
		
			
			
			
		//}
		
		
		
	}

}
