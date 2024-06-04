package KT.VoHongHai_Java.controllers;


import KT.VoHongHai_Java.entities.Role;
import KT.VoHongHai_Java.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{roleId}")
    public Optional<Role> getRoleById(@PathVariable Long roleId) {
        return roleService.getRoleById(roleId);
    }

    @PostMapping("/")
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @PutMapping("/{roleId}")
    public Role updateRole(@PathVariable Long roleId, @RequestBody Role roleDetails) {
        return roleService.updateRole(roleId, roleDetails);
    }

    @DeleteMapping("/{roleId}")
    public void deleteRole(@PathVariable Long roleId) {
        roleService.deleteRole(roleId);
    }
}
