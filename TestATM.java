import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestATM {
	
	//Deposits
	@Test
	void testNegativeDeposit() throws Exception {
		ATM atm = new ATM(0, "USD");
		atm.deposit(-5);
		Assert.assertEquals(0, atm.checkBalance(), 0.01);
	}
	
	@Test
	void testIntDeposit() throws Exception {
		ATM atm = new ATM(0, "USD");
		atm.deposit(5);
		Assert.assertEquals(5, atm.checkBalance(), 0.01);
	}
	
	@Test
	void testFloatDeposit() throws Exception {
		ATM atm = new ATM(0, "USD");
		atm.deposit(5.50);
		Assert.assertEquals(5.50, atm.checkBalance(), 0.01);
	}
		
	//USD To other
	 @Test
	void testExchangeUSDToUSD() throws Exception {
		ATM atm = new ATM(100, "USD");
		atm.exchangeCurrency("USD");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
	}
	 @Test 
	 void testExchangeUSDToEUR() throws Exception {
		 ATM atm = new ATM(100, "USD");
		 atm.exchangeCurrency("EUR");
		 Assert.assertEquals(98, atm.checkBalance(), 0.01);
		 Assert.assertEquals("EUR", atm.checkCurrency());
		 
	 }
	 @Test
	 void testExchangeUSDToCAD() throws Exception {
		 ATM atm = new ATM(100, "USD");
		 atm.exchangeCurrency("CAD");
		 Assert.assertEquals(130, atm.checkBalance(), 0.01);
		 Assert.assertEquals("CAD", atm.checkCurrency());
		 
	 }
	 
	 @Test
	 void testBadCurrencyFromUSD() throws Exception {
		 //Only checking on exchange, so use a good currency on init
		 ATM atm = new ATM(100, "USD");
		 Assert.assertThrows(Exception.class, () -> {
			 atm.exchangeCurrency("YEN");
		    });
	 }
	 
	 //CAD to *
	 @Test
	 void testExchangeCADToCAD() throws Exception {
		 ATM atm = new ATM(100, "CAD");
		 atm.exchangeCurrency("CAD");
		 Assert.assertEquals(100, atm.checkBalance(), 0.01);
		 Assert.assertEquals("CAD", atm.checkCurrency());
	 }
	 @Test 
	 void testExchangeCADToUSD() throws Exception {
		 ATM atm = new ATM(100, "CAD");
		 atm.exchangeCurrency("USD");
		 Assert.assertEquals(70, atm.checkBalance(), 0.01);
		 Assert.assertEquals("USD", atm.checkCurrency());
		 
	 }
	 
	 @Test 
	 void testExchangeCADToEUR() throws Exception {
		 ATM atm = new ATM(100, "CAD");
		 atm.exchangeCurrency("EUR");
		 Assert.assertEquals(76, atm.checkBalance(), 0.01);
		 Assert.assertEquals("EUR", atm.checkCurrency());
		 
	 }
	 @Test
	 void testBadCurrencyFromCAD() throws Exception {
		 //Only checking on exchange, so use a good currency on init
		 ATM atm = new ATM(100, "CAD");
		 Assert.assertThrows(Exception.class, () -> {
			 atm.exchangeCurrency("YEN");
		    });
	 }
	 
	 //EUR to other
	 @Test 
	 void testExchangeEURToEUR() throws Exception{
		 ATM atm = new ATM(100, "EUR");
		 atm.exchangeCurrency("EUR");
		 Assert.assertEquals(100, atm.checkBalance(), 0.01);
		 Assert.assertEquals("EUR", atm.checkCurrency());
		 
	 }
	 @Test 
	 void testExchangeEURToCAD() throws Exception {
		 ATM atm = new ATM(100, "EUR");
		 atm.exchangeCurrency("CAD");
		 Assert.assertEquals(134, atm.checkBalance(), 0.01);
		 Assert.assertEquals("CAD", atm.checkCurrency());
	 }
	 
	 @Test 
	 void testExchangeEURToUSD() throws Exception {
		 ATM atm = new ATM(100, "EUR");
		 atm.exchangeCurrency("USD");
		 Assert.assertEquals(102, atm.checkBalance(), 0.01);
		 Assert.assertEquals("USD", atm.checkCurrency());
		 
	 }
	 
	 @Test
	 void testBadCurrencyFromEUR() throws Exception {
		 //Only checking on exchange, so use a good currency on init
		 ATM atm = new ATM(100, "EUR");
		 Assert.assertThrows(Exception.class, () -> {
			 atm.exchangeCurrency("YEN");
		    });
	 }
	 
	 
	
}
