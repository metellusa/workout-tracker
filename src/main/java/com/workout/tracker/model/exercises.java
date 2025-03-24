package com.workout.tracker.model;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercises")
public abstract class exercises {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID DEFAULT gen_random_uuid()")
	private UUID id;
    @Column(name = "user_id", nullable = false, unique = true)
	private UUID userId;
    @Column(nullable = false, unique =false, length =225)
	private String name;
	@Column(name ="duration_minutes", nullable = false )
    private int duration_minutes;
	@Column(nullable = false, unique =false, length =50)
    private String muscleGroup;
    
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDurationMinutes() {
		return duration_minutes;
	}
	public void setDurationMinutes(int durationMinutes) {
		this.duration_minutes = durationMinutes;
	}
	public String getMuscleGroup() {
		return muscleGroup;
	}
	public void setMuscleGroup(String muscleGroup) {
		this.muscleGroup = muscleGroup;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(duration_minutes, id, muscleGroup, name, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		exercises other = (exercises) obj;
		return duration_minutes == other.duration_minutes && Objects.equals(id, other.id)
				&& Objects.equals(muscleGroup, other.muscleGroup) && Objects.equals(name, other.name)
				&& Objects.equals(userId, other.userId);
	}
	@Override
	public String toString() {
		return "exercises [id=" + id + ", userId=" + userId + ", name=" + name + ", durationMinutes=" + duration_minutes
				+ ", muscleGroup=" + muscleGroup + ", getId()=" + getId() + ", getUserId()=" + getUserId()
				+ ", getName()=" + getName() + ", getDurationMinutes()=" + getDurationMinutes() + ", getMuscleGroup()="
				+ getMuscleGroup() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

}
