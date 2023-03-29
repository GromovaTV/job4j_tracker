package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when00to20then2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double expected = 2;
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when000to020then2() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 2, 0);
        double expected = 2;
        double dist = a.distance3d(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

}