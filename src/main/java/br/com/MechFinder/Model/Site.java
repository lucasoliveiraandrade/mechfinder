package br.com.MechFinder.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.MechFinder.enums.PaymentType;

@Entity
public class Site {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ad_id")
	private Ad ad;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="contact_id")
	private Contact contact;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="site")	
	private List<Evaluation> evaluations;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="site_mechServices", joinColumns={ @JoinColumn(name="site_id") }, inverseJoinColumns={ @JoinColumn(name="mechanic_service_id") })
	private List<MechanicService> mechanicServices;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE, mappedBy="site")
	private List<Image> images;

	@NotNull
	private Boolean hasDeliveryCustomerService;
	
	@NotNull
	@Temporal(TemporalType.TIME) 
	private Date openingTime;
	
	@NotNull
	@Temporal(TemporalType.TIME)
	private Date closingTime;
	
	private Integer finalRate;
	
	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="site_paymentType", joinColumns=@JoinColumn(name="site_id"))
	@JoinColumn(name="payment_type")
	private List<PaymentType> paymentTypes; 	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Ad getAd() {
		return ad;
	}
	public void setAd(Ad ad) {
		this.ad = ad;
	}
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}
	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	public List<MechanicService> getMechanicServices() {
		return mechanicServices;
	}
	public void setMechanicServices(List<MechanicService> mechanicServices) {
		this.mechanicServices = mechanicServices;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public Boolean getHasDeliveryCustomerService() {
		return hasDeliveryCustomerService;
	}
	public void setHasDeliveryCustomerService(Boolean hasDeliveryCustomerService) {
		this.hasDeliveryCustomerService = hasDeliveryCustomerService;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Integer getFinalRate() {
		return finalRate;
	}
	public void setFinalRate(Integer finalRate) {
		this.finalRate = finalRate;
	}
	public List<PaymentType> getPaymentTypes() {
		return paymentTypes;
	}
	public void setPaymentTypes(List<PaymentType> paymentTypes) {
		this.paymentTypes = paymentTypes;
	}
	public Date getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(Date openingTime) {
		this.openingTime = openingTime;
	}
	public Date getClosingTime() {
		return closingTime;
	}
	public void setClosingTime(Date closingTime) {
		this.closingTime = closingTime;
	}
}
