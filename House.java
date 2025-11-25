/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  // Attributes 
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;

  public House() {
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  // Accessors 
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  public int nResidents(){
    return this.residents.size();
  }

  // Methods 

  // update the ArrayList of residents every time someone moves in or out
  public void moveIn(Student s){
    this.residents.add(s) 

  }

  public Student moveOut(Student s){
    this.residents.remove(s); 
  }
  
  // Is person a resident of the house 
  public boolean isResident(Student s){
    return this.residents.contains(s);
  }



  public static void main(String[] args) {
    new House();
  }

}