package massimomauro.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;

@Entity
@Table(name="loans")
public class Loan {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(optional = false)
    @JoinColumn(name="catalog_element_id")
    private ReadingElement elementLoan ;

    private LocalDate startLoan;
    private  LocalDate endLoan;

    private LocalDate hasReturned;

    public Loan(){};

    public Loan(User user, ReadingElement elementLoan) {
        this.user = user;
        this.elementLoan = elementLoan;
        setStartLoan();
        setEndLoan();
        setHasReturned();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReadingElement getElementLoan() {
        return elementLoan;
    }

    public void setElementLoan(ReadingElement elementLoan) {
        this.elementLoan = elementLoan;
    }

    public LocalDate getHasReturned() {
        return hasReturned;
    }

    public void setHasReturned() {

        Random rdm= new Random();
        this.hasReturned = this.startLoan.plusDays(rdm.nextInt(1,60));
    }

    public LocalDate getStartLoan() {
        return startLoan;
    }

    public void setStartLoan() {
        this.startLoan = LocalDate.now();
    }

    public LocalDate getEndLoan() {
        return endLoan;
    }

    public void setEndLoan() {
        this.endLoan = this.startLoan.plusDays(30);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", user=" + user +
                ", elementLoan=" + elementLoan +
                ", startLoan=" + startLoan +
                ", endLoan=" + endLoan +
                ", hasReturned=" + hasReturned +
                '}';
    }
}
