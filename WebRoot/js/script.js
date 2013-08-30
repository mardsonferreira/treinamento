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
	$elements = $("#formulario").find(
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

	$("#formulario").validate({
		messages : messages
	});

	$('#usuariosForm').validate({
	    messages : messages
	});
	
});