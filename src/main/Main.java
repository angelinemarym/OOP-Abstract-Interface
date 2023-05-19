package main;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * This is a program to calculate and report employees' payment in a store. There are two types of employee, which are manager and sales associate.
 * Each of the type has different calculation of wage. Thus, to cover the differences, interfaces and abstract classes are implemented.
 * There are two interfaces in this program:
 * - Employee: includes two abstract methods, which are calculatePay and checkPromotionEligibility
 * - Store: includes two constants (COMMISSION_RATE and TAX) and two abstract methods (calculateCommission and calculateRemainingStoreRevenue)
 * Manager and SalesAssociate inherit methods and constructors from StoreEmployee. It is an abstract class that implements both Employee and Store
 * interfaces. The calculateRemainingStoreRevenue and calculateCommission methods are specified, while calculatePay and checkPromotionEligibility
 * methods are made in abstract.
 * 
 * The differences between an abstract class and interface:
 * Abstract class:
 * - Able to have abstract and non-abstract methods
 * - A class can only inherit an abstract class.
 * - Can have final, non-final, static, and non-static variables.
 * - Support the implementation of interface.
 * Interface:
 * - Only have abstract methods (and default and static methods since Java 8).
 * - A class can inherit multiple interfaces.
 * - Can only have static and final variables
 * - Cannot implement abstract class in an interface.
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Manager> managerList = new ArrayList<Manager>();
		ArrayList<SalesAssociate> salesAssociateList = new ArrayList<SalesAssociate>();
		
		String storeDetails, empName;
		double basePay, numOfHoursWorked, hourlyRate, currentSalesDone, currentStoreSales, salesRate;
		int employeeType, opt;
		
		do {
			int managerCount = 0;
			int salesAssociateCount = 0;
			
			displayMenu();
			opt = sc.nextInt();
			
			
			if(opt == 1) {
				displayEmployeeTypes();
				employeeType = sc.nextInt();
				System.out.print("Input store details: "); sc.nextLine();
				storeDetails = sc.nextLine();
				System.out.print("Input employee name: ");
				empName = sc.nextLine();
				System.out.print("Input employee's base pay: Rp");
				basePay = sc.nextDouble();
				System.out.print("Input employee's number of hours worked: ");
				numOfHoursWorked = sc.nextDouble();
				System.out.print("Input employee's hourly rate: ");
				hourlyRate = sc.nextDouble();
				
				if(employeeType == 1) {
					System.out.print("Input employee's current sales done: Rp");
					currentSalesDone = sc.nextDouble();
					System.out.print("Input employee's current store sales: Rp");
					currentStoreSales = sc.nextDouble();
					
					Manager manager = new Manager(basePay, empName, hourlyRate, numOfHoursWorked, storeDetails, currentSalesDone, currentStoreSales);
					managerList.add(manager);
				} else {
					System.out.print("Input employee's sales rate (0-1): ");
					salesRate = sc.nextDouble();
					SalesAssociate salesAssociate = new SalesAssociate(basePay, empName, hourlyRate, numOfHoursWorked, storeDetails, salesRate);
					salesAssociateList.add(salesAssociate);
				}
			} else if(opt == 2) {
				System.out.println("Number of employees working as MANAGER are: " + managerList.size() + "\n");
				for (Manager manager : managerList) {
		            managerCount++;
		            System.out.println(managerCount + ". Manager Details:");
		            System.out.println(manager.getInfo());
		            System.out.println("Percentage of sales done: " + String.format("%.2f", manager.salesPercentByManager()) + "%");
		            System.out.println("Gross Payment: Rp" + String.format("%.1f", manager.calculatePay()));
		            System.out.println("Remaining store revenue: Rp" + manager.calculateRemainingStoreRevenue(manager.getTotalStoreSales()));
		            
		            System.out.print("Is " + manager.getEmployeeName() + " eligible for promotion? ");
		            if (manager.checkPromotionEligibility() == true) {
		                System.out.println("Yes, he is \n");
		            } else {
		                System.out.println("No, he needs to work harder\n");
		            }
		        }
				System.out.println("-------------------------------------------");
				System.out.println("Number of employees working as SALES ASSOCIATES are: " + salesAssociateList.size());
				for (SalesAssociate salesAssociate : salesAssociateList) {
		            salesAssociateCount++;
		            System.out.println(salesAssociateCount + ". Sales Associate Details:");
		            System.out.println(salesAssociate.getInfo());
		            System.out.println("Total commission: Rp" + salesAssociate.calculateCommission());
		            System.out.println("Gross Payment: Rp" + String.format("%.1f", salesAssociate.calculatePay()));
		            
		            System.out.print("Is " + salesAssociate.getEmployeeName() + " eligible for promotion? ");
		            if (salesAssociate.checkPromotionEligibility() == true) {
		                System.out.println("Yes, he/she is eligible\n");
		            } else {
		                System.out.println("No, he/she needs to work harder\n");
		            }
		        }
			}
		} while(opt != 3);
		
		
		sc.close();
	}
	
	public static void displayMenu() {
		System.out.println("Menu:");
		System.out.println("1. Insert an employee");
		System.out.println("2. View employee report");
		System.out.println("3. Terminate program");
		System.out.print(">> ");
	}
	
	public static void displayEmployeeTypes() {
		System.out.println("Employee Types:");
		System.out.println("1. Manager");
		System.out.println("2. Sales Associate");
		System.out.print("Input employee type (number): ");
	}
}
