package com.example.training.entity.cache;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Database entity to represent a railway station.
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Station {

    /** Unique identifier. <tt>null</tt> until it's persisted. */
    @Id
    @GeneratedValue
    private Long id;

    /** The name of the station. (NonNull) */
    private String name;

    /** The lines the station is on. */
    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private List<Line> lines = new ArrayList<Line>();

    /** Default constructor for hibernate. */
    Station() { /* NOP */ }

    /**
     * @param name The name of the station. (NonNull)
     * @param zone The zone where the station lays. (NonNull)
     */
    public Station(final String name) {
        super();
        this.name = name;
    }



    /**
     * @return Unique identifier. <tt>null</tt> until it's persisted.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id The unique identifier to set. (package private to avoid modification.)
     */
    void setId(final Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the lines
     */
    public List<Line> getLines() {
        return lines;
    }

    /**
     * @param lines the lines to set
     */
    void setLines(final List<Line> lines) {
        this.lines = lines;
    }



}
