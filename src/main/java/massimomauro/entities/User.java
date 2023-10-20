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

}
