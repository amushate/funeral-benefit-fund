package org.fbf.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}