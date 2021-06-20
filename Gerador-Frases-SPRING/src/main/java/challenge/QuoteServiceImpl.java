package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	private int getRandomQuoteInList(List<Quote> listQuote) {
		Random random = new Random();

		return random.nextInt(listQuote.size());
	}

	@Override
	public Quote getQuote() {
		List<Quote> listQuotes = this.repository.findAll();
		int randomIndex = this.getRandomQuoteInList(listQuotes);
		return listQuotes.get(randomIndex);
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> listQuotes = this.repository.findByActor(actor);
		int randomIndex = this.getRandomQuoteInList(listQuotes);
		return listQuotes.get(randomIndex);
	}


}
