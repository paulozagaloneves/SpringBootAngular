package com.foundation.validador;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.foundation.model.Usuario;
import com.foundation.service.UsuarioService;
import com.foundation.validacao.Validacoes;

@Component
@RequestScope
public class ValidadorUsuario extends AbstractValidador {

	public void validarSalvar(Usuario usuario, UsuarioService usuarioService) {
		Validacoes validacoes = usuarioService.getValidacoes();
		validarNome(usuario, validacoes);
		validarLogin(usuario, validacoes);
		validarSenha(usuario, validacoes);
		
	}

	private void validarNome(Usuario usuario, Validacoes validacoes) {
		if(StringUtils.isBlank(usuario.getNome())){
			validacoes.adicionarValidacaoCampoObrigatorio("nome", "Campo Nome Obrigatório.");
		}
	}

	private void validarLogin(Usuario usuario, Validacoes validacoes) {
		if(StringUtils.isBlank(usuario.getLogin())){
			validacoes.adicionarValidacaoCampoObrigatorio("login", "Campo Login Obrigatório.");
		}
	}
	
	private void validarSenha(Usuario usuario, Validacoes validacoes) {
		if(StringUtils.isBlank(usuario.getSenha())){
			validacoes.adicionarValidacaoCampoObrigatorio("senha", "Campo Senha Obrigatório.");
		}
	}

}
