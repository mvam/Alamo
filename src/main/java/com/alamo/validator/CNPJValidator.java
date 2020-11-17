package com.alamo.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cnpjValidator")
public class CNPJValidator implements Validator {
	private final int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String cnpj = (String) value;
		if (!this.isValidCNPJ(cnpj)) {
			this.gerarExcecao();
		}

	}

	public void gerarExcecao() throws ValidatorException {
		throw new ValidatorException(
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "O CNPJ informado não é válido."));

	}

	private int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	private boolean isValidCNPJ(String CNPJ) {
		CNPJ = CNPJ.trim().replace(".", "").replace("-", "").replace("/", "");
		// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") || CNPJ.equals("22222222222222")
				|| CNPJ.equals("33333333333333") || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
				|| CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") || CNPJ.equals("88888888888888")
				|| CNPJ.equals("99999999999999") || (CNPJ.length() != 14)) {
			return false;
		}

		Integer digito1 = calcularDigito(CNPJ.substring(0, 12), this.pesoCNPJ);
		Integer digito2 = calcularDigito(CNPJ.substring(0, 12) + digito1, this.pesoCNPJ);
		return CNPJ.equals(CNPJ.substring(0, 12) + digito1.toString() + digito2.toString());
	}

}
