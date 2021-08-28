package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1), // ENUMERA O STATUS, O NÚMERO SERVE PARA IDENTIFICAR O VALOR QUE VAI SAIR NO
						// BANCO DE DADOS, EVITANDO QUE ALGUÉM DESAVISADO MODIFIQUE
	// PORÉM, DESSE MOEDO, TEMOS QUE IMPLEMENTAR OS METODOS ABAIXO, SEM ONUMERO
	// PODERIA IR DIRETO
	PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);

	private int code; // exigencia explicada acima

	private OrderStatus(int code) {

		this.code = code;
	}

	public int getCode() { // faz com que o code possa ser aceitado publicamente;

		return code;
	}

	public static OrderStatus valueOf(int code) { // esse metodo vai retornar o tipoOrderStatus, ou seja, vou informar o
													// códido por exemplo 1, e ele vai me retornar o waiting payment)

		for (OrderStatus value : OrderStatus.values()) { // ele vai percorrer todos os valores para retornar o que disse
															// acima.

			if(value.getCode() == code) {
				return value;
				
			}
		}
		
		throw new IllegalArgumentException("Invalid order status code");

	}

}
