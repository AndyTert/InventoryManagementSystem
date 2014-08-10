package ims.facade;

import java.util.ArrayList;
import java.util.List;

import ims.domain.Part;
import ims.domain.PartAssembler;
import ims.domain.User;
import ims.domain.UserAssembler;
import ims.domain.UserDto;
import ims.dto.PartDto;
import ims.repository.PartRepository;
import ims.repository.UserRepository;

public class Facade {

	public void addPart(PartDto partDto) {
		Part part = new Part();
		part.setName(partDto.getName());
		part.setQuantity(partDto.getQuantity());
		part.setPrice(partDto.getPrice());
		
		PartRepository pr = new PartRepository();
		pr.addPart(part);
	}

	public PartDto updatePart(PartDto partDto) {
		PartRepository pr = new PartRepository();
		
		Part part = pr.findPartById(partDto.getId());
		part.setName(partDto.getName());
		part.setQuantity(partDto.getQuantity());
		part.setPrice(partDto.getPrice());
		
		pr.updatePart(part);
		
		return PartAssembler.assemble(part);
	}

	public void deletePart(int id) {
		PartRepository pr = new PartRepository();
		pr.deletePart(id);
	}

	public ArrayList<PartDto> getAllParts() {
		PartRepository pr = new PartRepository();
		List<Part> parts = pr.getAllParts();
		return PartAssembler.assemble(parts);
	}

	public PartDto findPartByID(int id) {
		PartRepository pr = new PartRepository();
		Part part = pr.findPartById(id);
		if ( part == null) {
			return null;
		}
		return PartAssembler.assemble(part);
	}
	
	public PartDto findPartByName(String name) {
		PartRepository pr = new PartRepository();
		Part part = pr.findPartByName(name);
		if (part == null) {
			return null;
		}
		return PartAssembler.assemble(part);
	}

	public void addUser(UserDto userDto) {
		User user = new User();
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		
		UserRepository ur = new UserRepository();
		ur.addUser(user);
		
		
	}

	public UserDto findUserByEmail(String email) {
		UserRepository ur = new UserRepository();
		User user = ur.findUserByEmail(email);
		if(user == null) {
			return null;
		}
		return UserAssembler.assemble(user);
	}

}
