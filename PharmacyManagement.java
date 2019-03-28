import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PharmacyManagement {
	
	/**
	 * reading all lines of input file and adding to an arraylist
	 * 
	 * @throws IOException  If an input exception occoured
	 * @see java.io.IOException
	 * @see java.nio.file.Files
	 * @see java.nio.file.Paths
	 * 
	 * @param path		string that holds the path of target input file
	 * @return			returning an arraylist that holds lines of the input file
	 */
	
	public static String[] readFile(String path){
		try{
			int i = 0;
			int lenght = Files.readAllLines(Paths.get(path)).size();
			String[] results = new String[lenght];
			
			for (String line:Files.readAllLines(Paths.get(path))) {
				results[i++] = line;
			}
			
			return results;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * making medic objects and adding these objects to an arraylist
	 * 
	 * @see java.text.DateFormat
	 * @see java.util.ArrayList
	 * 
	 * @param priceList				an arraylist that holds Medicament objects
	 * @param medicamentsLines		string array that holds the Medicaments.txt input lines
	 * @param prescription			an object that holds prescription info
	 */
	
	public static void buildPriceList(ArrayList<Medicament> priceList, String[] medicamentsLines,Prescription prescription){
		for(String line : medicamentsLines){
			String[] parts = line.split("\\s+");			/*Every white spaces will be split delimeter*/
			
			Date validityDate = createMedicDateObject(parts[2]);
			Date expiryDate = createMedicDateObject(parts[3]);	
			
			Float price = Float.parseFloat(parts[4]);					/*Price should be float if we need to hold fraction*/
			if(!prescription.getPrescriptDate().after(expiryDate)){		/*Control if prescription date is not after the expiry date of the medicament*/
				Medicament medic = new Medicament(parts[0], parts[1], validityDate, expiryDate, price, 0);		/*Allocating Medic Object*/
				priceList.add(medic);	
			}	
		}
		
	}
	
	/**
	 * building a date object and allocating space
	 *
	 * @throws ParseException  If an parsing exception occoured
	 * @see java.text.ParseException
	 * @see java.util.ArrayList
	 * @see java.text.DateFormat
	 * 
	 * @param dateString	string that holds the month, day, and year in order date format
	 * @return				returning Date object
	 */
	
	public static Date createMedicDateObject(String dateString){
		Date date = null;
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		try
        {
            date = dateFormat.parse(dateString);
        }
        catch (ParseException e)
        {
            System.out.println("Exception "+e);
        }
		
        return date;
	}
	
	/**
	 * building a prescription object and allocating space 
	 * 
	 * @see java.text.DateFormat
	 * 
	 * @param prescriptionLines		string array that holds prescription lines from prescription.txt			
	 * @return						returning Prescription object
	 */
	
	public static Prescription buildPrescription(String[] prescriptionLines){
		String[] parts = prescriptionLines[0].split("\t");
		Date prescriptDate = createMedicDateObject(parts[2]);
		Prescription prescription = new Prescription(parts[0], parts[1], prescriptDate);
		
		for(int i=1;i<prescriptionLines.length;i++){
			String[] parts2 = prescriptionLines[i].split("\\s+");
			int quantity = Integer.parseInt(parts2[1]);
			Medicament medic = new Medicament(parts2[0], parts[1], null, null, 0.0f, quantity);
	
			prescription.addMedicList(medic);
	
		}
		
		return prescription;
		
	}
	
	/**
	 * finding right price from among same medicenes that have same names, SSI code, and validity date 
	 * 
	 * @see java.util.ArrayList
	 * 
	 * @param priceList 			an arraylist that holds Medicament objects
	 * @param prescription			an object that holds prescription info
	 */
	
	public static void findingRightPrice(ArrayList<Medicament> priceList,Prescription prescription){
		
		for(int i=0;i<priceList.size();i++ ){
			for(int j=i+1;j<priceList.size();j++){
				if(priceList.get(i).getMedicName().equals(priceList.get(j).getMedicName())							/*Compare 2 Medicine Name*/
						&& (priceList.get(i).getSocialSecureCode().equals(priceList.get(j).getSocialSecureCode()))	/*Compare 2 Social Secure Code*/
						&& (priceList.get(i).getValidityDate().equals(priceList.get(j).getValidityDate()))){			/*Compare 2 Validity Date*/
					if(Float.compare(priceList.get(i).getPrice(), priceList.get(j).getPrice()) > 0){		/*Compare two float price*/
						priceList.get(i).setPrice(priceList.get(j).getPrice());					/*2nd variable is smaller then 1st, so it should be the right value*/
					}else if(Float.compare(priceList.get(i).getPrice(), priceList.get(j).getPrice()) < 0){
						priceList.get(j).setPrice(priceList.get(i).getPrice());					/*1st variable is smaller then 2nd, so it should be the right value*/
					}else{
						/*2 variable are both same, so do nothing*/
					}
				}
			}	
		}
		
	}
	
	/**
	 * getting right medic price from the priceList and printing the necessary info to console
	 * 
	 * @see java.util.ArrayList
	 * 
	 * @param priceList			an arraylist that holds Medicament objects
	 * @param prescription		an object that holds prescription info
	 */
	
	public static void invoicingPrescription(ArrayList<Medicament> priceList,Prescription prescription){
		double totalPrescriptPrice = 0;
		for(Medicament medic : prescription.getMedicList()){
			for(Medicament medic2 : priceList){
				if((medic2.getMedicName().equals(medic.getMedicName())) && (medic2.getSocialSecureCode().equals(medic.getSocialSecureCode()))){
					medic.setPrice(medic2.getPrice());
					break;
				}
			}
			double totalPrice = Math.floor(medic.getPrice()*medic.getQuantity()*100.0)/100.0;
			totalPrescriptPrice += totalPrice; 
			System.out.print(medic.getMedicName() + "\t" + medic.getPrice() + "\t" + medic.getQuantity() + "\t" + totalPrice + "\n");
		}
		System.out.println("Total" + "\t" + totalPrescriptPrice);
	}
	
}
