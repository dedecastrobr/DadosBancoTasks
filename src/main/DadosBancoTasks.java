package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Aluno;
import tools.Menu;
import tools.DBConnection;

public class DadosBancoTasks {
	
	public static ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
	public static List<String> opsMenuPrincipal = Arrays.asList("Inserir Aluno", "Listar Alunos", "Buscar por Matrícula");

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Bem-vindo ao exercício de banco de dados!");

		Menu menu = new Menu("Menu", opsMenuPrincipal);
		menu.show();
		
		int op = menu.getOption();
		do{
			switch(op){
			case 0:
				Aluno.create();
				break;
			case 1:
				listarAlunos();
				break;
			case 2:
				Aluno.getByMatricula();
				break;
			case 99:
				System.out.println("Tchau!");
				System.exit(0);
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}
			menu.show();
			op = menu.getOption();
		}while (op != 99);
	}

	public static void listarAlunos() {
		System.out.println("Dados dos Alunos:");
		System.out.println("================================");
		int pos = 0;
		for (Aluno aluno : listaAlunos){
			pos += 1;
			System.out.println("Número: "+ pos);
			System.out.println("================================");		
		}
	}
}
