package ml.bondarev.m4bank;

public enum Code {

    OK(0, "OK"),
    NOT_IN_DATABASE(11, "Item not in database"),
    ALREADY_BEEN_CREATED(12, "Item has already been created"),
    NOT_FOUND_EXCEPTION(31, "Not found exception");

    private int code;
    private String description;

    Code(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
