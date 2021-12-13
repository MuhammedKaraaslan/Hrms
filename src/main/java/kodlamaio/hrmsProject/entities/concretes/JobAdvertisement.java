package kodlamaio.hrmsProject.entities.concretes;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "job_advertisement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "max_salary")
	private String maxSalary;
	
	@Column(name = "min_salary")
	private String minSalary;
	
	@Column(name = "open_position_number")
	private int openPositionNumber;
	
	@Column(name = "deadline_date")
	private Date deadlineDate;
	
	@Column(name = "release_date")
	private Date releaseDate;
	
	@Column(name = "is_active")
	private boolean isActive=true;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed=false;
	 
	@Column(name = "confirm_date")
	private Date confirmDate = null;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Employer employer;
	 
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;  
	
	@ManyToOne
	@JoinColumn(name = "work_style_id")
	private WorkStyle workStyle;
	
	@ManyToOne
	@JoinColumn(name = "work_time_id")
	private WorkTime workTime;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobAdvertisement")
	private List<FavoriteJobAdvertisement> favoriteJobAdvertisements;
	
	
}
