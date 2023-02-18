package com.example.bubble.models;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer result;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "bubble_id")
    private Bubble bubble;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Bubble getBubble() {
        return bubble;
    }

    public void setBubble(Bubble bubble) {
        this.bubble = bubble;
    }

    public Element(Integer result, Bubble bubble) {
        this.result = result;
        this.bubble = bubble;
    }

    public Element() {
    }
}
