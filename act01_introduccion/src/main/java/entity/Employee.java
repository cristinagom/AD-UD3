package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue
    private long idemployee;
    private String fName;
    private String lName;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name="cardid")
    private Card c;
    @ManyToMany
    @JoinTable(name="employee_department", joinColumns = @JoinColumn(name="idemployee"),
            inverseJoinColumns = @JoinColumn(name="iddepartment"))
    private List<Department> ldepartments;

    public Employee() {
        ldepartments = new ArrayList<Department>();
    }

    public long getId() {
        return idemployee;
    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Card getCard() {
        return c;
    }

    public void setCard(Card c) {
        this.c = c;
    }


    public void addDepartment(Department d) {
        ldepartments.add(d);
    }


}
