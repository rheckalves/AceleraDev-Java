package challenge;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuoteRepository extends JpaRepository<Quote, Integer> {

    public List<Quote> findAll();

    public List<Quote> findByActor(String name);
}
