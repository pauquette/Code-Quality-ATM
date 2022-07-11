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
}
