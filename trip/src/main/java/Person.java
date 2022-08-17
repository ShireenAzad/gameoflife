import java.math.RoundingMode;
import java.text.DecimalFormat;

import static java.lang.Double.parseDouble;

class Person {


	private String name;
	private String item;

	private double dueAmount;
	public String getName() {
		return name;
	}

	public Person(String name) {
		this.name = name;
		this.item = "";
		this.dueAmount=0;

	}

	public void debit(double amount){
		this.dueAmount -=amount;
	}
	public void credit(double amount){
		this.dueAmount +=amount;
	}
	public double dueAmount(){
		return format(dueAmount);
	}
	private double format(double dueAmount) {
		DecimalFormat df = new DecimalFormat("0.##");
		df.setRoundingMode(RoundingMode.DOWN);
		return parseDouble(df.format(dueAmount));
	}

}
