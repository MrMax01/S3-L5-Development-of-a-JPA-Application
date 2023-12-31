package massimomauro.dao;

import massimomauro.entities.Loan;
import massimomauro.entities.ReadingElement;
import massimomauro.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class LoanDAO {
    private final EntityManager em;

    public LoanDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Loan a) {
        EntityTransaction transaction = em.getTransaction();
        // 1. Inizio la transazione
        transaction.begin();

        // 2. Aggiungo il nuovo oggetto al Persistence Context (ma non è ancora salvato a DB in questo momento)
        em.persist(a);

        // 3. Termino la transazione col salvataggio effettivo di una nuova riga nella tabella students
        transaction.commit();
        System.out.println("Prestito eseguito");
    }

    public List<Loan> findLoansByUserId (long userId){
        //SELECT * FROM catalog WHERE year=2135;
        TypedQuery<Loan> getAllQuery = em.createQuery("SELECT e FROM Loan e WHERE e.user.id = :user_id", Loan.class);
        getAllQuery.setParameter("user_id", userId);
        if(getAllQuery.getResultList().isEmpty()) throw new RuntimeException("l'utente selezionato non esiste o non ha niente in prestito");
        else return getAllQuery.getResultList();
    }

    //SELECT * FROM your_table WHERE date_column1 < date_column2
    public List <Loan> findExpiredLoan (){
        TypedQuery<Loan> getAllQuery = em.createQuery("SELECT e FROM Loan e WHERE e.endLoan < e.hasReturned", Loan.class);
        return getAllQuery.getResultList();
    }
    public List<Loan> findLoans() {

        TypedQuery<Loan> getAllQuery = em.createQuery("SELECT d FROM Loan d", Loan.class); // Query JPQL
        return getAllQuery.getResultList();
    }


}
