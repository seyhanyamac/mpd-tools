package io.lindstrom.mpd.data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Objects;

public class Event {
    @JacksonXmlProperty(isAttribute = true)
    private final Long presentationTime;

    @JacksonXmlProperty(isAttribute = true)
    private final Long duration;

    @JacksonXmlProperty(isAttribute = true)
    private final Long id;

    @JacksonXmlProperty(isAttribute = true)
    private final String messageData;

    @JacksonXmlProperty(localName = "Signal", namespace = Signal.SCTE_NAMESPACE)
    private final Signal signal;

    private Event(Long presentationTime, Long duration, Long id, String messageData, Signal signal) {
        this.presentationTime = presentationTime;
        this.duration = duration;
        this.id = id;
        this.messageData = messageData;
        this.signal = signal;
    }

    @SuppressWarnings("unused")
    private Event() {
        this.presentationTime = null;
        this.duration = null;
        this.id = null;
        this.messageData = null;
        this.signal = null;
    }

    public Long getPresentationTime() {
        return presentationTime;
    }

    public Long getDuration() {
        return duration;
    }

    public Long getId() {
        return id;
    }

    public String getMessageData() {
        return messageData;
    }

    public Signal getSignal(){
        return signal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(presentationTime, event.presentationTime) &&
                Objects.equals(duration, event.duration) &&
                Objects.equals(id, event.id) &&
                Objects.equals(messageData, event.messageData) &&
                Objects.equals(signal, event.signal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(presentationTime, duration, id, messageData, signal);
    }

    @Override
    public String toString() {
        return "Event{" +
                "presentationTime=" + presentationTime +
                ", duration=" + duration +
                ", id=" + id +
                ", messageData='" + messageData +
                ", signal=" + signal + '\'' +
                '}';
    }

    public Builder buildUpon() {
        return new Builder()
                .withPresentationTime(presentationTime)
                .withDuration(duration)
                .withId(id)
                .withMessageData(messageData)
                .withSignal(signal);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long presentationTime;
        private Long duration;
        private Long id;
        private String messageData;

        private Signal signal;

        public Builder withPresentationTime(Long presentationTime) {
            this.presentationTime = presentationTime;
            return this;
        }

        public Builder withDuration(Long duration) {
            this.duration = duration;
            return this;
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withMessageData(String messageData) {
            this.messageData = messageData;
            return this;
        }

        public Builder withSignal(Signal signal) {
            this.signal = signal;
            return this;
        }

        public Event build() {
            return new Event(presentationTime, duration, id, messageData, signal);
        }

    }
}
