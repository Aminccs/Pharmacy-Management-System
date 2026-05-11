package pharmacyManagementSystem;

public class PharmacyManager {
	private Medicine[] storehouse;
    private int count;

    public PharmacyManager(int size) {
        storehouse = new Medicine[size];
        count = 0;
    }
    
    public int getCount() {
    		return count;
    }
    public int getStorehouseLength() {
    		return storehouse.length;
    }

    public void addMedicine(Medicine med) throws InvalidDataException {
        storehouse[count++] = med;
        System.out.println("Medicine added successfully.");
    }
    
    public void search(int id) {
        for (int i = 0; i < count; i++) {
            if (storehouse[i].getId() == id) {
                storehouse[i].printInfo();
                return;
            }
        }
        System.out.println("Medicine with ID " + id + " not found.");
    }

    public void search(String name) {
        for (int i = 0; i < count; i++) {
            if (storehouse[i].getName().equalsIgnoreCase(name)) {
                storehouse[i].printInfo();
                return;
            }
        }
        System.out.println("Medicine with name " + name + " not found.");
    }

    public void updatePrice(int id, double newPrice) {
        for (int i = 0; i < count; i++) {
            if (storehouse[i].getId() == id) {
                storehouse[i].setPrice(newPrice);
                System.out.println("Price updated.");
                return;
            }
        }
        System.out.println("Medicine not found.");
    }
    
    public void showAllMedicines() {
    		System.out.println("========================================");
    		if(count == 0) {
    			System.out.println("Storehouse is empty!!");
    		} else {
    			for(int i = 0; i < count; i++) {
        			storehouse[i].printInfo();
        		}
    		}
    		System.out.println("========================================");
    }
}
