package ru.job4j.search;
import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Petrov", "555888", "Tomsk")
        );
        ArrayList<Person> persons = phones.find("Ivan");
        assertThat(persons.get(0).getSurname(), is("Petrov"));
    }

    @Test
    public void whenNotFoundByName() {
        PhoneDictionary phones = new PhoneDictionary();
        Person person = new Person("Ivan", "Petrov", "555888", "Tomsk");
        phones.add(person);
        ArrayList<Person> persons = phones.find("okhf");
        ArrayList<Person> expected = new ArrayList<>();
        assertEquals(expected, persons);
    }
}