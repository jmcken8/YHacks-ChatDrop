package gui.chatpanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MessagePanel extends JPanel{
	public MessagePanel(core.objects.Message message){
		setLayout(null);
		JLabel userName = new JLabel(message.getUserName());
		JLabel date = new JLabel(message.getDate());
		JLabel text = new JLabel(message.getMessageText());
		userName.setBounds(5,5,100,20);
		date.setBounds(5, 30, 100, 20);
		int messageSize = getMessageSize(message.getMessageText());
		text.setBounds(105, 5, 500, messageSize);
	}
	
	//need to use an algorithm to get the height from the amount of text
	public int getMessageSize(String text){
		int size = 100;
		
		return size;
	}
}