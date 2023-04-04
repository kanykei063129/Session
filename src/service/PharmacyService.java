package service;

import classes.Pharmacy;

import java.util.List;

public interface PharmacyService {
    Pharmacy addPharmacy(List<Pharmacy> pharmacies);

    Pharmacy getPharmacyById(List<Pharmacy> pharmacies);

    List<Pharmacy> getAllPharmacy(List<Pharmacy> pharmacies);

    List<Pharmacy> getPharmacyByAddress(List<Pharmacy> pharmacies);

    Pharmacy updatePharmacyId(List<Pharmacy> pharmacies);

    void deletePharmacyById(List<Pharmacy> pharmacies);
}
