import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class Trip {
	public double dueAmountFor(Person person) {
		return person.dueAmount();
	}
	public void process(ExpenseData expenseData) {
		Person spender = expenseData.getSpender();
		spender.debit(expenseData.getExpense());
		List<Person> beneficiaries = expenseData.getBeneficiaries();
		int size = beneficiaries.size();
		double shareAmount = expenseData.getExpense() / size;
		beneficiaries.forEach(beneficiary -> beneficiary.credit(shareAmount));
	}
}
