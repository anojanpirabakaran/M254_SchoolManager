package com.example.M151LB2.domain.marks;

import com.example.M151LB2.domain.marks.mapper.MarksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksController {

    private final MarksService marksService;

    private final MarksMapper marksMapper;

    @Autowired
    public MarksController(MarksService marksService, MarksMapper marksMapper) {
        this.marksService = marksService;
        this.marksMapper = marksMapper;
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<MarksDTO> getById(@PathVariable String id) {
        Marks mark = marksService.findById(id);
        return new ResponseEntity<>(marksMapper.toDTO(mark), HttpStatus.OK);
    }

    @GetMapping({"", "/"})
    public @ResponseBody ResponseEntity<List<MarksDTO>> getAll() {
        List<Marks> marks = marksService.getAllMarks();
        return new ResponseEntity<>(marksMapper.toDTOs(marks), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<MarksDTO> create(@Valid @RequestBody MarksDTO markDTO) {
        Marks mark = marksService.createMarks(marksMapper.fromDTO(markDTO));
        return new ResponseEntity<>(marksMapper.toDTO(mark), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}", "/{id}/"})
    public ResponseEntity<MarksDTO> updateById(@PathVariable String id,
                                               @RequestBody MarksDTO markDTO) throws Exception {
        Marks mark = marksMapper.fromDTO(markDTO);
        marksService.updateMarks(id, mark);
        return new ResponseEntity<>(marksMapper.toDTO(mark), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        marksService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
