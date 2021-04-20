package pages;

public enum SortBy {

    LOWEST("Price: Lowest first"),
    HIGHEST("Price: Highest first"),
    NAME_A_Z("Product Name: A to Z"),
    NAME_Z_A("Product Name: Z to A"),
    STOCK("In stock"),
    REFERENCE_LOW("Reference: Lowest first"),
    REFERENCE_HIGH("Reference: Highest first");

    private String value;

    SortBy(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
