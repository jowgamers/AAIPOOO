package sisCarnes;

import javax.swing.SwingUtilities;

import view.Splash;
import view.TelaLogin;

public class Main {
	public static void main(String args[]) throws Exception {
		Splash s = new Splash();
		s.setVisible(true);
		Thread t = Thread.currentThread();
		t.sleep(10000);
		s.dispose();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				TelaLogin telaLog = new TelaLogin();
				telaLog.setVisible(true);
			}
		});
	}

}