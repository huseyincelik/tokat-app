package com.n11.controller;

import com.n11.model.Content;
import com.n11.model.ContentForm;
import com.n11.repository.ContentRepository;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ContentController {

    @Autowired
    private ContentRepository contentRepository;

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("contentForm", new ContentForm());
        return "greeting";
    }

    @GetMapping("/content/{id}")
    public String content(@PathVariable Long id, Model model) {
        Content content = contentRepository.findOne(id);
        String rawContent = StringEscapeUtils.unescapeHtml4(content.getContent());
        content.setContent(rawContent);
        model.addAttribute("content", content);
        return "result";
    }

    @PostMapping("/contentForm")
    public String submit(@Valid ContentForm contentForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "greeting";
        }

        Content content = new Content();
        content.setId(contentForm.getId());
        String rawContent = contentForm.getContent();
        String escapedContent = StringEscapeUtils.escapeHtml4(rawContent);
        content.setContent(escapedContent);
        contentRepository.save(content);
        return "redirect:/content/" + contentForm.getId();
    }

}
