package massimomauro.entities;

import massimomauro.data.Periodicity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Magazine")
public class Magazine extends ReadingElement {
    Periodicity periodicity;

    public Magazine(){};
    public Magazine( String title, int pageNumber, int year, Periodicity periodicity) {
        super( title, pageNumber, year);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "ISBN="+ getISBN() +
                ", title='" + getTitle() + '\'' +
                ", year=" + getYear() +
                ", pageNumber=" + getPageNumber() +
                ", periodicity=" + periodicity +
                '}';
    }
}
