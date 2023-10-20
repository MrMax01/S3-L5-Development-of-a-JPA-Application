package massimomauro.dao;


import massimomauro.entities.ReadingElement;
import massimomauro.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO {
    private final EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public void save(User a) {
        EntityTransaction transaction = em.getTransaction();
        // 1. Inizio la transazione
        transaction.begin();

        // 2. Aggiungo il nuovo oggetto al Persistence Context (ma non è ancora salvato a DB in questo momento)
        em.persist(a);

        // 3. Termino la transazione col salvataggio effettivo di una nuova riga nella tabella students
        transaction.commit();
        System.out.println("Utente registrato");
    }
    public User findElementById(long id) {

        if(em.find(User.class, id)== null) throw  new RuntimeException("l'id utente non esiste");
        else return em.find(User.class, id);
    }
    public List<User> findUsers() {

        TypedQuery<User> getAllQuery = em.createQuery("SELECT d FROM User d", User.class); // Query JPQL
        return getAllQuery.getResultList();
    }
}
