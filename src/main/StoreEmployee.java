package main;

public abstract class StoreEmployee implements Employee, Store{
	private double basePay;
	String employeeName;
	private double hourlyRate;
	private double numberOfHoursWorked;
	private String storeDetails;
	
	/*
	 * Constructors:
	 * - basePay: base wage that the employee gets.
	 * - employeeName: name of the employee
	 * - hourlyRate: the amount of money the employee make for each hour of work.
	 * - numberOfHoursWorked: employee's amount of hour work.
	 * - storeDetails: store details (store name or other info)
	 */
	public StoreEmployee(double basePay, String employeeName, double hourlyRate, double numberOfHoursWorked,
			String storeDetails) {
		super();
		this.basePay = basePay;
		this.employeeName = employeeName;
		this.hourlyRate = hourlyRate;
		this.numberOfHoursWorked = numberOfHoursWorked;
		this.storeDetails = storeDetails;
	}
	
	// Getters and Setters
	public double getBasePay() {
		return basePay;
	}

	public void setBasePay(double basePay) {
		this.basePay = basePay;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double getNumberOfHoursWorked() {
		return numberOfHoursWorked;
	}

	public void setNumberOfHoursWorked(double numberOfHoursWorked) {
		this.numberOfHoursWorked = numberOfHoursWorked;
	}

	public String getStoreDetails() {
		return storeDetails;
	}

	public void setStoreDetails(String storeDetails) {
		this.storeDetails = storeDetails;
	}
	
	// Implements methods from Employee and Store interfaces.
	@Override
	public double calculateCommission() {
		return 0;
	}
	
	@Override
    public abstract double calculatePay();
	
	// calculateRemainingStoreRevenue: calculate store profits after deduct the storeSales with tax and employee wage.
	@Override
    public double calculateRemainingStoreRevenue(double storeSales) {
        double employeePay = calculatePay();
        double storeRevenue = 0;

        storeRevenue = storeSales * (1 - TAX) - employeePay;

        if (storeSales > 2550000) {
            storeRevenue = (1 - 0.05) * storeRevenue;
        } else if (storeSales > 1550000 && storeSales <= 2550000) {
            storeRevenue = (1 - 0.03) * storeRevenue;
        } else {
            storeRevenue = (1 - 0.01) * storeRevenue;
        }
        return storeRevenue;
    }
	
	@Override
    public abstract boolean checkPromotionEligibility();
	
	// getInfo: return a string that consists of all basic information about the employee
	public String getInfo() {
		return "Store Details: " + storeDetails + "\nEmployee Name: " + employeeName
                + "\nBase Pay: Rp" + basePay + "\nNumber of Hours worked: " + numberOfHoursWorked + "hrs"
                + "\nPayment Rate per hour: Rp" + hourlyRate + "/hr\n";
	}
}
