package henriperfoll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GraficoController {

	@RequestMapping("/grafico")
	public String graficoMain() {
		return "grafico.xhtml";
	}
}
