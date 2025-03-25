package com.workout.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

import com.workout.tracker.model.Users;
import com.workout.tracker.repository.WorkoutTrackerUsersRepository;

import jakarta.transaction.Transactional;

@Service
public class WorkoutTrackerUsersService {
	@Autowired
	WorkoutTrackerUsersRepository workoutTrackerUsersRepository;
	
	public Users createUsers(Users users){
		
		return workoutTrackerUsersRepository.save(users);
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<Users> getUsersById(UUID id){
		return (ResponseEntity<Users>) workoutTrackerUsersRepository.findByUserId(id);
	}
	@Transactional
	public ResponseEntity<Users> updateUsers(UUID id, Users updateUsers ){
		return workoutTrackerUsersRepository.findById(id)
		        .map(existingUser -> {
		            // Update fields
		            existingUser.setUsername(updateUsers.getUsername());
		            existingUser.setEmail(updateUsers.getEmail());
		            existingUser.setPasswordHash(updateUsers.getPasswordHash());
		            existingUser.setProvider(updateUsers.getProvider());

		            Users savedUser = workoutTrackerUsersRepository.save(existingUser); // Save updated user
		            return ResponseEntity.ok(savedUser); // Return updated user
		        })
		        .orElseGet(() -> ResponseEntity.notFound().build()); // Return 404 if user not found
		
	}
	public ResponseEntity<Void> deleteUsers(UUID id) {
		if (workoutTrackerUsersRepository.existsById(id)) {  // Check if user exists
			workoutTrackerUsersRepository.deleteById(id);  // Delete user
	        return ResponseEntity.noContent().build();  // Return 204 No Content
	    } else {
	        return ResponseEntity.notFound().build();  // Return 404 Not Found if user doesn't exist
	    }
	}
	

}
