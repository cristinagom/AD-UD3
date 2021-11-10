package entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private LocalDate beginDate;
    private LocalDate endDate;

    @ManyToOne
    private Employee emp;


    public Task(String description, Employee e) {
        this.description = description;
        this.beginDate = LocalDate.now();
        this.endDate = null;
        this.emp = e;
    }
}
