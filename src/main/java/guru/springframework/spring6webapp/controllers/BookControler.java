package guru.springframework.spring6webapp.controllers;

import guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookControler {
  private final BookRepository bookRepository;

  public BookControler(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @RequestMapping("/books")
  public String getBooks(Model model) {
    model.addAttribute("books", bookRepository.findAll());
    System.out.println("count of books: " + bookRepository.count());
    return "books/book_template";
  }
}
