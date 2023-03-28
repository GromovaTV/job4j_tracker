package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
        active = true;
        status = 404;
        message = "Not found";
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error err404 = new Error();
        err404.printInfo();
        Error err500 = new Error(true, 500, "Internal server error");
        err500.printInfo();
        Error err502 = new Error(true, 502, "Bad gateway");
        err502.printInfo();

    }

    public void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }
}
