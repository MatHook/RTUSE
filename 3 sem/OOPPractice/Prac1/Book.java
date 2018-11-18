package OOPPractice.Prac1;

public class Book {
    private String label;
    private int pages;

    public Book(String label, int pages) {
        this.label = label;
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public String getLabel() {
        return label;
    }

    public String toString(){
        return String.format("Label of book is %s with $d pages.", label, pages);
    }
}
