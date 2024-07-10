import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

public class Calculator {
    public static void main(String[] args) {
        new Cal();
    }
}

class Cal implements ActionListener {
    TextField tf;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10,
            b11, b12, b13, b14, b15, b16, b17, b18, b19, b20;

    String fv, sv, op;
    Double fdv, sdv, tot, sqrtv;

    Cal() {
        Frame f = new Frame();
        f.addWindowListener(new close());
        f.setBackground(Color.black);
        f.setTitle("Calculator");
        f.setResizable(false);
        f.setSize(400, 400);

        // set location center
        f.setLocationRelativeTo(null);

        // fonts
        Font f1 = new Font("Poppins", Font.BOLD, 30);
        Font f3 = new Font("Quicksand", Font.BOLD, 40);

        // menu bar
        MenuBar mb = new MenuBar();

        Menu m1 = new Menu("View");
        MenuItem mi = new MenuItem("Standard");
        m1.add(mi);

        Menu m2 = new Menu("Edit");
        MenuItem mi2 = new MenuItem("Copy");
        m2.add(mi2);

        Menu m3 = new Menu("Help");
        MenuItem mi3 = new MenuItem("About");
        m3.add(mi3);

        mb.add(m1);
        mb.add(m2);
        mb.add(m3);

        f.setMenuBar(mb);

        // panel
        Panel p1 = new Panel();
        Panel p2 = new Panel();

        // create grid layout
        GridLayout gl = new GridLayout(6, 4, 4, 4);

        // add grid layout
        p2.setLayout(gl);
        p2.setBackground(Color.black);

        // add text field
        tf = new TextField(15);
        tf.setFont(f3);
        tf.setEditable(true);
        tf.setForeground(Color.white);
        tf.setBackground(Color.black);
        tf.disable();

        // default value
        tf.setText("0");

        // add text field to panel
        p1.add(tf);

        // assign buttons
        b1 = new Button("AC");
        b2 = new Button("+/-");
        b3 = new Button("%");
        b4 = new Button("/");
        b5 = new Button("7");
        b6 = new Button("8");
        b7 = new Button("9");
        b8 = new Button("*");
        b9 = new Button("4");
        b10 = new Button("5");

        b11 = new Button("6");
        b12 = new Button("-");
        b13 = new Button("1");
        b14 = new Button("2");
        b15 = new Button("3");
        b16 = new Button("+");
        b17 = new Button("0");
        b18 = new Button(".");
        b19 = new Button("=");
        b20 = new Button("SQRT");

        // set bg colors to buttons
        b1.setBackground(Color.gray);
        b2.setBackground(Color.gray);
        b3.setBackground(Color.gray);
        b4.setBackground(Color.orange);
        b5.setBackground(Color.white);
        b6.setBackground(Color.white);
        b7.setBackground(Color.white);
        b8.setBackground(Color.orange);
        b9.setBackground(Color.white);
        b10.setBackground(Color.white);
        b11.setBackground(Color.white);
        b12.setBackground(Color.orange);
        b13.setBackground(Color.white);
        b14.setBackground(Color.white);
        b15.setBackground(Color.white);
        b16.setBackground(Color.orange);
        b17.setBackground(Color.white);
        b18.setBackground(Color.white);
        b19.setBackground(Color.orange);
        b20.setBackground(Color.orange);

        b1.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f1);
        b4.setFont(f1);
        b5.setFont(f1);
        b6.setFont(f1);
        b7.setFont(f1);
        b8.setFont(f1);
        b9.setFont(f1);
        b10.setFont(f1);
        b11.setFont(f1);
        b12.setFont(f1);
        b13.setFont(f1);
        b14.setFont(f1);
        b15.setFont(f1);
        b16.setFont(f1);
        b17.setFont(f1);
        b18.setFont(f1);
        b20.setFont(f1);
        b19.setFont(f1);

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(b7);
        p2.add(b8);
        p2.add(b9);
        p2.add(b10);
        p2.add(b11);
        p2.add(b12);
        p2.add(b13);
        p2.add(b14);
        p2.add(b15);
        p2.add(b16);
        p2.add(b17);
        p2.add(b18);
        p2.add(b20);
        p2.add(b19);

        // button actions
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        b17.addActionListener(this);
        b18.addActionListener(this);
        b19.addActionListener(this);
        b20.addActionListener(this);

        mi2.addActionListener(this);

        // add panels to frame
        f.add(p1, BorderLayout.NORTH);
        f.add(p2, BorderLayout.SOUTH);

        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        Object o = e.getSource();

        // copy
        if (o instanceof MenuItem && ((MenuItem) o).getLabel().equals("Copy")) {
            String s = tf.getText();
            StringSelection selection = new StringSelection(s);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            clipboard.setContents(selection, null);
        }

