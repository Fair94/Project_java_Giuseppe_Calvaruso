package giuseppecalvaruso.domain;

public abstract  class AbstractBook implements Book {
    private final String title;
    private final String ISBN;
    private final String author;
    private final int price;
    private final int publicationYear;
    private boolean rented;
    private final Genre genre;

        public AbstractBook(String title, String ISBN, String author, int price, int publicationYear, boolean rented, Genre genre){
            this.title = title;
            this.ISBN = ISBN;
            this.author = author;
            this.price = price;
            this.publicationYear = publicationYear;
            this.rented = rented;
            this.genre = genre;


        }

        @Override
        public String getTitle(){
            return title;
        }
        @Override
        public String getISBN(){
            return ISBN;
        }
        @Override
        public String getAuthor(){
            return author;
        }

        @Override
        public int getPrice(){
            return price;
        }
        @Override
        public int getPublicationYear(){
            return publicationYear;
        }
        @Override
        public boolean isRented(){
            return rented;
        }
        @Override
        public void setRented(boolean rented){
            this.rented = rented;
        }

        @Override
        public Genre getGenre(){
            return genre;
        }

        @Override
        public String toString(){

            return String.format("Title: %s | Author: %s | ISBN: %s | Price: %d | Year: %d | Genre: %s | Rented: %s",
            title,author,ISBN,price,publicationYear,genre,rented?"Yes":"No");
        }

    
}
