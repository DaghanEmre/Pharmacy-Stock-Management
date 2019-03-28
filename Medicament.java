import java.util.Date;

public class Medicament {
	private String medicName;
	private String socialSecureCode;
	private Date validityDate;
	private Date expiryDate;
	private float price;
	private int quantity;
	
	/*Default Constructor*/
	public Medicament(){
		super();
		this.medicName = null;
		this.socialSecureCode = null;
		this.expiryDate = null;
		this.validityDate = null;
		this.price = 0.0f;
		this.quantity = 0;
	}
	
	/**
	 * constructor for Medicament object
	 * 
	 * @param medicName				
	 * @param socialSecureCode
	 * @param validityDate
	 * @param expiryDate
	 * @param price
	 * @param quantity
	 */
	
	/*Constructor*/
	public Medicament(String medicName, String socialSecureCode, Date validityDate, Date expiryDate, float price,
			int quantity) {
		super();
		this.medicName = medicName;
		this.socialSecureCode = socialSecureCode;
		this.validityDate = validityDate;
		this.expiryDate = expiryDate;
		this.price = price;
		this.quantity = quantity;
	}

	/*Getters and Setters*/
	public String getMedicName() {
		return medicName;
	}
	public void setMedicName(String medicName) {
		this.medicName = medicName;
	}
	public Date getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getSocialSecureCode() {
		return socialSecureCode;
	}
	public void setSocialSecureCode(String socialSecureCode) {
		this.socialSecureCode = socialSecureCode;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
