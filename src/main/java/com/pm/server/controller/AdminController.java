package com.pm.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pm.server.datatype.Pacdot;
import com.pm.server.registry.PacdotRegistry;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PacdotRegistry pacdotRegistry;

	private final static Logger log =
			LogManager.getLogger(AdminController.class.getName());

	@RequestMapping(
			value="/pacdots/reset",
			method=RequestMethod.POST,
			produces={ "application/json" }
	)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void resetPacdots(HttpServletResponse response) {

		log.debug("Mapped POST /admin/pacdots/reset");

		List<Pacdot> pacdotList = pacdotRegistry.getAllPacdots();
		for(Pacdot pacdot : pacdotList) {
			pacdot.setEaten(false);
		}

	}

}
