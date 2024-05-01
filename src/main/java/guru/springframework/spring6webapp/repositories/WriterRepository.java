package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Writer;
import org.springframework.data.repository.CrudRepository;

public interface WriterRepository extends CrudRepository<Writer, Long> {

}
