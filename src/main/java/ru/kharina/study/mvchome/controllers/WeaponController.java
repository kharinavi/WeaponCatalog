package ru.kharina.study.mvchome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kharina.study.mvchome.dao.WeaponDAO;
import ru.kharina.study.mvchome.models.Weapon;

@Controller
@RequestMapping("/weapons")
public class WeaponController {

    private final WeaponDAO weaponDAO;

    @Autowired
    public WeaponController(WeaponDAO weaponDAO) {
        this.weaponDAO = weaponDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("weapons",weaponDAO.index());
        return "weapons/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("weapon", weaponDAO.show(id));
        return "weapons/show";
    }

    @GetMapping("/new")
    public String newWeapon(Model model) {
        model.addAttribute("weapon", new Weapon());
        return "weapons/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("weapon") Weapon weapon) {
        weaponDAO.save(weapon);
        return "redirect:/weapons";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("weapon", weaponDAO.show(id));
        return "weapons/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("weapon") Weapon weapon, @PathVariable("id") int id) {
        weaponDAO.update(id, weapon);
        return "redirect:/weapons";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        weaponDAO.delete(id);
        return "redirect:/weapons";
    }
}
