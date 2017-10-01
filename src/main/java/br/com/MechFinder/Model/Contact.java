package br.com.MechFinder.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import br.com.MechFinder.enums.PhoneType;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String firstEmail;
	private String secondEmail;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private PhoneType firstPhoneType;
	
	@NotNull
	private String firstPhone;
	
	@Enumerated(EnumType.STRING)
	private PhoneType secondPhoneType;
	
	private String secondPhone;
	
	@OneToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="site_id")
	private Site site;
	
	@OneToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="user_id")
	private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstEmail() {
		return firstEmail;
	}
	public void setFirstEmail(String firstEmail) {
		this.firstEmail = firstEmail;
	}
	public String getSecondEmail() {
		return secondEmail;
	}
	public void setSecondEmail(String secondEmail) {
		this.secondEmail = secondEmail;
	}
	public String getFirstPhone() {
		return firstPhone;
	}
	public void setFirstPhone(String firstPhone) {
		this.firstPhone = firstPhone;
	}
	public PhoneType getFirstPhoneType() {
		return firstPhoneType;
	}
	public void setFirstPhoneType(PhoneType firstPhoneType) {
		this.firstPhoneType = firstPhoneType;
	}
	public PhoneType getSecondPhoneType() {
		return secondPhoneType;
	}
	public void setSecondPhoneType(PhoneType secondPhoneType) {
		this.secondPhoneType = secondPhoneType;
	}
	public String getSecondPhone() {
		return secondPhone;
	}
	public void setSecondPhone(String secondPhone) {
		this.secondPhone = secondPhone;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}