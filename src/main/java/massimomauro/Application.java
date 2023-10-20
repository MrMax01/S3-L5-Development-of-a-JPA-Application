package massimomauro;

import massimomauro.dao.LoanDAO;
import massimomauro.dao.ReadingElementDAO;
import massimomauro.dao.UserDAO;
import massimomauro.data.Periodicity;
import massimomauro.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        ReadingElementDAO ed = new ReadingElementDAO(em);
        UserDAO ud = new UserDAO(em);
        LoanDAO ld= new LoanDAO(em);

        List<ReadingElement> catalog = new ArrayList<>();
        /*salvo un catalogo*/
        /*
        ed.save(new Book( "Lord Of Rings", 300, 1994, "Tolkien", "fantasy"));
        ed.save(new Book( "Harry Potter", 250, 1997, "Rowling", "fantasy"));
        ed.save(new Book( "Moby Dick ", 400, 1851, "Rowling", "avventura"));
        ed.save(new Magazine( "focus", 20, 1851, Periodicity.SETTIMANALE));
        ed.save(new Magazine( "Panorama", 10, 1851, Periodicity.SETTIMANALE));
        */
        /*salvo utenti*/
        //ud.save(new User("Massimo", "mauro", LocalDate.of(1995,03,11)));
        //ud.save(new User("Ran", "Dom", LocalDate.of(200,05,16)));

        /*Prestiti*/
        //ld.save(new Loan(ud.findElementById(2), ed.findElementById(6)));





        //System.out.println(ed.findElementsByYear(1851));
        //System.out.println(ed.findElementById(5));
        //System.out.println(ed.findElementsByAuthor("R"));

        em.close();
        emf.close();
    }
}
