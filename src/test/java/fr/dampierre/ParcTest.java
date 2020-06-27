package fr.dampierre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ParcTest {

  @Test
  void creationDeUnParking_creerParking_ParcGereUnParking() {

    // Mise en place

    Parc parc = new Parc();

    // Test

    parc.creerParking(100);

    // Vérification

    assertEquals(1, parc.nbParkings());
  }

  @Test
  void creationDeUnParking100places_creerParking_ParcGereUnParkingDe100places() {

    // Mise en place

    Parc parc = new Parc();
    int capacite = 100;

    // Test

    parc.creerParking(capacite);

    // Vérification

    assertEquals(capacite, parc.getParkings().get(0).getCapacite());
  }

  @Test
  void vehiculeInscrit_jeSaisPasQuoi_devraitPouvoirEntrerDansTousLesParkings() {

    // Mise en place

    Parc parc = new Parc();

    parc.creerParking(5);
    Parking parking2 = parc.creerParking(5);
    String imm = "1";
    parc.inscrire(imm);

    // Test

    boolean rentre = parc.enregistrerEntree(imm, parking2);

    // Vérification

    assertEquals(true, rentre);
  }

  @Test
  void avecUneImmatriculation_inscrire_devraitPeuplerTableauAvecUneImmatriculation() {

    Parc parc = new Parc();
    parc.creerParking(100);
    String immatriculation = "478-EF-561";

    boolean ok = parc.inscrire(immatriculation);

    assertEquals(true, ok);
    assertEquals(immatriculation, parc.getImmatriculationsAutorisees().get(0));
  }

  @Test
  void vehiculeAutorise_enregistrerEntree_devraitRetournerTrue() {

    Parc parc = new Parc();
    Parking parking = parc.creerParking(100);
    String immatriculation = "123-AB-456";
    parc.inscrire(immatriculation);

    boolean ok = parc.enregistrerEntree(immatriculation, parking);

    assertEquals(true, ok);
  }

  @Test
  void vehiculeNonAutoriseEtImmatriculationsAutoriseesNonVide_enregistrerEntree_devraitRetournerFaux() {

    Parc parc = new Parc();

    Parking parking = parc.creerParking(100);
    String immatriculation = "123-AB-456";
    String immatriculationBateau = "123456789";

    parc.inscrire(immatriculationBateau);
    parc.inscrire(immatriculationBateau);
    parc.inscrire(immatriculationBateau);
    parc.inscrire(immatriculationBateau);

    boolean ok = parc.enregistrerEntree(immatriculation, parking);

    assertEquals(false, ok);
  }

  @Test
  void vehiculeAutoriseEtImmatriculationsAutoriseesNonVide_enregistrerEntree_devraitRetournerTrue() {

    // Mise en place

    Parc parc = new Parc();
    Parking parking = parc.creerParking(100);
    String immatriculation = "123-AB-456";
    String immatriculationBateau = "123456789";
    parc.inscrire(immatriculationBateau);
    parc.inscrire(immatriculationBateau);
    parc.inscrire(immatriculation);
    parc.inscrire(immatriculationBateau);
    parc.inscrire(immatriculationBateau);

    // Test

    boolean ok = parc.enregistrerEntree(immatriculation, parking);

    // Vérification

    assertEquals(true, ok);
  }

  @Test
  void parkingNonPleinVehiculeNonAutorise_enregistrerEntree_DevraitRetournerFaux() {

    // Mise en place

    Parc parc = new Parc();
    Parking parking = parc.creerParking(3);
    String immatriculation1 = "1";
    String immatriculation2 = "2";
    String immatriculationNonInscrite = "123456789";
    parc.inscrire(immatriculation1);
    parc.inscrire(immatriculation2);
    parking.enregistrerEntree(immatriculation1);
    parking.enregistrerEntree(immatriculation2);

    // Test

    boolean peutEntrer = parc.enregistrerEntree(immatriculationNonInscrite, parking);

    // Validation

    assertEquals(false, peutEntrer);
  }

  @Test
  void vehiculeNonAutorise_enregistrerEntree_devraitRetournerFaux() {

    Parc parc = new Parc();
    Parking parking = parc.creerParking(100);
    String immatriculation = "123-AB-456";

    boolean ok = parc.enregistrerEntree(immatriculation, parking);

    assertEquals(false, ok);
  }
}
