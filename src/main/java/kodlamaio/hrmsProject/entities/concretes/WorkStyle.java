package kodlamaio.hrmsProject.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "work_styles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkStyle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "style")
	private String style;
	
	@JsonIgnore
	@OneToMany(mappedBy = "workStyle")
	private List<JobAdvertisement> jobAdvertisements;

}
 