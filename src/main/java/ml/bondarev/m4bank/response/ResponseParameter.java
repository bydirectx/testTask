package ml.bondarev.m4bank.response;

import ml.bondarev.m4bank.Code;

public class ResponseParameter implements Response {
    private int sum;
    private int code;
    private String description;

    public ResponseParameter() {
    }

    public ResponseParameter(Code code, int sum) {
        this.code = code.getCode();
        this.description = code.getDescription();
        this.sum = sum;
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

    public void setSum(int value) {
        this.sum = value;
    }

    public int getSum() {
        return sum;
    }
}
