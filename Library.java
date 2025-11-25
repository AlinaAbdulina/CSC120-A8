/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {

  // Attributes 
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<>();
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
    }

    // Overload, library has an elevator
    public Library(String name, String address, int nFloors) {
        this(name, address, nFloors, true);
    }

    // Methods 
    // *update collection every time we add/remove a title
    public void addTitle(String title){
      collection.put(title, true);
    }

    // *update every time we remove a book
    public String removeTitle(String title){
      // check if title exists 
      if (!collection.containsKey(title)) {
        throw new RuntimeException("Not found in the collection.");
      }

      // remove book 
      collection.remove(title);
      return title;
    } 
  
    // *check a book out
    public void checkOut(String title) {
      // check if it's in collection
      if (!collection.containsKey(title)) {
        throw new RuntimeException("Not found in the collection.");
      }

        // checking out a book
        collection.put(title, false);
        System.out.println("Checked out!");
    }
    
    // // Overload, check out multiple books 
    // public void checkOut(String title) {
    //     for (String title : title) {
    //         checkOut(title);
    //     }
    // }



    // *return a book 
    public void returnBook(String title) {
      // check if book is in the collection
      if (!collection.containsKey(title)) {
        throw new RuntimeException("Not found in the collection.");
      }

      // return book back to collection
      collection.put(title, true);
      System.out.println("Returned");
    }


    // *returns true if the title appears as a key in the Libary's collection, false otherwise
    public boolean containsTitle(String title){
      return collection.containsKey(title);
    }

    // *returns true if the title is currently available, false otherwise
    public boolean isAvailable(String title){
      return collection.containsKey(title);

    }

    // *prints out the entire collection in an easy-to-read way (including checkout status) 
    public void printCollection() {
      System.out.println("Library Collection:");
      for (String title : collection.keySet()) {
        if (collection.get(title)) {
          System.out.println(title + " Available");
        } else {
          System.out.println(title + " Checked Out");
        }
      }
    }



  // Override - show library-specific options 
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title) \n + printCollection()");
    }


  // Override - libraries with elevators can jump floors */
  @Override
  public void goToFloor(int floorNum) {
      super.goToFloor(floorNum);

  // need to add the elevator 
      
  }



    public static void main(String[] args) {
      Library neilson = new Library("Neilson Library", "7 Neilson Drive, Northampton, MA", 4, true);
      // not done yet
    }

}

