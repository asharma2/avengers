package com.avengers.fc.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.avengers.fc.exception.ForecastException;
import com.avengers.fc.model.CreditCardBill;

@Service
public class CreditCardForecastService implements ForecastService<CreditCardBill> {

	@Override
	public CreditCardBill predictData(byte[] tsData) throws ForecastException {
		return null;
	}

	@Override
	public CreditCardBill predictData(Collection<CreditCardBill> creditCardBills) throws ForecastException {
		Long totalTime = 0L;
		Double totalAmount = 0.0;

		String accountHolder = "";
		String cardNumber = "";
		Long lastPubTime = Long.MIN_VALUE;
		Long lastPubAmount = Long.MIN_VALUE;

		for (CreditCardBill ccb : creditCardBills) {
			totalTime += ccb.getDate().getTime();
			totalAmount += ccb.getAmount().doubleValue();
			accountHolder = ccb.getAccountHolder();
			cardNumber = ccb.getCardNumber();
			lastPubTime = ccb.getDate().getTime();
			lastPubAmount = ccb.getAmount().longValue();
		}
		int size = creditCardBills.size();

		BigDecimal meanTotalTime = BigDecimal.valueOf(totalTime).divide(new BigDecimal(size), 2, RoundingMode.HALF_UP);
		BigDecimal meanTotalAmount = BigDecimal.valueOf(totalAmount).divide(new BigDecimal(size), 2, RoundingMode.HALF_UP);

		Double squareTime = 0.0;
		Double squareAmount = 0.0;

		for (CreditCardBill ccb : creditCardBills) {
			squareAmount += Math.pow(meanTotalAmount.doubleValue() - ccb.getAmount().doubleValue(), 2);
			squareTime += Math.pow(meanTotalTime.doubleValue() - ccb.getDate().getTime(), 2);
		}

		Double sdTime = Math.sqrt(squareTime / size);
		Double sdAmount = Math.sqrt(squareAmount / size);

		return new CreditCardBill().setAccountHolder(accountHolder).setCardNumber(cardNumber)
		        .setDate(new Date(lastPubTime + sdTime.longValue()))
		        .setAmount(BigDecimal.valueOf(lastPubAmount + sdAmount.doubleValue()).multiply(BigDecimal.ONE,
		                new MathContext(2, RoundingMode.CEILING)));
	}

}
