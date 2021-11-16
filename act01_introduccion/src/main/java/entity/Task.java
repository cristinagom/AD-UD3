package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idtask")
    private int id;
    //@Basic(optional = false)
    @Column(length = 100) //,nullable = false)
    private String description;
    //@Basic(optional = false)
    @Column(name="begindate") //,nullable = false)
    private LocalDate beginDate;
    @Column(name="enddate")
    private LocalDate endDate;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="idemployee")
    private Employee employee;

    public Task() {}
    public Task(String description) {
        this.description = description;
        this.beginDate = LocalDate.now();
    }

    public Task(String description, LocalDate beginDate) {
        this.description = description;
        this.beginDate = beginDate;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws Exception {
        //if (description!=null && description.length()>0 && description.length()<=100) {
            this.description = description;
        //} else throw new Exception("Error al modificar la descripción");
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Task(String description, LocalDate beginDate, LocalDate endDate) {
        this.description = description;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
