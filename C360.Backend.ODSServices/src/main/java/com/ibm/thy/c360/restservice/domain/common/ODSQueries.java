package com.ibm.thy.c360.restservice.domain.common;

public class ODSQueries {
	
	public static String SearchCustomerByNameSurnamePassport = " SELECT CI.CAMPAIGN_CODE,"
						+ "  CI.SECTOR_ID," 
						+ "  CI.BRAND_ID ," 
						+ "  CI.BRAND_NAME_EN," 
						+ "  FROM MNS_ACTION_TABLE MAT"  
						+ "  JOIN VW_MNS_CAMP_INFO CI" 
						+ "  WHERE " 
			      		+ "  CI.ODS_NAME ='pallavi' AND"  
						+ "  CI.ODS_SURNAME='Mandal' AND"  
						+ "  MAT.PassportNumber=:passportNumber";
	
	public static String SearchCustomerByNameSurnameTCKN = " SELECT CI.CAMPAIGN_CODE,"
			+ "  CI.SECTOR_ID," 
			+ "  CI.BRAND_ID ," 
			+ "  CI.BRAND_NAME_EN," 
			+ "  FROM MNS_ACTION_TABLE MAT"  
			+ "  JOIN VW_MNS_CAMP_INFO CI" 
			+ "  WHERE " 
      		+ "  CI.ODS_NAME ='pallavi' AND"  
			+ "  CI.ODS_SURNAME='Mandal' AND"  
			+ "  MAT.TCKN=:TCKN";
	
	public static String SearchCustomerByNameSurnameEmail = " SELECT CI.CAMPAIGN_CODE,"
			+ "  CI.SECTOR_ID," 
			+ "  CI.BRAND_ID ," 
			+ "  CI.BRAND_NAME_EN," 
			+ "  FROM MNS_ACTION_TABLE MAT"  
			+ "  JOIN VW_MNS_CAMP_INFO CI" 
			+ "  WHERE " 
      		+ "  CI.ODS_NAME ='pallavi' AND"  
			+ "  CI.ODS_SURNAME='Mandal' AND"  
			+ "  MAT.email=:email";
	
	public static String SearchCustomerByNameSurnameTelephone = " SELECT CI.CAMPAIGN_CODE,"
			+ "  CI.SECTOR_ID," 
			+ "  CI.BRAND_ID ," 
			+ "  CI.BRAND_NAME_EN," 
			+ "  FROM MNS_ACTION_TABLE MAT"  
			+ "  JOIN VW_MNS_CAMP_INFO CI" 
			+ "  WHERE " 
      		+ "  CI.ODS_NAME ='pallavi' AND"  
			+ "  CI.ODS_SURNAME='Mandal' AND"  
			+ "  MAT.Telephone=:telephone";
	
	public static String SearchCustomerByTCCNumber = " SELECT CI.CAMPAIGN_CODE,"
			+ "  CI.SECTOR_ID," 
			+ "  CI.BRAND_ID ," 
			+ "  CI.BRAND_NAME_EN," 
			+ "  FROM MNS_ACTION_TABLE MAT"  
			+ "  JOIN VW_MNS_CAMP_INFO CI" 
			+ "  WHERE " 
			+ "  MAT.TCc=:TCc";
	
	public static String SearchCustomerByTKNumber = " SELECT CI.CAMPAIGN_CODE,"
			+ "  CI.SECTOR_ID," 
			+ "  CI.BRAND_ID ," 
			+ "  CI.BRAND_NAME_EN," 
			+ "  FROM MNS_ACTION_TABLE MAT"  
			+ "  JOIN VW_MNS_CAMP_INFO CI" 
			+ "  WHERE "   
			+ "  MAT.TK=:TK";
	
	// customer profile ODS query
	public static String SearchCustomerProfile = " SELECT CI.CAMPAIGN_CODE,"
			+ "  CI.SECTOR_ID," 
			+ "  CI.BRAND_ID ," 
			+ "  CI.BRAND_NAME_EN," 
			+ "  FROM MNS_ACTION_TABLE MAT"  
			+ "  JOIN VW_MNS_CAMP_INFO CI" 
			+ "  WHERE "   
			+ "  MAT.TKnumber=:TKnumber";
	
	

}
