package learn.venus.models;

public class Orbiter {

    private int orbiterId;
    private String name;
    private OrbiterType type;
    private String sponsor;

    public int getOrbiterId() {
        return orbiterId;
    }

    public void setOrbiterId(int orbiterId) {
        this.orbiterId = orbiterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrbiterType getType() {
        return type;
    }

    public void setType(OrbiterType type) {
        this.type = type;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }
}
