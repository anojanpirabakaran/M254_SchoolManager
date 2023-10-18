package com.example.M151LB2.domain.marks;

import com.example.M151LB2.config.generic.ExtendedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "marks")
public class Marks extends ExtendedEntity {

    @Column(name = "markNumber", nullable = false)
    private String markNumber;

    public String getMarkNumber() {
        return markNumber;
    }

    public void setMarkNumber(String markNumber) {
        this.markNumber = markNumber;
    }
}
