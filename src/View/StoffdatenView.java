package View;

import Data.DatabaseHandler;
import Data.Stoffdaten;
import Data.StoffdatenHandler;
import Data.StoffdatenTablenames;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.h2.engine.Database;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class StoffdatenView implements Initializable {

    Logger logger;
    private DatabaseHandler connection;
    private ObservableList<Stoffdaten> data;

    @FXML TableView<Stoffdaten> tbl_data;

    @FXML TableColumn<Stoffdaten, String> col_name;
    @FXML TableColumn<Stoffdaten, String> col_hersteller;
    @FXML TableColumn<Stoffdaten, String> col_aggregat;
    @FXML TableColumn<Stoffdaten, String> col_maxLager;
    @FXML TableColumn<Stoffdaten, String> col_arbeitsplatz;
    @FXML TableColumn<Stoffdaten, String> col_datum;
    @FXML TableColumn<Stoffdaten, String> col_verwendung;
    @FXML TableColumn<Stoffdaten, String> col_stoffanmerkung;
    @FXML TableColumn<Stoffdaten, String> col_lagerbestand;
    @FXML TableColumn<Stoffdaten, String> col_lageranmerkung;
    @FXML TableColumn<Stoffdaten, String> col_betriebsanweisung;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert tbl_data != null : "fx:id=\"tbl_data\" was not injected: check your FXML file 'UserMaster.fxml'.";
        col_name.setCellValueFactory(new PropertyValueFactory<Stoffdaten,String>("name"));
        col_hersteller.setCellValueFactory(new PropertyValueFactory<Stoffdaten, String>("hersteller"));
        col_aggregat.setCellValueFactory(new PropertyValueFactory<Stoffdaten, String>("aggregatszustand"));
        col_maxLager.setCellValueFactory(new PropertyValueFactory<Stoffdaten, String>("maxLagermenge"));
        col_arbeitsplatz.setCellValueFactory(new PropertyValueFactory<Stoffdaten, String>("arbeitsplatzGrenze"));
        col_datum.setCellValueFactory(new PropertyValueFactory<Stoffdaten, String>("date"));
        col_verwendung.setCellValueFactory(new PropertyValueFactory<Stoffdaten, String>("verwendung"));
        col_stoffanmerkung.setCellValueFactory(new PropertyValueFactory<Stoffdaten, String>("stoffanmerkung"));
        col_lagerbestand.setCellValueFactory(new PropertyValueFactory<Stoffdaten, String>("lagerbestand"));
        col_lageranmerkung.setCellValueFactory(new PropertyValueFactory<Stoffdaten, String>("lageranmerkung"));
        col_betriebsanweisung.setCellValueFactory(new PropertyValueFactory<Stoffdaten, String>("betriebsanweisung"));


        try {
            DatabaseHandler.instance = new DatabaseHandler("jdbc:h2:~/test", "sa", "");
            fetch();
        }
        catch(ClassNotFoundException ce){
            logger.info(ce.toString());
        }
        catch(SQLException ce){
            logger.info(ce.toString());
        }
    }
    private void fetch() throws SQLException, ClassNotFoundException {
        data = FXCollections.observableArrayList();
        try {
            String querry = "select NAME, HERSTELLER,  AGGREGATSZUSTAND, MAXLADEMENGE, ARBEITSPLATZGRENZE, DATUM, VERWENDUNG, STOFFANMERKUNG , STOFFDATEN.STOFF_ID, LAGERMENGE, ANMERKUNG, LAGERDATEN.LAGER_ID, BETRIENSANMERKUNG, VERBOTSLISTEN_ID, ANMERKUNGSDATEN.BETRIEBSANMERKUNG_ID " +
                    "from STOFFDATEN, LAGERDATEN, ANMERKUNGSDATEN " +
                    "where STOFFDATEN.STOFF_ID = LAGERDATEN.STOFF_ID and " +
                    "LAGERDATEN.LAGER_ID = STOFFDATEN.LAGER_ID and " +
                    "STOFFDATEN.BETRIEBSANMERKUNG_ID = ANMERKUNGSDATEN.BETRIEBSANMERKUNG_ID";
            ResultSet resultSet = DatabaseHandler.instance.executeStatement(querry);
            //resultSet.first();

            while(resultSet.next())
            {
                Stoffdaten row = new Stoffdaten();
//                row.setName (resultSet.getString(StoffdatenTablenames.NAME.name()));
                //row.setHersteller (resultSet.getString(StoffdatenTablenames.HERSTELLER.name()));
                //row.setAggregatszustand (resultSet.getString(StoffdatenTablenames.AGGREGATSZUSTAND.name()));
                //row.setMaxLagermenge (resultSet.getString(StoffdatenTablenames.MAXLADEMENGE.name()));
                //row.setArbeitsplatzGrenze (resultSet.getString(StoffdatenTablenames.ARBEITSPLATZGRENZE.name()));
                //row.setDate (resultSet.getDate(StoffdatenTablenames.DATUM.name()).toString());
                //row.setVerwendung (resultSet.getString(StoffdatenTablenames.VERWENDUNG.name()));
                //row.setStoffanmerkung (resultSet.getString(StoffdatenTablenames.STOFFANMERKUNG.name()));
                //row.setStoff_id (resultSet.getString(StoffdatenTablenames.STOFF_ID.name()));
                //row.setVerbotslisten_id (resultSet.getString(StoffdatenTablenames.VERBOTSLISTEN_ID.name()));
                //row.setLager_id (resultSet.getString(StoffdatenTablenames.LAGER_ID.name()));
                //row.setLagerbestand (resultSet.getString(StoffdatenTablenames.LAGERBESTAND.name()));
                //row.setLageranmerkung (resultSet.getString(StoffdatenTablenames.LAGERANMERKUNG.name()));
                //row.setBetrebsanweisung_id (resultSet.getString(StoffdatenTablenames.BETRIEBSANWEISUNG_ID.name()));
                //row.setBetriebsanweisung (resultSet.getString(StoffdatenTablenames.BETRIEBSANWEISUNG.name()));
                row.setName (resultSet.getString("NAME"));
                row.setHersteller (resultSet.getString("HERSTELLER"));
                row.setAggregatszustand (resultSet.getString("AGGREGATSZUSTAND"));
                row.setMaxLagermenge (resultSet.getString("MAXLADEMENGE"));
                row.setArbeitsplatzGrenze (resultSet.getString("ARBEITSPLATZGRENZE"));
                row.setDate (resultSet.getDate("DATUM").toString());
                row.setVerwendung (resultSet.getString("VERWENDUNG"));
                row.setStoffanmerkung (resultSet.getString("STOFFANMERKUNG"));
                row.setStoff_id (resultSet.getString("STOFFDATEN.STOFF_ID"));
                row.setVerbotslisten_id (resultSet.getString("VERBOTSLISTEN_ID"));
                row.setLager_id (resultSet.getString("LAGERDATEN.LAGER_ID"));
                row.setLagerbestand (resultSet.getString("LAGERMENGE"));
                row.setLageranmerkung (resultSet.getString("ANMERKUNG"));
                row.setBetrebsanweisung_id (resultSet.getString("ANMERKUNGSDATEN.BETRIEBSANMERKUNG_ID"));
                row.setBetriebsanweisung (resultSet.getString("BETRIENSANMERKUNG"));
                data.add(row);
            }
            tbl_data.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }
}
