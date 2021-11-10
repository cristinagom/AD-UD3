package entity;

import javax.persistence.*;

@Entity
@Table(name="cards")
public class Card {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="employeeid")
    private Employee emp;

    public Card(String code, Employee e) {
        this.code = code;
        this.emp = e;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
}
