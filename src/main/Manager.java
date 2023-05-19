package main;

public class Manager extends StoreEmployee {
	private double bonusRate;
	private double salesDone;
	private double totalStoreSales;
	
	/*
	 * Constructors:
	 * - basePay, employeeName, hourlyRate, numberOfHoursWorked, storeDetails are inherited from StoreEmployee.
	 * - bonusRate: the bonus percentage received by the manager based on the sales performance.
	 * - salesDone: the amount of sales (in Rupiah) that the manager has achieved.
	 * - totalStoreSales: the total amount of store sales (in Rupiah).
	 */
	public Manager(double basePay, String employeeName, double hourlyRate, double numberOfHoursWorked,
			String storeDetails, double salesDone, double totalStoreSales) {
		super(basePay, employeeName, hourlyRate, numberOfHoursWorked, storeDetails);
		this.bonusRate = 0;
		this.salesDone = salesDone;
		this.totalStoreSales = totalStoreSales;
	}
	
	// Getters and Setters
	public double getBonusRate() {
		return bonusRate / 100;
	}

	public void setBonusRate(double bonusRate) {
		this.bonusRate = bonusRate;
	}

	public double getSalesDone() {
		return salesDone;
	}

	public void setSalesDone(double salesDone) {
		this.salesDone = salesDone;
	}

	public double getTotalStoreSales() {
		return totalStoreSales;
	}

	public void setTotalStoreSales(double totalStoreSales) {
		this.totalStoreSales = totalStoreSales;
	}
	
	// Abstract methods implementation from StoreEmployee
	// calculatePay: calculate the manager wage by considering the number of hours worked, hourly rate, base pay, and bonus.
	@Override
	public double calculatePay() {
		if (salesDone > 2500000) {
            bonusRate = 15.0;
        } else if (salesDone > 500000 && salesDone <= 2500000) {
            bonusRate = 10.0;
        } else {
            bonusRate = 1;
        }

        return (super.getNumberOfHoursWorked() * super.getHourlyRate()
                + super.getBasePay()) * (1 + bonusRate / 100);
	}
	
	// checkPromotionEligibility: if the wage is greater than Rp5000000, then the manager deserves a promotion.
	@Override
	public boolean checkPromotionEligibility() {
		if (calculatePay() > 5000000) {
			return true;
		} else {
			return false;
		}
	}
	
	// salesPercentByManager: calculate the percentage of sales done by the manager.
	public double salesPercentByManager() {
        return (salesDone / totalStoreSales) * 100;
    }
	
	@Override
	public String getInfo() {
        return super.getInfo() + "Total Sales in store: Rp" + String.format("%.1f", totalStoreSales)
                + "\nSales done: Rp" + salesDone;
    }
}
