package music_player.controller;

import music_player.model.Music;
import music_player.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping("/")
    public String showMusicPlayer(Model model) {
        model.addAttribute("music", iMusicService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/save")
    public String save(Music music, RedirectAttributes redirectAttributes) {
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("masse1", "successfully added new !!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Music music, RedirectAttributes redirect) {
        iMusicService.remove(music.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Music music, RedirectAttributes redirectAttributes) {
        iMusicService.update(music);
        redirectAttributes.addFlashAttribute("messa", "edit successfully!");
        return "redirect:/";
    }
}
