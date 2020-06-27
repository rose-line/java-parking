package fr.dampierre;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingTest {

  @Test
  void parkingPleinVehiculeAutorise_enregistrerEntree_DevraitRetournerFaux() {

    // Mise en place

    Parc parc = new Parc();
    Parking parking = parc.creerParking(3);
    String immatriculation = "123-AB-456";
    parc.inscrire(immatriculation);
    parking.enregistrerEntree(immatriculation);
    parking.enregistrerEntree(immatriculation);
    parking.enregistrerEntree(immatriculation);

    // Test

    boolean peutEntrer = parking.enregistrerEntree(immatriculation);

    // Validation

    assertEquals(false, peutEntrer);
  }

  @Test
  void parkingPleinVehiculeNonAutorise_enregistrerEntree_DevraitRetournerFaux() {

    // Mise en place

    Parc parc = new Parc();
    Parking parking = parc.creerParking(3);
    String immatriculation1 = "1";
    String immatriculation2 = "2";
    String immatriculation3 = "3";
    String immatriculationNonInscrite = "123456789";
    parc.inscrire(immatriculation1);
    parc.inscrire(immatriculation2);
    parc.inscrire(immatriculation3);
    parking.enregistrerEntree(immatriculation1);
    parking.enregistrerEntree(immatriculation2);
    parking.enregistrerEntree(immatriculation3);

    // Test

    boolean peutEntrer = parking.enregistrerEntree(immatriculationNonInscrite);

    // Validation

    assertEquals(false, peutEntrer);
  }

  @Test
  void parkingNonPleinVehiculeAutorise_enregistrerEntree_DevraitRetournerTrue() {

    // Mise en place

    Parc parc = new Parc();
    Parking parking = parc.creerParking(3);
    String immatriculation1 = "123";
    String immatriculation2 = "456";
    String immatriculation3 = "789";
    parc.inscrire(immatriculation1);
    parc.inscrire(immatriculation2);
    parc.inscrire(immatriculation3);
    parking.enregistrerEntree(immatriculation1);
    parking.enregistrerEntree(immatriculation2);

    // Test

    boolean peutEntrer = parking.enregistrerEntree(immatriculation3);

    // Validation

    assertEquals(true, peutEntrer);
  }


  @Test
  void avecUnVehiculeDansParking_enregistrerSortie_devraitLaisserParkingVide() {

    // Mise en place

    Parc parc = new Parc();
    Parking parking = parc.creerParking(100);
    String immatriculation = "123-AB-456";
    parc.inscrire(immatriculation);
    parking.enregistrerEntree(immatriculation);

    // Test

    parking.enregistrerSortie(immatriculation);

    // Validation

    assertEquals(true, parking.estVide());
  }

  @Test
  void deuxImmatriculationsIdentiques_enregistrerEntree_devraitRetournerFalse() {

    // Mise en place

    Parc parc = new Parc();
    Parking parking = parc.creerParking(100);
    String immatriculation = "123";
    parc.inscrire(immatriculation);
    parking.enregistrerEntree(immatriculation);

    // Test

    boolean rentre = parking.enregistrerEntree(immatriculation);

    // Vérification

    assertEquals(false, rentre);
  }

  @Test
  void parkingVide_tauxDOccupation_devraitRetourner0() {
    Parking parking = new Parking(100);

    double taux = parking.tauxDOccupation();

    assertEquals(0.0, taux);
  }

  @Test
  void parkingPlein_tauxDOccupation_devraitRetourner100() {


    Parc parc = new Parc();
    Parking parking = parc.creerParking(2);

    String imm1 = "1";
    String imm2 = "2";
    parc.inscrire(imm1);
    parc.inscrire(imm2);
    parking.enregistrerEntree(imm1);
    parking.enregistrerEntree(imm2);

    double taux = parking.tauxDOccupation();

    assertEquals(100.0, taux);
  }

  @Test
  void parkingAMoitiePlein_tauxDOccupation_devraitRetourner50() {

    Parc parc = new Parc();
    Parking parking = parc.creerParking(2);

    String imm1 = "1";
    parc.inscrire(imm1);
    parking.enregistrerEntree(imm1);

    double taux = parking.tauxDOccupation();

    assertEquals(50.0, taux);
  }

  @Test
  void avecUnVehicule_estPresente_devraitRenvoyerVraiPourCeVehicule() {

    Parc parc = new Parc();
    Parking parking = parc.creerParking(2);

    String imm1 = "1";
    parc.inscrire(imm1);
    parking.enregistrerEntree(imm1);

    boolean present = parking.estPresente(imm1);

    assertEquals(true, present);
  }

  @Test
  void avecParkingVide_estPresente_devraitRenvoyerFaux() {

    Parc parc = new Parc();
    Parking parking = parc.creerParking(2);
    String imm = "1";
    parc.inscrire(imm);

    boolean present = parking.estPresente(imm);

    assertEquals(false, present);
  }

  @Test
  void avecUnVehicule_estPresente_devraitRenvoyerFauxPourUnAutreVehicule() {

    Parc parc = new Parc();
    Parking parking = parc.creerParking(2);

    String imm1 = "1";
    parc.inscrire(imm1);
    parking.enregistrerEntree(imm1);

    String imm2 = "2";
    parc.inscrire(imm2);

    boolean present = parking.estPresente(imm2);

    assertEquals(false, present);
  }
}
