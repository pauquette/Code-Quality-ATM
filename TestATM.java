import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestATM {
	//ATM Creation
	@Test
	void testCADFullInt() throws Exception{
		System.out.println("Creating ATM with int value of CAD");
		ATM atm = new ATM(100, "CAD");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("CAD", atm.checkCurrency());
		System.out.println();
		
	}
	
	@Test
	void testCADFullFloat() throws Exception{
		System.out.println("Creating ATM with float value of CAD");
		ATM atm = new ATM(0.50, "CAD");
		Assert.assertEquals(0.50, atm.checkBalance(), 0.01);
		Assert.assertEquals("CAD", atm.checkCurrency());
		System.out.println();
	}
	
	@Test
	void testCADEmpty() throws Exception{
		System.out.println("Creating ATM with 0 value of CAD");
		ATM atm = new ATM(0, "CAD");
		Assert.assertEquals(0, atm.checkBalance(), 0.01);
		Assert.assertEquals("CAD", atm.checkCurrency());
		System.out.println();
	}
	
	
	@Test
	void testEURFullInt() throws Exception{
		System.out.println("Creating ATM with int value of EUR");
		ATM atm = new ATM(100, "EUR");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("EUR", atm.checkCurrency());
		System.out.println();
	}
	
	@Test
	void testEURFullFloat() throws Exception{
		System.out.println("Creating ATM with float value of EUR");
		ATM atm = new ATM(0.50, "EUR");
		Assert.assertEquals(0.50, atm.checkBalance(), 0.01);
		Assert.assertEquals("EUR", atm.checkCurrency());
		System.out.println();
		
	}
	
	@Test
	void testEUREmpty() throws Exception{
		System.out.println("Creating ATM with 0 value of EUR");
		ATM atm = new ATM(0, "EUR");
		Assert.assertEquals(0, atm.checkBalance(), 0.01);
		Assert.assertEquals("EUR", atm.checkCurrency());
		System.out.println();
		
	}
	
	@Test
	void testUSDFullInt() throws Exception{
		System.out.println("Creating ATM with int value of USD");
		ATM atm = new ATM(100, "USD");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
		System.out.println();
		
	}
	
	@Test
	void testUSDFullFloat() throws Exception{
		System.out.println("Creating ATM with float value of USD");
		ATM atm = new ATM(0.50, "USD");
		Assert.assertEquals(0.50, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
		System.out.println();
		
	}
	
	@Test
	void testUSDEmpty() throws Exception{
		System.out.println("Creating ATM with 0 value of USD");
		ATM atm = new ATM(0, "USD");
		Assert.assertEquals(0, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
		System.out.println();
		
	}
	
	
	@Test
	void testBadCurrencyFullInt() throws Exception{
		System.out.println("Creating ATM with int value of BAD");
		Assert.assertThrows(UnsupportedCurrencyCodeException.class, () -> {
			new ATM(1000, "BAD");
		    });
		System.out.println();
	}
	
	@Test
	void testBadCurrencyFullFloat() throws Exception{
		System.out.println("Creating ATM with float value of BAD");
		Assert.assertThrows(UnsupportedCurrencyCodeException.class, () -> {
			new ATM(0.50, "BAD");
		    });
		System.out.println();
	}
	
	@Test
	void testBadCurrencyEmpty() throws Exception{
		System.out.println("Creating ATM with int value of 0");
		Assert.assertThrows(UnsupportedCurrencyCodeException.class, () -> {
			new ATM(0, "BAD");
		    });
		System.out.println();
	}
	//Deposits
	@Test
	void testNegativeDeposit() throws Exception {
		System.out.println("Depositing $-5");
		ATM atm = new ATM(0, "USD");
		atm.deposit(-5);
		Assert.assertEquals(0, atm.checkBalance(), 0.01);
		System.out.println();
	}
	
	@Test
	void testIntDeposit() throws Exception {
		System.out.println("Deopsiting $5");
		ATM atm = new ATM(0, "USD");
		atm.deposit(5);
		Assert.assertEquals(5, atm.checkBalance(), 0.01);
		System.out.println();
	}
	
	@Test
	void testFloatDeposit() throws Exception {
		System.out.println("Depositing $5.50");
		ATM atm = new ATM(0, "USD");
		atm.deposit(5.50);
		Assert.assertEquals(5.50, atm.checkBalance(), 0.01);
		System.out.println();
	}
	
	//Withdrawal
	@Test
	void testNegativeWithdraw() throws Exception {
		System.out.println("Withdrawing $-5");
		ATM atm = new ATM(100, "USD");
		atm.withdraw(-5);
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		System.out.println();
	}
	
	@Test
	void testIntWithdraw() throws Exception {
		System.out.println("Withdrawing $5");
		ATM atm = new ATM(100, "USD");
		atm.withdraw(5);
		Assert.assertEquals(95, atm.checkBalance(), 0.01);
		System.out.println();
	}
	
	@Test
	void testFloatWithdraw() throws Exception {
		System.out.println("Withdrawing $5.50");
		ATM atm = new ATM(100, "USD");
		atm.withdraw(5.50);
		Assert.assertEquals(94.50, atm.checkBalance(), 0.01);
		System.out.println();
	}
	
	@Test
	void testEmptyWithdraw() throws Exception {
		System.out.println("Withdrawing $5.50 from empty account");
		ATM atm = new ATM(0, "USD");
		atm.withdraw(5.50);
		Assert.assertEquals(0, atm.checkBalance(), 0.01);
		System.out.println();
	}
	
	@Test
	void testBigWithdraw() throws Exception{
		System.out.println("Withdrwaing $500 with $100 balance");
		ATM atm = new ATM(100, "USD");
		atm.withdraw(500);
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		System.out.println();
	}
		
	//USD To other
	 @Test
	void testExchangeUSDToUSD() throws Exception {
		System.out.println("USD -> USD");
		ATM atm = new ATM(100, "USD");
		atm.exchangeCurrency("USD");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
		System.out.println();
	}
	 @Test 
	 void testExchangeUSDToEUR() throws Exception {
		 System.out.println("USD -> EUR");
		 ATM atm = new ATM(100, "USD");
		 atm.exchangeCurrency("EUR");
		 Assert.assertEquals(98, atm.checkBalance(), 0.01);
		 Assert.assertEquals("EUR", atm.checkCurrency());
		 System.out.println();
		 
	 }
	 @Test
	 void testExchangeUSDToCAD() throws Exception {
		 System.out.println("USD -> CAD");
		 ATM atm = new ATM(100, "USD");
		 atm.exchangeCurrency("CAD");
		 Assert.assertEquals(130, atm.checkBalance(), 0.01);
		 Assert.assertEquals("CAD", atm.checkCurrency());
		 System.out.println();
		 
	 }
	 
	 @Test
	 void testBadCurrencyFromUSD() throws Exception {
		 System.out.println("USD -> YEN");
		 //Only checking on exchange, so use a good currency on init
		 ATM atm = new ATM(100, "USD");
		 Assert.assertThrows(UnsupportedCurrencyCodeException.class, () -> {
			 atm.exchangeCurrency("YEN");
		    });
		 System.out.println();
	 }
	 
	 //CAD to *
	 @Test
	 void testExchangeCADToCAD() throws Exception {
		 System.out.println("CAD -> CAD");
		 ATM atm = new ATM(100, "CAD");
		 atm.exchangeCurrency("CAD");
		 Assert.assertEquals(100, atm.checkBalance(), 0.01);
		 Assert.assertEquals("CAD", atm.checkCurrency());
		 System.out.println();
	 }
	 @Test 
	 void testExchangeCADToUSD() throws Exception {
		 System.out.println("CAD -> USD");
		 ATM atm = new ATM(100, "CAD");
		 atm.exchangeCurrency("USD");
		 Assert.assertEquals(70, atm.checkBalance(), 0.01);
		 Assert.assertEquals("USD", atm.checkCurrency());
		 System.out.println();
		 
	 }
	 
	 @Test 
	 void testExchangeCADToEUR() throws Exception {
		 System.out.println("CAD -> EUR");
		 ATM atm = new ATM(100, "CAD");
		 atm.exchangeCurrency("EUR");
		 Assert.assertEquals(76, atm.checkBalance(), 0.01);
		 Assert.assertEquals("EUR", atm.checkCurrency());
		 System.out.println();
		 
	 }
	 @Test
	 void testBadCurrencyFromCAD() throws Exception {
		 System.out.println("CAD -> YEN");
		 //Only checking on exchange, so use a good currency on init
		 ATM atm = new ATM(100, "CAD");
		 Assert.assertThrows(UnsupportedCurrencyCodeException.class, () -> {
			 atm.exchangeCurrency("YEN");
		    });
		 System.out.println();
	 }
	 
	 //EUR to other
	 @Test 
	 void testExchangeEURToEUR() throws Exception{
		 System.out.println("EUR -> EUR");
		 ATM atm = new ATM(100, "EUR");
		 atm.exchangeCurrency("EUR");
		 Assert.assertEquals(100, atm.checkBalance(), 0.01);
		 Assert.assertEquals("EUR", atm.checkCurrency());
		 System.out.println();
		 
	 }
	 @Test 
	 void testExchangeEURToCAD() throws Exception {
		 System.out.println("EUR -> CAD");
		 ATM atm = new ATM(100, "EUR");
		 atm.exchangeCurrency("CAD");
		 Assert.assertEquals(134, atm.checkBalance(), 0.01);
		 Assert.assertEquals("CAD", atm.checkCurrency());
		 System.out.println();
	 }
	 
	 @Test 
	 void testExchangeEURToUSD() throws Exception {
		 System.out.println("EUR -> USD");
		 ATM atm = new ATM(100, "EUR");
		 atm.exchangeCurrency("USD");
		 Assert.assertEquals(102, atm.checkBalance(), 0.01);
		 Assert.assertEquals("USD", atm.checkCurrency());
		 System.out.println();
		 
	 }
	 
	 @Test
	 void testBadCurrencyFromEUR() throws Exception {
		 System.out.println("EUR -> YEN");
		 //Only checking on exchange, so use a good currency on init
		 ATM atm = new ATM(100, "EUR");
		 Assert.assertThrows(UnsupportedCurrencyCodeException.class, () -> {
			 atm.exchangeCurrency("YEN");
		    });
		 System.out.println();
	 }
	 
	 
	
}
