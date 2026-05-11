package pharmacyManagementSystem;

import java.util.Scanner;

public class PharmacyApp {
    private static PharmacyManager manager = new PharmacyManager(10);
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
    		boolean loginStatus = login();
        if (loginStatus) {
            showMenu();
        } else {
            System.out.println("Username or Password incorrect!!");
        }
    }

    public static boolean login() {
        System.out.print("Enter Username: ");
        String user = scan.next();
        
        System.out.print("Enter Password: ");
        String pass = scan.next();
        
        boolean status = user.equals("admin") && pass.equals("123");
        return status;
    }

    public static void showMenu() {
        while (true) {
            System.out.println("\n--- Pharmacy System ---");
            System.out.println("1. Add Medicine");
            System.out.println("2. Search by ID");
            System.out.println("3. Search by Name");
            System.out.println("4. Update Price");
            System.out.println("5. Display All Medicines in storehouse.");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            
            try {
                int choice = scan.nextInt();
                selectOption(choice); 
            } catch (Exception e) {
                System.out.println("ادخال خاطئ!");
                scan.nextLine(); 
            }
            System.out.println("--------------------");
        }
    }

    public static void selectOption(int choice) throws InvalidDataException {
    	
        switch (choice) {
            case 1:
            		if (manager.getCount() >= manager.getStorehouseLength()) {
                    throw new InvalidDataException("Storehouse is full!");
                }
            		
                System.out.print("Enter ID: ");
                int id = scan.nextInt();
                // ممكن نضيف خطوة احترافية هنا

                System.out.print("Enter Name: ");
                String name = scan.next();
                
                System.out.print("Enter Price: ");
                double price = scan.nextDouble();
                
                MedicineType	 medType;
                if (price < 0) {
                    	throw new InvalidDataException("Price cannot be negative!");                	
                } else {
                		System.out.print("Choice Type Of Medicine: 1.TABLET 2.CAPSULE 3.VITAMIN (by default 'TABLET'): ");
                		int choiceType = scan.nextInt();
                		
                		if(choiceType == 1) {
                			medType = MedicineType.TABLET;
                		}else if(choiceType == 2) {
                			medType = MedicineType.CAPSULE;
                		}else if(choiceType == 3) {
                			medType = MedicineType.VITAMIN;
                		}else {
                			medType = MedicineType.TABLET;
                		}         	
                }
                manager.addMedicine(new Medicine(id, name, price, medType));   
                break;
            case 2:
                System.out.print("Enter ID: ");
                manager.search(scan.nextInt());
                break;
            case 3:
                System.out.print("Enter Name: ");
                manager.search(scan.next());
                break;
            case 4:
                System.out.print("Enter ID and New Price: ");
                manager.updatePrice(scan.nextInt(), scan.nextDouble());
                break;
            case 5:
            		manager.showAllMedicines();
            		break;
            case 6:
            		System.out.println("Sallam :)");
                System.exit(0);
                
            // ممكن نضيف خطوة احترافية هنا
        }
    }
}