import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ATM {
	
	//double balance;
	BigDecimal balance;
	String currentCurrency;
	private final List<String> supportedCurrencyCodeList;

	{
		supportedCurrencyCodeList = Arrays.asList("USD", "CAD", "EUR");
	}

	/* Class constructor */
	/* Checking for negative inputs and non-capitalized Strings */
	public ATM(double initialBalance, String currencyCode) throws Exception {
		if (initialBalance < 0){
			balance = BigDecimal.ZERO;
		} else {
			balance = BigDecimal.valueOf(initialBalance);
		}
		String newCurrencyCode = capitalize(currencyCode);
		if (supportedCurrencyCodeList.contains(newCurrencyCode)) {
			currentCurrency = newCurrencyCode;
		} else {
			throw new UnsupportedCurrencyCodeException(newCurrencyCode + " is not a supported currency. Supported currencies are " + supportedCurrencyCodeList);
		}
	}
	
	 /* Method to check the current balance of the account */
	public double checkBalance() {
		printBalance();
		return balance.doubleValue();
	}
	
	/* Method to check the current currency in use */
	public String checkCurrency() {
		return currentCurrency;
	}
	
	/* Method to deposit (add) money to the account
	*
	*  */
	public void deposit(double depositAmount) {
		System.out.println("Depositing " + depositAmount + " " + currentCurrency);
		if (depositAmount < 0){
			return;
		}
		BigDecimal depAmount = BigDecimal.valueOf(depositAmount);
		System.out.println("Deposit amount after big decimal conversion " + depAmount);
		balance = depAmount.add(balance);
		System.out.println("new balance " + balance);


	}
	
	/* Method to withdraw (subtract) money from the account */
	public void withdraw(double withdrawalAmount) throws Exception {
		if (withdrawalAmount < 0){
			throw new NegativeInputException("Negative inputs are not allowed");
		}
		System.out.println("Withdrawing " + withdrawalAmount + " " + currentCurrency);
		balance = balance.subtract(BigDecimal.valueOf(withdrawalAmount));
		System.out.println("balance after subtraction " + balance );
	}
	
	/* Method to convert the current currency to USD, CAD, or EUR */
	public void exchangeCurrency(String desiredCurrency) throws Exception {
		String newDesiredCurrency = capitalize(desiredCurrency);
		if (supportedCurrencyCodeList.contains(newDesiredCurrency)) {
			CurrencyExchanger exchanger = new CurrencyExchanger();
			double exchangeRate = exchanger.getExchangeRate(currentCurrency, newDesiredCurrency);
			System.out.println(exchangeRate + " double value");
			currentCurrency = newDesiredCurrency;
			BigDecimal exRate = BigDecimal.valueOf(exchangeRate);
			System.out.println(exRate + " Big Decimal value");
			balance = balance.multiply(exRate);
		} else {
			throw new UnsupportedCurrencyCodeException(newDesiredCurrency + " is not a supported currency. Supported currencies are " + supportedCurrencyCodeList);

		}

	}
	
	/* Helper method that prints the current balance.
	 * You may assume this method works correctly and should not modify it. */
	public void printBalance() {
		System.out.println("Current balance: " + balance + " " + currentCurrency);
	}

	public String capitalize(String m){
		return m.toUpperCase();
	}
}
