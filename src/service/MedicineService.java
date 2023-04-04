package service;

import classes.Medicine;
import classes.Pharmacy;

import java.util.List;

public interface MedicineService {
    Medicine addMedicineToPharmacy(List<Pharmacy> pharmacies);

    Medicine findMedicineByName(List<Pharmacy> pharmacies);

    List<Medicine> getAllMedicine(List<Pharmacy> pharmacies);

    void deleteMedicine(List<Pharmacy> pharmacies);
}
