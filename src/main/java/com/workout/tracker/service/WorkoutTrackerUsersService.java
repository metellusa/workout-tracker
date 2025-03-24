package com.workout.tracker.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

import com.workout.tracker.model.Users;

import jakarta.transaction.Transactional;

@Service
public class WorkoutTrackerUsersService {
	public Users createUsers(Users users){
		
		return null;
	}
	
	public ResponseEntity<Users> getUsersById(UUID id){
		return null;
	}
	@Transactional
	public ResponseEntity<Users> updateUsers(UUID id, Users updateUsers ){
		return null;
	}
	public ResponseEntity<Void> deleteUsers(UUID id) {
		return null;
	}
	

}
