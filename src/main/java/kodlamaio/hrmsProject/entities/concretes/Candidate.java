package kodlamaio.hrmsProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Candidate extends User{
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "identity_number")
	private String identityNumber;
	
	@Column(name = "birth_year")
	private int birthYear;	
	
	@Column(name = "is_mail_verified")
	private boolean isMailVerified = false; 

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<School> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<JobExperience> jobExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<ForeignLanguage> foreignLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Photo> photos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<LinkAddress> linkAddresses;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<ProfessionalProgrammingSkill> professionalProgrammingSkills;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CoverLetter> coverLetters;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<FavoriteJobAdvertisement> favoriteJobAdvertisements;
}
