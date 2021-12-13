package kodlamaio.hrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "link_addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title") // Zorunlu değil
	private String title;
	
	@Column(name = "address") // Zorunlu değil
	private String address;

	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
