package com.basico.api.dto;

import com.basico.api.model.Endereco;

public class EnderecoDTO {
	
	private Long id;
	
	private String logradouro;
	
	private int numero;

	private String bairro;
	
	private String cep;

	private String cidade;

	private String estado;

	private Long clienteId;
	
	public EnderecoDTO(Long id, String logradouro, int numero, String bairro, String cep, String cidade, String estado,
			Long clienteId) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.clienteId = clienteId;
	}
	
	public static EnderecoDTO toDTO(Endereco endereco) {
		return new EnderecoDTO(
				endereco.getId(),
				endereco.getLogradouro(),
				endereco.getNumero(),
				endereco.getBairro(),
				endereco.getCep(),
				endereco.getCidade(),
				endereco.getEstado(),
				endereco.getClienteId());
	}
	
	public Endereco toEndereco() {
		return new Endereco(logradouro, numero, bairro, cep, cidade, estado, clienteId);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

}
