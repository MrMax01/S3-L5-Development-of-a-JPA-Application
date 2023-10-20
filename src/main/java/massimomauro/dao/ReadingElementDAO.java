package massimomauro.dao;

import massimomauro.entities.ReadingElement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ReadingElementDAO {
    private final EntityManager em;

    public ReadingElementDAO(EntityManager em) {
        this.em = em;
    }

    public void save(ReadingElement a) {
        EntityTransaction transaction = em.getTransaction();
        // 1. Inizio la transazione
        transaction.begin();

        // 2. Aggiungo il nuovo oggetto al Persistence Context (ma non è ancora salvato a DB in questo momento)
        em.persist(a);

        // 3. Termino la transazione col salvataggio effettivo di una nuova riga nella tabella students
        transaction.commit();
        System.out.println("Nuovo elemento catalogo salvato correttamente");
    }

    //ricerca per id
    public ReadingElement findElementById(long id) {
        return em.find(ReadingElement.class, id);
    }

    public List<ReadingElement> findElementsByYear (int year){
        //SELECT * FROM catalog WHERE year=2135;
        TypedQuery<ReadingElement> getAllQuery = em.createQuery("SELECT e FROM ReadingElement e WHERE e.year = :year", ReadingElement.class);
        getAllQuery.setParameter("year", year);

        return getAllQuery.getResultList();
    }

    public List<ReadingElement> findElementsByAuthor (String author){
        TypedQuery<ReadingElement> getAllQuery = em.createQuery("SELECT e FROM ReadingElement e WHERE e.author LIKE :author", ReadingElement.class);
        getAllQuery.setParameter("author", author + "%");
        return getAllQuery.getResultList();
    }
    public List<ReadingElement> findElementsByTitle (String title){
        TypedQuery<ReadingElement> getAllQuery = em.createQuery("SELECT e FROM ReadingElement e WHERE e.title LIKE :title", ReadingElement.class);
        getAllQuery.setParameter("title", title + "%");
        return getAllQuery.getResultList();
    }
}
