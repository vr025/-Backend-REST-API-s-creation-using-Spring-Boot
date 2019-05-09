package io.javabrains.springbootstarter.topic;

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

@RestController
public class TopicController {
	
	@Autowired  // this annoation marks something that needs dependency injection
	private TopicService topicservice;
	
	@RequestMapping("/topics")    // equal to @GetMapping
	public List<Topic> getAllTopics() {
		return topicservice.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {    // @PathVariable("foo") if used /topics/foo
			return topicservice.getTopic(id);			// that foo will be mapped to id. But not recommended
	}
	
	@PostMapping("/topics")  // equal to @RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicservice.addTopic(topic);
		
	}
	
	
	@PutMapping("/topics/{id}")  // equal to @RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void addTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicservice.updateTopic(id, topic);
		
	}
	
	@DeleteMapping("/topics/{id}")  // equal to @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {    
			 topicservice.deleteTopic(id);			
		
	}
}
