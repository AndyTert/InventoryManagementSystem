package ims.tests;

import java.util.ArrayList;

import ims.dto.PartDto;
import ims.facade.FacadeFactory;
import junit.framework.TestCase;

public class PartsTest extends TestCase{

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		TestCleanup.cleanUp();
	}
	
	public void test_addPart() {
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
	
	public void test_updatePart() {
		//Assemble
		PartDto partDto = new PartDto();
		partDto.setName("part name");
		partDto.setQuantity(5);
		partDto.setPrice(10.99);
		FacadeFactory.getFacade().addPart(partDto);
		
		partDto = FacadeFactory.getFacade().findPartByName(partDto.getName());
		partDto.setName("new name");
		partDto.setQuantity(6);
		partDto.setPrice(11.11);
		
		//Act
		PartDto actualPart = FacadeFactory.getFacade().updatePart(partDto);
		
		///Assert
		assertNotNull(actualPart);
		assertEquals("The ID should be" + partDto.getId(), partDto.getId(), actualPart.getId());
		assertEquals("The name should be" + partDto.getName(), partDto.getName(), actualPart.getName());
		assertEquals("The quantity should be" + partDto.getQuantity(), partDto.getQuantity(), actualPart.getQuantity());
		assertEquals("The price should be" + partDto.getPrice(), partDto.getPrice(), actualPart.getPrice());
	}
	
	public void test_deletePart() {
		//Assemble
		PartDto partDto = new PartDto();
		partDto.setName("part name");
		partDto.setQuantity(5);
		partDto.setPrice(10.99);
		FacadeFactory.getFacade().addPart(partDto);
		
		partDto = FacadeFactory.getFacade().findPartByName(partDto.getName());
		
		//Act
		FacadeFactory.getFacade().deletePart(partDto.getId());
		
		//Assert
		PartDto actualPart = FacadeFactory.getFacade().findPartByName(partDto.getName());
		assertNull(actualPart);
	}
	
	public void test_getAllParts() {
		//Assemble
		PartDto partDto = new PartDto();
		partDto.setName("part name");
		partDto.setQuantity(5);
		partDto.setPrice(10.99);
		FacadeFactory.getFacade().addPart(partDto);
		
		//Act
		ArrayList<PartDto> allParts = FacadeFactory.getFacade().getAllParts();
		
		//Assert
		assertEquals("Number of parts should be 1", 1, allParts.size());
	}
	
	public void test_getAllParts_MultipleParts() {
		//Assemble
		PartDto partDto = new PartDto();
		partDto.setName("part name");
		partDto.setQuantity(5);
		partDto.setPrice(10.99);
		FacadeFactory.getFacade().addPart(partDto);
		
		PartDto partDto1 = new PartDto();
		partDto1.setName("part name 1");
		partDto1.setQuantity(10);
		partDto1.setPrice(15.99);
		FacadeFactory.getFacade().addPart(partDto1);
		
		PartDto partDto2 = new PartDto();
		partDto2.setName("part name 2");
		partDto2.setQuantity(15);
		partDto2.setPrice(20.99);
		FacadeFactory.getFacade().addPart(partDto2);
		
		//Act
		ArrayList<PartDto> allParts = FacadeFactory.getFacade().getAllParts();
		
		//Assert
		assertEquals("Number of parts should be 3", 3, allParts.size());
	}
	
	public void test_getAllParts_NoParts() {
		//Assemble
		//Act
		ArrayList<PartDto> allParts = FacadeFactory.getFacade().getAllParts();
		
		//Assert
		assertEquals("Number of parts should be 0", 0, allParts.size());
	}
	
	public void test_findPartByID() {
		//Assemble
		PartDto partDto = new PartDto();
		partDto.setName("name");
		partDto.setPrice(5);
		partDto.setQuantity(4);
		FacadeFactory.getFacade().addPart(partDto);
		PartDto partWithId = FacadeFactory.getFacade().findPartByName(partDto.getName());
		
		//Act
		PartDto actualPart = FacadeFactory.getFacade().findPartByID(partWithId.getId());
		
		//Assert
		assertNotNull(actualPart);
		assertEquals("The ID should be" + partWithId.getId(), partWithId.getId(), actualPart.getId());
		assertEquals("The name should be" + partWithId.getName(), partWithId.getName(), actualPart.getName());
		assertEquals("The quantity should be" + partWithId.getQuantity(), partWithId.getQuantity(), actualPart.getQuantity());
		assertEquals("The price should be" + partWithId.getPrice(), partWithId.getPrice(), actualPart.getPrice());
	}
	
	public void test_findPartByID_InvalidId() {
		//Assemble
		
		//Act
		PartDto part = FacadeFactory.getFacade().findPartByID(0);
		
		//Assert
		assertNull("Part should be null.", part);
	}
}
