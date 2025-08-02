package com.beanjoseph.BeanStyle_Hub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sizes")
public class Size {

    public Size() {
    }

    public Size(Long id, SizeCategory sizeCategory, String name) {
        this.id = id;
        this.sizeCategory = sizeCategory;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private SizeCategory sizeCategory;

    @Column(name = "name", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SizeCategory getSizeCategory() {
        return sizeCategory;
    }

    public void setSizeCategory(SizeCategory sizeCategory) {
        this.sizeCategory = sizeCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
