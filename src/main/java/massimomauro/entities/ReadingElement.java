package massimomauro.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "catalog")
@DiscriminatorColumn(name = "element_type")
public abstract class ReadingElement {
    @Id
    @GeneratedValue
    private long ISBN;
    private String title;
    private int year;
    private int pageNumber;
    @OneToOne(mappedBy = "elementLoan")
    private Loan elementLoan;



    public ReadingElement(){};
    public ReadingElement( String title, int pageNumber, int year) {

        this.title = title;
        this.pageNumber = pageNumber;
        this.year = year;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.equals("")) throw new RuntimeException("L'elemento di lettura non può non avere titolo!");
        else this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        LocalDate today = LocalDate.now();
        if(year >=today.getYear()) throw new RuntimeException("Data inserita errata ");

        else this.year = year;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        if(pageNumber>0) throw  new RuntimeException("elemento di lettura numero minimo di pagine 1");
        else this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "ReadingElement{" +
                "ISBN="+ ISBN +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
