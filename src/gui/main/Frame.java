package gui.main;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Frame {
	public static JFrame frame = new JFrame();
	public Frame(){
		frame.setVisible(true);
		frame.setBounds(100, 100, 600, 500);
		frame.getContentPane().setBackground(new Color(0x123456));
		frame.setLayout(null);
		WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(null, "Are You Sure to Close Application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                	//Main.closeConnection();
                	System.exit(0);
                }
            }
        };
        frame.addWindowListener(exitListener);
	}
	public void initSearch(List<File> list){
		gui.searchpanel.SearchPanel searchPanel = new gui.searchpanel.SearchPanel(list);
		searchPanel.setBounds(5,5,300,660);
		frame.add(searchPanel);
		frame.validate();
		frame.repaint();
	}
	public void initEmptyChat(){
		gui.chatpanel.EmptyChat empty = new gui.chatpanel.EmptyChat();
		empty.setBounds(305,5,785,490);
		frame.add(empty);
		frame.validate();
		frame.repaint();
	}
	public static void initChat(core.objects.Message[] messages){
		gui.chatpanel.ChatPanel chatPanel = new gui.chatpanel.ChatPanel(messages);
		gui.chatpanel.EntryPanel entryPanel = new gui.chatpanel.EntryPanel();
		chatPanel.setBounds(310,65,780,430);
		entryPanel.setBounds(310,500,780,165);
		frame.add(chatPanel);
		frame.add(entryPanel);
		frame.validate();
		frame.repaint();
	}
	public String newUser(String authorizeUrl){
		frame.setBounds(50,50,900,600);
		NewUserPanel newUser = new NewUserPanel(authorizeUrl);
		frame.add(newUser);
		frame.validate();
		frame.repaint();
		
		while(newUser.getURL() == null);
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		
		return newUser.getURL();
	}
}
