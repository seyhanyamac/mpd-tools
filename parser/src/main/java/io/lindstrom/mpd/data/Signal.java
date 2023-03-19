package io.lindstrom.mpd.data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Objects;

public class Signal {
    static final String SCTE_NAMESPACE="urn:scte:scte35:2014:xml+bin";

    @JacksonXmlProperty(localName = "Binary", namespace = SCTE_NAMESPACE)
    private final String binary;

    public Signal(String binary) {
        this.binary = binary;
    }

    public Signal(){
        this.binary = null;
    }

    public String getBinary() {
        return binary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Signal signal = (Signal) o;
        return Objects.equals(binary, signal.binary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(binary);
    }

    @Override
    public String toString() {
        return "Signal{" +
                "binary=" + binary + '\'' +
                '}';
    }

    public Signal.Builder buildUpon() {
        return new Signal.Builder()
                .withBinary(binary);
    }

    public static Signal.Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String binary;

        public Signal.Builder withBinary(String binary) {
            this.binary = binary;
            return this;
        }

        public Signal build() {
            return new Signal(binary);
        }
    }
}
