package edu.miu.EA_Lab2_A;

public interface IEmailSender {
	void sendEmail(String email, String message);
	String getOutgoingMailServer();
}