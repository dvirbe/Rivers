package org.example;

public class River {
    private String name;
    private int lengthKm;
    private int lengthMiles;
    private int drainageArea;

    public River () {

    }

    public River(String name, int lengthKm, int lengthMiles, int drainageArea) {
        this.name = name;
        this.lengthKm = lengthKm;
        this.lengthMiles = lengthMiles;
        this.drainageArea = drainageArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLengthKm() {
        return lengthKm;
    }

    public void setLengthKm(int lengthKm) {
        this.lengthKm = lengthKm;
    }

    public int getLengthMiles() {
        return lengthMiles;
    }

    public void setLengthMiles(int lengthMiles) {
        this.lengthMiles = lengthMiles;
    }

    public int getDrainageArea() {
        return drainageArea;
    }

    public void setDrainageArea(int drainageArea) {
        this.drainageArea = drainageArea;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("River{");
        sb.append("name='").append(name).append('\'');
        sb.append(", lengthKm=").append(lengthKm);
        sb.append(", lengthMiles=").append(lengthMiles);
        sb.append(", drainageArea=").append(drainageArea);
        sb.append('}');
        return sb.toString();
    }

}
