import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* 
    * initializes empty ArrayList 
    */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
     * Displays a directory of all buildings with their names and addresses
     * @return a string containing all buildings on the map
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }
    

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        
        // Add at least 10 buildings including all types
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Sabin Reed Hall", "10 Elm Street Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Burton Hall", "46 College Lane Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("McConnell Hall", "2 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("King House", "180 Elm Street Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new House("Scales House", "64 Prospect Street Northampton, MA 01063", 4, true)); // overloaded constructor
        myMap.addBuilding(new House("Chapin House", "10 Chapin Court Northampton, MA 01063", 4, true));
        myMap.addBuilding(new House("Tyler House", "164 Green Street Northampton, MA 01063", 4, true));
        myMap.addBuilding(new House("Comstock House", "1 Mandelle Road Northampton, MA 01063", 3, true));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 5));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 College Lane Northampton, MA 01063", 1, 100, 50, 50, 20));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm Street Northampton, MA 01063", 1)); // overloaded constructor
        
        System.out.println(myMap);
        
        // Quick demonstrations of overloaded methods
        System.out.println("\n--- Demonstrating Overloaded Methods ---");
        
        House testHouse = new House("Test", "123 St", 3, true);
        Student s1 = new Student("Alina", "001", 2027);
        Student s2 = new Student("Irina", "002", 2026);
        testHouse.moveIn(s1);
        testHouse.moveIn(new Student[]{s2});
        
        Library testLib = new Library("Test Lib", "123 Ave");
        testLib.addTitle("Book1"); 
        testLib.addTitle(new String[]{"Book2", "Book3"});
        
        Cafe testCafe = new Cafe("Test Cafe", "123 Rd", 1);
        testCafe.sellCoffee(12, 1, 1); // full
        testCafe.sellCoffee(8);
        
        System.out.println("All overloaded methods demonstrated successfully!");
    }
}