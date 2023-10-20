package massimomauro.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private long id_card;
    private String name;
    private String surname;
    private LocalDate birth_day;
    @OneToOne(mappedBy = "user")
    private Loan loan;

    public User(){};

    public User(String name, String surname, LocalDate birth_day) {
        this.name = name;
        this.surname = surname;
        this.birth_day = birth_day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(LocalDate birth_day) {
        this.birth_day = birth_day;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_card=" + id_card +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth_day=" + birth_day +
                '}';
    }
}
