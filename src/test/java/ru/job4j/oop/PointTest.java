package ru.job4j.oop;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class PointTest {

    @Test
    public void when00to20then2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double input = a.distance(b);
        double expected = 2;
        double eps = 0.01;
        assertThat(input).isCloseTo(expected, offset(eps));
    }

    @Test
    public void when82to23then6dot08() {
        Point a = new Point(8, 2);
        Point b = new Point(2, 3);
        double input = a.distance(b);
        double expected = 6.08;
        double eps = 0.01;
        assertThat(input).isCloseTo(expected, offset(eps));
    }

    @Test
    public void when103to23then8() {
        Point a = new Point(10, 3);
        Point b = new Point(2, 3);
        double input = a.distance(b);
        double expected = 8;
        double eps = 0.01;
        assertThat(input).isCloseTo(expected, offset(eps));
    }

    @Test
    public void when1031to232then8() {
        Point a = new Point(10, 3, 1);
        Point b = new Point(2, 3,3);
        double input = a.distance3d(b);
        double expected = 8.24;
        double eps = 0.01;
        assertThat(input).isCloseTo(expected, offset(eps));
    }

    @Test
    public void when626to826then2() {
        Point a = new Point(6, 2, 6);
        Point b = new Point(8, 2,6);
        double input = a.distance3d(b);
        double expected = 2;
        double eps = 0.01;
        assertThat(input).isCloseTo(expected, offset(eps));
    }
}