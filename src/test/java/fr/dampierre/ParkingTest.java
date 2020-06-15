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
    assertEquals(immatriculation, parking.getInscriptionsDesImmatriculations()[0]);
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

    assertEquals(immatriculation2, parking.getInscriptionsDesImmatriculations()[1]);
    assertEquals(immatriculation3, parking.getInscriptionsDesImmatriculations()[2]);
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
  void vehiculeAutorise_validerEntree_devraitRetournerTrue() {

    Parking parking = new Parking(100);
    String immatriculation = "123-AB-456";

    boolean ok = parking.validerEntree(immatriculation);

    assertEquals(false, ok);
  }
}
