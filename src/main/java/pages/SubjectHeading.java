package pages;

public enum SubjectHeading {

    CUSTOMER_SERVICE("Customer service"),
    WEBMASTER("Webmaster");

    private String subjectHeading;

    SubjectHeading(final String subjectHeading) {
        this.subjectHeading = subjectHeading;
    }

    public String getSubjectHeading() {
        return subjectHeading;
    }
}
