<h1>Employee Payment Report</h1>
<p>This is a program to calculate and report employees' payment in a store. There are two types of employee, which are manager and sales associate. Each of the type has different calculation of wage. Thus, to cover the differences, interfaces and abstract classes are implemented.</p>
<p>There are two interfaces in this program:</p>
<ul>
  <li>Employee: includes two abstract methods, which are calculatePay and checkPromotionEligibility</li>
  <li>Store: includes two constants (COMMISSION_RATE and TAX) and two abstract methods (calculateCommission and calculateRemainingStoreRevenue)</li>
</ul>
<p>Manager and SalesAssociate inherit methods and constructors from StoreEmployee. It is an abstract class that implements both Employee and Store interfaces. The calculateRemainingStoreRevenue and calculateCommission methods are specified, while calculatePay and checkPromotionEligibility methods are made in abstract.</p>

<h2>The differences between an abstract class and interface</h2>
<p>Abstract class:</p>
<ul>
  <li>Able to have abstract and non-abstract methods</li>
  <li>A class can only inherit an abstract class.</li>
  <li>Can have final, non-final, static, and non-static variables.</li>
  <li>Support the implementation of interface.</li>
</ul>
<p>Interface:</p>
<ul>
  <li>Only have abstract methods (and default and static methods since Java 8).</li>
  <li>A class can inherit multiple interfaces.</li>
  <li>Can only have static and final variables</li>
  <li>Cannot implement abstract class in an interface.</li>
</ul>
