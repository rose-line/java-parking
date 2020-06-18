package fr.dampierre;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingTest {

  @Test
  void avecUneImmatriculation_inscrire_devraitAvoir1Inscrit() {

    Parking parking = new Parking(100);
    boolean ok = parking.inscrire("478-EF-561");

    assertEquals(true, ok);
    assertEquals(1, parking.getNbInscrits());
  }

  @Test
  void avecDeuxImmatriculations_inscrire_devraitAvoir2Inscrits() {
    Parking parking = new Parking(100);

    parking.inscrire("478-EF-561");
    parking.inscrire("478-EF-562");

    assertEquals(2, parking.getNbInscrits());
  }

  @Test
  void avecUneImmatriculation_inscrire_devraitPeuplerTableauAvecUneImmatriculation() {
    Parking parking = new Parking(100);

    String immatriculation = "478-EF-561";

    boolean ok = parking.inscrire(immatriculation);

    assertEquals(true, ok);
    assertEquals(immatriculation, parking.getImmatriculationsAutorisees()[0]);
  }

  @Test
  void avecTroisImmatriculations_inscrire_devraitPeuplerTableauAvecTroisImmatriculations() {
    Parking parking = new Parking(100);

    String immatriculation1 = "478-EF-561";
    String immatriculation2 = "478-EF-562";
    String immatriculation3 = "478-EF-563";

    parking.inscrire(immatriculation1);
    parking.inscrire(immatriculation2);
    parking.inscrire(immatriculation3);

    assertEquals(immatriculation2, parking.getImmatriculationsAutorisees()[1]);
    assertEquals(immatriculation3, parking.getImmatriculationsAutorisees()[2]);
  }

  @Test
  void inscriptionsMaxAtteint_inscrire_devraitRetournerFalse() {

    Parking parking = new Parking(100);

    boolean ok = false;
    for (int i = 0; i < 10000; i++) {
      ok = parking.inscrire("478-EF-561");
    }

    assertEquals(true, ok);

    ok = parking.inscrire("478-EF-561");

    assertEquals(false, ok);
  }

  @Test
  void vehiculeNonAutorise_enregistrerEntree_devraitRetournerFaux() {

    Parking parking = new Parking(100);
    String immatriculation = "123-AB-456";

    boolean ok = parking.enregistrerEntree(immatriculation);

    assertEquals(false, ok);
  }

  @Test
  void vehiculeAutorise_enregistrerEntree_devraitRetournerTrue() {

    Parking parking = new Parking(100);
    String immatriculation = "123-AB-456";
    parking.inscrire(immatriculation);

    boolean ok = parking.enregistrerEntree(immatriculation);

    assertEquals(true, ok);
  }

  @Test
  void vehiculeNonAutoriseEtImmatriculationsAutoriseesNonVide_enregistrerEntree_devraitRetournerFaux() {

    Parking parking = new Parking(100);
    String immatriculation = "123-AB-456";
    String immatriculationBateau = "123456789";

    parking.inscrire(immatriculationBateau);
    parking.inscrire(immatriculationBateau);
    parking.inscrire(immatriculationBateau);
    parking.inscrire(immatriculationBateau);

    boolean ok = parking.enregistrerEntree(immatriculation);

    assertEquals(false, ok);
  }

  @Test
  void vehiculeAutoriseEtImmatriculationsAutoriseesNonVide_enregistrerEntree_devraitRetournerTrue() {

    // Mise en place

    Parking parking = new Parking(100);
    String immatriculation = "123-AB-456";
    String immatriculationBateau = "123456789";
    parking.inscrire(immatriculationBateau);
    parking.inscrire(immatriculationBateau);
    parking.inscrire(immatriculation);
    parking.inscrire(immatriculationBateau);
    parking.inscrire(immatriculationBateau);

    // Test

    boolean ok = parking.enregistrerEntree(immatriculation);

    // Vérification

    assertEquals(true, ok);
  }

  @Test
  void parkingPleinVehiculeAutorise_enregistrerEntree_DevraitRetournerFaux() {

    // Mise en place

    Parking parking = new Parking(3);
    String immatriculation = "123-AB-456";
    parking.inscrire(immatriculation);
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

    Parking parking = new Parking(3);
    String immatriculation = "123-AB-456";
    String immatriculationNonInscrite = "123456789";
    parking.inscrire(immatriculation);
    parking.enregistrerEntree(immatriculation);
    parking.enregistrerEntree(immatriculation);
    parking.enregistrerEntree(immatriculation);

    // Test

    boolean peutEntrer = parking.enregistrerEntree(immatriculationNonInscrite);

    // Validation

    assertEquals(false, peutEntrer);
  }

  @Test
  void parkingNonPleinVehiculeAutorise_enregistrerEntree_DevraitRetournerTrue() {

    // Mise en place

    Parking parking = new Parking(3);
    String immatriculation = "123-AB-456";
    parking.inscrire(immatriculation);
    parking.enregistrerEntree(immatriculation);
    parking.enregistrerEntree(immatriculation);

    // Test

    boolean peutEntrer = parking.enregistrerEntree(immatriculation);

    // Validation

    assertEquals(true, peutEntrer);
  }

  @Test
  void parkingNonPleinVehiculeNonAutorise_enregistrerEntree_DevraitRetournerFaux() {

    // Mise en place

    Parking parking = new Parking(3);
    String immatriculation = "123-AB-456";
    String immatriculationNonInscrite = "123456789";
    parking.inscrire(immatriculation);
    parking.enregistrerEntree(immatriculation);
    parking.enregistrerEntree(immatriculation);

    // Test

    boolean peutEntrer = parking.enregistrerEntree(immatriculationNonInscrite);

    // Validation

    assertEquals(false, peutEntrer);
  }

  @Test
  void avecUnVehiculeDansParking_enregistrerSortie_devraitLaisserParkingVide() {

    // Mise en place

    Parking parking = new Parking(100);
    String immatriculation = "123-AB-456";
    parking.inscrire(immatriculation);
    parking.enregistrerEntree(immatriculation);

    // Test

    parking.enregistrerSortie();

    // Validation

    assertEquals(true, parking.estVide());
  }
}
