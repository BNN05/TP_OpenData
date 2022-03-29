package fr.bnn05.tp_opendata;

import java.io.Serializable;

public class Diarrhé implements Serializable {
    private String semaine;
    private String region;
    private int casConsult;

    public Diarrhé(String semaine, String region, int casConsult) {
        this.semaine = semaine;
        this.region = region;
        this.casConsult = casConsult;
    }

    public String getSemaine() {
        return semaine;
    }

    public void setSemaine(String semaine) {
        this.semaine = semaine;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getCasConsult() {
        return casConsult;
    }

    public void setCasConsult(int casConsult) {
        this.casConsult = casConsult;
    }

    @Override
    public String toString() {
        return   region + " = "+ casConsult ;
    }
}
