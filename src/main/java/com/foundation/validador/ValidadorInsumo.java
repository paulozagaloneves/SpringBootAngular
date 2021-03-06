package com.foundation.validador;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.annotation.RequestScope;

import com.foundation.model.Insumo;
import com.foundation.service.InsumoService;
import com.foundation.validacao.Validacoes;

@Component
@RequestScope
public class ValidadorInsumo extends AbstractValidador {

	public void validarSalvar(Insumo insumo, InsumoService insumoService) {
		Validacoes validacoes = insumoService.getValidacoes();
		if (insumo.getNome() == null || StringUtils.isEmpty(insumo.getNome().trim())) {
			validacoes.adicionarValidacaoCampoObrigatorio("nome", "Campo Nome Obrigatório.");
		}
		if (insumo.getQuantidade() == null) {
			validacoes.adicionarValidacaoCampoObrigatorio("quantidade", "Campo Quantidade Obrigatório.");
		}
		if (insumo.getMedida() == null) {
			validacoes.adicionarValidacaoCampoObrigatorio("medida", "Campo Medida Obrigatório.");
		}
		
	}

	public void validarDelete(Long id, InsumoService insumoService) {
		Validacoes validacoes = insumoService.getValidacoes();
		if(insumoService.existeInsumoAssociadoAAlgumProduto(id)) {
			validacoes.adicionarValidacao("Não é possível remover o Insumo pois o mesmo se encontra associado a um Produto.");
		}
		
	}
}
