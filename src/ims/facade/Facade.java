package ims.facade;

import ims.domain.Part;
import ims.dto.PartDto;
import ims.repository.PartRepository;

public class Facade {

	public void addPart(PartDto partDto) {
		Part part = new Part();
		part.setName(partDto.getName());
		part.setQuantity(partDto.getQuantity());
		part.setPrice(partDto.getPrice());
		
		PartRepository pr = new PartRepository();
		pr.addPart(part);
		
	}

	public PartDto findPartByName(String name) {
		PartRepository pr = new PartRepository();
		Part part = pr.findPartByName(name);
		
		PartDto partDto = new PartDto();
		partDto.setId(part.getId());
		partDto.setName(part.getName());
		partDto.setQuantity(part.getQuantity());
		partDto.setPrice(part.getPrice());
		
		return partDto;
	}

}
