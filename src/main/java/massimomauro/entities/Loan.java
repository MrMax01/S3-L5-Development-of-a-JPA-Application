package massimomauro.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="loans")
public class Loan {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="catalog_element_id")
    private ReadingElement elementLoan ;

    private LocalDate startLoan;
    private  LocalDate endLoan;

    private LocalDate hasReturned;

}
