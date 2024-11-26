package data_access.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import use_case.book.search.SearchBookDataAccessInterface;
import use_case.book.view.ViewBookDataAccessInterface;


public class InMemoryBookDataAccessObject implements ViewBookDataAccessInterface, SearchBookDataAccessInterface {


}
