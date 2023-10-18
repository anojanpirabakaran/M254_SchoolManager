package com.example.M151LB2.domain.marks;

import com.example.M151LB2.config.error.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MarksServiceImpl implements MarksService {

    private final Logger logger = LoggerFactory.getLogger(MarksServiceImpl.class);

    private final MarksRepository marksRepository;

    private final String NO_SUCH_ELEMENT_ERROR_MSG =
            "Mark with ID '%s' could not be found";

    private final String SUCH_ELEMENT_ALREADY_EXISTS_ERROR_MSG =
            "Entity with Mark Number '%s' already exists";

    @Autowired
    public MarksServiceImpl(MarksRepository marksRepository) {
        this.marksRepository = marksRepository;
    }

    @Override
    public void deleteById(String id) {
        logger.info("/DELETE deleteById Method request called");
        logger.info("Searching for the given ID");
        if (marksRepository.existsById(id)) {
            marksRepository.deleteById(id);
            logger.info("Mark deleted successfully.");
        } else {
            logger.error("Couldn't find the given ID, please check the inputs");
            throw new NoSuchElementException(String.format("Mark with ID '%s' not found", id));
        }

    }

    @Override
    public List<Marks> getAllMarks() {
        logger.info("/GET getAllMarks Method request called");
        logger.info("Accessing Database");
        if (marksRepository.findAll().isEmpty()) {
            logger.error("Database is empty");
            throw new NoSuchElementException(String.format("No Marks found in the database"));
        }
        logger.info("Entries found");
        logger.info("Get Marks successfully");
        return marksRepository.findAll();
    }

    @Override
    public Marks findById(String id) {
        logger.info("/GET findById Method request called");
        logger.info("Accessing Database");
        Optional<Marks> marks = marksRepository.findById(id);

        if (marks.isPresent()) {
            logger.info("Check if ID exists");
            logger.info("Get Mark by ID successfully.");
            return marks.get();
        } else {
            logger.error("Couldn't find the given ID, please check the inputs");
            throw new NoSuchElementException(String.format(NO_SUCH_ELEMENT_ERROR_MSG, id));
        }
    }

    @Override
    public Marks createMarks(Marks marks) {
        logger.info("/POST createMarks Method request called");
        logger.info("Check if Mark is already exists in Database");
        if (marksRepository.existsByMarkNumber(marks.getMarkNumber())) {
            logger.error("Mark Number already exists in Database, Please change Mark Number");
            throw new BadRequestException(
                    String.format(SUCH_ELEMENT_ALREADY_EXISTS_ERROR_MSG,
                            marks.getMarkNumber()));
        } else {
            logger.info("Mark Number doesn't exists in Database");
            logger.info("Create new Mark");
            return marksRepository.save(marks);
        }
    }

    @Override
    public String updateMarks(String id, Marks marks) throws Exception {
        logger.info("/PUT updateMarks Method request called");
        logger.info("Check if Mark exists in Database");
        if (marksRepository.existsById(id)) {
            logger.info("Search after Mark by ID");
            marksRepository.findById(id)
                    .map(marks1 -> {
                        marks1.setMarkNumber(marks.getMarkNumber());
                        if (marksRepository.existsByMarkNumber(marks.getMarkNumber())) {
                            logger.error("Mark Number already exists, Please Check Input");
                            throw new BadRequestException("Mark Number already exists");
                        } else {
                            logger.info("Updating Mark");
                            marksRepository.save(marks);
                        }
                        return "Update Marks";
                    }).orElseThrow(
                            () -> new Exception("Payment Detail not found - " + marks));
            return "Mark is updated";
        } else {
            logger.error("Mark doesn't exists in database, please check id or the input");
            throw new BadRequestException("Mark ID doesnt exists in Database");
        }
    }
}
