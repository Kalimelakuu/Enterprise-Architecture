package edu.miu.EALab2_B;

public interface IEmailSender {
	void sendEmail(String email, String message);
	String getOutgoingMailServer();
}