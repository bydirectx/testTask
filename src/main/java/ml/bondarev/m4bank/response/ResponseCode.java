package ml.bondarev.m4bank.response;

import ml.bondarev.m4bank.Code;

public class ResponseCode implements Response {
    private int code;
    private String description;

    public ResponseCode() {
    }

    public ResponseCode(Code code) {
        this.code = code.getCode();
        this.description = code.getDescription();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
