package com.workout.tracker.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "workouts")
public class workouts {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(columnDefinition = "UUID DEFAULT gen_random_uuid()")
	private UUID id;
   @Column(name = "user_id", nullable = false, unique = true)
	private UUID userId;
   @JoinColumn(name = "email", referencedColumnName = "id", nullable = false)
    private Users user;
   @Column(name = "date", updatable = false)
   @Temporal(TemporalType.TIMESTAMP)
    private Instant date = Instant.now(); // Default timestamp
   @Column(name = "duration_minutes", nullable = false)
    private int durationMinutes;

   @Column(length = 50, nullable = false)
   @Enumerated(EnumType.STRING)
    private Category category;
   @Column(columnDefinition = "TEXT")
    private String feedback;
    public enum Category {
        CARDIO, RESISTANCE;
    }
    
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
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	public int getDurationMinutes() {
		return durationMinutes;
	}
	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
    @Override
   	public int hashCode() {
   		return Objects.hash(category, durationMinutes, feedback);
   	}
   	@Override
   	public boolean equals(Object obj) {
   		if (this == obj)
   			return true;
   		if (obj == null)
   			return false;
   		if (getClass() != obj.getClass())
   			return false;
   		workouts other = (workouts) obj;
   		return category == other.category && durationMinutes == other.durationMinutes
   				&& Objects.equals(feedback, other.feedback);
   	}
    @Override
   	public String toString() {
   		return "workouts [durationMinutes=" + durationMinutes + ", category=" + category + ", feedback=" + feedback
   				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
   				+ "]";
   	}
}

