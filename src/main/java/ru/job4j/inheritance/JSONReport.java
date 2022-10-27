package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        String ln = System.lineSeparator();
        String x = "{" + ln
                + "\t\"name\" : " + "\"" + name + "\"," + ln
                + "\t\"body\" : " + "\"" + body + "\"" + ln
                + "}";
        return x;
    }
}
