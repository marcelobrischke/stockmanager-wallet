package br.com.mb.stockmanagerwallet.kafka;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class InvoiceMessage {

	private String code;
	private Date operationDate;
	private String operation;
	private String symbol;
	private Integer quantity;
	private BigDecimal unitaryValue;
	private String username;

}