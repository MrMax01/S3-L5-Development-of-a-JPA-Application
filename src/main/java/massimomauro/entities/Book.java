package massimomauro.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Book")
public class Book extends ReadingElement {
    private String author;
    private String type;

    public Book(){};
    public Book( String title, int pageNumber, int year, String author, String type) {
        super(title, pageNumber, year);
        this.author = author;
        this.type = type;
    }



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author.equals("")) this.author ="Autore anonimo";
        else this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(type.equals("")) throw new RuntimeException("Inserire il genere...");
        else this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN="+ getISBN() +
                ", title='" + getTitle() + '\'' +
                ", year=" + getYear() +
                ", pageNumber=" + getPageNumber() +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
