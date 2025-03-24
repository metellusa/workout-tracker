package com.workout.tracker.model;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "users")
public abstract class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;
	@Column(nullable = false, unique = true, length = 255)
	private String username;
    @Column(nullable = false, unique = true, length = 255)
	private String email;
    @Column(name = "password_hash", columnDefinition = "TEXT")
	private String passwordHash;
    @Column(length = 50)
	private String provider;
    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Instant createdAt = Instant.now(); // Default to now
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public Instant getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public int hashCode() {
		return Objects.hash(createdAt, email, id, passwordHash, provider, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(passwordHash, other.passwordHash)
				&& Objects.equals(provider, other.provider) && Objects.equals(username, other.username);
	}

    @Override
	public String toString() {
		return "users [id=" + id + ", username=" + username + ", email=" + email + ", passwordHash=" + passwordHash
				+ ", provider=" + provider + ", createdAt=" + createdAt + "]";
	}

	
}
