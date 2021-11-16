package entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="idemployee")
    private int idEmployee;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="contactnumber")
    private String contactNumber;
    @OneToOne()
    @JoinColumn(name="idcard")
    private Card card;

    @OneToMany(mappedBy = "employee", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Task> ltasks;

    @ManyToMany
    @JoinTable(name = "emp_dep",joinColumns = @JoinColumn(name="idemployee"),
    inverseJoinColumns = @JoinColumn(name="iddepartment"))
    private List<Department> ldepartments;

    public Employee(){

    }
    public Employee(String firstName, String lastName, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        ltasks=new ArrayList<Task>();
        ldepartments = new ArrayList<Department>();
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card c) {
        this.card = c;
    }

    public void addTask(Task t) {
        ltasks.add(t);
        t.setEmployee(this);
    }

    public void removeTask(Task t) {
        ltasks.remove(t);
        t.setEmployee(null);
    }

    public void addDepartment(Department d) {
        ldepartments.add(d);
        d.addEmployee(this);
    }
}
