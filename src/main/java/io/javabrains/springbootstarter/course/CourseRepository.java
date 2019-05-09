package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.javabrains.springbootstarter.topic.Topic;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	public List<Course> findByTopicId(String topicId);

}
