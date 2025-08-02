package com.beanjoseph.BeanStyle_Hub.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "size_categories")
public class SizeCategory {

    public SizeCategory() {
    }

    public SizeCategory(Integer id, String name, Set<Size> sizes) {
        this.id = id;
        this.name = name;
        this.sizes = sizes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "sizeCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Size> sizes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Size> getSizes() {
        return sizes;
    }

    public void setSizes(Set<Size> sizes) {
        this.sizes = sizes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
