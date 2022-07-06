package service;

import java.util.List;
import java.util.Scanner;

public class ClientWS {
    static Scanner sc = new Scanner(System.in);
    static EtudiantService stub = new EtudiantServiceService().getEtudiantServicePort();

    public static void main(String[] args) throws SQLException_Exception {
        affiche();

    }

    public static void affiche() throws SQLException_Exception {
        System.out.println("--------------------CHOIX MENU-----------------");
        System.out.println("Que souhaitez vous faire?");
        System.out.println("1. Ajouter un(e) étudiant(e).");
        System.out.println("2. Lister tous les étudiants.");
        System.out.println("3. Modifier un étudiant.");
        System.out.println("4. Supprimer un étudiant.");
        System.out.println("0. Quitter le programme.");
        System.out.println();
        while (choix() != 0) {
            affiche();
        }
        ;
    }

    public static int choix() throws SQLException_Exception {
        System.out.println("Veuillez effectuer votre choix : ");
        int choix = sc.nextInt();
        if (choix == 1) {
            // créer
            System.out.println("Entrez le prénom:");
            String prenom = sc.next();
            System.out.println("Entrez le nom:");
            String nom = sc.next();
            stub.newetudiant(nom, prenom);
            System.out.println("------------------------");
            System.out.println("L'étudiant(e) "+prenom +" " + nom+ " a bien été ajouté à la base de donnée.");
            System.out.println("------------------------");

        } else if (choix == 2) {
            // lister
            List<Etudiant> listeEtudiants = stub.getall();
            for (Etudiant etudiant : listeEtudiants) {
                System.out.println("------------------------");
                System.out.println(etudiant.getCode());
                System.out.println(etudiant.getNom());
                System.out.println(etudiant.getPrenom());
                System.out.println("------------------------");
            }
        } else if (choix == 3) {
            //modifier
            System.out.println("Not implemented method");
        } else if (choix == 4) {
            // supprimer
            System.out.println("Entrez l'identifiant de l'étudiant à supprimer:");
            int _id = sc.nextInt();
            stub.delete(_id);
            System.out.println("L'étudiant avec l'id "+_id+ " a bien été supprimé.");


        } else if (choix == 0) {
            // exit programm
            System.exit(0);
        }
        return choix;

    }
}