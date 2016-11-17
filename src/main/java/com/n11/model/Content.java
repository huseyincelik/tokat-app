package com.n11.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "content")
public class Content implements Serializable {

    @Id
    private Long id;

    @Column(nullable = false)
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
