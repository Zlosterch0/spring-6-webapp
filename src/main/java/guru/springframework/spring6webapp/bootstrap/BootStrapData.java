package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.domain.Writer;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import guru.springframework.spring6webapp.repositories.WriterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  private final WriterRepository writersRepository;

  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootStrapData(
      WriterRepository writersRepository,
      BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.bookRepository = bookRepository;
    this.writersRepository = writersRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Writer writer = new Writer("Joseph", "Heller", 43);
    Book book = new Book(1234, "Catch 22");
    writer.getBooks().add(book);
    book.getWriters().add(writer);
    Publisher publisher = new Publisher("gosho");
    publisher.getBooks().add(book);
    book.setPublisher(publisher);
    writersRepository.save(writer);
    publisherRepository.save(publisher);
    bookRepository.save(book);
    System.out.println("Books Data: " + bookRepository.count());
    System.out.println("Books Data: " + publisherRepository.count());
  }
}
