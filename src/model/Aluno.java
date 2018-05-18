package model;

import java.sql.ResultSet;
import java.util.InputMismatchException;

import main.DadosBancoTasks;
import tools.DBConnection;

public class Aluno {

	private int idAluno = 0;
	private String nomeAluno = "";
	private String emailAluno = "";
	private String dataNasc = "";
	private long matriculaAluno = 0;

	public Aluno(long matricula) {
		
		//ResultSet que deve ser preenchido
		ResultSet rs = getByMatricula(matricula);
		
		

	}

	public Aluno() {
		System.out.println("Informe o nome do aluno: ");
		this.nomeAluno = DadosBancoTasks.scan.nextLine();

		System.out.println("Informe o e-mail do aluno: ");
		this.nomeAluno = DadosBancoTasks.scan.nextLine();
		
		System.out.println("Informe a data de nascimento do aluno: ");
		this.dataNasc = DadosBancoTasks.scan.nextLine();
		
		/*System.out.println("Informe a matricula do aluno: ");
		try {

			this.matriculaAluno = DadosBancoTasks.scan.nextLong();
			DadosBancoTasks.scan.nextLine();

		} catch (InputMismatchException e) {
			e.printStackTrace();
		}*/

	}

	public void create() {
		DBConnection conn = new DBConnection();
		conn.executeSQL("insert into Alunos(Nome,Email,DataNasc) values('" +nomeAluno+"','" +emailAluno+"','" +dataNasc+"')" );
		System.out.println("Você inseriu um Aluno com Sucesso!");
		DadosBancoTasks.listaAlunos.add(this);
	}
    public void mostraDados(){
        System.out.println("Dados Cadastrais: ");
        System.out.println("Nome: "+this.nomeAluno + " \nEmail: "+this.emailAluno + "\nData de Nascimento: "+this.dataNasc);
    }

	public ResultSet getByMatricula(long matricula) {
		// TODO Implemente seu código aqui

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