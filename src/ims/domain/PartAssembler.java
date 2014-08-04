package ims.domain;

import java.util.ArrayList;
import java.util.List;

import ims.dto.PartDto;

public class PartAssembler {
	
	private Part part;

	private PartAssembler(Part part) {
		this.part = part;
	}

	public static PartDto assemble(Part part) {
		return new PartAssembler(part).assemblePartDto();
	}

	private PartDto assemblePartDto() {
		PartDto partDto = new PartDto();
		partDto.setId(part.getId());
		partDto.setName(part.getName());
		partDto.setQuantity(part.getQuantity());
		partDto.setPrice(part.getPrice());
		return partDto;
	}

	public static ArrayList<PartDto> assemble(List<Part> parts) {
		ArrayList<PartDto> dtos = new ArrayList<PartDto>();
		for(int i= 0; i < parts.size(); i++) {
			Part part = parts.get(i);
			PartDto pDto = new PartAssembler(part).assemblePartDto();
			dtos.add(pDto);
		}
		return dtos;
	}
	
	
	
}
