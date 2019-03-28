
import java.util.ArrayList;

public class Main {

	/**
	 * 
	 * @author      Daghan Emre Aytac <daghanemreaytac@hotmail.com>
	 * @version  	1.1 		(Current version number of program)
	 * @since 		2016-03-01	(the version of the package this class was first added to)
	 */
	public static void main(String[] args) {
		String[] prescriptionLines = PharmacyManagement.readFile(args[0]);
		String[] medicamentsLines = PharmacyManagement.readFile(args[1]);
		Prescription prescription = PharmacyManagement.buildPrescription(prescriptionLines);
		ArrayList<Medicament> priceList = new ArrayList<Medicament>();
		PharmacyManagement.buildPriceList(priceList, medicamentsLines,prescription);
		PharmacyManagement.findingRightPrice(priceList,prescription);
		PharmacyManagement.invoicingPrescription(priceList, prescription);
	}

}
