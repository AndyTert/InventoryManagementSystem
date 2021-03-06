package ims.tests;

import ims.domain.UserDto;
import ims.dto.PartDto;
import ims.facade.FacadeFactory;
import junit.framework.TestCase;

public class UserTest extends TestCase {
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		TestCleanup.cleanUp();
	}
	
	public void test_addUser() {
		//Assemble
		UserDto userDto = new UserDto();
		userDto.setEmail("test@gmail.com");
		userDto.setPassword("rainbows123");

		//Act
		FacadeFactory.getFacade().addUser(userDto);
		
		//Assert
		UserDto actualUser = FacadeFactory.getFacade().findUserByEmail(userDto.getEmail());
		
		assertNotNull(actualUser);
		assertEquals("The email should be" + userDto.getEmail(), userDto.getEmail(), actualUser.getEmail());
		assertEquals("The password should be" + userDto.getPassword(), userDto.getPassword(), actualUser.getPassword());
	}
}
