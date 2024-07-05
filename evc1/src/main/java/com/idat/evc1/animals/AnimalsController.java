package com.idat.evc1.animals;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;

@Controller
public class AnimalsController {
    @GetMapping("/animals")
    public String getAnimals(Model model) {
        model.addAttribute("animals", Arrays.asList(
            new animals("Bob", "Perro", 9, "Mozta", "Pitbull"),
            new animals("Juan", "Gato", 10, "Negro", "Siames"),
            new animals("Luis", "Perro", 12, "Blanco", "Pitbull"),
            new animals("Maria", "Gato", 11, "Negro", "Siames"),
            new animals("Pedro", "Perro", 13, "Blanco", "Pitbull")
        ));
        return "Animals";
    }
}
