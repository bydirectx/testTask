package ml.bondarev.m4bank.codeError;

public enum Code {

    Created("1", "Created"),
    Removed("2", "Removed"),
    AddSuccessful("3", "Addition successful"),
    NotAdded("11", "Item not added"),
    NotInDatabase("12", "Item not in database"),
    AlreadyBeenCreated("13", "Item has already been created"),
    SameParameters("14", "The addition parameters are the same."),
    NotConnect("21", "No database connection");

    private String code;
    private String description;

    Code(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
