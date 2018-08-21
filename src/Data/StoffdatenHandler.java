package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoffdatenHandler {
    ArrayList<Stoffdaten> stoffdatenContent;

    public StoffdatenHandler(ResultSet resultSet) throws SQLException {

        String name;
        String hersteller;
        String aggregatszustand;
        String maxLagermenge;
        String arbeitsplatzGrenze;
        String date;
        String verwendung;
        String stoffanmerkung;
        String stoff_id;
        String verbotslisten_id;
        //Lagerspezifische Daten
        String lager_id;
        String lagerbestand;
        String lageranmerkung;
        //Betriebsanweisungsdaten
        String betrebsanweisung_id;
        String betriebsanweisung;
        resultSet.first();

        while(resultSet.next())
        {
            Stoffdaten row = new Stoffdaten();
            row.setName (resultSet.getString(StoffdatenTablenames.NAME.name()));
            row.setHersteller (resultSet.getString(StoffdatenTablenames.HERSTELLER.name()));
            row.setAggregatszustand (resultSet.getString(StoffdatenTablenames.AGGREGATSZUSTAND.name()));
            row.setMaxLagermenge (resultSet.getString(StoffdatenTablenames.MAXLADEMENGE.name()));
            row.setArbeitsplatzGrenze (resultSet.getString(StoffdatenTablenames.ARBEITSPLATZGRENZE.name()));
            row.setDate (resultSet.getDate(StoffdatenTablenames.DATUM.name()).toString());
            row.setVerwendung (resultSet.getString(StoffdatenTablenames.VERWENDUNG.name()));
            row.setStoffanmerkung (resultSet.getString(StoffdatenTablenames.STOFFANMERKUNG.name()));
            row.setStoff_id (resultSet.getString(StoffdatenTablenames.STOFF_ID.name()));
            row.setVerbotslisten_id (resultSet.getString(StoffdatenTablenames.VERBOTSLISTEN_ID.name()));
            row.setLager_id (resultSet.getString(StoffdatenTablenames.LAGER_ID.name()));
            row.setLagerbestand (resultSet.getString(StoffdatenTablenames.LAGERBESTAND.name()));
            row.setLageranmerkung (resultSet.getString(StoffdatenTablenames.LAGERANMERKUNG.name()));
            row.setBetrebsanweisung_id (resultSet.getString(StoffdatenTablenames.BETRIEBSANWEISUNG_ID.name()));
            row.setBetriebsanweisung (resultSet.getString(StoffdatenTablenames.BETRIEBSANWEISUNG.name()));

            stoffdatenContent.add(row);
        }

    }
}
