package com.alamo.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cnpjValidator")
public class CPFValidator implements Validator {
	private final int[] pesoCPF = { 9, 8, 7, 6, 5, 4, 3, 2, 9, 8, 7, 6, 5 };

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String cpf = (String) value;
		if (!this.isValidCPF(cpf)) {
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

	private boolean isValidCPF(String CPF) {
		CPF = CPF.trim().replace(".", "").replace("-", "").replace("/", "");
		// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11)) {
			return false;
		}

		Integer digito1 = calcularDigito(CPF.substring(0, 9), this.pesoCPF);
		Integer digito2 = calcularDigito(CPF.substring(0, 9) + digito1, this.pesoCPF);
		return CPF.equals(CPF.substring(0, 9) + digito1.toString() + digito2.toString());
	}

}
