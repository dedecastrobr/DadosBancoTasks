package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.DadosBancoTasks;
import tools.DBConnection;

public class Aluno {
	
	private Connection conn = null;
	
	public static ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
	public static Scanner scan = new Scanner(System.in);

	private int idAluno = 0;
	private String nomeAluno = "";
	private String emailAluno = "";
	private long matriculaAluno = 0;

	public Aluno(long matricula) {
		
		//ResultSet que deve ser preenchido
		ResultSet rs = getByMatricula(matricula);
		Statement stmt = null;

		try {

			stmt = conn.createStatement();
			if (stmt.execute(mz)) {
				rs = stmt.getResultSet();
				while (rs.next()) {
					System.out.println(rs.getString(2));
				}
				System.out.println(rs);
			} else {
				int count = stmt.getUpdateCount();
				if (count == 1) {
					System.out.println("Registro Inserido com sucesso!");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public void create(String sql) {
		conn.dbt = ("insert into Alunos(Nome, Email, Matricula) values('"+this.nomeAluno+"','"+ this.emailAluno+"', "+this.matriculaAluno+")");
		
	}

	public ResultSet getByMatricula(long matricula) {
		System.out.println("Matrícula do aluno: ");
		long m = scan.nextLong();
    	scan.nextLine();
    	Aluno aluno = new Aluno(m);
    		if (aluno.getNomeAluno().isEmpty()){               
    			System.out.println("Deu ruim!");
    		}else {
    			System.out.println("Deu bom!");
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
	
}