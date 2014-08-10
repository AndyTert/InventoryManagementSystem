package ims.domain;

public class UserAssembler {
	private User user;

	private UserAssembler(User user) {
		this.user = user;
	}

	public static UserDto assemble(User user) {
		return new UserAssembler(user).assembleUserDto();
	}

	private UserDto assembleUserDto() {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		return userDto;
	}
}
