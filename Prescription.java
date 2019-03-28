import java.util.ArrayList;
import java.util.Date;


public class Prescription {
	private String patientNameSurname;
	private String socialSecureCode;
	private Date prescriptDate;
	private ArrayList<Medicament> medicList;
	
	public void addMedicList(Medicament medic){
		
		medicList.add(medic);
	}
	
	/**
	 * constructor for Prescription object
	 * 
	 * @param patientNameSurname
	 * @param socialSecureCode
	 * @param prescriptDate
	 */
	
	/*Constructor*/
	public Prescription(String patientNameSurname, String socialSecureCode, Date prescriptDate) {
		this.patientNameSurname = patientNameSurname;
		this.socialSecureCode = socialSecureCode;
		this.prescriptDate = prescriptDate;
		medicList = new ArrayList<Medicament>();
	}
	
	/*Getters Setters*/
	public ArrayList<Medicament> getMedicList() {
		return medicList;
	}

	public String getPatientNameSurname() {
		return patientNameSurname;
	}

	public void setPatientNameSurname(String patientNameSurname) {
		this.patientNameSurname = patientNameSurname;
	}

	public Date getPrescriptDate() {
		return prescriptDate;
	}

	public void setPrescriptDate(Date prescriptDate) {
		this.prescriptDate = prescriptDate;
	}

	public String getSocialSecureCode() {
		return socialSecureCode;
	}
	public void setSocialSecureCode(String socialSecureCode) {
		this.socialSecureCode = socialSecureCode;
	}

}
