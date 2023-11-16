package com.iti.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.iti.entity.master.Caste_master;
import com.iti.projections.ITIApiDashBoardReportProj;

public interface Caste_master_repo extends JpaRepository<Caste_master, String>{
	
	@Query(value="SELECT dist_name,iti.iti_name,iti.iti_code, count(*) FILTER (WHERE admissions.iti_admissions.rec_status='S') \r\n" + 
			"as Success, count(*) FILTER (WHERE admissions.iti_admissions.rec_status='E' or admissions.iti_admissions.rec_status \r\n" + 
			" is null) as Error,  count(*) FILTER (WHERE admissions.iti_admissions.rec_status is null) as Tobeupdated,  count(*) \r\n" + 
			" FILTER (WHERE admissions.iti_admissions.rec_status='E') as Updated,count(*) FILTER (where phno in(select phno from \r\n" + 
			" admissions.iti_admissions where year_of_admission=:admissionYear and admissions.iti_admissions.iti_code=:itiCode group by \r\n" + 
			" admissions.iti_admissions.phno having count(phno)>1 order by phno) and year_of_admission=:admissionYear) as phno_duplicate,\r\n" + 
			" count(*) FILTER (where adarno in(select adarno from admissions.iti_admissions where year_of_admission=:admissionYear group \r\n" + 
			" by admissions.iti_admissions.adarno having count(adarno)>1 order by adarno) and year_of_admission=:admissionYear) as \r\n" + 
			" aadhar_duplicate,count(*) FILTER (where email_id in(select email_id from admissions.iti_admissions where \r\n" + 
			" year_of_admission=:admissionYear group by admissions.iti_admissions.email_id having count(email_id)>1 order by email_id) and \r\n" + 
			" year_of_admission=:admissionYear) as email_duplicate from admissions.iti_admissions left join iti on \r\n" + 
			" admissions.iti_admissions.iti_code=iti.iti_code left join dist_mst on admissions.iti_admissions.dist_code=\r\n" + 
			" dist_mst.dist_code  where year_of_admission=:admissionYear and admissions.iti_admissions.iti_code=:itiCode\r\n" + 
			"group by iti.iti_code,iti.iti_name,dist_mst.dist_name order by dist_mst.dist_name",nativeQuery = true)
	public List<ITIApiDashBoardReportProj> getITIApiDashboard(@RequestParam String admissionYear,@RequestParam String itiCode);

}
