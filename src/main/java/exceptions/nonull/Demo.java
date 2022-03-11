package exceptions.nonull;

import java.awt.*;
import java.util.Collections;
import java.util.List;

class Employee {

    public int getPay() {
        return 0;
    }
}

public class Demo {

    static int totalPay = 0;

    List<Employee> getEmployees() {
        // ...
        // if (no employees)
        return Collections.emptyList();
    }

    void bad() {

        List<Employee> employees = getEmployees();
        if (employees != null) {
            for (Employee e : employees) {
                totalPay += e.getPay();
            }
        }
    }

    void better() {

        List<Employee> employees = getEmployees();
        for (Employee e : employees) {
            totalPay += e.getPay();
        }
    }

    public double operationOnPoints(Point p1, Point p2) {
        if (p1 == null || p2 == null) {
            throw new IllegalArgumentException("...");
        }
        return p2.x - p1.x;
    }

    public static void main(String[] args) {
        final double v = new Demo().operationOnPoints(new Point(), new Point());
    }
}
