package dj.hegi.finished;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * @author Stefan, https://st-page.de
 * 
 */
public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private File mupath;
	private File txtpath;

	public GUI() {
		setSize(new Dimension(1300, 800));
		setPreferredSize(new Dimension(300, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PLSorter");
		getContentPane().setBackground(Color.white);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		JLabel lblDraganddrop = new JLabel("m3u8 hier droppen");
		springLayout.putConstraint(SpringLayout.NORTH, lblDraganddrop, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblDraganddrop, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblDraganddrop, -100, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblDraganddrop, 625, SpringLayout.WEST, lblDraganddrop);
		lblDraganddrop.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDraganddrop.setHorizontalAlignment(SwingConstants.CENTER);
		lblDraganddrop.setBorder(new LineBorder(new Color(170, 170, 170)));
		lblDraganddrop.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDraganddrop.setVerticalAlignment(SwingConstants.CENTER);
		lblDraganddrop.setVerticalTextPosition(SwingConstants.CENTER);
		lblDraganddrop.setFont(new Font("Sagoe", Font.PLAIN, 48));
		lblDraganddrop.setForeground(Color.lightGray);
		getContentPane().add(lblDraganddrop);

		JLabel txt = new JLabel("txt hier droppen");
		springLayout.putConstraint(SpringLayout.NORTH, txt, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txt, 10, SpringLayout.EAST, lblDraganddrop);
		springLayout.putConstraint(SpringLayout.SOUTH, txt, -100, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txt, -10, SpringLayout.EAST, getContentPane());
		txt.setHorizontalTextPosition(SwingConstants.CENTER);
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setBorder(new LineBorder(new Color(170, 170, 170)));
		txt.setAlignmentX(Component.CENTER_ALIGNMENT);
		txt.setVerticalAlignment(SwingConstants.CENTER);
		txt.setVerticalTextPosition(SwingConstants.CENTER);
		txt.setFont(new Font("Tahoma", Font.PLAIN, 48));
		txt.setForeground(Color.lightGray);
		getContentPane().add(txt);

		JTextArea txtarea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtarea, 10, SpringLayout.SOUTH, txt);
		springLayout.putConstraint(SpringLayout.WEST, txtarea, 460, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtarea, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtarea, -10, SpringLayout.EAST, getContentPane());
		txtarea.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtarea.setFont(new Font("Sagoe", Font.PLAIN, 20));

		getContentPane().add(txtarea);

		JButton sort = new JButton("Sortieren");
		springLayout.putConstraint(SpringLayout.NORTH, sort, 10, SpringLayout.SOUTH, lblDraganddrop);
		springLayout.putConstraint(SpringLayout.WEST, sort, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, sort, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, sort, 450, SpringLayout.WEST, getContentPane());
		sort.setFont(new Font("Tahoma", Font.PLAIN, 30));
		sort.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (mupath != null && txtpath != null) {
					PLSorter playlist = new PLSorter(mupath, txtpath);
					playlist.execute();
					if (playlist.getWrong() == true) {
						txtarea.setText(
								"Fehler: Die Dateien scheinen nicht zusammenzupassen,\n           oder haben ein falsches Format.\nErneut versuchen.");
						mupath = null;
						txtpath = null;
					} else {
						mupath = null;
						txtpath = null;
						txtarea.setText("Sortiert.\nWeitere Dateien können gedropt werden.");
					}
				} else if (mupath == null && txtpath != null) {
					txtarea.setText("Fehler: Keine m3u8-Datei gedropt.");
				} else if (txtpath == null && mupath != null) {
					txtarea.setText("Fehler: Keine txt-Datei gedropt.");
				} else {
					txtarea.setText("Fehler: Keine Dateien gedropt.");
				}
			}
		});
		getContentPane().add(sort);

		setVisible(true);

		new DropTarget(lblDraganddrop, new DropTargetListener() {
			@Override
			public void drop(DropTargetDropEvent dtde) {
				try {
					Transferable tr = dtde.getTransferable();
					DataFlavor[] flavors = tr.getTransferDataFlavors();

					for (int i = 0; i < flavors.length; i++) {
						if (flavors[i].isFlavorJavaFileListType()) {
							dtde.acceptDrop(dtde.getDropAction());
							@SuppressWarnings("unchecked")
							java.util.List<File> files = (java.util.List<File>) tr.getTransferData(flavors[i]);

							mupath = files.get(0);
							if (txtpath != null) {
								txtarea.setText("m3u8-Datei: " + mupath + "\n");
								txtarea.append("txt-Datei: " + txtpath + "\n");
							} else {
								txtarea.setText("m3u8-Datei: " + mupath + "\n");
							}

							if (mupath.toString().charAt(mupath.toString().length() - 1) == 't') {
								txtarea.setText("Fehler: txt-Datei im m3u8-Feld gedropt.\nErneut versuchen.");
								mupath = null;
							}

							dtde.dropComplete(true);
						}
					}
					return;
				} catch (Throwable t) {
					t.printStackTrace();
				}
				dtde.rejectDrop();

			}

			@Override
			public void dragEnter(DropTargetDragEvent dtde) {
			}

			@Override
			public void dragOver(DropTargetDragEvent dtde) {
			}

			@Override
			public void dropActionChanged(DropTargetDragEvent dtde) {
			}

			@Override
			public void dragExit(DropTargetEvent dte) {
			}

		});

		new DropTarget(txt, new DropTargetListener() {
			@Override
			public void drop(DropTargetDropEvent dtde) {
				try {
					Transferable tr = dtde.getTransferable();
					DataFlavor[] flavors = tr.getTransferDataFlavors();

					for (int i = 0; i < flavors.length; i++) {
						if (flavors[i].isFlavorJavaFileListType()) {
							dtde.acceptDrop(dtde.getDropAction());
							@SuppressWarnings("unchecked")
							java.util.List<File> files = (java.util.List<File>) tr.getTransferData(flavors[i]);

							txtpath = files.get(0);
							if (mupath != null) {
								txtarea.setText("m3u8-Datei: " + mupath + "\n");
								txtarea.append("txt-Datei: " + txtpath + "\n");
							} else {
								txtarea.setText("txt-Datei: " + txtpath + "\n");
							}

							if (txtpath.toString().charAt(txtpath.toString().length() - 1) == '8') {
								txtarea.setText("Fehler: m3u8-Datei im txt-Feld gedropt.\nErneut versuchen.");
								txtpath = null;
							}

							dtde.dropComplete(true);
						}
					}
					return;
				} catch (Throwable t) {
					t.printStackTrace();
				}
				dtde.rejectDrop();

			}

			@Override
			public void dragEnter(DropTargetDragEvent dtde) {
			}

			@Override
			public void dragOver(DropTargetDragEvent dtde) {
			}

			@Override
			public void dropActionChanged(DropTargetDragEvent dtde) {
			}

			@Override
			public void dragExit(DropTargetEvent dte) {
			}

		});

	}

	public static void main(String[] args) {
		new GUI();
	}
}
