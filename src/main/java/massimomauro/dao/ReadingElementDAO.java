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
        if (em.find(ReadingElement.class, id) == null) throw new RuntimeException("id reading element non esistente");
        else return em.find(ReadingElement.class, id
        );
    }

    public List<ReadingElement> findElementsByYear(int year) {
        //SELECT * FROM catalog WHERE year=2135;
        TypedQuery<ReadingElement> getAllQuery = em.createQuery("SELECT e FROM ReadingElement e WHERE e.year = :year", ReadingElement.class);
        getAllQuery.setParameter("year", year);

        return getAllQuery.getResultList();
    }

    public List<ReadingElement> findElementsByAuthor(String author) {
        TypedQuery<ReadingElement> getAllQuery = em.createQuery("SELECT e FROM ReadingElement e WHERE e.author LIKE :author", ReadingElement.class);
        getAllQuery.setParameter("author", author + "%");
        return getAllQuery.getResultList();
    }

    public List<ReadingElement> findElementsByTitle(String title) {
        TypedQuery<ReadingElement> getAllQuery = em.createQuery("SELECT e FROM ReadingElement e WHERE e.title LIKE :title", ReadingElement.class);
        getAllQuery.setParameter("title", title + "%");
        return getAllQuery.getResultList();
    }

    public void findByIdAndDelete(long id) {

        // 1. Faccio una find per cercare lo studente
        ReadingElement found = em.find(ReadingElement.class, id);

        if (found != null) {

            EntityTransaction transaction = em.getTransaction();

            transaction.begin();


            em.remove(found);

            transaction.commit();
            System.out.println("Lo studente è stato cancellato correttamente");
        } else {
            // 3. Altrimenti --> "Student not found"
            System.err.println("Lo studente con l'id " + id + " non è stato trovato");
        }

    }
    public List<ReadingElement> findCatalog() {
        
        TypedQuery<ReadingElement> getAllQuery = em.createQuery("SELECT d FROM ReadingElement d", ReadingElement.class); // Query JPQL
        return getAllQuery.getResultList();
    }
}
