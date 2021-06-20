package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class QuoteController {

	@Autowired
	private QuoteService service;

	@GetMapping("/quote")
	public Quote getQuote() {
		return this.service.getQuote();
	}

	@GetMapping("/quote/{actorName}")
	public Quote getQuoteByActor(@PathVariable("actorName") String actor) {
		return this.service.getQuoteByActor(actor);
	}

}

