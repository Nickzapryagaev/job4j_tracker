package ru.job4j.oop;

public class Error {

    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("System online: " + active);
        System.out.println("Status:  " + status);
        System.out.println("server " + message);
    }

    public static void main(String[] args) {
        Error er404 = new Error();
        Error er405 = new Error(false, 404, "down");
        Error noErr = new Error(true, 0, "online");
        er404.printInfo();
        er405.printInfo();
        noErr.printInfo();
    }
}

