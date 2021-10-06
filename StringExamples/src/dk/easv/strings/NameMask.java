package dk.easv.strings;

public class NameMask {
    private String name;
    private String mask;

    public NameMask(String name, String mask) {
        this.name = name;
        this.mask = mask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }
}
