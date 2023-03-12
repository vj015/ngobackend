package com.ngobackend.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngobackend.dto.fundraiseDTO;
import com.ngobackend.entities.fundraise;
import com.ngobackend.repository.FundraiseRepository;

@Service
public class FundraiseService {
	
	@Autowired
	private FundraiseRepository fundraiseRepository;
	
	//To add a new fundraising
	public void addFundraise(fundraiseDTO f) throws Exception
	{
		try {
			this.fundraiseRepository.save(this.fundraiseDTOtofundraise(f));
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		
	}
	
	//To edit a new fundraising
	public int editFundraise(fundraiseDTO f, int id) throws Exception
	{
		try {
			Optional<fundraise> op = this.fundraiseRepository.findById(id);
			if(op.isPresent())
			{
				fundraise fd = op.get();
				fd.setCurrentamount(f.getCurrentamount());
				fd.setEndDate(f.getEndDate());
				fd.setMessage(f.getMessage());
				fd.setStartDate(f.getStartDate());
				fd.setTitle(f.getTitle());
				fd.setTotalmount(f.getTotalamount());
				fd.setLikes(f.getLikes());
				this.fundraiseRepository.save(fd);
			 return 1;
				
			}
			else {
				return 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		
	}
	
	public int deletefundraise(int id) throws Exception
	{
		try {
			Optional<fundraise> op = this.fundraiseRepository.findById(id);
			if(op.isPresent())
			{
				fundraise fd = op.get();
				this.fundraiseRepository.delete(fd);
				
			 return 1;
				
			}
			else {
				return 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public fundraise findfundraiseByID(int id) throws Exception
	{
		try {
			Optional<fundraise> optional=this.fundraiseRepository.findById(id);
			if(optional.isPresent())
			{
				return optional.get();
			}
			else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public List<fundraise> findAllfundraise() throws Exception
	{
		try {
			List<fundraise> u = this.fundraiseRepository.findAll();
			if(u.isEmpty())
			{
				return null;
			}
			else {
				return u;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
		
	}
	
	public int increasecurrentamount(long val,int id)throws Exception
	{
		try {
			Optional<fundraise> optional=this.fundraiseRepository.findById(id);
			if(optional.isPresent())
			{
				fundraise f =optional.get();
				long n = f.getCurrentamount() + val;
				if(n>=f.getTotalmount())
				{
					this.deletefundraise(id);
					return 0;
					
				}
				else {
					f.setCurrentamount(n);
					this.fundraiseRepository.save(f);
					return 1;
				}
			}
			return 0;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
		
	}
	
	public int like(int id)throws Exception
	{
		try {
			Optional<fundraise> optional=this.fundraiseRepository.findById(id);
			if(optional.isPresent())
			{
				fundraise f =optional.get();
				int ans = f.getLikes() +1;
				f.setLikes(ans);
				this.fundraiseRepository.save(f);
				return ans;
			}
			return 0;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
		
	}
	
	public int getDays(int id)throws Exception
	{
		try {
			int ans;
			Optional<fundraise> optional=this.fundraiseRepository.findById(id);
			if(optional.isPresent())
			{
				fundraise f =optional.get();
				String enddate = f.getEndDate();
				int dd = Integer.parseInt(enddate.substring(0, 2));
				int mm = Integer.parseInt(enddate.substring(3, 5));
				int yy = Integer.parseInt(enddate.substring(6, 10));
			    LocalDate endd = LocalDate.of(yy, mm, dd);
				LocalDate curr = LocalDate.now();
				ans = (int) ChronoUnit.DAYS.between(curr, endd);
			}else {
				return -1;
			}
			
			if(ans==0)
			{
				this.deletefundraise(id);
				return 0;
			}
			else {
				return ans;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
		
	}
	
	public fundraise fundraiseDTOtofundraise(fundraiseDTO fd)
	{
		fundraise f= new fundraise();
		f.setTitle(fd.getTitle());
		f.setCurrentamount(fd.getCurrentamount());
		f.setEndDate(fd.getEndDate());
		f.setMessage(fd.getMessage());
		f.setStartDate(fd.getStartDate());
		f.setTotalmount(fd.getTotalamount());
		f.setLikes(0);
		return f;
	}

}
