package main;

public class SalesAssociate extends StoreEmployee{
	private final double salesRate;
	/*
	 * Constructors:
	 * - basePay, employeeName, hourlyRate, numberOfHoursWorked, storeDetails are inherited from StoreEmployee.
	 * - salesRate: the rate of sales achieved by the sales associate range from 0 to 1.
	 */
	public SalesAssociate(double basePay, String employeeName, double hourlyRate, double numberOfHoursWorked,
			String storeDetails, double salesRate) {
		super(basePay, employeeName, hourlyRate, numberOfHoursWorked, storeDetails);
		this.salesRate = salesRate;
	}
	
	// Getter
	public double getSalesRate() {
		return salesRate * 100;
	}
	
	// calculateCommission: an override method to calculate the commission that the sales associate can get.
	@Override
    public double calculateCommission() {
        if (getSalesRate() > 30) {
            return super.getBasePay() * COMMISSION_RATE;
        } else {
            return 0.0;
        }
    }
	
	// Abstract methods implementation from StoreEmployee
	// calculatePay: calculate the wage by considering the base pay, commission, number of hours worked, and hourly rate.
	@Override
	public double calculatePay() {
		return super.getBasePay() + calculateCommission() + 
                (super.getNumberOfHoursWorked() * super.getHourlyRate());
	}
	
	// checkPromotionEligibility: if the wage is greater than Rp2500000, then the sales associate deserves a promotion.
	@Override
	public boolean checkPromotionEligibility() {
		if (calculatePay() > 2500000) {
            return true;
        } else {
            return false;
        }
	}
	
	@Override
    public String getInfo() {
        return super.getInfo() + "Sales Rate: " + getSalesRate() + "%";
    }
}
