package Data;

import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;


public class Stoffdaten {
    //Stoffspezifische Daten
    SimpleStringProperty name = new SimpleStringProperty();
    SimpleStringProperty hersteller = new SimpleStringProperty();
    SimpleStringProperty aggregatszustand = new SimpleStringProperty();
    SimpleStringProperty maxLagermenge = new SimpleStringProperty();
    SimpleStringProperty arbeitsplatzGrenze = new SimpleStringProperty();
    SimpleStringProperty date = new SimpleStringProperty();
    SimpleStringProperty verwendung = new SimpleStringProperty();
    SimpleStringProperty stoffanmerkung = new SimpleStringProperty();
    SimpleStringProperty stoff_id = new SimpleStringProperty();
    SimpleStringProperty verbotslisten_id = new SimpleStringProperty();
    //Lagerspezifische Daten
    SimpleStringProperty lager_id = new SimpleStringProperty();
    SimpleStringProperty lagerbestand = new SimpleStringProperty();
    SimpleStringProperty lageranmerkung = new SimpleStringProperty();
    //Betriebsanweisungsdaten
    SimpleStringProperty betrebsanweisung_id = new SimpleStringProperty();
    SimpleStringProperty betriebsanweisung = new SimpleStringProperty();

    public void setName(String name) {
        this.name.set(name);
    }

    public void setHersteller(String hersteller) {
        this.hersteller.set(hersteller);
    }

    public void setAggregatszustand(String aggregatszustand) {
        this.aggregatszustand.set(aggregatszustand);
    }

    public void setMaxLagermenge(String maxLagermenge) {
        this.maxLagermenge.set(maxLagermenge);
    }

    public void setArbeitsplatzGrenze(String arbeitsplatzGrenze) {
        this.arbeitsplatzGrenze.set(arbeitsplatzGrenze);
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public void setVerwendung(String verwendung) {
        this.verwendung.set(verwendung);
    }

    public void setStoffanmerkung(String stoffanmerkung) {
        this.stoffanmerkung.set(stoffanmerkung);
    }

    public void setStoff_id(String stoff_id) {
        this.stoff_id.set(stoff_id);
    }

    public void setVerbotslisten_id(String verbotslisten_id) {
        this.verbotslisten_id.set(verbotslisten_id);
    }

    public void setLager_id(String lager_id) {
        this.lager_id.set(lager_id);
    }

    public void setLagerbestand(String lagerbestand) {
        this.lagerbestand.set(lagerbestand);
    }

    public void setLageranmerkung(String lageranmerkung) {
        this.lageranmerkung.set(lageranmerkung);
    }

    public void setBetrebsanweisung_id(String betrebsanweisung_id) {
        this.betrebsanweisung_id.set(betrebsanweisung_id);
    }

    public void setBetriebsanweisung(String betriebsanweisung) {
        this.betriebsanweisung.set(betriebsanweisung);
    }

    public String getName()
    {
        return name.get();
    }

    public String getHersteller() {
        return hersteller.get();
    }

    public String getAggregatszustand() {
        return aggregatszustand.get();
    }

    public String getMaxLagermenge() {
        return maxLagermenge.get();
    }

    public String getArbeitsplatzGrenze() {
        return arbeitsplatzGrenze.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getVerwendung() {
        return verwendung.get();
    }

    public String getStoffanmerkung() {
        return stoffanmerkung.get();
    }

    public String getStoff_id() {
        return stoff_id.get();
    }

    public String getVerbotslisten_id() {
        return verbotslisten_id.get();
    }


    public String getLager_id() {
        return lager_id.get();
    }

    public String getLagerbestand() {
        return lagerbestand.get();
    }

    public String getLageranmerkung() {
        return lageranmerkung.get();
    }


    public String getBetrebsanweisung_id() {
        return betrebsanweisung_id.get();
    }

    public String getBetriebsanweisung() {
        return betriebsanweisung.get();
    }
}

