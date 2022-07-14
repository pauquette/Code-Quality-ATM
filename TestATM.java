import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestATM {
	
	@Test
	void testNegativeDeposit() throws Exception {
		ATM atm = new ATM(0, "USD");
		atm.deposit(-5);
		Assertions.assertEquals(0, atm.checkBalance(), 0.01);
	}
	
	@Test
	void testExchangeUSDToUSD() throws Exception {
		ATM atm = new ATM(100, "USD");
		atm.exchangeCurrency("USD");
		Assertions.assertEquals(100, atm.checkBalance(), 0.01);
		Assertions.assertEquals("USD", atm.checkCurrency());
	}
	/* Write your tests here */

	@Test
	void testNormalDeposit() throws Exception {
		ATM atm = new ATM(105, "USD");
		atm.deposit(2.66);
		Assertions.assertEquals(107.66, atm.checkBalance(), 0.01);
	}

	@Test
	void testWithdraw() throws Exception {
		ATM atm = new ATM(55.55, "USD");
		atm.withdraw(5.550099);
		Assertions.assertEquals(49.999901, atm.checkBalance(), 0.01);
	}

	@Test
	void testMultipleDepositsAndWithdrawals() throws Exception {
		ATM atm = new ATM(100.00, "USD");
		atm.withdraw(3.3333);
		atm.deposit(3.3333);
		Assertions.assertEquals(100.0, atm.checkBalance(), 0.01);
		atm.deposit(2.22222);
		atm.withdraw(2.22222);
		Assertions.assertEquals(100.0, atm.checkBalance(), 0.01);

	}
	@Test
	void testMultipleExchanges() throws Exception {
		ATM atm = new ATM(100, "USD");
		atm.exchangeCurrency("CAD");
		Assertions.assertEquals(130.00, atm.checkBalance(), 0.01);
		atm.exchangeCurrency("EUR");
		Assertions.assertEquals(98.8, atm.checkBalance(), 0.01);
		atm.exchangeCurrency("USD");
		Assertions.assertEquals(100.776, atm.checkBalance(), 0.01);

	}

	@Test
	void testUSDtoCADtoUSD() throws Exception {
		ATM atm = new ATM(10, "USD");
		atm.exchangeCurrency("CAD");

	}

	@Test
	void unrecognizedCurrency() throws Exception {
		ATM atm = new ATM(10, "uSd");
		Assertions.assertEquals("USD", atm.checkCurrency());
		ATM atm2 = new ATM(15, "euR");
		Assertions.assertEquals("EUR", atm2.checkCurrency());
		ATM atm3 = new ATM(3, "CAd");
		Assertions.assertEquals("CAD", atm3.checkCurrency());
	}

	@Test
	void testNegativeInitialization() throws Exception {
		ATM atm = new ATM(-100.000, "USD");
		Assertions.assertEquals(0, atm.checkBalance(), 0.01);
	}

	@Test
	void exchangeUnknownCurrency() throws Exception {
		ATM atm = new ATM(40.00, "USd");
		atm.exchangeCurrency("cAd");
		Assertions.assertEquals(52.0, atm.checkBalance(), 0.01);
	}

	}
