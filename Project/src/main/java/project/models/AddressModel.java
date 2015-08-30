package project.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Table;

@Embeddable
@Table(name = "address")
public class AddressModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "street", nullable = false)
	private String street;

	@Column(name = "suite")
	private String suite;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "zip_code", nullable = false)
	private Integer zipCode;

	@Embedded
	private GeoLocationModel geoLocation;

	public AddressModel() {

	}

	public AddressModel(String street, String suite, String city, Integer zipCode, GeoLocationModel geoLocation) {
		super();
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipCode = zipCode;
		this.geoLocation = geoLocation;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public GeoLocationModel getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocationModel geoLocation) {
		this.geoLocation = geoLocation;
	}

}
