package com.example.bubble.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Bubble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String result;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "bubble_id")
    private List<Element> elements;

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public Bubble() {
    }

    public Bubble(String result) {

        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
