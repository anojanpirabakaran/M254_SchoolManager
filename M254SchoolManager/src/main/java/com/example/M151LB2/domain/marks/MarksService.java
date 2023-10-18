package com.example.M151LB2.domain.marks;

import java.util.List;

public interface MarksService {

    void deleteById(String id);

    List<Marks> getAllMarks();

    Marks findById(String id);

    Marks createMarks(Marks marks);

    String updateMarks(String id, Marks marks) throws Exception;
}