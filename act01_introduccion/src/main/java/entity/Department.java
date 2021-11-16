package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="iddepartment")
    private int id;
    private String name;
    @ManyToMany(mappedBy = "ldepartments")
    private List<Employee> lemployees;

    public Department(String name) {
        this.name = name;
        lemployees = new ArrayList<Employee>();
    }

    public Department() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEmployee(Employee e) {
        lemployees.add(e);
        e.addDepartment(this);
    }
}
