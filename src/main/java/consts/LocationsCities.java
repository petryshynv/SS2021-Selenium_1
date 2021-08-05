package consts;

public enum LocationsCities {
    LVIV("Lviv"), KHARKIV("Kharkiv");

    private final String city;

    LocationsCities(String city) {
        this.city = city;
    }

    public String getCity(){
        return city;
    }
}
