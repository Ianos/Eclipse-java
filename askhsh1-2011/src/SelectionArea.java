import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * The Class SelectionArea.
 */
public class SelectionArea  extends JPanel implements ActionListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The combo. */
	private JComboBox combo;

	/** The text. */
	private JTextArea text;

	/** The canvas. */
	private Canvas canvas;


	/**
	 * Instantiates a new selection area.
	 *

	@param canvas the canvas
	 */
	public SelectionArea(Canvas canvas) {
		setPreferredSize(new Dimension(800,150));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.canvas = canvas;

		String [] options = {"Κύκλος", "Ευθεία"};
		combo = new JComboBox(options);
		add(combo);
		combo.addActionListener(this);

		text = new JTextArea(5,40);
		JScrollPane scrollPane = new JScrollPane(text); 
		add(scrollPane);
	}
	
	/**
	 * Gets the text area.
	 *

	@return the text area
	 */
	public String getTextArea() {
		return text.getText();
	}

	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		JComboBox combo = (JComboBox)ev.getSource();
		if (combo.getSelectedItem().equals("Κύκλος"))
			canvas.setCircle(true);
		else
			canvas.setCircle(false);
		repaint();
	}
	
}
