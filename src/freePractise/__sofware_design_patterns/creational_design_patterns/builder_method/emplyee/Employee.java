package freePractise.__sofware_design_patterns.creational_design_patterns.builder_method.emplyee;

import lombok.NonNull;
import lombok.ToString;

@ToString(includeFieldNames = false)
public class Employee {
    private String name;
    private String company;
    private boolean hasCar;
    private boolean hasBike;

    private Employee(String name, String company, boolean hasCar, boolean hasBike) {
        this.name = name;
        this.company = company;
        this.hasCar = hasCar;
        this.hasBike = hasBike;
    }

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder {
        private String name;
        private String company;
        private boolean hasCar;
        private boolean hasBike;


        private EmployeeBuilder() {
            name = "";
            company = "";
            hasCar = false;
            hasBike = false;
        }

        public EmployeeBuilder setName(@NonNull String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setCompany(@NonNull String company) {
            this.company = company;
            return this;
        }

        public EmployeeBuilder setHasCar(boolean hasCar) {
            this.hasCar = hasCar;
            return this;
        }

        public EmployeeBuilder setHasBike(boolean hasBike) {
            this.hasBike = hasBike;
            return this;
        }

        public Employee build() {
            return new Employee(name, company, hasCar, hasBike);
        }
    }
}
