package ObservationTest.models;

public class Animal {
    private String speciesName;
    private String province;

    public Animal(String speciesName, String province) {
        this.speciesName = speciesName;
        this.province = province;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public String getProvince() {
        return province;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "speciesName='" + speciesName + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}

