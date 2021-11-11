package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iddepartment")
    private int id;
    private String name;
   /* @ManyToMany
    @JoinTable(name="employee_department", joinColumns = @JoinColumn(name="iddepartment"),
    inverseJoinColumns = @JoinColumn(name="idemployee"))
    private List<Employee> lemployees;

*/
    public Department(String name) {
        this.name = name;
        //this.lemployees = new ArrayList<Employee>();
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
/*
    public void addEmployee(Employee e) {
        lemployees.add(e);
    }*/
}
