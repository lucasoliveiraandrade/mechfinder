package br.com.MechFinder.Model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Evaluation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;	
	
	@Lob
	private String comment;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="site_id", nullable=false)
	private Site site;
	
	@OneToMany(mappedBy="evaluation")	
	private List<Image> images;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User responsible;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="evaluation_revisions", joinColumns=@JoinColumn(name="evaluation_id"))
	@JoinColumn(name="revision_id")
	private List<Calendar> revisions;
	
	private Integer customerServiceRate;
	private Integer priceRate;
	private Integer cleaningRate;
	private Integer serviceQualityRate;
	
	private Boolean talkedWithMechanic;
	private Boolean wouldReturn;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public User getResponsible() {
		return responsible;
	}
	public void setResponsible(User responsible) {
		this.responsible = responsible;
	}
	public List<Calendar> getRevisions() {
		return revisions;
	}
	public void setRevisions(List<Calendar> revisions) {
		this.revisions = revisions;
	}
	public Integer getCustomerServiceRate() {
		return customerServiceRate;
	}
	public void setCustomerServiceRate(Integer customerServiceRate) {
		this.customerServiceRate = customerServiceRate;
	}
	public Integer getPriceRate() {
		return priceRate;
	}
	public void setPriceRate(Integer priceRate) {
		this.priceRate = priceRate;
	}
	public Integer getCleaningRate() {
		return cleaningRate;
	}
	public void setCleaningRate(Integer cleaningRate) {
		this.cleaningRate = cleaningRate;
	}
	public Integer getServiceQualityRate() {
		return serviceQualityRate;
	}
	public void setServiceQualityRate(Integer serviceQualityRate) {
		this.serviceQualityRate = serviceQualityRate;
	}
	public Boolean getTalkedWithMechanic() {
		return talkedWithMechanic;
	}
	public void setTalkedWithMechanic(Boolean talkedWithMechanic) {
		this.talkedWithMechanic = talkedWithMechanic;
	}
	public Boolean getWouldReturn() {
		return wouldReturn;
	}
	public void setWouldReturn(Boolean wouldReturn) {
		this.wouldReturn = wouldReturn;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Evaluation)) {
			return false;
		}
		Evaluation other = (Evaluation) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
}
