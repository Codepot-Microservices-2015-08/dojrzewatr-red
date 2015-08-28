package pl.codepot.dojrzewatr.brewing.model;

/**
 * Created by kedzior on 28.08.15.
 */
public class Wort {
    private Integer wort;

    public Wort(Integer wort) {
        this.wort = wort;
    }

    public Wort() {
    }

    public Integer getWort() {
        return wort;
    }

    public void setWort(Integer wort) {
        this.wort = wort;
    }
}
