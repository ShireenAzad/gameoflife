import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonShare {
	@Test
	void amountSpentByPersonOnItem() {
		Person personA = new Person("A");
		personA.debit(70);
		assertEquals(personA.dueAmount(), -70);
	}

	@Test
	void amountDebitByPersonOnMultipleItems() {
		Person personA = new Person("A");
		personA.debit(70);
		personA.debit(80);
		personA.debit(90);
		personA.debit(10);
		assertEquals(personA.dueAmount(), -250);
	}

	@Test
	void amountCreditedForEachPerson() {
		Person personA = new Person("A");
		personA.credit(100);
		assertEquals(personA.dueAmount(), 100);
	}

}
