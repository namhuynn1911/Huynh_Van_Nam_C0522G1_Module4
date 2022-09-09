package dictionary.controller;

import dictionary.model.DictionaryLanguage;
import dictionary.service.IDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DictionaryController {

    @Autowired
   private IDictionary iDictionary;
@GetMapping("/")
    public String search(){
        return "/index";
    }
    @PostMapping("/search")
    public String meaing(@RequestParam String keyword, Model model){
        List<DictionaryLanguage> dictionaryLanguages=iDictionary.findAll();
        for (int i=0;i<dictionaryLanguages.size();i++){
            if(keyword.equalsIgnoreCase(dictionaryLanguages.get(i).getEnglish())){
                model.addAttribute("word",dictionaryLanguages.get(i).getVietNamese());
                model.addAttribute("key",keyword);
                break;
            } else {
                model.addAttribute("word","Not Found !");
            }
        }
        return "/index";
    }
}
