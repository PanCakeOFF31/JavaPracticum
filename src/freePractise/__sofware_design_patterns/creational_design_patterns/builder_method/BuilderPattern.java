package freePractise.__sofware_design_patterns.creational_design_patterns.builder_method;

import freePractise.__sofware_design_patterns.creational_design_patterns.builder_method.emplyee.Employee;
import helpers.coloredString.Logger;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class BuilderPattern {
    public static void builderMethod() {
        printSection("Builder Method");

        {
            Employee employee1 =  Employee.builder().build();
            System.out.println("employee1 = " + employee1);

            Employee employee2 = Employee.builder()
                    .setCompany("Big company")
                    .setName("Igor")
                    .setHasCar(true)
                    .setHasBike(false)
                    .build();

            System.out.println("employee2 = " + employee2);
        }

        {

        }


        printSectionEnding();
    }
}
