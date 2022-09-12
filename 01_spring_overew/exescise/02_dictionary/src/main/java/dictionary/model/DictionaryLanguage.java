package dictionary.model;

public class DictionaryLanguage {

    private String english;
    private String vietNamese;

    public DictionaryLanguage() {
    }

    public DictionaryLanguage(String english, String vietNamese) {

        this.english = english;
        this.vietNamese = vietNamese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getVietNamese() {
        return vietNamese;
    }

    public void setVietNamese(String vietNamese) {
        this.vietNamese = vietNamese;
    }
}
