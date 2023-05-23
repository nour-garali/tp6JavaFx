package application;


public class Etudiant {

    private int id ;
    private String nom ;
    private String prenom ;
    private String filiere;
    private String sexe ;

    public Etudiant( int id ,String nom, String prenom, String filiere, String sexe) {

        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
        this.sexe = sexe;
    }


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getFiliere() {
        return filiere;
    }

    public String getSexe() {
        return sexe;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom=" + prenom +
                ", filiere='" + filiere + '\'' +
                ", sexe='" + sexe + '\'' +
                '}';
    }
}
