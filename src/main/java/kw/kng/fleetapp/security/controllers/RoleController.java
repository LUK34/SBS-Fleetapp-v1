package kw.kng.fleetapp.security.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kw.kng.fleetapp.models.User;
import kw.kng.fleetapp.security.models.Role;
import kw.kng.fleetapp.security.services.RoleService;
import kw.kng.fleetapp.services.UserService;

@Controller
public class RoleController 
{
@Autowired	RoleService rs;
@Autowired UserService us;

	/*
	<------------------------------------------ Manage Role Button ->Manage the roles of the user --------------------------------------------------->
	*/	
	@GetMapping("/security/user/edit/{id}")
	public String editUser (@PathVariable Integer id, Model model)
	{
	   User user = us.findById(id);
	   model.addAttribute("user", user);
	   model.addAttribute("userRoles", rs.getUserRoles(user));
	   model.addAttribute("userNotRoles", rs.getUserNotRoles(user));
	   return "/useredit";
	}
	/*
	 <------------------------------------------ Return List of Role --------------------------------------------------->
	*/
	@GetMapping("/role")
	public String getAllRoleList(Model model)
	{
		
		List<Role> rolelist = rs.listAllRole();
		
		model.addAttribute("role", rolelist);
		return "role";
	}
	
	/*
	 <------------------------------------------ "Add Role" button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/role/addNew")
	public String addNewRole(Role role)
	{	
		rs.saveRole(role);
		return "redirect:/role";
		
	}

	/*
	 <------------------------------------------ Edit Role Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/role/findById")
	@ResponseBody
	public Optional<Role> findById(int id)
	{
		return rs.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit Role Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/role/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateRoleRecord(Role role)
	{
		rs.saveRole(role);
		return "redirect:/role";
	}

	/*
	 <------------------------------------------ Delete Role Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/role/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
		rs.deleteRole(id);
		return "redirect:/role";
	}
	
	/*
	 <------------------------------------------ Assigning Roles  --------------------------------------------------->
	*/
	
	@RequestMapping("/security/role/assign/{userId}/{roleId}")
	public String assignRole(@PathVariable Integer userId, @PathVariable Integer roleId)
	{
	    rs.assignUserRole(userId, roleId);
	    return "redirect:/security/user/edit/"+userId;
	}
	
	/*
	 <------------------------------------------ Unassigning Roles  --------------------------------------------------->
	*/
	
	@RequestMapping("/security/role/unassign/{userId}/{roleId}")
	public String unassignRole(@PathVariable Integer userId, @PathVariable Integer roleId)
	{
	    rs.unassignUserRole(userId, roleId);
	    return "redirect:/security/user/edit/"+userId;
	}
}
