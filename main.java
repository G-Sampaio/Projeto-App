package aplicacao;

import sublime_main.Jogador;
import sublime_main.Jogo;
import sublime_main.pontuacao;
import sublimeDAO.jogadorDAO;
import sublimeDAO.jogoDAO;
import sublimeDAO.pontuacaoDAO;

import java.util.List;
import java.util.Scanner;


public class main {
	
	private static Scanner input= new Scanner(System.in);
	
	public static void main(String[] args) {
		Jogador jogador= new Jogador();		
		jogadorDAO jogadorDao = new jogadorDAO();
		Jogo jogo = new Jogo();
		jogoDAO jogoDao = new jogoDAO();
		String menu = "\n\n1-Cadastrar Jogador\n2-Atualizar Jogador\n3-Apagar Jogador\n4-Listar Jogadores\n\n5-Cadastrar Jogo\n6-Listar Jogo\n7-Atulizar Jogo\n8-Deletar Jogo\n\n9-Listar Jogador específico\n10-Listar Jogo específico\n\n11-Verificar Pontuação de Jogador\n12-Cadastrar pontuação por Id\n\nDigite 0 para Sair\n";
		
		int op;
		
		
		do{
			System.out.print("BEM VINDO AO APP SUBLIME");
			System.out.print("\nSelecione uma Opção: ");
			System.out.print(menu);
			op = Integer.parseInt(input.nextLine());
			switch (op){
			
			//          CRIAR JOGADOR
			case 1:
				System.out.print("DIGITE O NOME DO JOGADOR: ");		
				String nome = input.nextLine();
				jogador.setNome(nome);
				
				System.out.println("DIGITE O APELIDO DO JOGADOR: ");
				String nickname = input.nextLine();
				jogador.setNickname(nickname);		
				
				jogadorDao.salvar(jogador);
			break;	
			//              ATUALIZAR JOGADOR
			case 2:

				Jogador p1 = new Jogador();
				
				System.out.print("DIGITE O ID DO JOGADOR: ");		
				Integer id =  Integer.parseInt(input.nextLine());
				p1.setId(id);
				
				System.out.print("DIGITE O NOME ATUALIZADO DO JOGADOR: ");		
				String nome_att = input.nextLine();
				p1.setNome(nome_att);
				
				System.out.println("DIGITE O APELIDO ATUALIZADO DO JOGADOR: ");
				String nickname_att = input.nextLine();
				p1.setNickname(nickname_att);			
			    jogadorDao.atualizar(p1);
			break;
			//              DELETAR JOGADOR
			case 3:
				
				System.out.println("ID DO JOGADOR QUE DESEJA DELETAR: ");
			    Integer Delete_id =  Integer.parseInt(input.nextLine());
			    
				jogadorDAO.deletar(Delete_id);
			break;
			//                    VIZUALIZAR TODOS OS REGISTROS DE JOGADOR
			case 4:
			
				for(Jogador j : jogadorDAO.getJogador()) {
				System.out.printf("\nJogador: "+j.getNome() + " || Apelido: "+j.getNickname());
				System.out.printf("\n");
				System.out.printf("\n");
				
				}
			break;			
			//                    CADASTRAR JOGO
			case 5:
			
				System.out.print("DIGITE O NOME DO JOGO: ");		
				String nome_Jogo = input.nextLine();
				jogo.setNome_jogo(nome_Jogo);
			
				System.out.println("DIGITE O TEMA DO JOGO: ");
				String Tema_jogo = input.nextLine();
				jogo.setTema(Tema_jogo);
			
				System.out.print("DIGITE A PONTUAÇÃO MÁXIMA: ");		
				Integer Pontmax =  Integer.parseInt(input.nextLine());
				jogo.setPontMax(Pontmax);
					
				jogoDao.salvar_jogo(jogo);
			break;		
			//                    LISTAR JOGO
			case 6:
				
				for(Jogo jg : jogoDAO.getJogo()) {
				System.out.printf("\nJogo: "+jg.getNome_jogo() + " || Tema: "+jg.getTema()+" || Pontução Máxima: "+jg.getPontMax());
				System.out.printf("\n");
				System.out.printf("\n");
				}
			
			break;
			//                    ATUALIZAR JOGO
			case 7:
				Jogo j2 = new Jogo();
			
				System.out.print("DIGITE O ID DO JOGO PARA ATUALIZAR: ");		
				Integer id_jogo =  Integer.parseInt(input.nextLine());
				j2.setId(id_jogo);
			
				System.out.print("DIGITE O NOME DO JOGO ATUALIZADO: ");		
				String nomejg_att = input.nextLine();
				j2.setNome_jogo(nomejg_att);
			
				System.out.println("DIGITE O TEMA ATUALIZADO: ");
				String tema_att = input.nextLine();
				j2.setTema(tema_att);			
	
				System.out.print("DIGITE A PONTUAÇÃO ATUALIZADA: ");		
				Integer pont_att =  Integer.parseInt(input.nextLine());
				j2.setPontMax(pont_att);
				
				jogoDao.atualizar_jogo(j2);
			break;
			//                    DELETAR JOGO
			case 8:
		    	System.out.println("ID DO JOGO QUE DESEJA DELETAR: ");
		    	Integer Delete_id_jogo =  Integer.parseInt(input.nextLine());
		    
		    	jogoDAO.deletar_jogo(Delete_id_jogo);
		    	
		    break;
			//                    MOSTRAR JOGADOR INDUVIDUALMENTE
			case 9:
				System.out.print("DIGITE O ID DO JOGADOR QUE DESEJA VER: ");		
				Integer busca_id =  Integer.parseInt(input.nextLine());
				
				for(Jogador j1 : jogadorDAO.getJogadorid(busca_id)) {
				System.out.printf("\nJogador: "+j1.getNome() + " || Apelido: "+j1.getNickname());
				System.out.printf("\n");
				System.out.printf("\n");				
				}
			break;
			//                    MOSTRAR JOGO INDUVIDUALMENTE
			case 10:
				System.out.print("DIGITE O ID DO JOGO QUE DESEJA VER: ");		
				Integer busca_id_jogo =  Integer.parseInt(input.nextLine());
				
				for(Jogo j1 : jogoDAO.getJogoid(busca_id_jogo)) {
				System.out.printf("\nJogo: "+j1.getNome_jogo() + " || Tema: "+j1.getTema()+" || Pontução Máxima: "+j1.getPontMax());
				System.out.printf("\n");
				System.out.printf("\n");				
				}
				
			break;
			//                    MOSTRAR A PONTUÇÃO DO JOGADOR EM UM JOGO
			case 11:
			    
				System.out.print("DIGITE O NOME DO JOGO PARA VER A PONTUAÇÃO: ");
				String nome_jg = (input.nextLine());
				System.out.print("DIGITE O NOME DO JOGADOR PARA VER A PONTUAÇÃO: ");
				String nome_jgr = (input.nextLine());
			    
				List<pontuacao> pontuacoes = pontuacaoDAO.getMostrarPontuacao(nome_jgr, nome_jg);
			    for (pontuacao pontuacao : pontuacoes) {
			    	
			        System.out.printf("\nPontuacao: " + pontuacao.getMostrar_pontuacao());
			        System.out.printf("\n");
			        System.out.printf("\n");
			        
			    }

			break;
			//                    CADASTRAR A PONTUAÇÃO EM UM JOGO
			case 12:
				pontuacao pt2 = new pontuacao();
				
				System.out.print("DIGITE O ID DO JOGADOR PARA CADASTRAR A PONTUAÇÃO: ");		
				String id_jgr_pt =  (input.nextLine());
				pt2.setNome_jgr(id_jgr_pt);
			
				System.out.print("DIGITE O NOME DO JOGO QUE DESEJA CADASTRAR A PONTUAÇÃO: ");		
				String nome_jg_pt = input.nextLine();
				pt2.setNome_jg(nome_jg_pt);
				
				System.out.print("DIGITE A PONTUAÇÃO ATUALIZADA: ");		
				String add_pt =  (input.nextLine());
				pt2.setInserir_pontuacao(add_pt);
				
				pontuacaoDAO.salvar_pontuacao(pt2);
				break;
				
			default:
				System.out.println(" Você optou para Sair ou Digitou uma opção inválida! ");		
			}						
			}while (op != 0);			
		}
}