package catalogue;

public class Book 
{
    //properties, fields, global variables
    String title;
    int pageCount;
    int ISBN;
    boolean isCheckedOut;// whether or not the book is checked out or not
    int dayCheckedOut = -1;
    
    public Book(String bookTitle,int bookPageCount,int bookISBN)// constructor
    {
       this.title = bookTitle;
       this.pageCount = bookPageCount;
       this.ISBN = bookISBN;
       isCheckedOut = false;
    }
    
    // getters --> instance methods
    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getISBN() {
        return ISBN;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public int getDayCheckedOut() {
        return dayCheckedOut;
    }
    
    // setters
    public void setIsCheckedOut(boolean newIsCheckedOut,int currentDayCheckedOut) {
        this.isCheckedOut = newIsCheckedOut;
        setDayCheckedOut(currentDayCheckedOut);
    }
    
    private void setDayCheckedOut(int day){
        this.dayCheckedOut = day;
    }    
}
