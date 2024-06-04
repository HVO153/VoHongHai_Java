package KT.VoHongHai_Java.controllers;

import KT.VoHongHai_Java.entities.Role;
import KT.VoHongHai_Java.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String showAllRoles(Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        return "role/list";
    }

    @GetMapping("/add")
    public String addRoleForm(Model model) {
        model.addAttribute("role", new Role());
        return "role/add";
    }

    @PostMapping("/add")
    public String addRole(@ModelAttribute("role") Role role) {
        roleService.addRole(role);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String editRoleForm(Model model, @PathVariable Long id) {
        var role = roleService.getRoleById(id).orElse(new Role());
        model.addAttribute("role", role);
        return "role/edit";
    }

    @PostMapping("/edit")
    public String editRole(@ModelAttribute("role") Role role) {
        roleService.updateRole(role);
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleService.deleteRoleById(id);
        return "redirect:/roles";
    }
}
