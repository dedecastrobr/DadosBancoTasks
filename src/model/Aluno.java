package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.DadosBancoTasks;
import tools.DBConnection;

public class Aluno {
	
	public static ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
	public static Scanner scan = new Scanner(System.in);

	private int idAluno = 0;
	private String nomeAluno = "";
	private String emailAluno = "";
	private long matriculaAluno = 0;
	private int indice = 0;

	public Aluno(long matricula) {
		
		//ResultSet que deve ser preenchido
		ResultSet rs = getByMatricula(matricula);
		
		

	}

	public Aluno() {
		System.out.println("Informe o nome do aluno: ");
		this.nomeAluno = DadosBancoTasks.scan.nextLine();

		System.out.println("Informe o e-mail do aluno: ");
		this.emailAluno = DadosBancoTasks.scan.nextLine();

		System.out.println("Informe a matricula do aluno: ");
		try {

			this.matriculaAluno = DadosBancoTasks.scan.nextLong();
			DadosBancoTasks.scan.nextLine();

		} catch (InputMismatchException e) {
			e.printStackTrace();
		}

	}

	public void create() {
		DBConnection conn = new DBConnection();
		conn.executeSQL("insert into Alunos(Nome, Email) values('Gabriel Suterio', 'gabriel.suterio@hotmail.com')");
	}

	public ResultSet getByMatricula(long matricula) {
		long pesquisa = 0;
		System.out.println("Matrícula do aluno: ");
    	pesquisa = scan.nextLong();
    	scan.nextLine();
    	for (Aluno al : listaAlunos) {
    		if (al.getMatriculaAluno() == pesquisa){               
    			al.setIndice(listaAlunos.indexOf(al));  
    			return al;
    		}
    	} 
		return null;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}

	public Long getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(Long matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}
	
	public int getIndice() {
		return indice;
	}
	
	public void setIndice(int indice) {
		this.indice = indice;
	}
	
}