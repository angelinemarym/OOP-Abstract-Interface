package main;

public interface Store {
	// Constants
	static final double COMMISSION_RATE = 0.15;
	static final double TAX = 0.20;
	
	// calculateCommission: calculates the total amount of commissions that is received by an employee.
	public double calculateCommission();
	// calculateRemainingStoreRevenue: calculates the remaining revenue.
	public double calculateRemainingStoreRevenue(double storeSales);
}
