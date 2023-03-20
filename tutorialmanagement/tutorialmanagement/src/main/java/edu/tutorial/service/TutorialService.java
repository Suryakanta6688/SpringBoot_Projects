	package edu.tutorial.service;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.dao.EmptyResultDataAccessException;
	import org.springframework.stereotype.Service;

	import edu.tutorial.entity.Tutorial;
	import edu.tutorial.exception.ResourceNotFoundException;
	import edu.tutorial.repository.TutorialRepository;

	@Service
	public class TutorialService {

		  @Autowired
		    private TutorialRepository tutorialRepository;

		    public Tutorial createTutorial(Tutorial tutorial) {
		        Tutorial _tutorial = tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
		        return _tutorial;
		    }

		    public Tutorial updateTutorial(int id, Tutorial tutorial) {
		        Optional<Tutorial> tdata = tutorialRepository.findById(id);
		        if (tdata.isPresent()) {
		            Tutorial _tutorial = tdata.get();
		            _tutorial.setTitle(tutorial.getTitle());
		            _tutorial.setDescription(tutorial.getDescription());
		            _tutorial.setPublished(tutorial.isPublished());
		            Tutorial updatedTutorial = tutorialRepository.save(_tutorial);
		            return updatedTutorial;
		        } else {
		            throw new ResourceNotFoundException("Tutorial not found with id: " + id);
		        }
		    }

		    public List<Tutorial> getAllTutorials(String title) {
		        List<Tutorial> tutorials = new ArrayList<Tutorial>();
		        if (title == null) {
		            tutorialRepository.findAll().forEach(tutorials::add);
		        } else {
		            tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
		        }
		        if (tutorials.isEmpty()) {
		            throw new ResourceNotFoundException("No tutorials found");
		        }
		        return tutorials;
		    }

		    public Tutorial getTutorialById(int id) {
		        Optional<Tutorial> tdata = tutorialRepository.findById(id);
		        if (tdata.isPresent()) {
		            return tdata.get();
		        } else {
		            throw new ResourceNotFoundException("Tutorial not found with id: " + id);
		        }
		    }

		    public void deleteTutorial(int id) {
		        try {
		            tutorialRepository.deleteById(id);
		        } catch (EmptyResultDataAccessException e) {
		            throw new ResourceNotFoundException("Tutorial not found with id: " + id);
		        }
		    }
		}




