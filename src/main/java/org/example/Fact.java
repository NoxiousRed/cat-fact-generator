package org.example;

/**
 * Class to hold information regarding the response from the API.
 * Constructor holds the fact and information data to be called from the main class
 */
public class Fact {

    private String fact;
    private String length;

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return fact;
    }
}
