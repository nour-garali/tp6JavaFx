package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class controller implements Initializable {
    private TextField tfnom;
    private TextField prenomField;
    private RadioButton tfF;
    private RadioButton tfM;
    private int  idE;
    private Button ajoutbtn;
    private Button supprimbtn;
    private Button modifbtn;
    private ComboBox<String> filiereComboBox;
    @FXML
    private TableView<Etudiant> tableEtudiant;
    @FXML
    private TableColumn<Etudiant, String> nomCol;
    @FXML
    private TableColumn<Etudiant, String> prenomCol;
    private TableColumn<Etudiant, String> sexeCol;
    @FXML
    private TableColumn<Etudiant, String> filiereCol;
    private ObservableList<Etudiant> etudiantData = FXCollections.observableArrayList();
    private Connection cnx = Connexion.getCn();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }}