package io.javabrains.springbootstarter.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired  // this annoation marks something that needs dependency injection
	private CourseService courseservice;
	
	@RequestMapping("/topics/{id}/courses")    // equal to @GetMapping
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseservice.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {    // @PathVariable("foo") if used /topics/foo
			return courseservice.getCourse(id);			// that foo will be mapped to id. But not recommended
	}
	
	@PostMapping("/topics/{topicId}/courses")  // equal to @RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseservice.addCourse(course);
		
	}
	
	
	@PutMapping("/topics/{topicId}/courses/{id}")  // equal to @RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId , @PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		courseservice.updateCourse(course);
		
	}
	
	@DeleteMapping("/topics/{topicId}/courses/{id}")  // equal to @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteCourse(@PathVariable String id) {    
			 courseservice.deleteCourse(id);			
		
	}
}
