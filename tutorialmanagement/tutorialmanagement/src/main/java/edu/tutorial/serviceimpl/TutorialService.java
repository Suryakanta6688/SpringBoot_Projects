package edu.tutorial.serviceimpl;

import java.util.List;

import edu.tutorial.entity.Tutorial;

public interface TutorialService {

	List<Tutorial> getAllTutorials();

	Tutorial getTutorialById(int tutorialId);

	Tutorial createTutorial(Tutorial tutorial);

	Tutorial updateTutorial(int tutorialId, Tutorial tutorialDetails);

	void deleteTutorial(int tutorialId);

}
