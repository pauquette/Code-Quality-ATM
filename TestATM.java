import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Executable;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestATM {

	@Test
	void testNegativeDeposit() throws Exception {
		Exception thrown = assertThrows(NegativeCurrencyException.class, () -> {
	        ATM atm = new ATM(0, "USD");
			atm.deposit(-5);
		});
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
	void testNegativeWithdraw() throws Exception {
		Exception thrown = assertThrows(NegativeCurrencyException.class, () -> {

			ATM atm = new ATM(10, "USD");
			atm.withdraw(-5);
			Assert.assertEquals(10, atm.checkBalance(), 0);
		});
	}
	@Test
	void testExchangeUSDToCAD() throws Exception {
		ATM atm = new ATM(100, "USD");
		atm.exchangeCurrency("CAD");
		Assert.assertEquals(130, atm.checkBalance(), 0.01);
		Assert.assertEquals("CAD", atm.checkCurrency());
	}
	
	@Test
	void testInvalidDesiredExchange() throws Exception {
		Exception thrown = assertThrows(UnsupportedCurrencyCodeException.class, () -> {

			ATM atm = new ATM(100, "USD");
			atm.exchangeCurrency("AUD");
			Assert.assertEquals(100, atm.checkBalance(), 0.01);
			Assert.assertEquals("USD", atm.checkCurrency());
		});
	}
	
	@Test
	void testInvalidInputExchange() throws Exception {
		Exception thrown = assertThrows(UnsupportedCurrencyCodeException.class, () -> {

			ATM atm = new ATM(100, "AUD");
		});

		
	}
	@Test
	void testValidDeposit() throws Exception {
	     ATM atm = new ATM(0, "USD");
	     atm.deposit(100);
		 Assert.assertEquals(100, atm.checkBalance(), 0);

	     
		
	}
	@Test
	void testValidWithdraw() throws Exception {
	     ATM atm = new ATM(100, "USD");
	     atm.withdraw(50);
		 Assert.assertEquals(50, atm.checkBalance(), 0);

	     
		
	}

	
	
}
