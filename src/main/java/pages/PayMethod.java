package pages;

public enum PayMethod {

    BANK_WIRE("a[class='bankwire']"),
    CHECK("a[class='cheque']");

    private String payMethod;

    PayMethod(final String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayMethod() {
        return payMethod;
    }
}
