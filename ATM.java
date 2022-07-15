import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ATM {
	
	double balance;
	String currentCurrency;
	private final List<String> supportedCurrencyCodeList = Arrays.asList("USD", "CAD", "EUR");
	
	/* Class constructor */
	public ATM(double initialBalance, String currencyCode) throws Exception {
		balance = initialBalance;
		if (supportedCurrencyCodeList.contains(currencyCode)) {
			currentCurrency = currencyCode;
		} else {
			throw new UnsupportedCurrencyCodeException(currencyCode + " is not a supported currency. Supported currencies are " + supportedCurrencyCodeList.toString());
		}
	}
	
	 /* Method to check the current balance of the account */
	public double checkBalance() {
		printBalance();
		return balance;
	}
	
	/* Method to check the current currency in use */
	public String checkCurrency() {
		return currentCurrency;
	}
	
	/* Method to deposit (add) money to the account */
	public void deposit(double depositAmount) {
		System.out.println("Depositing " + depositAmount + " " + currentCurrency);
		balance += depositAmount;
	}
	
	/* Method to withdraw (subtract) money from the account */
	public void withdraw(double withdrawalAmount) {
		System.out.println("Withdrawing " + withdrawalAmount + " " + currentCurrency);
		balance--;
	}
	
	/* Method to convert the current currency to USD, CAD, or EUR */
	public void exchangeCurrency(String desiredCurrency) throws Exception {
		CurrencyExchanger exchanger = new CurrencyExchanger();
		double exchangeRate = exchanger.getExchangeRate(currentCurrency, desiredCurrency);
		currentCurrency = desiredCurrency;
		balance = balance * exchangeRate;
	}
	
	/* Helper method that prints the current balance.
	 * You may assume this method works correctly and should not modify it. */
	public void printBalance() {
		System.out.println("Current balance: " + balance + " " + currentCurrency);
	}
}
