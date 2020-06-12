$(document).ready(function () {
	
	//evento que possibilita o exibir e manipular o modal
    $('#id_da_tabela #botao_Do_Deletar').on('click', function (evento) {
        evento.preventDefault();
        var href = $(this).attr('href');
        $('#id_Do_Modal_Do_Deletar #botao_De_Deletar_Do_Modal').attr('href', href);
        $('#id_Do_Modal_Do_Deletar').modal({backdrop: 'static', keyboard: false});
    });
    
  //ação de fechar o modal depois de 2 segundos
	setTimeout(function() {
        $("#alertaRemovido").alert('close');
    }, 2000);
});