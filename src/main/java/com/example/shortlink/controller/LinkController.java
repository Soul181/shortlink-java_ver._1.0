package com.example.shortlink.controller;

import com.example.shortlink.service.LinkService;
import com.example.shortlink.model.Link;
import com.example.shortlink.utils.GenerationUniqueShort;
import com.example.shortlink.utils.ValidationOriginalLink;
import com.example.shortlink.utils.ValidationPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Timestamp;

@Controller
public class LinkController{
    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/link-startpage")
    public String createLinkForm(Link link){
        return "/link-startpage";
    }

    @PostMapping("/link-startpage")
    public String createLink(Link link, Model model) throws Exception {
        if (link.getOriginalLink() == ""){
            model.addAttribute("errorMessage", "Enter website link.");
            return "/link-startpage";
        }

        if (!ValidationOriginalLink.isAvailable(link.getOriginalLink())){
            model.addAttribute("errorMessage", "URL is not valid. Please, check your URL again.");
            return "/link-startpage";
        } else {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Long time = timestamp.getTime();
            link.setTimeCreate(time);
            link.setShortLink(GenerationUniqueShort.generateString());
            linkService.saveLink(link);
            model.addAttribute("link", link);
            return "/link-startpage";
        }
    }

    @GetMapping("/link-startpage/{path}")
    public RedirectView getRedirect(@PathVariable String path) {
        ValidationPath validationPath = new ValidationPath();
        boolean isValidatePath = validationPath.getValidationPath(path);
        if (isValidatePath) {
            String linkToRedirect = "";
            try {
                Link link = linkService.findByShort(path);
                linkToRedirect = link.getOriginalLink();
            } catch(Exception ex) {
                return new RedirectView("/link-startpage");
            }
            return new RedirectView(linkToRedirect);
        } else {
            return new RedirectView("/link-startpage");
        }
    }
}
