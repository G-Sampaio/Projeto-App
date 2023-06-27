package aplicacao;

import sublime_main.Jogador;
import sublime_main.Jogo;
import sublimeDAO.jogadorDAO;
import sublimeDAO.jogoDAO;

import java.util.Scanner;


public class main {
	
	private static Scanner input= new Scanner(System.in);
	
	public static void main(String[] args) {
		//Criar Contato
		
		Jogador jogador= new Jogador();		
		jogadorDAO jogadorDao = new jogadorDAO();
		Jogo jogo = new Jogo();
		jogoDAO jogoDao = new jogoDAO();
		
		//System.out.print("DIGITE O NOME DO JOGADOR: ");		
		//String nome = input.nextLine();
		//jogador.setNome(nome);
		
		//System.out.println("DIGITE O APELIDO DO JOGADOR: ");
		//String nickname = input.nextLine();
		//jogador.setNickname(nickname);		
		
		//jogadorDao.salvar(jogador);
		
		
		//Atualizar contato
		
		
		//Jogador p1 = new Jogador();
		
		//System.out.print("DIGITE O ID DO JOGADOR: ");		
		//Integer id =  Integer.parseInt(input.nextLine());
		//p1.setId(id);
		
		//System.out.print("DIGITE O NOME ATUALIZADO DO JOGADOR: ");		
		//String nome_att = input.nextLine();
		//p1.setNome(nome_att);
		
		//System.out.println("DIGITE O APELIDO ATUALIZADO DO JOGADOR: ");
		//String nickname_att = input.nextLine();
		//p1.setNickname(nickname_att);			
	    //jogadorDao.atualizar(p1);
		
		//Deletar Contato por id
	    //System.out.println("ID DO JOGADOR QUE DESEJA DELETAR: ");
	    //Integer Delete_id =  Integer.parseInt(input.nextLine());
	    
		//jogadorDAO.deletar(Delete_id);
		
		//Visualizar Todos Registros
		
		//for(Jogador j : jogadorDAO.getJogador()) {
			//System.out.printf("\nJogador: "+j.getNome() + " || Apelido: "+j.getNickname());
			
		
		//---------------------------------------------JOGO------------------------------------------------------------------------------
		//CADASTRAR JOGO
		
		
			/*System.out.print("DIGITE O NOME DO JOGO: ");		
			String nome_Jogo = input.nextLine();
			jogo.setNome_jogo(nome_Jogo);
			
			System.out.println("DIGITE O TEMA DO JOGO: ");
			String Tema_jogo = input.nextLine();
			jogo.setTema(Tema_jogo);
			
			System.out.print("DIGITE A PONTUAÇÃO MÁXIMA: ");		
			Integer Pontmax =  Integer.parseInt(input.nextLine());
			jogo.setPontMax(Pontmax);
			
			
			jogoDao.salvar_jogo(jogo);*/
			
		
			//LISTAR JOGO
		
			/*	for(Jogo jg : jogoDAO.getJogo()) {
				System.out.printf("\nJogo: "+jg.getNome_jogo() + " || Tema: "+jg.getTema()+" || Pontução Máxima: "+jg.getPontMax()); */
		
			//ATUALIZAR JOGO
		
			/*Jogo j2 = new Jogo();
		
			System.out.print("DIGITE O ID DO JOGO PARA ATUALIZAR: ");		
			Integer id =  Integer.parseInt(input.nextLine());
			j2.setId(id);
		
			System.out.print("DIGITE O NOME DO JOGO ATUALIZADO: ");		
			String nomejg_att = input.nextLine();
			j2.setNome_jogo(nomejg_att);
		
			System.out.println("DIGITE O TEMA ATUALIZADO: ");
			String tema_att = input.nextLine();
			j2.setTema(tema_att);			

			
			System.out.print("DIGITE A PONTUAÇÃO ATUALIZADA: ");		
			Integer pont_att =  Integer.parseInt(input.nextLine());
			j2.setPontMax(pont_att);
			
			jogoDao.atualizar_jogo(j2);*/
		
			//DELETAR JOGO

	    	System.out.println("ID DO JOGO QUE DESEJA DELETAR: ");
	    	Integer Delete_id =  Integer.parseInt(input.nextLine());
	    
	    	jogoDAO.deletar_jogo(Delete_id);
	    	
			
			
			
		}
		
		
		
	}
