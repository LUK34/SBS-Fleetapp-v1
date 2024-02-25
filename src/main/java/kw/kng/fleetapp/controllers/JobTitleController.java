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


import kw.kng.fleetapp.models.JobTitle;

import kw.kng.fleetapp.services.JobTitleService;

@Controller
public class JobTitleController 
{
	@Autowired	JobTitleService js;
	/*
	 <------------------------------------------ Return List of JobTitle --------------------------------------------------->
	*/
	@GetMapping("/jobtitle")
	public String getAllJobTitleList(Model model)
	{
		List<JobTitle> jobtitleList = js.listAllJobTitle();
		
		model.addAttribute("jobtitle", jobtitleList);
		return "jobtitle";
	}
	
	/*
	 <------------------------------------------ "Add JobTitle" button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/jobtitle/addNew")
	public String addNewJobTitle(JobTitle jobtitle)
	{	
		js.saveJobTitle(jobtitle);
		return "redirect:/jobtitle";
		
	}

	/*
	 <------------------------------------------ Edit JobTitle Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/jobtitle/findById")
	@ResponseBody
	public Optional<JobTitle> findById(int id)
	{
	return js.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit JobTitle Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/jobtitle/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateJobTitleRecord(JobTitle jobtitle)
	{
	js.saveJobTitle(jobtitle);
	return "redirect:/jobtitle";
	}

	/*
	 <------------------------------------------ Delete JobTitle Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/jobtitle/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	 js.deleteJobTitle(id);
	return "redirect:/jobtitle";
	}

}
