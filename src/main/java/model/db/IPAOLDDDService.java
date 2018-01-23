/**
 * 
 */
package model.db;

import java.util.ArrayList;
/**
 * @author acil
 *
 */
public abstract class IPAOLDDDService extends FolderService{

	protected IPADTO iPADTO;
	
	/**
	 * There is an option to create IPAService using the DTO OR using 
	 * Arraylist of the values
	 */
	public IPAOLDDDService(ArrayList<String> iPAvaluesList)
	{
		dTOMapper(iPAvaluesList);
	}
	/**
	 * There is an option to create IPAService using the DTO OR using 
	 * Arraylist of the values
	 */
	public IPAOLDDDService(IPADTO iPADTO)
	{
		super(iPADTO);
		this.iPADTO = iPADTO;
	}
	public boolean iPAName_IsValid()
	{
		IPADAO iPADAO= new IPADAO();
		String iPAName = iPADTO.getName();
		//Checking Name has value
		if(iPAName.isEmpty())
		{
			System.out.println("IPA Name is mandatory. Please enter a value.");
			return false;
		}
		//Checking Name is unique
		if(iPADAO.display(iPADAO.getAttributeList().get(2), "=", iPAName) != null)
		{
			System.out.println("IPA Name: " + iPAName + " already exists, Please enter another name.");
			return false;
		}
		return true;
	}
	public boolean iPAMainFileName_IsValid()
	{
		String iPAMainFileName = iPADTO.getMainFileName();
		//Checking newIPAMainFileName has a value
		if(iPAMainFileName.isEmpty())
		{
			System.out.println("IPA Main File Name is mandatory. Please enter a value.");
			return false;
		}
		return true;
	}
	public boolean iPAProgLanguageName_IsValid() {
		String progLanguageName = iPADTO.getProgLanguageName();
		//Checking progLanguageName has a value
		if(progLanguageName.isEmpty())
		{
			System.out.println("progLanguageName is mandatory. Please enter a value.");
			return false;
		}
		return true;
	}
	public boolean iPAProgLanguageNum_IsValid() {
		String progLanguageNum = iPADTO.getProgLanguageNum();
		//Checking progLanguageNum has a value
		if(progLanguageNum.isEmpty())
		{
			System.out.println("progLanguageNum is mandatory. Please enter a value.");
			return false;
		}
		return true;
	}


//	@Override
//	public boolean add() {
//		IPADAO iPADAO= new IPADAO();
//		
//		//Checking the new IPA Name
//		if (iPAName_IsValid() 
//				&& iPAMainFileName_IsValid()
//				&& iPAProgLanguageName_IsValid()
//				&& iPAProgLanguageNum_IsValid())
//		{
//			// Adding the new IPA to the database
//			if( !iPADAO.add(iPADTO))
//			{
//				System.out.println("IPA: " + iPADTO.getName() 
//					+ " has NOT been added succesfully. Problem in Database");
//				return false;
//			}
//			System.out.println("New IPA: " + iPADTO.getName() + " has been added "
//					+ "succesfully.");
//			return true;	
//		}
//		return false;
//	}
//	@Override
//	public boolean update(IPADTO newiPADTO) {
//		IPADAO iPADAO= new IPADAO();
//		
//		//Checking if the IPA's info are valid or not
//		if (iPAName_IsValid() 
//				&& iPAMainFileName_IsValid()
//				&& iPAProgLanguageName_IsValid()
//				&& iPAProgLanguageNum_IsValid())
//		{
//			// Updating the IPA using the IPA name attribute
//			if( !iPADAO.update(iPADTO, iPADAO.getAttributeList().get(2), "=", 
//					oldIPAName))
//			{
//				System.out.println("IPA: " + iPADTO.getName() 
//					+ " failed to get updated. Problem in Database");
//				return false;
//			}
//			System.out.println("New IPA: " + iPADTO.getName() + " has been updated "
//					+ "succesfully.");
//		// Renaming folder name in disk
//			if(!renameFolder(iPADTO.getFullPath(), iPADTO.getName()))
//			{
//				System.err.println("Folder is not renamed ");
//			}
//			System.out.println("Physical Folder has been renamed successfully");
//			
//
//			return true;	
//		}
//		System.err.println("IPA values are not validated successfully");
//		return false;
//	}
//	

	protected void dTOMappertoArrayList(ArrayList<String> iPAvaluesList)
	{
		// ToDo: Remove mandatory fields from constructor
			
			iPADTO.setUserName(iPAvaluesList.get(0));
			iPADTO.setName(iPAvaluesList.get(1));
			iPADTO.setMainFileName(iPAvaluesList.get(2));
			iPADTO.setDescription(iPAvaluesList.get(3));
			iPADTO.setProgLanguageName(iPAvaluesList.get(4));
			iPADTO.setProgLanguageNum(iPAvaluesList.get(5));
	}
	
	public boolean executeIPA(InputDatasetDTO inputDatasetDTO)
	{
		IPADockerExecute iPADockerExec = new IPADockerExecute();
		iPADockerExec.execute(iPADTO, inputDatasetDTO);
		return true;
	}
//	@Override
//	public FolderDTO dTOMapper(ArrayList<String> dTOvaluesList) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public boolean update(FolderDTO newFolderDTO) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	@Override
//	public boolean delete() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	@Override
//	public ArrayList dTOMapper(GenericDTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	
	


	

}
