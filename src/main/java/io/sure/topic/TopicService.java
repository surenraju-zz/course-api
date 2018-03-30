package io.sure.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		return makeCollection(topicRepository.findAll());
	}

	public Topic getTopic(String id) {
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		Topic dbtopic = getTopic(id);
		if (dbtopic != null) {
			dbtopic.setName(topic.getName());
			dbtopic.setDescription(topic.getDescription());
			topicRepository.save(dbtopic);
		}
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}

	static List<Topic> makeCollection(Iterable<Topic> iter) {
		List<Topic> topics = new ArrayList<Topic>();
		for (Topic item : iter) {
			topics.add(item);
		}
		return topics;
	}

}
