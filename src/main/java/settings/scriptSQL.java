package settings;

import java.io.IOException;

import com.jcraft.jsch.JSchException;

import junit.framework.Assert;
import pages.OpenNewTicket;
import pages.OpenTicketTab;

public class scriptSQL 
{
	OpenTicketTab ticketTab = new OpenTicketTab();
	
		String scriptSQL;
	    String getSubject = "SELECT ost_ticket__cdata.subject result FROM ostickets.ost_ticket__cdata WHERE ost_ticket__cdata.ticket_id ="+ticketTab.ticket_id+";";
	    String getEmail = "SELECT ost_user_email.address result FROM ostickets.ost_ticket join ostickets.ost_user_email ON ost_user_email.user_id = ost_ticket.user_id WHERE ost_ticket.ticket_id ="+ticketTab.ticket_id+";";
	    String getUser = "SELECT ost_user.name result FROM ostickets.ost_ticket join ostickets.ost_user ON ost_user.id = ost_ticket.user_id WHERE ost_ticket.ticket_id ="+ticketTab.ticket_id+";";
        String getPhone = "SELECT ost_user__cdata.phone result FROM ostickets.ost_user__cdata join ostickets.ost_ticket ON ost_user__cdata.user_id = ost_ticket.user_id WHERE ost_ticket.ticket_id ="+ticketTab.ticket_id+";";
 
    public  void checkIssueSummary() throws IOException {
	   scriptSQL = getSubject;
	   try {
		   MysqlConnect mysqlConnect = new MysqlConnect();
		   OpenNewTicket openTicket = new OpenNewTicket();
		   Assert.assertEquals(openTicket.issueSummaryCorrect, mysqlConnect.readTable(scriptSQL));
		   System.out.println("Issue Summary in DB is correct");
		} catch (JSchException e) {
			System.out.println("Issue Summary in DB is incorrect");
			e.printStackTrace();
		}
	  
	   
   }
   
   public  void checkEmail() throws IOException {
	   scriptSQL = getEmail;
	   try {
		   MysqlConnect mysqlConnect = new MysqlConnect();
		   OpenNewTicket openTicket = new OpenNewTicket();
		   Assert.assertEquals(openTicket.emailAddressCorrect, mysqlConnect.readTable(scriptSQL));
		   System.out.println("emailAddress in DB is correct");
		} catch (JSchException e) {
			System.out.println("emailAddress in DB is incorrect");
			e.printStackTrace();
		}
	  
	   
   }
   
   public  void checkfullName() throws IOException {
	   scriptSQL = getUser;
	   try {
		   MysqlConnect mysqlConnect = new MysqlConnect();
		   OpenNewTicket openTicket = new OpenNewTicket();
		   Assert.assertEquals(openTicket.fullNameCorrect, mysqlConnect.readTable(scriptSQL));
		   System.out.println("User name in DB is correct");
		} catch (JSchException e) {
			System.out.println("User name in DB is incorrect");
			e.printStackTrace();
		}
	  
	   
   }
   
   public  void checkPhone() throws IOException {
	   scriptSQL = getUser;
	   OpenNewTicket openTicket = new OpenNewTicket();
	   String phone = openTicket.phoneNumberCorrect+"X"+openTicket.phoneNumberExtCorrect;
	   
	   try {
		   MysqlConnect mysqlConnect = new MysqlConnect();
		   Assert.assertEquals("phoneNumber in DB is incorrect!!!", phone, mysqlConnect.readTable(getPhone));
		   System.out.println("phoneNumber in DB is correct");
		} catch (JSchException e) {
			System.out.println("phoneNumber in DB is incorrect");
			e.printStackTrace();
		}
	  
	   
   }
        
        
     
    
    
}
