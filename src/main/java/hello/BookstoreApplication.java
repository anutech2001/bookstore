package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@SpringBootApplication
public class BookstoreApplication {
	private static Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
			
  @RequestMapping(value = "/recommended", method=RequestMethod.GET)
  public String readingList(){
	log.info("Get request for get recommended books.");
	try {
		Thread.sleep((long)(randomWithRange(1,4) * 1000));
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	log.info("Return a list.");
    return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
  }
  
  int randomWithRange(int min, int max)
  {
     int range = (max - min) + 1;     
     return (int)(Math.random() * range) + min;
  }

  public static void main(String[] args) {
    SpringApplication.run(BookstoreApplication.class, args);
  }
}