package com.example.training.entity.cache;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * No cached entity.
 * 
 */
@Entity
public class NoCacheEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    /** Default constructor for Hibernate. */
    NoCacheEntity() { /* NOP */ }

    public NoCacheEntity(final String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
