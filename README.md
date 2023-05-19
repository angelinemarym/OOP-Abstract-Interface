<h1>Employee Payment Report</h1>
<p>This is a program to calculate and report employees' payment in a store. There are two types of employee, which are manager and sales associate. Each of the type has different calculation of wage. Thus, to cover the differences, interfaces and abstract classes are implemented.</p>
<p>There are two interfaces in this program:</p>
<li>
  <ul>Employee: includes two abstract methods, which are calculatePay and checkPromotionEligibility</ul>
  <ul>Store: includes two constants (COMMISSION_RATE and TAX) and two abstract methods (calculateCommission and calculateRemainingStoreRevenue)</ul>
</li>
<p>Manager and SalesAssociate inherit methods and constructors from StoreEmployee. It is an abstract class that implements both Employee and Store interfaces. The calculateRemainingStoreRevenue and calculateCommission methods are specified, while calculatePay and checkPromotionEligibility methods are made in abstract.</p>

<h2>The differences between an abstract class and interface</h2>
<p>Abstract class:</p>
<li>
  <ul>Able to have abstract and non-abstract methods</ul>
  <ul>A class can only inherit an abstract class.</ul>
  <ul>Can have final, non-final, static, and non-static variables.</ul>
  <ul>Support the implementation of interface.</ul>
</li>
<p>Interface:</p>
<li>
  <ul>Only have abstract methods (and default and static methods since Java 8).</ul>
  <ul>A class can inherit multiple interfaces.</ul>
  <ul>Can only have static and final variables</ul>
  <ul>Cannot implement abstract class in an interface.</ul>
</li>
