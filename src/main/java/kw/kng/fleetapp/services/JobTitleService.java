package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.JobTitle;
import kw.kng.fleetapp.repositories.JobTitleRepository;

@Service
public class JobTitleService
{
	@Autowired
	JobTitleRepository jtitlerepo;
	
	/*
	 <------------------------------------------ Return List of JobTitle --------------------------------------------------->
	*/
	public List<JobTitle> listAllJobTitle()
	{
		return jtitlerepo.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add JobTitle ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveJobTitle(JobTitle jobtitle)
	{
		jtitlerepo.save(jobtitle);
	}
	
	/*
	 <------------------------------------------ Edit JobTitle Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<JobTitle> findById(int id)
	{
	return jtitlerepo.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete JobTitle Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteJobTitle(Integer id)
	{
		jtitlerepo.deleteById(id);
	}

}
