package pages;

public enum Gender {

    MR("div[id='uniform-id_gender1']"),
    MRS("div[id='uniform-id_gender2']");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
