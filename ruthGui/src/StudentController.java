import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.*;

public class StudentController {

    @FXML
    private Button zoekButton;
    @FXML
    private Button opslaanButton;
    @FXML
    private Button opnieuw;
    @FXML
    private TextField zoekInput;
    @FXML
    private TextField voornaamWijzigVak;
    @FXML
    private TextField naamWijzigVak;
    @FXML
    private TextField ssnWijzigVak;
    @FXML
    private Label voornaam;
    @FXML
    private Label naam;
    @FXML
    private Label bevestigOpslag;
    @FXML
    private Label instructiesNaOpzoeking;
    @FXML
    private Label geenToestemming;
    @FXML
    private ListView<String> zoekResultatenLijst;
    private ObservableList<String> items = FXCollections.observableArrayList();
    ResultSet rs = null;
    Connection connection = StudentIO.getConnection();
    Statement statement = StudentIO.getStatement();
    String zoekQuery = "select * from student where firstName like ? || lastName like ? || ssn like ?";
    String zoekQuerySsn = "select ssn from student where ssn = ?";
    String insertStudent = "insert into student (ssn, firstName, lastName) values (?,?,?)";
    PreparedStatement prepStmtZoek = connection.prepareStatement(zoekQuery);
    PreparedStatement insertStudents = connection.prepareStatement(insertStudent);
    PreparedStatement checkSsn = connection.prepareStatement(zoekQuerySsn);

    public StudentController() throws SQLException, ClassNotFoundException {}

    public void zoek() throws SQLException {
        zoekResultatenLijst.setItems(items);
        String zoekTerm = zoekInput.getText();
        prepStmtZoek.setString(1,"%"+ zoekTerm + "%");
        prepStmtZoek.setString(2,"%"+ zoekTerm + "%");
        prepStmtZoek.setString(3,"%"+ zoekTerm + "%");
        rs = prepStmtZoek.executeQuery();
        while (rs.next()) {
            items.add(rs.getString(2)+" "+rs.getString(4));
        }

            instructiesNaOpzoeking.setText("klik op de student in de lijst\n die je wil aanpassen");

        //if (!rs.next()){instructiesNaOpzoeking.setText("Geen match!");}
    }

    public void geenMachtiging(){
        instructiesNaOpzoeking.setText(null);
        geenToestemming.setText("U hebt geen machtiging \nom een bestaande student\n te wijzigen");
}

    public void catchWijzigNaam() throws SQLException {

        String nieuweVoornaam = voornaamWijzigVak.getText();
        String nieuweNaam = naamWijzigVak.getText();
        String nieuwSsn = ssnWijzigVak.getText();
        insertStudents.setString(2, nieuweVoornaam);
        insertStudents.setString(3, nieuweNaam);
        insertStudents.setString(1,nieuwSsn);
        checkSsn.setString(1,nieuwSsn);
        rs = checkSsn.executeQuery();

        if (!rs.next()) {
            insertStudents.execute();
            bevestigOpslag.setText(nieuweVoornaam + " " + nieuweNaam + " werd geregistreerd");
        }
        else{
            bevestigOpslag.setText(nieuwSsn+ " werd al gebruikt! Opslaan mislukt");
        }
    }

    public void wis()  {
        voornaamWijzigVak.setText(null);
        naamWijzigVak.setText(null);
        bevestigOpslag.setText(null);
        zoekInput.setText(null);
        zoekResultatenLijst.setItems(null);
        instructiesNaOpzoeking.setText(null);
        ssnWijzigVak.setText(null);
        geenToestemming.setText(null);
    }
}
