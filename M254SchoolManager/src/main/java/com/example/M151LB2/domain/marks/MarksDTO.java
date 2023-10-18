package com.example.M151LB2.domain.marks;

import com.example.M151LB2.config.generic.ExtendedDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MarksDTO extends ExtendedDTO {

    @NotNull
    @Size(min = 1, max = 25)
    private String marksNumber;

    public String getMarksNumber() {
        return marksNumber;
    }

    public void setMarksNumber(String marksNumber) {
        this.marksNumber = marksNumber;
    }
}
