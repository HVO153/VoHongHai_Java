package KT.VoHongHai_Java.service;

import KT.VoHongHai_Java.entities.Role;
import KT.VoHongHai_Java.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long roleId) {
        return roleRepository.findById(roleId);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Long roleId, Role roleDetails) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            role.setRoleName(roleDetails.getRoleName());
            // Set other role details similarly
            return roleRepository.save(role);
        } else {
            return null; // Or throw an exception
        }
    }

    public void deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
    }
}
