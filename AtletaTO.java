package ClubManager.Bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name ="atleta")
public class AtletaTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@SequenceGenerator(name ="sequence", sequenceName ="seq_atleta", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
	@Id
	private int id = 0;
	private String nome =null;
	private String sobrenome = null;
	private String idade = null;
	private String esporte = null;
	private String Telefone = null;
	private String altura = null;
	
	
	public AtletaTO(){
		
		
	}


	public AtletaTO(int id, String nome, String sobrenome, String idade,
			String esporte, String telefone, String altura) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.esporte = esporte;
		this.Telefone = telefone;
		this.altura = altura;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getIdade() {
		return idade;
	}


	public void setIdade(String idade) {
		this.idade = idade;
	}


	public String getEsporte() {
		return esporte;
	}


	public void setEsporte(String esporte) {
		this.esporte = esporte;
	}


	public String getTelefone() {
		return Telefone;
	}


	public void setTelefone(String telefone) {
		Telefone = telefone;
	}


	public String getAltura() {
		return altura;
	}


	public void setAltura(String altura) {
		this.altura = altura;
	}
	
	
	
	
}
