/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;

  /**
   * Construct a Library
   * @param name library name
   * @param address library address
   * @param nFloors number of floors
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Overloaded constructor - default to 2 floors
   * @param name library name
   * @param address library address
   */
  public Library(String name, String address) {
    this(name, address, 2);
  }

  /** 
   * Add a title to the collection 
   * @param title title to add
   */
  public void addTitle(String title){
    this.collection.put(title, true);
  }

  /**
   * Overloaded addTitle - add multiple titles at once
   * @param titles array of titles to add
   */
  public void addTitle(String[] titles) {
    for (String title : titles) {
      addTitle(title);
    }
  }

  /**
   * Remove a title from the collection and return it back
   * @param title title to remove
   * @return the removed title
   */
  public String removeTitle(String title) { 
    if (this.collection.containsKey(title)) {
      this.collection.remove(title);
      return title;
    }
    return null;
  }
  
  /** 
   * Check out a title
   * @param title title to check out
   */
  public void checkOut(String title) {
    if (this.collection.containsKey(title)) {
      this.collection.replace(title, false);
    }
  }
    
  /** 
   * Return a book
   * @param title title to return
   */
  public void returnBook(String title) {
    if (this.collection.containsKey(title)) {
      this.collection.replace(title, true);
    }
  }

  /**
   * Check whether the collection contains the title
   * @param title title to check
   * @return true if present
   */
  public boolean containsTitle(String title){
    return this.collection.containsKey(title);
  }

  /**
   * Check whether a title is available
   * @param title title to check
   * @return availability status
   */
  public boolean isAvailable(String title) {
    if (this.collection.containsKey(title)) {
      return this.collection.get(title);
    }
    return false;
  }
  
  /** 
   * Print the full collection
   */
  public void printCollection() {
    System.out.println("Library Collection:");
    for (String title : this.collection.keySet()) {
      boolean isAvailable = this.collection.get(title);
      String status;
      if (isAvailable) {
        status = "Available";
      } else {
        status = "Checked Out";
      }
      
      System.out.println("- " + title + ": " + status);
    }
  }

  /**
   * Override showOptions to include Library-specific methods
   */
  @Override
  public void showOptions() {
    super.showOptions();
    System.out.println(" + addTitle(String)\n + removeTitle(String)\n + checkOut(String)\n + returnBook(String)\n + containsTitle(String)\n + isAvailable(String)\n + printCollection()");
  }

  /**
   * Override goToFloor - libraries have elevators, so can move to any floor
   * @param floorNum floor to go to
   */
  @Override
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  public static void main(String[] args) {
    Library myLibrary = new Library("Neilson Library", "7 Neilson Drive", 4);
    myLibrary.addTitle("The Great Gatsby");
    myLibrary.printCollection();
    myLibrary.checkOut("The Great Gatsby");
    myLibrary.printCollection();
  }
}