        if (tf.getText().equals("0") || (tf.getText().equals("+") || tf.getText().equals("-")
                || tf.getText().equals("/") || tf.getText().equals("*")) || tf.getText().equals("")) {
            tf.setText("");

            if (o.equals(b13)) {
                // 1
                tf.setText(tf.getText() + b13.getLabel());
            } else if (o.equals(b14)) {
                // 2
                tf.setText(tf.getText() + b14.getLabel());
            } else if (o.equals(b15)) {
                // 3
                tf.setText(tf.getText() + b15.getLabel());
            } else if (o.equals(b9)) {
                // 4
                tf.setText(tf.getText() + b9.getLabel());
            } else if (o.equals(b10)) {
                // 5
                tf.setText(tf.getText() + b10.getLabel());
            } else if (o.equals(b11)) {
                // 6
                tf.setText(tf.getText() + b11.getLabel());
            } else if (o.equals(b5)) {
                // 7
                tf.setText(tf.getText() + b5.getLabel());
            } else if (o.equals(b6)) {
                // 8
                tf.setText(tf.getText() + b6.getLabel());
            } else if (o.equals(b7)) {
                // 9
                tf.setText(b7.getLabel() + tf.getText());
            } else if (o.equals(b1)) {
                // AC
                tf.setText("0");
            }

            else if (o.equals(b16)) {
                // +
                fv = tf.getText();
                op = b16.getLabel();
                tf.setText("");
            } else if (o.equals(b12)) {
                // -
                fv = tf.getText();
                op = b12.getLabel();
                tf.setText("");
            } else if (o.equals(b19)) {
                // =
                sv = tf.getText();
            }

        } else {

            if (o.equals(b13)) {
                // 1
                tf.setText(tf.getText() + b13.getLabel());
            } else if (o.equals(b14)) {
                // 2
                tf.setText(tf.getText() + b14.getLabel());
            } else if (o.equals(b15)) {
                // 3
                tf.setText(tf.getText() + b15.getLabel());
            } else if (o.equals(b9)) {
                // 4
                tf.setText(tf.getText() + b9.getLabel());
            } else if (o.equals(b10)) {
                // 5
                tf.setText(tf.getText() + b10.getLabel());
            } else if (o.equals(b11)) {
                // 6
                tf.setText(tf.getText() + b11.getLabel());
            } else if (o.equals(b5)) {
                // 7
                tf.setText(tf.getText() + b5.getLabel());
            } else if (o.equals(b6)) {
                // 8
                tf.setText(tf.getText() + b6.getLabel());
            } else if (o.equals(b7)) {
                // 9
                tf.setText(b7.getLabel() + tf.getText());
            } else if (o.equals(b1)) {
                // AC
                tf.setText("0");
                sv = "0";
                fv = "0";
                op = "";
            } else if (o.equals(b18)) {
                tf.setText(tf.getText() + b18.getLabel());
            } else if (o.equals(b17)) {
                tf.setText(tf.getText() + b17.getLabel());
            } else if (o.equals(b2)) {
                if (tf.getText().charAt(0) != '-') {
                    tf.setText('-' + tf.getText());
                } else {
                    tf.setText(tf.getText().substring(1));
                }
            }

            else if (o.equals(b16)) {
                // +
                fv = tf.getText();
                op = b16.getLabel();
                tf.setText("");
            } else if (o.equals(b12)) {
                // -
                fv = tf.getText();
                op = b12.getLabel();
                tf.setText("");
            } else if (o.equals(b8)) {
                // *
                fv = tf.getText();
                op = b8.getLabel();
                tf.setText("");
            } else if (o.equals(b4)) {
                // /
                fv = tf.getText();
                op = b4.getLabel();
                tf.setText("");
            } else if (o.equals(b3)) {
                // %
                fv = tf.getText();
                op = b3.getLabel();
                tf.setText("");
            } else if (o.equals(b20)) {
                // sqrt
                fv = tf.getText();
                op = b3.getLabel();
                fdv = Double.parseDouble(fv);
                sqrtv = Math.sqrt(fdv);
                tf.setText(String.valueOf(sqrtv));
            }

            else if (o.equals(b19)) {
                // =
                sv = tf.getText();

                // calculate
                if (!op.equals("") && !fv.equals("") && !sv.equals("")) {
                    // convert str to double
                    fdv = Double.parseDouble(fv);
                    sdv = Double.parseDouble(sv);

                    tf.setText("");

                    if (op.equals("+")) {
                        tot = fdv + sdv;
                        tf.setText(tot + "");
                    } else if (op.equals("-")) {
                        tot = fdv - sdv;
                        tf.setText(tot + "");
                    } else if (op.equals("*")) {
                        tot = fdv * sdv;
                        tf.setText(tot + "");
                    } else if (op.equals("/")) {
                        tot = fdv / sdv;
                        tf.setText(tot + "");
                    } else if (op.equals("%")) {
                        tot = fdv % sdv;
                        tf.setText(tot + "");
                    } else {
                        tf.setText("0");
                    }
                } else {
                    tf.setText("0");
                }
            }
        }
    }

}

class close extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
