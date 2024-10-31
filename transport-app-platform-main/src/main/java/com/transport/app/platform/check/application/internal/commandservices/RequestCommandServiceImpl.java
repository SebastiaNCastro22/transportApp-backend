package com.transport.app.platform.check.application.internal.commandservices;

import com.transport.app.platform.check.domain.model.aggregates.Request;
import com.transport.app.platform.check.domain.model.commands.CreateRequestCommand;
import com.transport.app.platform.check.domain.services.RequestCommandService;
import com.transport.app.platform.check.infrastructure.persistence.jpa.repositories.RequestRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestCommandServiceImpl implements RequestCommandService {

    private final RequestRepository requestRepository;

    public RequestCommandServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Long handle(CreateRequestCommand command) {
        var request = new Request(command);
        try {
            requestRepository.save(request);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving request: " + e.getMessage());
        }
        return request.getId();
    }
/*
    @Override
    public Optional<Course> handle(UpdateCourseCommand command) {
        if (courseRepository.existsByTitleAndIdIsNot(command.title(), command.id()))
            throw new IllegalArgumentException("Course with same title already exists");
        var result = courseRepository.findById(command.id());
        if (result.isEmpty()) throw new IllegalArgumentException("Course does not exist");
        var courseToUpdate = result.get();
        try {
            var updatedCourse = courseRepository.save(courseToUpdate.updateInformation(command.title(), command.description()));
            return Optional.of(updatedCourse);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating course: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteCourseCommand command) {
        if (!courseRepository.existsById(command.courseId())) {
            throw new IllegalArgumentException("Course does not exist");
        }
        try {
            courseRepository.deleteById(command.courseId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting course: " + e.getMessage());
        }

    }

    @Override
    public void handle(AddTutorialToCourseLearningPathCommand command) {
        if (!courseRepository.existsById(command.courseId())) {
            throw new IllegalArgumentException("Course does not exist");
        }
        try {
            courseRepository.findById(command.courseId()).map(course -> {
                course.addTutorialToLearningPath(command.tutorialId());
                courseRepository.save(course);
                System.out.println("Tutorial added to learning path");
                return course;
            });
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while adding tutorial to learning path: " + e.getMessage());
        }


    }*/
}
