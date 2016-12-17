package net.khe.homework11;

import java.util.*;

import static net.khe.util.Print.*;
/**
 * Created by hyc on 2016/12/16.
 */
public class Employee implements Comparable<Employee>{
    private String id;
    private String name;
    private String position;
    private double salary;

    public Employee(String id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    public double getSalary(){return salary;}
    @Override
    public String toString(){
        return "Id: "+id+
                " name: "+name+
                " position: "+position+
                " salary: "+salary;
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Employee)) return false;
        Employee e = (Employee)obj;
        return id.equals(e.id);
    }
    @Override
    public int hashCode(){
        return id.hashCode();
    }
    @Override
    public int compareTo(Employee o) {
        return id.compareTo(o.id);
    }
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("001","A","员工",3000),
                new Employee("002","B","员工",4000),
                new Employee("003","C","员工",2500),
                new Employee("004","D","员工",5000),
                new Employee("005","E","员工",1000),
        };
        Set<Employee> employeeSet =
                new HashSet<>(Arrays.asList(employees));
        printEmployees(employeeSet);
        employeeSet = new TreeSet<>((Employee lhs,Employee rhs)->{
            if (lhs.getSalary()<rhs.getSalary())return 1;
            else if(lhs.getSalary() == rhs.getSalary())return 0;
            else return -1;
        });
        employeeSet.addAll(Arrays.asList(employees));
        printEmployees(employeeSet);

        List<Employee> employeeList =
                new ArrayList<>(Arrays.asList(employees));
        printEmployees(employeeList);
    }
    public static void printEmployees(Collection<Employee> employees){
        String collectionName = " "+employees.getClass().getSimpleName()+" ";
        StringBuilder title = new StringBuilder("===================");
        int index = (title.length()-collectionName.length())/2;
        title.replace(index,index+collectionName.length(),collectionName);
        println(title.toString());
        for(Employee e:employees){
            println(e);
        }
        println();
    }
}
