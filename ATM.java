import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ATM {
	
	BigDecimal balance;
	String currentCurrency;
	private final List<String> supportedCurrencyCodeList = Arrays.asList("USD", "CAD", "EUR");
	
	/* Class constructor */
	public ATM(double initialBalance, String currencyCode) throws Exception {
		balance = BigDecimal.valueOf(initialBalance);
		if (supportedCurrencyCodeList.contains(currencyCode)) {
			currentCurrency = currencyCode;
		} else {
			throw new UnsupportedCurrencyCodeException(currencyCode + " is not a supported currency. Supported currencies are " + supportedCurrencyCodeList.toString());
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
	
	/* Method to deposit (add) money to the account */
	public void deposit(double depositAmount) {
		BigDecimal deposit = BigDecimal.valueOf(depositAmount);
		if(deposit.compareTo(BigDecimal.ZERO) == 1) { //deposit < 0
		System.out.println("Depositing " + deposit + " " + currentCurrency);
		balance = balance.add(deposit);
		}
		else
		{
			System.out.println("Cannot deposit negative amounts.\nPlease use withdrawal instead");
		}
	}
	
	/* Method to withdraw (subtract) money from the account */
	public void withdraw(double withdrawalAmount) {
		BigDecimal withdraw = BigDecimal.valueOf(withdrawalAmount);
		if (withdraw.compareTo(BigDecimal.ZERO) == -1){ //withdraw < 0
			System.out.println("Cannot withdraw negative amounts.\nPlease use deposit instead");
			return;
			
		}
		if (balance.compareTo(withdraw) == -1) {
			System.out.println("Insufficient funds.");
			return;
		}
		System.out.println("Withdrawing " + withdraw + " " + currentCurrency);
		balance =  balance.subtract(withdraw);
	}
	
	/* Method to convert the current currency to USD, CAD, or EUR */
	public void exchangeCurrency(String desiredCurrency) throws Exception {
		CurrencyExchanger exchanger = new CurrencyExchanger();
		BigDecimal exchangeRate = BigDecimal.valueOf(exchanger.getExchangeRate(currentCurrency, desiredCurrency));
		currentCurrency = desiredCurrency;
		balance = balance.multiply(exchangeRate);
	}
	
	/* Helper method that prints the current balance.
	 * You may assume this method works correctly and should not modify it. */
	public void printBalance() {
		System.out.println("Current balance: " + balance + " " + currentCurrency);
	}
}
