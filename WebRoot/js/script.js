$(function() {
		$("#new").click(function() {
			$("#content").load("/produtos/produtos/new");
		});
		$("#list").click(function() {
			$("#content").load("/produtos/produtos/");
		});
		$("#busca").keyup(function() {
			$("#content").load("/produtos/produtos/find/"+$("#busca").val());
		});
		$("#busca").puts("Buscar produtos por nome");
				
		$(".remove").click(function(){	
			$.get($(this).parent().find("form").attr("action")).success(function() {
				$(this).parent().parent().remove();
			});
		});

	$(".remove").click(function(){
		var url = "/produtos/produtos/remove/" + $(this).attr("id");
		var id = $(this).attr("id");
		$.ajax({
			url: url,
			type : "DELETE",
			success: function() {
				$("#produto-"+id).remove();
			},
			error: function() {
				alert("erro!");
			}
		});
	});

		
	$("#ppreco").mask("999999999999.99", {reverse: true});
	
	var messages = {}, itensObrigatoriosList = [];
	function validateForm (form) {
		$elements = $(form).find(
		"input[type != hidden], select, textarea");
		$elements.each(function() {
			var thisClass = $(this).attr("class");
			if (thisClass && thisClass.match("required")) {
				itensObrigatoriosList.push($(this).attr("name"));
			}
		});
		for ( var i = 0; i < itensObrigatoriosList.length; i++) {
			messages[itensObrigatoriosList[i]] = {
					required : ""
			};
		}		
	}

	
	
	validateForm($("#formulario"));
	$("#formulario").validate({
		messages : messages
	});

	validateForm($("#usuariosForm"));
	$('#usuariosForm').validate({
	    messages : messages
	});
	
	validateForm($("#loginForm"));
	$('#loginForm').validate({
	    messages : messages
	});
	
});

function verificaUsuario() {
	var login = $("#login").val();
	var url = "/produtos/usuarios/login/" + login;
	$.ajax({
		url: url,
		type : "GET",
		success: function(retorno) {
			if(retorno){
				$(".sucesso").hide();
				$(".erroLogin").show();
			}else{
				$(".sucesso").show();
				$(".erroLogin").hide();
			}
		},
	});
};