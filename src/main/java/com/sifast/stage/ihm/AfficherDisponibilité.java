package com.sifast.stage.ihm;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import com.sifast.stage.ihm.Disponibilite;

public class AfficherDisponibilit� extends DefaultCellEditor {

	private static final long serialVersionUID = 1L;

	protected JButton button;
	private String label;
	private boolean isPushed;

	public AfficherDisponibilit�(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();

			}
		});
	}

	public Component getTableCellEditorComponent(JTable table1, Object value, boolean isSelected, int row, int column) {
		if (isSelected) {
			button.setForeground(table1.getSelectionForeground());
			button.setBackground(table1.getSelectionBackground());

		} else {
			button.setForeground(table1.getForeground());
			button.setBackground(table1.getBackground());
		}
		label = (value == null) ? "afficher disponibilit�" : value.toString();
		button.setText(label);
		isPushed = true;
		return button;
	}

	public Object getCellEditorValue() {

		if (isPushed) {
			Disponibilite frame = new Disponibilite();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			
		
		}
		isPushed = false;
		return new String(label);
	}

	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}
}
