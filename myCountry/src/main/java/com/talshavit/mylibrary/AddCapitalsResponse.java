package com.talshavit.mylibrary;

public class AddCapitalsResponse {
    private String message;

    public AddCapitalsResponse() {}

    public AddCapitalsResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
