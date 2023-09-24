package oop;

import java.util.Calendar;
import java.util.Formatter;

public class CarMain {
    private String model;

    public class Transmition {
        public Transmition() {
            System.out.println("Transmition default constructor!");
        }
    }

    public class Engine {
        public Engine() {
            System.out.println("Engine default constructor!");
        }

        public void engineMethod() {
            System.out.println("Engine method!");
        }
    }

    public static void main(String[] args) {
        System.out.println("fsdf");
        CarMain carMain = new CarMain();
        carMain.model = "Kia";
        CarMain.Engine engine = carMain.new Engine();
        CarMain.Transmition transmition = carMain.new Transmition();
        engine.engineMethod();

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
    }
}