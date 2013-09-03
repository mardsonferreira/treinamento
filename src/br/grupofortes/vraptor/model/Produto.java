package br.grupofortes.vraptor.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.apache.commons.io.IOUtils;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;

@Entity
public class Produto {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	private String nome;

	@NotEmpty
	private String descricao;

	@NotNull
	@DecimalMin(value="0")
	private Double preco;
	
	private String image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Produto(String nome, String descricao, Double preco) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Produto() {
		super();
	}

	public void salvaImagem(UploadedFile imagem, String nome){
		String caminhoImagens = "C:/Users/mardsonferreira/Workspaces/MyEclipse 10/treinamento/WebRoot/WEB-INF/images/";
		File pastaImagens = new File(caminhoImagens);
		pastaImagens.mkdir();
		File destino = new File(pastaImagens, nome);
		try {
			IOUtils.copy(imagem.getFile(), new FileOutputStream(destino));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			throw new RuntimeException("Erro ao copiar imagem", e);
		}
	}
	
	
	public void removerImagem(String nome){
		String caminhoImagens = "C:/Users/mardsonferreira/Workspaces/MyEclipse 10/treinamento/WebRoot/WEB-INF/images/";
		File imagem = new File(caminhoImagens, nome);
		if(imagem.exists() && imagem.delete()){
		   System.out.println("imagem excluída com sucesso");	
		}
	}
	
}
