package edu.tutorial.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tutorial.entity.Tutorial;
import edu.tutorial.exception.ResourceNotFoundException;
import edu.tutorial.repository.TutorialRepository;

@Service
	public class TutorialServiceImpl implements TutorialService {

	    @Autowired
	    private TutorialRepository tutorialRepository;

	    @Override
	    public List<Tutorial> getAllTutorials() {
	        return tutorialRepository.findAll();
	    }

	    @Override
	    public Tutorial getTutorialById(int tutorialId) {
	        return tutorialRepository.findById(tutorialId)
	                .orElseThrow(() -> new ResourceNotFoundException("Tutorial not found with id: " + tutorialId));
	    }

	    @Override
	    public Tutorial createTutorial(Tutorial tutorial) {
	        return tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
	    }

	    @Override
	    public Tutorial updateTutorial(int tutorialId, Tutorial tutorialDetails) {
	        Tutorial tutorial = tutorialRepository.findById(tutorialId)
	                .orElseThrow(() -> new ResourceNotFoundException("Tutorial not found with id: " + tutorialId));
	        tutorial.setTitle(tutorialDetails.getTitle());
	        tutorial.setDescription(tutorialDetails.getDescription());
	        tutorial.setPublished(tutorialDetails.isPublished());
	        return tutorialRepository.save(tutorial);
	    }

	    @Override
	    public void deleteTutorial(int tutorialId) {
	        Tutorial tutorial = tutorialRepository.findById(tutorialId)
	                .orElseThrow(() -> new ResourceNotFoundException("Tutorial not found with id: " + tutorialId));
	        tutorialRepository.delete(tutorial);
	    }
	}


