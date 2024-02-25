package kw.kng.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import kw.kng.fleetapp.models.State;
import kw.kng.fleetapp.services.StateService;

@Controller
public class StateController
{
	@Autowired
	StateService ss;


	/*
	 <------------------------------------------ Return List of States --------------------------------------------------->
	*/
	@GetMapping("/state")
	public String getAllStateList(Model model)
	{
		List<State> stateList = ss.listAllState();
		model.addAttribute("state", stateList);
		return "state";
	}
	
	/*
	 <------------------------------------------ "Add State" button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/state/addNew")
	public String addNewState(State state)
	{	
		ss.saveState(state);
		return "redirect:/state";
		
	}

	/*
	 <------------------------------------------ Edit State Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/state/findById")
	@ResponseBody
	public Optional<State> findById(int id)
	{
	return ss.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit State Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/state/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateStateRecord(State state)
	{
	ss.saveState(state);
	return "redirect:/state";
	}

	/*
	 <------------------------------------------ Delete State Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/state/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	ss.deleteState(id);
	return "redirect:/state";
	}
	
	
	
	
}

