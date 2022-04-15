package it.engineering.webapp.domain.dto;

public class UserDto {
	private String username;
	private String firstName;
	private String lastName;

	public UserDto(String username, String firstName, String lastName) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "UserDto [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
