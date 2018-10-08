package settings;

import java.io.IOException;

import com.jcraft.jsch.JSchException;

import junit.framework.Assert;
import pages.OpenNewTicket;
import pages.OpenTicketTab;

public class scriptSQL 
{
	
	static	  String scriptSQL;
	static    String getSubject = "SELECT ost_ticket__cdata.subject result FROM ostickets.ost_ticket__cdata WHERE ost_ticket__cdata.ticket_id ="+OpenTicketTab.ticket_id+";";
	static    String getEmail = "SELECT ost_user_email.address result FROM ostickets.ost_ticket join ostickets.ost_user_email ON ost_user_email.user_id = ost_ticket.user_id WHERE ost_ticket.ticket_id ="+OpenTicketTab.ticket_id+";";
	static    String getUser = "SELECT ost_user.name result FROM ostickets.ost_ticket join ostickets.ost_user ON ost_user.id = ost_ticket.user_id WHERE ost_ticket.ticket_id ="+OpenTicketTab.ticket_id+";";
    static    String getPhone = "SELECT ost_user__cdata.phone result FROM ostickets.ost_user__cdata join ostickets.ost_ticket ON ost_user__cdata.user_id = ost_ticket.user_id WHERE ost_ticket.ticket_id ="+OpenTicketTab.ticket_id+";";
 
    public static void checkIssueSummary() throws IOException {
	   scriptSQL = getSubject;
	   try {
		   Assert.assertEquals(OpenNewTicket.issueSummaryCorrect, MysqlConnect.readTable(scriptSQL));
		   System.out.println("Issue Summary in DB is correct");
		} catch (JSchException e) {
			System.out.println("Issue Summary in DB is incorrect");
			e.printStackTrace();
		}
	  
	   
   }
   
   public static void checkEmail() throws IOException {
	   scriptSQL = getEmail;
	   try {
		   Assert.assertEquals(OpenNewTicket.emailAddressCorrect, MysqlConnect.readTable(scriptSQL));
		   System.out.println("emailAddress in DB is correct");
		} catch (JSchException e) {
			System.out.println("emailAddress in DB is incorrect");
			e.printStackTrace();
		}
	  
	   
   }
   
   public static void checkfullName() throws IOException {
	   scriptSQL = getUser;
	   try {
		   Assert.assertEquals(OpenNewTicket.fullNameCorrect, MysqlConnect.readTable(scriptSQL));
		   System.out.println("User name in DB is correct");
		} catch (JSchException e) {
			System.out.println("User name in DB is incorrect");
			e.printStackTrace();
		}
	  
	   
   }
   
   public static void checkPhone() throws IOException {
	   scriptSQL = getUser;
	   String phone = OpenNewTicket.phoneNumberCorrect+"X"+OpenNewTicket.phoneNumberExtCorrect;
	   
	   try {
		   Assert.assertEquals("phoneNumber in DB is incorrect!!!", phone, MysqlConnect.readTable(getPhone));
		   System.out.println("phoneNumber in DB is correct");
		} catch (JSchException e) {
			System.out.println("phoneNumber in DB is incorrect");
			e.printStackTrace();
		}
	  
	   
   }
        
        
        public static void main( String[] args ) throws IOException
    {
       
    }
    
    
}
