package mariuszjaczewski.repository_rest.Views;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainView {


    @RequestMapping(value="/")
    public String mainPage(){

        System.err.println("index.html");
        return "index.html";

    }




}
