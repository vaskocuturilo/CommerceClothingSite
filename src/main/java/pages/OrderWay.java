package pages;

public enum OrderWay {

    LOWEST("asc"),
    HIGHEST("desc"),
    NAME_A_Z("asc"),
    NAME_Z_A("desc"),
    STOCK("desc"),
    REFERENCE_LOW("asc"),
    REFERENCE_HIGH("desc");

    private String value;

    OrderWay(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
