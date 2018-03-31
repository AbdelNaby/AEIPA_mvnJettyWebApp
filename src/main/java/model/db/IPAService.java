/**
 * 
 */
package model.db;

import java.util.ArrayList;



/**
 * @author acil
 *
 */
public class IPAService extends FolderService<IPADTO> {

	public IPAService() {
		// User has the option to create IPAservice using Arraylist of strings
	}

	public boolean iPAMainFileName_IsValid(String iPAMainFileName) {
		// Checking newIPAMainFileName has a value
		System.out.println("Inside IPAservice -> iPAMainFileName_IsValid -> iPAMainFileName is: " + iPAMainFileName);
		if (iPAMainFileName.isEmpty()) {
			System.out.println("IPA Main File Name is mandatory. Please enter a value.");
			return false;
		}
		return true;
	}

	public boolean iPAProgLanguageName_IsValid(String progLanguageName) {
		// Checking progLanguageName has a value
		if (progLanguageName.isEmpty()) {
			System.out.println("progLanguageName is mandatory. Please enter a value.");
			return false;
		}
		return true;
	}

	public boolean iPAProgLanguageNum_IsValid(String progLanguageNum) {
		// Checking progLanguageNum has a value
		if (progLanguageNum.isEmpty()) {
			System.out.println("progLanguageNum is mandatory. Please enter a value.");
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(IPADTO dto) {
		IPADAO iPADAO = new IPADAO();
		String oldIPAName = dto.getName();
		// Deleting the IPA using the IPA name attribute
		if (!iPADAO.delete(iPADAO.getAttributeList().get(2), "=", oldIPAName)) {
			System.out.println("IPA: " + oldIPAName + " failed to get deleted. Problem in Database");
			return false;
		}
		System.out.println("New IPA: " + oldIPAName + " has been deleted " + "succesfully.");
		// Deleting folder name in disk
		if (!deleteFolder(dto.getFullPath())) {
			System.err.println("Folder is not deleted ");
			return false;
		} else {
			System.out.println("Physical Folder has been deleted successfully");
			return true;
		}
	}
	//
	// @Override
	// public boolean validateDatabyType(IPADTO dto) {

	// }

	@Override
	public boolean createNew(IPADTO dto) {
		IPADAO iPADAO = new IPADAO();
		// Checking the new IPA Name
		System.out.println("This is tha iPAMainFileName: " + dto.getMainFileName());
		if (validateData(dto)) {
			// Adding the new IPA to the database
			if (!iPADAO.add(dto)) {
				System.out.println("IPA: " + dto.getName() + " has NOT been added succesfully. Problem in Database");
				return false;
			}
			System.out.println("New IPA: " + dto.getName() + " has been added succesfully to the database.");
			// Creating a directory in the physical disk
			createDirectory(dto.getFullPath());
			return true;
		}
		return false;
	}

	@Override
	public boolean updateInfo(IPADTO dto, IPADTO newIPADTO) {
		IPADAO iPADAO = new IPADAO();

		// Checking if the New IPA's info are valid or not
		IPAService iPAtempService = new IPAService();

		if (iPAtempService.validateData(newIPADTO)) {
			String oldIPAName = dto.getName();
			// Updating the IPA using the IPA name attribute
			if (!iPADAO.update(newIPADTO, iPADAO.getAttributeList().get(1), "=", oldIPAName)) {
				System.out.println("IPA: " + oldIPAName + " failed to get updated. Problem in Database");
				return false;
			}
			System.out.println("New IPA: " + oldIPAName + " has been updated " + "succesfully.");
			// Renaming folder name in disk
			if (!renameFolder(dto.getFullPath(), newIPADTO.getName())) {
				System.err.println("Folder is not renamed ");
			} else {
				System.out.println("Physical Folder has been renamed successfully");
			}

		}
		System.err.println("IPA values are not validated successfully");
		return false;
	}

	@Override
	public IPADTO dTOMapper(ArrayList<String> dTOvaluesList) {
		IPADTO iPA = null;
		String iPAlgorithmtype = dTOvaluesList.get(3);
		if (iPAlgorithmtype.equalsIgnoreCase("Matching")) {
			iPA = new IPA_MatchingDTO();
		} else if (iPAlgorithmtype.equalsIgnoreCase("Edge_Detection")) {
			iPA = new IPA_Edge_DetectionDTO();
		}
		// iPA.setId(dTOvaluesList.get(0));
		iPA.setUserName(dTOvaluesList.get(0));
		iPA.setName(dTOvaluesList.get(1));
		iPA.setDescription(dTOvaluesList.get(2));
		// Full path is generated automatically, there is no need to set it
		// iPA.setFullPath(rs.getString(attributeList.get(---)));
		// Type is set automatically when the object is created
		// iPA.setType(rs.getString(attributeList.get(3)));
		iPA.setMainFileName(dTOvaluesList.get(4));
		iPA.setProgLanguageName(dTOvaluesList.get(5));
		iPA.setProgLanguageNum(dTOvaluesList.get(6));
		return iPA;
	}

	@Override
	public ArrayList<String> dTOMapper(IPADTO dto) {
		ArrayList<String> tempIPA = new ArrayList<String>();
		tempIPA.add(dto.getName());
		tempIPA.add(dto.getDescription());
		tempIPA.add(dto.getType());
		// No need for the full path to be displayed to the user
		//tempIPA.add(dto.getFullPath());
		// tempIPA.add(dto.getId());
		tempIPA.add(dto.getMainFileName());
		
		tempIPA.add(dto.getProgLanguageName());
		tempIPA.add(dto.getProgLanguageNum());
		
		tempIPA.add(dto.getUserName());
		// No need for it now
		// tempIPA.addAll(dto.getFilesNameList());
		// IPA_MatchingDTO XX = new IPA_MatchingDTO();
		// validateDatabyType (XX);
		return tempIPA;
	}

	@Override
	protected boolean validateDatabyType(IPADTO dto) {

		System.out.println("We are here !!!");
		if (iPAMainFileName_IsValid(dto.getMainFileName()) && iPAProgLanguageName_IsValid(dto.getProgLanguageName())
				&& iPAProgLanguageNum_IsValid(dto.getProgLanguageNum()))
			return true;
		return false;
	}

	public boolean name_IsValid(String iPAName) {
		IPADAO iPADAO = new IPADAO();
		// Checking Name has value
		if (iPAName.isEmpty()) {
			System.out.println("IPA Name is mandatory. Please enter a value.");
			return false;
		}
		// Checking Name is unique
		if (iPADAO.display(iPADAO.getAttributeList().get(1), "=", iPAName) == null) {
			// ArrayList<String> chkAttributeList = new ArrayList<String>();
			// ArrayList<String> chkConditionOpList = new ArrayList<String>();
			// ArrayList<String> chkValueList = new ArrayList<String>();
			// // IPA Name
			// chkAttributeList.add(iPADAO.getAttributeList().get(1));
			// chkConditionOpList.add("=");
			// chkValueList.add(iPAName);
			// if (iPADAO.displayManyConditions(chkAttributeList, chkConditionOpList,
			// chkValueList) == null) {
			System.out.println("IPA Name: " + iPAName + " already exists, Please enter another name.");
			return false;
		}
		System.out.println("IPA Name: " + iPAName + " is a new IPA and can be added to the database");
		return true;
	}

	@Override
	public IPADTO retrieveInfobyName(String name) {
		IPADAO iPADAO = new IPADAO();
		// Checking the new IPA Name
		System.out.println("This is from retrieveInfo for IPAName: " + name);

		ArrayList<IPADTO> iPA = iPADAO.display("NAME", "LIKE", "%" + name + "%");
		if (iPA == null) {
			// Failed to retrieve the information of the IPA
			System.out.println("IPA Name: " + name + " has NOT been found in the database succesfully..");
			return null;
		}
		System.out.println("IPA Name: " + name + " has  been found in the database succesfully..");
		return iPA.get(0);
	}

	public boolean executeIPA(IPADTO iPADTO, DatasetContainerDTO datasetContainerDTO, String userName) {
		
		System.out.println("Inside ... executeIPA");
		// creating a new benchmark results out of the IPAName and InputDatasetName
		//String resultFolder = inputDatasetDTO.benchmarkDataset.addToResultDatasetList(iPADTO);
//		if (resultFolder.equals(null))
//		{
//			System.out.println("## benchmarkResultFolder has NOT been created..." + resultFolder);
//		}
		IPADockerExecute_Java iPADockerExecute_Java = new IPADockerExecute_Java();
		if(iPADockerExecute_Java.executeIPA(iPADTO, datasetContainerDTO, userName))
		{
			System.out.println(" Congrats,,, IPA has been executed successfully ....");
			return true;
		}
		System.out.println("IPA has failed execution ....");
		return false;
	}

	@Override
	public ArrayList<IPADTO> retrieveInfobyType(String type) {
		IPADAO iPADAO = new IPADAO();
		// Checking the new IPA Name
		System.out.println("This is from retrieveInfo for IPA type: " + type);

		ArrayList<IPADTO> iPAList = iPADAO.display("Type", "=", type);
		if (iPAList == null) {
			// Failed to retrieve the information of the IPA
			System.out.println("IPA type: " + type + " has NOT been found in the database succesfully..");
			return null;
		}
		System.out.println("IPA type: " + type + " has  been found in the database succesfully..");
		return iPAList;
	}

}
