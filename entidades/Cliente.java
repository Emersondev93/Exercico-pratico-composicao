package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {
	private String nome;
	private String email;
	private LocalDate dataNasc;

	private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Cliente(String nome, String email, LocalDate dataNasc) {
		this.nome = nome;
		this.email = email;
		this.dataNasc = dataNasc;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	@Override
	public String toString() {
		return nome + ", " + email + ", " + dataNasc.format(fmt);
	}

}
