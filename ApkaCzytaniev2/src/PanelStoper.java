
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelStoper extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static JButton start;
	static JButton stop;
	static JButton reset;
	static JLabel display;
	
	JTextField minuty;
	JTextField sekundy;
	
	static Timer timer;
	
	public PanelStoper() { // trzeba wywołać konstruktor
		start = new JButton ("START");
		start.setBounds(3, 13, 77, 25);
		
		start.addActionListener((ActionListener) new StartListener() );
		
		stop = new JButton("STOP");
		stop.setBounds(85, 13, 71, 25);
		stop.addActionListener((ActionListener) new StopListener());
		
	
		reset = new JButton ("RESET");
		reset.setBounds(161, 13, 76, 25);
		reset.addActionListener((ActionListener) new ResetListener());
		
		
		display = new JLabel();
		display.setBounds(37, 139, 200, 42);
		display.setText("00:00");
		
		Font font = new Font("Jokerman", Font.PLAIN, 35);
		display.setFont(font);
		
		minuty = new JTextField("00");
		minuty.setBounds(36, 67, 48, 19);
		minuty.requestFocus();
	
		
		
		
		sekundy = new JTextField("00");
		sekundy.setBounds(112, 67, 48, 19);
		setLayout(null);
		
		
		
		add(start);
		add(stop);
		add(reset);
		add(display);
		add(minuty);
		add(sekundy);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setBounds(39, 50, 37, 15);
		add(lblMin);
		
		JLabel lblSec = new JLabel("sec");
		lblSec.setBounds(122, 50, 70, 15);
		add(lblSec);
		
	}
	
	class StartListener implements ActionListener {
		public void actionPerformed (ActionEvent zd) {
			timer = new Timer();	
			timer.scheduleAtFixedRate(new TimerTask() {
			int	secs = Integer.parseInt(sekundy.getText());
			int	mins = Integer.parseInt(minuty.getText());
				
				@Override
				public void run() {
										
					display.setText(mins + ":" + (secs--));
					
					
					if (mins >= 01 && secs <= 00) {
						mins --;
						secs = 59;
					}
					
					if (mins == 00 && secs < 00) {
						timer.cancel();
						display.setText("Koniec");
						
						;
					}
					
					
				}
			}, 0, 1000);
		}
	}
		
	class StopListener implements ActionListener {
		public void actionPerformed (ActionEvent zd) {
			timer.cancel();
			display.setText("Stop");
			sekundy.setText("20");
			minuty.setText("20");
			
			
		}
	}
	
	class ResetListener implements ActionListener {
		public void actionPerformed (ActionEvent click) {
			timer.cancel();
			display.setText("Reset");
			minuty.setText("00");
			sekundy.setText("00");
		}
	}
	}
	
	
	




