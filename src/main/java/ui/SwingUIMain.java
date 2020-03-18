package ui;

import exceptions.StringIsNotJsonException;
import json_utils.WikiArticleExporter;
import json_utils.WikiArticleParser;
import wikipedia.WikiArticleEdits;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingUIMain extends JFrame implements ActionListener {

    JLabel displayLabel;
    JLabel revisions;
    JLabel revisions2;
    JTextField searchText;

    public SwingUIMain() {
        super("Wikipedia Revision Manager");
        JPanel panel = new JPanel();
        GridBagLayout gridBag = new GridBagLayout();
        panel.setLayout(gridBag);
        setContentPane(panel);

        displayLabel = new JLabel("Welcome to the Wikipedia Revision Viewer!\r Type in a word to look for an article.");
        var displayLabelConstraints = new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 20, 20), 0, 0);
        panel.add(displayLabel, displayLabelConstraints);

        revisions = new JLabel("--REVISIONS--");
        var revisionConstraints = new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 20, 20), 0, 0);
        panel.add(revisions,revisionConstraints);

        revisions2 = new JLabel("Pretend I have an organized table here.");
        var revision2Constraints = new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 20, 20), 0, 0);
        panel.add(revisions2,revision2Constraints);

        searchText = new JTextField(1);
        var searchConstraints = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 20, 20), 0, 0);
        panel.add(searchText,searchConstraints);

        JButton button = new JButton("Search");
        var buttonconstraints = new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        button.addActionListener(e -> {
            String word = searchText.getText();
            String json = WikiArticleParser.parseWikiArticleToJson(word);
            try {
                WikiArticleEdits w = WikiArticleExporter.exportArticleEditInfo(json);
                revisions.setText(w.toString());
            } catch (StringIsNotJsonException ex) {
                ex.printStackTrace();
            }
        });
        panel.add(button, buttonconstraints);


        setPreferredSize(new Dimension(1000, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingUIMain();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("EXECUTING SEARCH");
    }

}
