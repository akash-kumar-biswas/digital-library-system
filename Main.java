interface Ebook{
    void display();
}

class RealEBook implements Ebook{
    String bookName;

    RealEBook(String bookName){
        this.bookName = bookName;
        loadBook(bookName);
    }
    
    String getTitle(){
        return bookName;
    }

    String getSize(){
        return "size";
    }
    
    public void loadBook(String bookName){
        System.out.println("Book loaded from disk: "+ bookName);
    }

    public void display() {
        System.out.println("Displaying book: "+ bookName);
    }
}

class ProxyEBook implements Ebook{
    String bookName;
    RealEBook realEBook;

    ProxyEBook(String bookName){
        this.bookName = bookName;
    }

    public void display() {
        if(realEBook == null){
            realEBook = new RealEBook(bookName);
        }
        realEBook.display();
    }
}

public class Main {
    public static void main(String[] args) {
        Ebook ebook1 = new ProxyEBook("Physics");
        Ebook ebook2 = new ProxyEBook("Math");

        ebook1.display();
        ebook1.display(); 

        ebook2.display();
        ebook2.display();
    }
}