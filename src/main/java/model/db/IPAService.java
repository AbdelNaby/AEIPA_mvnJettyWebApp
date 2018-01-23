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

	//protected IPADTO dto;
	public IPAService(IPADTO dto) {
		super(dto);
		this.dto = (IPADTO) dto;
	}
	public IPAService() {
		// User has the option to create IPAservice using Arraylist of strings
	}

//	public FolderDTO dTOMapper(ArrayList<String> dTOvaluesList) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public ArrayList<String> dTOMapper(FolderDTO dto) {
//		this.dto = (IPADTO) dto;
//		
//		// Rest of the Mapping code
//		return null;
//	}

	public boolean iPAMainFileName_IsValid()
	{
		String iPAMainFileName = dto.getMainFileName();
		//Checking newIPAMainFileName has a value
		if(iPAMainFileName.isEmpty())
		{
			System.out.println("IPA Main File Name is mandatory. Please enter a value.");
			return false;
		}
		return true;
	}
	public boolean iPAProgLanguageName_IsValid() {
		String progLanguageName = dto.getProgLanguageName();
		//Checking progLanguageName has a value
		if(progLanguageName.isEmpty())
		{
			System.out.println("progLanguageName is mandatory. Please enter a value.");
			return false;
		}
		return true;
	}
	public boolean iPAProgLanguageNum_IsValid() {
		String progLanguageNum = dto.getProgLanguageNum();
		//Checking progLanguageNum has a value
		if(progLanguageNum.isEmpty())
		{
			System.out.println("progLanguageNum is mandatory. Please enter a value.");
			return false;
		}
		return true;
	}



	@Override
	public boolean delete() {
		IPADAO iPADAO= new IPADAO();
		
		//Checking if the New IPA's info are valid or not

			String oldIPAName = dto.getName();
			// Deleting the IPA using the IPA name attribute
			if( !iPADAO.delete(iPADAO.getAttributeList().get(2), "=", 
					oldIPAName))
			{
				System.out.println("IPA: " + oldIPAName 
					+ " failed to get deleted. Problem in Database");
				return false;
			}
			System.out.println("New IPA: " + oldIPAName + " has been deleted "
					+ "succesfully.");
		// Deleting folder name in disk
			if(!deleteFolder(dto.getFullPath()))
			{
				System.err.println("Folder is not deleted ");
			}
			else {
				System.out.println("Physical Folder has been deleted successfully");
			}

	
		System.err.println("IPA values are not validated successfully");
		return false;
	}

	@Override
	public boolean validateDatabyType() {
		if (iPAMainFileName_IsValid()
				&& iPAProgLanguageName_IsValid()
				&& iPAProgLanguageNum_IsValid())
			return true;
		return false;
	}



	@Override
	public boolean createNew() {
		IPADAO iPADAO= new IPADAO();
		
		//Checking the new IPA Name
		if (validateData())
		{
			// Adding the new IPA to the database
			if( !iPADAO.add(dto))
			{
				System.out.println("IPA: " + dto.getName() 
					+ " has NOT been added succesfully. Problem in Database");
				return false;
			}
			System.out.println("New IPA: " + dto.getName() + " has been added "
					+ "succesfully.");
			return true;	
		}
		return false;
	}

	@Override
	public boolean updateInfo(IPADTO newIPADTO) {
		IPADAO iPADAO= new IPADAO();
		
		//Checking if the New IPA's info are valid or not
		IPAService iPAtempService = new IPAService(newIPADTO);
		
		
		if (iPAtempService.validateData())
		{
			String oldIPAName = dto.getName();
			// Updating the IPA using the IPA name attribute
			if( !iPADAO.update(newIPADTO, iPADAO.getAttributeList().get(2), "=", 
					oldIPAName))
			{
				System.out.println("IPA: " + oldIPAName 
					+ " failed to get updated. Problem in Database");
				return false;
			}
			System.out.println("New IPA: " + oldIPAName + " has been updated "
					+ "succesfully.");
		// Renaming folder name in disk
			if(!renameFolder(dto.getFullPath(), newIPADTO.getName()))
			{
				System.err.println("Folder is not renamed ");
			}
			else {
				System.out.println("Physical Folder has been renamed successfully");
				dto = newIPADTO;
			}

		}
		System.err.println("IPA values are not validated successfully");
		return false;
	}

	@Override
	public IPADTO dTOMapper(ArrayList<String> dTOvaluesList) {
		IPADTO iPA = null;
		String iPAlgorithmtype = dTOvaluesList.get(5);
		if (iPAlgorithmtype.equalsIgnoreCase("Matching")) {
			iPA = new IPA_MatchingDTO();
		}
		else if(iPAlgorithmtype.equalsIgnoreCase("Edge_Detection"))
		{
			iPA = new IPA_Edge_DetectionDTO();
		}
		iPA.setId(dTOvaluesList.get(0));
		iPA.setUserName(dTOvaluesList.get(1));
		iPA.setName(dTOvaluesList.get(2));
		iPA.setDescription(dTOvaluesList.get(3));
		// Full path is generated automatically, there is no need to set it
		// iPA.setFullPath(rs.getString(attributeList.get(4)));
		// Type is set automatically when the object is created
		// iPA.setType(rs.getString(attributeList.get(5)));
		return null;
	}
	@Override
	public ArrayList<String> dTOMapper(IPADTO dto) {
		// TODO Auto-generated method stub
		return null;
	}








//	@Override
//	public boolean validateDatabyType() {
//		if (iPAName_IsValid() 
//				&& iPAMainFileName_IsValid()
//				&& iPAProgLanguageName_IsValid()
//				&& iPAProgLanguageNum_IsValid())
//			return true;
//		return false;
//	}






}
