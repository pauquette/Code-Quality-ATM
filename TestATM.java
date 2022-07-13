import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestATM {

	@Test
	void testNegativeDeposit() throws Exception {
		ATM atm = new ATM(0, "USD");
		atm.deposit(-5);
		Assert.assertEquals(0, atm.checkBalance(), 0.01);
	}

	@Test
	void testExchangeUSDToUSD() throws Exception {
		ATM atm = new ATM(100, "USD");
		atm.exchangeCurrency("USD");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
	}

	/* Write your tests here */
	@Test
	void testPositiveDeposit() throws Exception {
		ATM atm = new ATM(0, "USD");
		atm.deposit(5);
		Assert.assertEquals(5, atm.checkBalance(), 0.01);
	}

	@Test
	void testNegativeWithdrawal() throws Exception {
		ATM atm = new ATM(10, "USD");
		atm.withdraw(-5);
		Assert.assertEquals(10, atm.checkBalance(), 0.01);
	}

	@Test
	void testPositiveWithdrawal() throws Exception {
		ATM atm = new ATM(10, "USD");
		atm.withdraw(5);
		Assert.assertEquals(5, atm.checkBalance(), 0.01);
	}

	@Test
	void testCheckCurrency() throws Exception {
		ATM atm = new ATM(100, "CAD");
		Assert.assertEquals("CAD", atm.checkCurrency());
	}

	@Test
	void testCheckBalance() throws Exception {
		ATM atm = new ATM(100, "CAD");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
	}

	@Test
	void testUSDToCAD() throws Exception {
		ATM atm = new ATM(100, "USD");
		atm.exchangeCurrency("CAD");
		Assert.assertEquals(130, atm.checkBalance(), 0.01);
		Assert.assertEquals("CAD", atm.checkCurrency());
	}

	@Test
	void testUSDToEUR() throws Exception {
		ATM atm = new ATM(100, "USD");
		atm.exchangeCurrency("EUR");
		Assert.assertEquals(98, atm.checkBalance(), 0.01);
		Assert.assertEquals("EUR", atm.checkCurrency());
	}

	@Test
	void testUSDError() throws Exception {
		try {
			ATM atm = new ATM(100, "USD");
			atm.exchangeCurrency("");
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(),
					" is not a supported currency to convert to. Supported currencies are: USD, CAD and EUR");
		}
	}

	@Test
	void testCADtoCAD() throws Exception {
		ATM atm = new ATM(100, "CAD");
		atm.exchangeCurrency("CAD");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("CAD", atm.checkCurrency());
	}

	@Test
	void testCADtoUSD() throws Exception {
		ATM atm = new ATM(100, "CAD");
		atm.exchangeCurrency("USD");
		Assert.assertEquals(70, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
	}

	@Test
	void testCADtoEUR() throws Exception {
		ATM atm = new ATM(100, "CAD");
		atm.exchangeCurrency("EUR");
		Assert.assertEquals(76, atm.checkBalance(), 0.01);
		Assert.assertEquals("EUR", atm.checkCurrency());
	}

	@Test
	void testCADError() throws Exception {
		try {
			ATM atm = new ATM(100, "CAD");
			atm.exchangeCurrency("");
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(),
					" is not a supported currency to convert to. Supported currencies are: USD, CAD and EUR");
		}
	}

	@Test
	void testEURtoEUR() throws Exception {
		ATM atm = new ATM(100, "EUR");
		atm.exchangeCurrency("EUR");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("EUR", atm.checkCurrency());
	}

	@Test
	void testEURtoUSD() throws Exception {
		ATM atm = new ATM(100, "EUR");
		atm.exchangeCurrency("USD");
		Assert.assertEquals(102, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
	}

	@Test
	void testEURtoCAD() throws Exception {
		ATM atm = new ATM(100, "EUR");
		atm.exchangeCurrency("CAD");
		Assert.assertEquals(134, atm.checkBalance(), 0.01);
		Assert.assertEquals("CAD", atm.checkCurrency());
	}

	@Test
	void testEURError() throws Exception {
		try {
			ATM atm = new ATM(100, "EUR");
			atm.exchangeCurrency("");
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(),
					" is not a supported currency to convert to. Supported currencies are: USD, CAD and EUR");
		}
	}

	@Test
	void testCurrencyException() throws Exception {
		try {
			ATM atm = new ATM(100, "USA");
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(),
					"USA is not a supported currency. Supported currencies are [USD, CAD, EUR]");
		}
	}
}
