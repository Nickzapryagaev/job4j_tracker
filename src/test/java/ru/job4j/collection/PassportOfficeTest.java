package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {

    @Test
    public void whenTestAddMethodTrue() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestAddMethodFalse() {
        Citizen petr = new Citizen("2f44a", "Petr Arsentev");
        Citizen nick = new Citizen("2f44a", "Nick Zap");
        PassportOffice office = new PassportOffice();
        office.add(petr);
        assertThat(office.add(nick)).isFalse();
    }
}