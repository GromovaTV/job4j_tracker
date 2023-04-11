package ru.job4j.collection;
import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndProrityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("B", 1),
                new Job("B", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByName() {
        Comparator<Job> cmpNamePriority = new JobAscByName();
        int rsl = cmpNamePriority.compare(
                new Job("B", 0),
                new Job("A", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("B", 0),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}