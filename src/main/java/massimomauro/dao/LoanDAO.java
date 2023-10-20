package massimomauro.dao;

import massimomauro.entities.Loan;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
}
