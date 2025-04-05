class Book {
    private String bookTitle;
    private String writer;
    private int releaseYear;

    public Book(String bookTitle, String writer, int releaseYear) {
        this.bookTitle = bookTitle;
        this.writer = writer;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Book: " + bookTitle + " by " + writer + " (" + releaseYear + ")";
    }
}

class PhysicalBook extends Book {
    private String publishingCompany;
    private String bookCode;

    public PhysicalBook(String title, String author, int year, 
                       String publisher, String code) {
        super(title, author, year);
        this.publishingCompany = publisher;
        this.bookCode = code;
    }

    @Override
    public String toString() {
        return super.toString() + " | Publisher: " + publishingCompany 
               + " | ISBN: " + bookCode;
    }
}

class DigitalAudioBook extends Book {
    private double storageSize;
    private int runtime;
    private String voiceActor;

    public DigitalAudioBook(String title, String author, int year,
                          double size, int minutes, String narrator) {
        super(title, author, year);
        this.storageSize = size;
        this.runtime = minutes;
        this.voiceActor = narrator;
    }

    @Override
    public String toString() {
        return super.toString() + " | Audio: " + storageSize + "MB, " 
               + runtime + " mins | Read by: " + voiceActor;
    }
}

class BookStore {
    public static void main(String[] args) {
        Book[] inventory = {
            new Book("Java Basics", "Alex Johnson", 2020),
            new PhysicalBook("Web Development", "Sam Lee", 2021, "TechPress", "WD-2021"),
            new DigitalAudioBook("Python Guide", "Taylor Swift", 2022, 320.5, 420, "Morgan Freeman")
        };

        for (Book item : inventory) {
            System.out.println(item);
        }
    }
}