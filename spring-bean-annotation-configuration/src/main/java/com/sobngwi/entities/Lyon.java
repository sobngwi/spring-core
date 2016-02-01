package com.sobngwi.entities;

import org.springframework.stereotype.Component;

@Component
public class Lyon implements Team {

	@Override
	public String getName() {
		return "Olympique Lyonnais";
	}

}
