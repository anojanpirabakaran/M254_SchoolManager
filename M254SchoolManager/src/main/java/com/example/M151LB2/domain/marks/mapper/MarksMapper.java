package com.example.M151LB2.domain.marks.mapper;

import com.example.M151LB2.domain.marks.Marks;
import com.example.M151LB2.domain.marks.MarksDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarksMapper {

    Marks fromDTO(MarksDTO marksDTO);

    List<Marks> fromDTOs(List<MarksDTO> marksDTO);

    MarksDTO toDTO(Marks marks);

    List<MarksDTO> toDTOs(List<Marks> marks);
}
