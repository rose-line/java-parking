package fr.dampierre;

import java.util.ArrayList;
import java.util.List;

public class Parc {

  private List<Parking> parkings;
  private List<String> immatriculationsAutorisees;

  public Parc() {
    parkings = new ArrayList<>();
    immatriculationsAutorisees = new ArrayList<>();
  }

  public List<String> getImmatriculationsAutorisees() {
    return immatriculationsAutorisees;
  }

  public Parking creerParking(int capacite) {
    Parking parking = new Parking(capacite);
    parkings.add(parking);
    return parking;
  }

  public int nbParkings() {
    return parkings.size();
  }

  public List<Parking> getParkings() {
    return parkings;
  }

  public boolean inscrire(String immatriculation) {
    return immatriculationsAutorisees.add(immatriculation);
  }

  public boolean enregistrerEntree(String immatriculation, Parking parking) {
    if (estAutorisee(immatriculation)) {
      if (parking.enregistrerEntree(immatriculation)) {
        return true;
      }
    }
    return false;
  }

  private boolean estAutorisee(String immatriculation) {
    return immatriculationsAutorisees.contains(immatriculation);
  }

  public void afficherImmatriculationsAutorisees() {
    for (String imm : immatriculationsAutorisees) {
      System.out.println(imm);
    }
  }

  public void afficherImmatriculationsPresentes() {
    System.out.println("Nombre de parkings : " + parkings.size());
    System.out.println("Liste des immatriculations :");

    for (Parking parking : parkings) {
      parking.afficherImmatriculationsPresentes();
    }
  }


}
