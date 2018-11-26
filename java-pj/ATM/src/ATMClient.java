import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ATMClient {
    private JFrame frame;
    private JPanel panel1;
    private JButton registerButton;
    private JButton loginButton;
    private JLabel titleLabel;
    private JLabel accountType;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JFormattedTextField formattedTextField1;
    private JTextArea textArea1;
    private JFormattedTextField formattedTextField2;
    private JButton commitButton;
    private JButton returnButton;
    private JPanel MainPanel;
    private JPanel RegisterPanel;
    private JPanel LoginPanel;
    private JPanel businessPanel;
    private JTextField textField2;
    private JPasswordField passwordField3;
    private JButton confirmButton;
    private JButton cancelButton;
    private JLabel accountIdLabel;
    private JLabel passwordLabel;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    public ATMClient() {
        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                MainPanel.setVisible(false);
                RegisterPanel.setVisible(true);

            }
        });
        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                RegisterPanel.setVisible(false);
                MainPanel.setVisible(true);
            }
        });
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                MainPanel.setVisible(false);
                LoginPanel.setVisible(true);
            }
        });
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                LoginPanel.setVisible(false);
                MainPanel.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ATMClient");
        frame.setContentPane(new ATMClient().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new CardLayout(0, 0));
        panel1.setEnabled(false);
        panel1.setBorder(BorderFactory.createTitledBorder("Jpanel"));
        MainPanel = new JPanel();
        MainPanel.setLayout(new GridBagLayout());
        panel1.add(MainPanel, "Card1");
        MainPanel.setBorder(BorderFactory.createTitledBorder("MainPanel"));
        titleLabel = new JLabel();
        titleLabel.setText("模拟ICBC ATM终端");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        MainPanel.add(titleLabel, gbc);
        loginButton = new JButton();
        loginButton.setText("登录");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        MainPanel.add(loginButton, gbc);
        registerButton = new JButton();
        registerButton.setText("注册");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        MainPanel.add(registerButton, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        MainPanel.add(spacer1, gbc);
        RegisterPanel = new JPanel();
        RegisterPanel.setLayout(new GridBagLayout());
        panel1.add(RegisterPanel, "Card2");
        RegisterPanel.setBorder(BorderFactory.createTitledBorder("RegisterPanel"));
        accountType = new JLabel();
        accountType.setText("账户类型");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        RegisterPanel.add(accountType, gbc);
        label1 = new JLabel();
        label1.setText("用户名");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        RegisterPanel.add(label1, gbc);
        label2 = new JLabel();
        label2.setText("密码");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        RegisterPanel.add(label2, gbc);
        label3 = new JLabel();
        label3.setText("确认密码");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        RegisterPanel.add(label3, gbc);
        label4 = new JLabel();
        label4.setText("身份证号");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        RegisterPanel.add(label4, gbc);
        label5 = new JLabel();
        label5.setText("详细地址");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        RegisterPanel.add(label5, gbc);
        label6 = new JLabel();
        label6.setText("E-Mail");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        RegisterPanel.add(label6, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 250;
        RegisterPanel.add(spacer2, gbc);
        comboBox1 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        comboBox1.setModel(defaultComboBoxModel1);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RegisterPanel.add(comboBox1, gbc);
        passwordField1 = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RegisterPanel.add(passwordField1, gbc);
        passwordField2 = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RegisterPanel.add(passwordField2, gbc);
        formattedTextField1 = new JFormattedTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RegisterPanel.add(formattedTextField1, gbc);
        textArea1 = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.BOTH;
        RegisterPanel.add(textArea1, gbc);
        formattedTextField2 = new JFormattedTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RegisterPanel.add(formattedTextField2, gbc);
        commitButton = new JButton();
        commitButton.setText("提交");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RegisterPanel.add(commitButton, gbc);
        textField1 = new JTextField();
        textField1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RegisterPanel.add(textField1, gbc);
        returnButton = new JButton();
        returnButton.setText("返回");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RegisterPanel.add(returnButton, gbc);
        LoginPanel = new JPanel();
        LoginPanel.setLayout(new GridBagLayout());
        panel1.add(LoginPanel, "Card3");
        LoginPanel.setBorder(BorderFactory.createTitledBorder("LoginPanel"));
        accountIdLabel = new JLabel();
        accountIdLabel.setText("用户帐号");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        LoginPanel.add(accountIdLabel, gbc);
        passwordLabel = new JLabel();
        passwordLabel.setText("用户密码");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        LoginPanel.add(passwordLabel, gbc);
        textField2 = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        LoginPanel.add(textField2, gbc);
        passwordField3 = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        LoginPanel.add(passwordField3, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        LoginPanel.add(spacer3, gbc);
        confirmButton = new JButton();
        confirmButton.setText("确认");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        LoginPanel.add(confirmButton, gbc);
        cancelButton = new JButton();
        cancelButton.setText("返回");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        LoginPanel.add(cancelButton, gbc);
        businessPanel = new JPanel();
        businessPanel.setLayout(new GridBagLayout());
        panel1.add(businessPanel, "Card4");
        businessPanel.setBorder(BorderFactory.createTitledBorder("BusinessPanel"));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
