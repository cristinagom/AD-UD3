package entity;

import javax.persistence.*;

@Entity
@Table(name="cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="idcard")
    private int id;
    @Column(nullable = false)
    private String code;
    @Transient
    private TypeCard type;
    @OneToOne
    @JoinColumn(name="idemployee")
    private Employee employee;

    public Card(String code, TypeCard type, Employee e) {
        this.code = code;
        this.type = type;
        this.employee = e;
    }

    public Card() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TypeCard getType() {
        return type;
    }

    public void setType(TypeCard type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
