package com.peaksoft.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {
    @GetMapping("/all-users")
    public String getAllUsers() {
        return "all-users-page";
    }

    @GetMapping("/user-page")
    public String getUser() {
        return "user-page";
    }
}
//	private final UserService userService;
//	private final RoleService roleService;
//
//	public MyController(UserService userService, RoleService roleService) {
//		this.userService = userService;
//		this.roleService = roleService;
//	}
//
//
//
//	@GetMapping
//	public String loginPage() {
//		return "login-page";
//	}
//
//	@GetMapping("/admin")
//	public String getAllUsers(Model model) {
//		model.addAttribute("user1", userService.getAllUsers());
//		return "all-users-page";
//	}
//
//	@GetMapping("delete/{id}")
//	public String deleteUserById(@PathVariable("id") int id) {
//		userService.deleteUserById(id);
//		return "redirect:/admin";
//	}
//
//	@GetMapping("{id}/edit")
//	public String getUserByIdForEditUser2(@PathVariable("id") int id, Model model) {
//		model.addAttribute("user2", userService.getUserById(id));
//		model.addAttribute("roles2", roleService.getAllRoles());
//		return "edit-users";
//	}
//	@PostMapping("/edit")
//	public String editUser(@ModelAttribute("user2") User user, @RequestParam Map<String, String> form) {
//		List<String> roles = roleService.getRoleNamesToList();
//		Set<String> strings = new HashSet<>(roles);
//		user.getRoles().clear();
//		for (String key : form.keySet()) {
//			if (strings.contains(key)) {
//				user.getRoles().add(roleService.getRoleByName(key));
//			}
//		}
//		userService.saveUser(user);
//		return "redirect:/admin";
//	}
//
//	@GetMapping("/user")
//	public String getUserMethod(Principal principal, Model model) {
//		model.addAttribute("user4", userService.getUserByName(principal.getName()));
//		return "user-page";
//	}
//
//	@GetMapping("/new")
//	public String setUserForCreationUser(@ModelAttribute("user3") User user, Model model) {
//		model.addAttribute("role3", roleService.getAllRoles());
//		return "new-user";
//	}
//
//	@PostMapping("/creation")
//	public String createNewUser(User user, @RequestParam Map<String, String> form) {
//		List<String> roles = roleService.getRoleNamesToList();
//		Set<String> strings = new HashSet<>(roles);
//		user.getRoles().clear();
//		for (String key : form.keySet()) {
//			if (strings.contains(key)) {
//				user.getRoles().add(roleService.getRoleByName(key));
//			}
//		}
//		userService.saveUser(user);
//		return "redirect:/admin";
//	}
//
