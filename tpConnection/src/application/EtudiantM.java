package application;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantM {


    public boolean create(Etudiant etudiant) {
        try {
            // Récupérer la connexion à la base de données
            Connection connection = Connexion.getCn();

            String query = "INSERT INTO etudiant(nom, prenom, email, adresse) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getSexe());
            preparedStatement.setString(4, etudiant.getFiliere());

            int ligneinsere = preparedStatement.executeUpdate();
            if (ligneinsere > 0) {
                System.out.println("Un nouvel étudiant a été ajouté à la base de données.");
                return true;
            } else {
                System.out.println("Impossible d'ajouter l'étudiant à la base de données.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'étudiant à la base de données: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(Etudiant etudiant) {
        try {
            Connection connection = Connexion.getCn();

            String query = "DELETE FROM etudiant WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, etudiant.getId());

            int lignessup = preparedStatement.executeUpdate();

            // Vérifier si la requête a été exécutée avec succès
            if (lignessup > 0) {
                System.out.println("L'étudiant a été supprimé de la base de données.");
                return true;
            } else {
                System.out.println("Impossible de supprimer l'étudiant de la base de données.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'étudiant de la base de données: " + e.getMessage());
            return false;
        }
    }

    public boolean update(Etudiant etudiant) {
        try {
            Connection connection = Connexion.getCn();

            String query = "UPDATE etudiant SET nom=?, prenom=?, sexe=?, filiere=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getSexe());
            preparedStatement.setString(4, etudiant.getFiliere());
            preparedStatement.setInt(5, etudiant.getId());

            int lignesupdate = preparedStatement.executeUpdate();

            if (lignesupdate > 0) {
                System.out.println("L'étudiant a été mis à jour dans la base de données.");
                return true;
            } else {
                System.out.println("Impossible de mettre à jour l'étudiant dans la base de données.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'étudiant dans la base de données: " + e.getMessage());
            return false;
        }
    }

    public Etudiant findById(int id) {
        String query = "SELECT * FROM etudiant WHERE id = ?";
        PreparedStatement statement = null;
        ResultSet rs = null;
        Etudiant e = null;

        try {
            statement = Connexion.getCn().prepareStatement(query);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()) {

                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String sexe = rs.getString("sexe");
                String filiere = rs.getString("filiere");
                e = new Etudiant(id, nom, prenom, sexe, filiere);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche de l'étudiant avec l'ID " + id);
            ex.printStackTrace();
        }
        return e;
    }

    public List<Etudiant> findAll() {
        String query = "SELECT * FROM etudiant";
        Statement statement = null;
        ResultSet rs = null;
        List<Etudiant> etudiants = new ArrayList<>();

        try {
            statement = Connexion.getCn().createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String sexe = rs.getString("sexe");
                String filiere = rs.getString("filiere");
                Etudiant e = new Etudiant(id, nom, prenom, sexe, filiere);
                etudiants.add(e);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des étudiants");
            ex.printStackTrace();
        }
        return etudiants;
    }




}