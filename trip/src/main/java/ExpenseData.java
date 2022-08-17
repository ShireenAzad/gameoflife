import java.util.List;

public class ExpenseData {
	public Person getSpender() {
		return spender;
	}

	public double getExpense() {
		return expense;
	}

	private final Person spender;
	private final List<Person> beneficiaries;
	private final double expense;

	ExpenseData(Person spender, List<Person> beneficiaries, double expense) {
		this.spender = spender;
		this.beneficiaries = beneficiaries;
		this.expense = expense;


	}

	public List<Person> getBeneficiaries() {
		return beneficiaries;
	}
}
