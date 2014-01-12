package com.example.training.entity.cache;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * An entity configured with {@link CacheConcurrencyStrategy#READ_WRITE Read-write} cache strategy.
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ReadWriteEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    /** Default constructor for Hibernate. */
    ReadWriteEntity() { /* NOP */ }

    public ReadWriteEntity(final String name) {
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
