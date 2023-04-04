package serviceImpl;

import classes.Medicine;
import classes.Person;
import classes.Pharmacy;
import exceptions.MyException;
import service.MedicineService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MedicineServiceImpl implements MedicineService {
    static int idCounter;

    @Override
    public Medicine addMedicineToPharmacy(List<Pharmacy> pharmacies) {
        Medicine medicine = null;
        try {
            System.out.print("Enter pharmacy id: ");
            int id = new Scanner(System.in).nextInt();
            for (Pharmacy p : pharmacies) {
                if (p.getId() == id) {
                    System.out.println("Enter medicine name: ");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("Enter medicine price: ");
                    int price = new Scanner(System.in).nextInt();
                    medicine = new Medicine(++idCounter, name, price);
                    p.getMedicines().add(medicine);
                } else {
                    throw new MyException("Pharmacy with id: " + id + " not found!");
                }
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Write only numbers!");
        }
        return medicine;
    }

    @Override
    public Medicine findMedicineByName(List<Pharmacy> pharmacies) {
        try {
            System.out.print("Enter medicine name: ");
            String name = new Scanner(System.in).nextLine();
            boolean isFalse = false;
            for (Pharmacy p : pharmacies) {
                for (Medicine m : p.getMedicines()) {
                    if (m.getName().equalsIgnoreCase(name)) {
                        isFalse = false;
                        return m;
                    } else {
                        isFalse = true;
                    }
                }
            }
            if (isFalse) {
                throw new MyException("Medicine with name: " + name + " not found!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
            return null;
    }

    @Override
    public List<Medicine> getAllMedicine(List<Pharmacy> pharmacies) {
        for (Pharmacy p:pharmacies) {
            for (Medicine m:p.getMedicines()) {
                return (List<Medicine>) m;
            }
        }
        return null;
    }

    @Override
    public void deleteMedicine(List<Pharmacy> pharmacies) {
        try {
            boolean isTrue = true;
            System.out.print("Enter medicine id: ");
            int id = new Scanner(System.in).nextInt();
            for (Pharmacy ph : pharmacies) {
                for (Medicine m : ph.getMedicines()) {
                    if (m.getId() == id) {
                        isTrue = true;
                        pharmacies.remove(m);
                        System.out.println("Medicine with id: " + id + " deleted!");
                    } else {
                        isTrue = false;
                    }
                }
            }
            if (!isTrue) {
                throw new MyException("Medicine with id: " + id + " not found!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Write only numbers!");
        }
    }
}
