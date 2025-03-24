package com.workout.tracker;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workout.tracker.model.Users;
import com.workout.tracker.service.WorkoutTrackerUsersService;

@RestController
@RequestMapping()
public class WorkoutTrackerUsersController {
	@Autowired
	WorkoutTrackerUsersService workoutTrackerUsersService;

	@GetMapping()
public List<Users> getAllUsers(){
	return null;		
}

@GetMapping()
public ResponseEntity<Users> getUsersById(@PathVariable UUID id){
	
 return workoutTrackerUsersService.getUsersById(id);
}
@PostMapping()
public Users createUsers(@RequestBody Users user) {
	return workoutTrackerUsersService.createUsers(user) ;
}

@DeleteMapping()
public ResponseEntity<Void> deleteUser(@PathVariable UUID id){
	return workoutTrackerUsersService.deleteUsers(id);
	
}
}
