package com.example.withfront.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    private int starting;
    private int connecting;
    private int answering;
    private int ongoing;
    private int all;

    public Result() {
    }

    public int getStarting() {
        return starting;
    }

    public void setStarting(int starting) {
        this.starting = starting;
    }

    public int getConnecting() {
        return connecting;
    }

    public void setConnecting(int connecting) {
        this.connecting = connecting;
    }

    public int getAnswering() {
        return answering;
    }

    public void setAnswering(int answering) {
        this.answering = answering;
    }

    public int getOngoing() {
        return ongoing;
    }

    public void setOngoing(int ongoing) {
        this.ongoing = ongoing;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}
