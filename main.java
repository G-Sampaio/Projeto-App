package aplicacao;

import sublime_main.Jogador;
import sublimeDAO.jogadorDAO;


public class main {

	public static void main(String[] args) {
		
		Jogador jogador= new Jogador();		
		jogadorDAO jogadorDao = new jogadorDAO();
		
		jogador.setNome("Guilherme Sampaio");
		jogador.setNickname("Delta");		
		//jogadorDao.salvar(jogador);
		
		// Atualizar contato
		
		Jogador p1 = new Jogador();
		p1.setNome("Lourival Sampaio");
		p1.setNickname("Foxtrot");		
		p1.setId(1);
		
		//jogadorDao.atualizar(p1);
		
		//Deletar Contato por id
		
		jogadorDAO.deletar(2);
		
		//Visualizar Registros
		
		for(Jogador j : jogadorDAO.getJogador()) {
			System.out.printf("\nJogador: "+j.getNome() + " || Apelido: "+j.getNickname());
		
		
			
			
			
		}
		
		
		
	}

}
