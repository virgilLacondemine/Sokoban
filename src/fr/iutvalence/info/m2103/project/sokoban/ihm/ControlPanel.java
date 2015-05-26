package fr.iutvalence.info.m2103.project.sokoban.ihm;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel
{
	public ControlPanel(ActionListener buttonAudit)
	{
		this.setLayout(new GridLayout(2,2));
		JButton up = new JButton("UP");
		up.addActionListener(buttonAudit);
		JButton down = new JButton("DOWN");
		down.addActionListener(buttonAudit);
		JButton left = new JButton("LEFT");
		left.addActionListener(buttonAudit);
		JButton right = new JButton("RIGHT");
		right.addActionListener(buttonAudit);
		this.add(up);
		this.add(down);
		this.add(left);
		this.add(right);
	}
}
