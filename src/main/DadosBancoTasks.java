package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Aluno;
import tools.DBConnection;

public class DadosBancoTasks {

	public static ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		DBConnection conn = new DBConnection();
		System.out.println("Bem-vindo ao exercício de banco de dados!");
		
		Aluno al = new Aluno();
		
		al.create();
	}

	public static void listarAlunos() {

		// TODO Implemente uma listagem dos alunos cadastrados no banco.
		System.out.println("Lista de Alunos");
		System.out.println("-----------------------------------------------");
		for (Aluno a : listaAlunos) {
			a.mostraDados();
			System.out.println("-----------------------------------------------");
		}
	}

}
