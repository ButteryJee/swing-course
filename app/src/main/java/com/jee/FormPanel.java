package com.jee;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton btnOk;
    private FormListener formListener;
    private JList<AgeCategory> ageList;
    private JComboBox<String> empCombo;
    private JCheckBox citizenCheck;
    private JTextField taxField;
    private JLabel taxLabel;


    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outBorder, innerBorder));

        nameLabel = new JLabel("Name:");
        occupationLabel = new JLabel("Occupation:");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String name = nameField.getText();
                String occupation = occupationField.getText();
                AgeCategory ageCat = ageList.getSelectedValue();
                String empCat = (String)empCombo.getSelectedItem();
                FormEvent event = new FormEvent(this, name, occupation, ageCat.getId(),
                                                empCat, citizenCheck.isSelected(), 
                                                taxField.getText());
                formListener.formEventOccurred(event);
            }
        });
        ageList = new JList<AgeCategory>();
        ageList.setPreferredSize(new Dimension(114, 66));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        DefaultListModel<AgeCategory> ageModel = new DefaultListModel<>();
        ageModel.addElement(new AgeCategory(0, "Under 18"));
        ageModel.addElement(new AgeCategory(1, "18 to 65"));
        ageModel.addElement(new AgeCategory(2, "Over 65"));
        ageList.setModel(ageModel);
        ageList.setSelectedIndex(0);
        empCombo = new JComboBox<>();
        DefaultComboBoxModel<String> empModel = new DefaultComboBoxModel();
        empModel.addElement("employed");
        empModel.addElement("self-employed");
        empModel.addElement("unemployed");
        empCombo.setModel(empModel);
        empCombo.setEditable(false);
        citizenCheck = new JCheckBox();
        taxField = new JTextField(10);
        taxLabel = new JLabel("Tax ID: ");

        // Set up tax ID
        taxLabel.setEnabled(false);
        taxField.setEnabled(false);
        citizenCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boolean isTicked = citizenCheck.isSelected();
                taxField.setEnabled(isTicked);
                taxLabel.setEnabled(isTicked);
            }
        });

        layoutComponents();
    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
 
        // Name Row
        gc.weightx = 0.1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(nameField, gc);

        // Occupation Row
        gc.gridy++;
        gc.weightx = 0.1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(occupationLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(occupationField, gc);

        // Age Row
        gc.gridy++;
        gc.weightx = 0.1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Age:"), gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(ageList, gc);

        // Employment Row
        gc.gridy++;
        gc.weightx = 0.1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(4, 0, 0, 5);
        add(new JLabel("Employment:"), gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(empCombo, gc);
        
        // Citizen Check Row
        gc.gridy++;
        gc.weightx = 0.1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Citizen:"), gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(citizenCheck, gc);

        // Tax Row
        gc.gridy++;
        gc.weightx = 0.1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(taxLabel, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(taxField, gc);        

        // OK Button Row
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 2;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(btnOk, gc);

    }
}

class AgeCategory {

    private int id;
    private String text;

    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String toString() {
        return text;
    }

    public int getId() {
        return id;
    }
}