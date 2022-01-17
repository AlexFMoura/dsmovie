package com.alex.dsmove.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alex.dsmove.dto.MovieDTO;
import com.alex.dsmove.dto.ScoreDTO;
import com.alex.dsmove.entities.Movie;
import com.alex.dsmove.entities.Score;
import com.alex.dsmove.entities.User;
import com.alex.dsmove.repositories.MovieRepository;
import com.alex.dsmove.repositories.ScoreRepository;
import com.alex.dsmove.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired	
	private MovieRepository movieRepository;
	
	@Autowired	
	private UserRepository userRepository;
	
	@Autowired	
	private ScoreRepository scoreRepository;
	
	@Transactional(readOnly = true)
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmial(dto.getEmail());		
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
			
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
		
	}

}
