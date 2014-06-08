package ims.tests;

import ims.dto.PartDto;
import ims.facade.FacadeFactory;
import junit.framework.TestCase;

public class PartsTest extends TestCase{

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		TestCleanup.cleanUp();
	}
	
	public void addPart() {
		//Assemble
		PartDto partDto = new PartDto();
		partDto.setName("part name");
		partDto.setQuantity(5);
		partDto.setPrice(10.99);
		
		//Act
		FacadeFactory.getFacade().addPart(partDto);
		
		//Assert
		PartDto actualPart = FacadeFactory.getFacade().findPartByName(partDto.getName());
		assertNotNull(actualPart);
		assertEquals("The name should be" + partDto.getName(), partDto.getName(), actualPart.getName());
		assertEquals("The quantity should be" + partDto.getQuantity(), partDto.getQuantity(), actualPart.getQuantity());
		assertEquals("The price should be" + partDto.getPrice(), partDto.getPrice(), actualPart.getPrice());
		
	}
	
	
}
