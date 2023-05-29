package com.ulbs.deposit.controller;

import com.ulbs.deposit.converter.EchipamentDto;
import com.ulbs.deposit.entity.Cladiri;
import com.ulbs.deposit.entity.Echipament;
import com.ulbs.deposit.service.ICladiriService;
import com.ulbs.deposit.service.IEchipamenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class EchipamentController {
    @Autowired
    IEchipamenteService echipamentService;

    @Autowired
    ICladiriService cladiriService;

    @GetMapping(path = "/Echipamente")
    public String getEchipament(Model model){
        List<Echipament> echipamente = echipamentService.getAllEchipamente();
        model.addAttribute("ListaEchipamente", echipamente);
        return "Echipamente";
    }

    @GetMapping(path = "/AddNewEchipament")
    public String getEchipamentForm(Model model){
        List<Cladiri> cladiri = cladiriService.getAllCladiri();
        model.addAttribute("cladiri", cladiri);
        return "addNewEchipament";
    }

    @PostMapping("/AddNewEchipament")
    public RedirectView addNewEchipament(@ModelAttribute("echipamentForm") EchipamentDto echipamentForm) {
        // Create an instance of Echipament and populate it with form data
        Echipament echipament = new Echipament();
//        echipament.setId(echipamentForm.getId());
        echipament.setNumeEchipament(echipamentForm.getNumeEchipament());
        echipament.setDataAdaugare(echipamentForm.getDataAdaugare());
        echipament.setDataSchimbare(echipamentForm.getDataSchimbare());
        // Assuming you have a service or repository for managing Cladiri, retrieve the selected Cladire object using its ID
        Cladiri cladire = cladiriService.getCladireByName(echipamentForm.getCladire());
        echipament.setAmplasare(echipamentForm.getAmplasare());
        echipament.setCladire(cladire);

        // Save the Echipament object or perform other necessary operations
        echipamentService.addNewEchipamente(echipament);

        // Redirect to a success page or perform other actions
        return new RedirectView("/Echipamente");
    }

    @GetMapping("/EditEchipament/{id}")
    public String editEchipament(@PathVariable("id") Long id, Model model) {
        // Retrieve the Echipament object with the given ID from the database
        Echipament echipament = echipamentService.getEchipamentById(id);

        // Retrieve the list of cladiri from the database
        List<Cladiri> cladiri = cladiriService.getAllCladiri();

        // Add the echipament and cladiri to the model
        model.addAttribute("echipament", echipament);
        model.addAttribute("cladiri", cladiri);

        return "editEchipament"; // Replace with the appropriate view name
    }

    @PostMapping("/EditEchipament")
    public String saveEditedEchipament(@ModelAttribute("echipament") Echipament echipament, Model model) {
        // Perform the necessary operations to save the edited echipament to the database
        echipamentService.addNewEchipamente(echipament);
        List<Echipament> echipamente = echipamentService.getAllEchipamente();
        model.addAttribute("ListaEchipamente", echipamente);
        return "Echipamente"; // Redirect to the Echipamente page
    }

    @PostMapping(value = "/Search")
    public String searchEchipamente(@RequestParam("keyword") String keyword, Model model) {
        // Perform search logic based on the provided keyword
        List<Echipament> searchResults = echipamentService.searchEchipamente(keyword);

        // Add the search results to the model
        model.addAttribute("ListaEchipamente", searchResults);
        // Return the appropriate view
        return "Echipamente"; // Replace "search-results" with the actual name of your search results view
    }

    @GetMapping("/DeleteEchipament/{id}")
    public String deleteEchipament(@PathVariable("id") Long id) {
        echipamentService.deleteEchipament(id);
        return "redirect:/Echipamente";
    }
}