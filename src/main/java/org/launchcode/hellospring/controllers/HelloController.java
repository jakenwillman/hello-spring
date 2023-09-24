package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //lives /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // lives /hello/hello
    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // modify the helloForm method to include language selection
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='greet' method='post'>" + // submit a request to /hello/greet
                "<input type='text' name='name' placeholder='Your name'>" +
                "<select name='language'>" +
                "<option value='English'>English</option>" +
                "<option value='French'>French</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='Russian'>Russian</option>" +
                "<option value='German'>German</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    // Add a new method that handles the form submission
    @PostMapping("greet")
    @ResponseBody
    public String createMessage(@RequestParam String name, @RequestParam String language) {
        String greeting = "";

        if (language.equals("English")) {
            greeting = "Hello, " + name;
        } else if (language.equals("French")) {
            greeting = "Bonjour, " + name;
        } else if (language.equals("Spanish")) {
            greeting = "Hola, " + name;
        } else if (language.equals("Russian")) {
            greeting = "Привет, " + name;
        } else if (language.equals("German")) {
            greeting = "Hallo, " + name;
        }

        String htmlResponse = "<html><body><h1><code>" + greeting + "</code></h1></body></html>";
        return htmlResponse;
    }
}