import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class TripShareTest {
	@Test
	public void verifySpenderDebitAmount() {
		Person personA = Mockito.mock(Person.class);
		List<Person> beneficiaries = List.of();
		ExpenseData expenseDataA = new ExpenseData(personA, beneficiaries, 75);
		Trip trip = new Trip();
		trip.process(expenseDataA);
		verify(personA).debit(75);
	}

	@Test
	public void verifyBeneficiariesCreditedShareAmount() {
		Person personA = Mockito.mock(Person.class);
		Person personB = Mockito.mock(Person.class);
		List<Person> beneficiaries = List.of(personA,personB);
		ExpenseData expenseDataA = new ExpenseData(personA, beneficiaries, 50);
		Trip trip = new Trip();
		trip.process(expenseDataA);
		verify(personA).debit(50);
		verify(personA).credit(25);
		verify(personB).credit(25);
	}

	@Test
	void dueAmount() {
		Person personA = new Person("A");
		Person personB = new Person("B");
		List<Person> beneficiaries = List.of(personA,personB);
		ExpenseData expenseDataA = new ExpenseData(personA, beneficiaries, 50);
		Trip trip = new Trip();
		trip.process(expenseDataA);
		assertEquals(trip.dueAmountFor(personA),-25);
		assertEquals(trip.dueAmountFor(personB),25);

	}
}
