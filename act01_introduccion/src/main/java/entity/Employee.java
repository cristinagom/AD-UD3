package entity;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    private String fName;
    private String lName;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name="cardid")
    private Card c;

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

}
