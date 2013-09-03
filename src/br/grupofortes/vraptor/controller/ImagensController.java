package br.grupofortes.vraptor.controller;

import java.io.File;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.validator.Validations;
import br.grupofortes.vraptor.model.Imagens;
import br.grupofortes.vraptor.model.Produto;
import br.com.caelum.vraptor.Validator;
import static org.hamcrest.Matchers.*; 

@Resource
public class ImagensController {
	private final Validator validator;
	private final Imagens imagens;
	private final Result result;
	
	
	public ImagensController(Validator validator, Imagens imagens, Result result) {
		super();
		this.validator = validator;
		this.imagens = imagens;
		this.result = result;
	}



	@Post("/{id}/imagem")
	public void upload(Produto produto, final UploadedFile imagem ){
		validator.checking(new Validations(){{
			
			if (that(imagem, is(notNullValue()), "imagem",
					"Adicione uma imagem")) {
					that(imagem.getContentType(),
					startsWith("image"), "imagem", "Selecione uma imagem");
					}
			
		}});
		
			validator.onErrorRedirectTo(ProdutosController.class).formulario();
		//	imagens.salva(imagem, produto);
			result.redirectTo(ProdutosController.class).produtos();	
	}
	
	@Get("/{id}/imagem")
	public File download(Produto produto){
	 return imagens.carrega(produto);	
	}
	

}
