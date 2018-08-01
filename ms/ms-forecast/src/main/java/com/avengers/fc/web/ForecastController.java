package com.avengers.fc.web;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.avengers.fc.exception.ForecastException;
import com.avengers.fc.model.CreditCardBill;
import com.avengers.fc.service.CreditCardForecastService;

@RestController
@RequestMapping("/api/card")
public class ForecastController {

	class Description {
		String version;
		String desc;
		String since;

		public String getVersion() {
			return version;
		}

		public Description setVersion(String version) {
			this.version = version;
			return this;
		}

		public String getDesc() {
			return desc;
		}

		public Description setDesc(String desc) {
			this.desc = desc;
			return this;
		}

		public String getSince() {
			return since;
		}

		public Description setSince(String since) {
			this.since = since;
			return this;
		}

	}

	@Autowired
	CreditCardForecastService creditCardForestcastService;

	@RequestMapping(value = "/p-bill", method = RequestMethod.POST)
	@ResponseBody
	public CreditCardBill predictCreditCardBill(@RequestBody Collection<CreditCardBill> creditCards) throws ForecastException {
		return creditCardForestcastService.predictData(creditCards);
	}

	@GetMapping(path = "/desc", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Description description() throws ForecastException {
		return new Description().setVersion("1.0").setSince("07/2018").setDesc("Predict the credit card bill");
	}

	@GetMapping(path = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CreditCardBill status() throws ForecastException {
		return new CreditCardBill().setAccountHolder("ATUL").setAmount(BigDecimal.TEN).setCardNumber("xxxx-xxxx-xxxx-9211")
		        .setDate(new Date());
	}
}
