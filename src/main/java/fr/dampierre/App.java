package fr.dampierre;

public class App {
  public static void main(String[] args) {
    Parking parking = new Parking(3);

    parking.inscrire("123-456");
    parking.inscrire("789-012");
    parking.inscrire("345-678");
    parking.inscrire("012");

    System.out.println("Liste des immatriculations autorisées : ");
    parking.afficherImmatriculationsAutorisees();

    parking.enregistrerEntree("123-456");
    parking.enregistrerEntree("789-012");

    System.out.println("Liste des immatriculations présentes : ");
    parking.afficherImmatriculationsPresentes();

    System.out.println("123-456 sort.");
    parking.enregistrerSortie("123-456");
    parking.afficherImmatriculationsPresentes();

    System.out.println("123-456 entre.");
    parking.enregistrerEntree("123-456");
    parking.afficherImmatriculationsPresentes();

    System.out.println("345-678 entre.");
    parking.enregistrerEntree("345-678");
    parking.afficherImmatriculationsPresentes();

    System.out.println("012 tente de rentrer");
    parking.enregistrerEntree("012");
    parking.afficherImmatriculationsPresentes();


  }
}
