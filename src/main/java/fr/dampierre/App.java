package fr.dampierre;

public class App {
  public static void main(String[] args) {
    Parking parking = new Parking(100);

    parking.inscrire("123-456");
    parking.inscrire("789-012");
    parking.inscrire("345-678");

    System.out.println("Liste des immatriculations autorisées : ");
    parking.afficherImmatriculationsAutorisees();

    parking.enregistrerEntree("123-456");
    parking.enregistrerEntree("789-012");
    parking.enregistrerEntree("345-678");

    System.out.println("Liste des immatriculations présentes : ");
    parking.afficherImmatriculationsPresentes();

  }
}
