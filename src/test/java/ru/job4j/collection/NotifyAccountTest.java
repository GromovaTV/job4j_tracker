package ru.job4j.collection;
import org.junit.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {
    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Ivan Ivanov", "1000"),
                new Account("142", "Ivan Ivanov", "200000")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Ivan Ivanov", "1000"),
                        new Account("142", "Ivan Ivanov", "200000")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void whenSentSimilar() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Ivan Ivanov", "1000"),
                new Account("123", "Ivan Ivanov", "1000")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Ivan Ivanov", "1000")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}