package com.project.MovieTicket.Controller;

import com.project.MovieTicket.Entity.Promotion;
import com.project.MovieTicket.Repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/promotions")
public class AdminPromotionController {

    @Autowired
    private PromotionRepository promotionRepository;

    @GetMapping
    public String listPromotions(Model model) {
        model.addAttribute("promotions", promotionRepository.findAll());
        return "admin/promotions";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("promotion", new Promotion());
        model.addAttribute("editMode", false);
        return "admin/promotion-form";
    }

    @PostMapping("/add")
    public String addPromotion(@ModelAttribute Promotion promotion, RedirectAttributes ra) {
        promotionRepository.save(promotion);
        ra.addFlashAttribute("success", "เพิ่มโปรโมชั่น \"" + promotion.getTitle() + "\" สำเร็จ!");
        return "redirect:/admin/promotions";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Promotion not found"));
        model.addAttribute("promotion", promotion);
        model.addAttribute("editMode", true);
        return "admin/promotion-form";
    }

    @PostMapping("/edit/{id}")
    public String editPromotion(@PathVariable Long id, @ModelAttribute Promotion promotion, RedirectAttributes ra) {
        promotion.setId(id);
        promotionRepository.save(promotion);
        ra.addFlashAttribute("success", "แก้ไขโปรโมชั่นสำเร็จ!");
        return "redirect:/admin/promotions";
    }

    @PostMapping("/delete/{id}")
    public String deletePromotion(@PathVariable Long id, RedirectAttributes ra) {
        promotionRepository.deleteById(id);
        ra.addFlashAttribute("success", "ลบโปรโมชั่นสำเร็จ");
        return "redirect:/admin/promotions";
    }
}
