/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Construct a House.
   * @param name house name
   * @param address house address
   * @param nFloors number of floors
   * @param hasDiningRoom whether the house includes a dining room
   * @param hasElevator whether the house has an elevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Overloaded constructor - assumes no elevator by default
   * @param name house name
   * @param address house address
   * @param nFloors number of floors
   * @param hasDiningRoom whether the house includes a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    this(name, address, nFloors, hasDiningRoom, false);
  }

  /**
   * Does the house have a dining room?
   * @return true if the house has a dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Number of residents currently in the house
   * @return resident count
   */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * Move a student into the house
   * @param s student to move in
   */
  public void moveIn(Student s) {
    if (!this.residents.contains(s)) {
      this.residents.add(s);
    }
  }

  /**
   * Overloaded moveIn - move in multiple students at once
   * @param students array of students to move in
   */
  public void moveIn(Student[] students) {
    for (Student s : students) {
      moveIn(s);
    }
  }

  /**
   * Move a student out of the house
   * @param s student to move out
   * @return the student who moved out
   */
  public Student moveOut(Student s) {
    if (this.residents.contains(s)) {
      this.residents.remove(s);
      return s;
    } else {
      return null;
    }
  }
  
  /**
   * Check if the student a resident of the house?
   * @param s student to check
   * @return true if student is a resident
   */
  public boolean isResident(Student s){
    return this.residents.contains(s);
  }

  /**
   * Override showOptions to include House-specific methods
   */
  @Override
  public void showOptions() {
    super.showOptions();
    System.out.println(" + hasDiningRoom()\n + nResidents()\n + moveIn(Student)\n + moveOut(Student)\n + isResident(Student)");
  }

  /**
   * Override goToFloor to only allow non-adjacent floor movement if elevator exists
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
    
    if (!hasElevator && Math.abs(floorNum - this.activeFloor) > 1) {
      throw new RuntimeException("This house does not have an elevator. You can only move between adjacent floors.");
    }
    
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  public static void main(String[] args) {
    House myHouse = new House("King House", "180 Elm Street Northampton, MA 01063", 4, true);
    System.out.println(myHouse);
  }
}