import com.rabitdash.rabyte.*;
import com.rabitdash.rabyte.Accounts.Account;
import com.rabitdash.rabyte.Accounts.Loanable;
import com.rabitdash.rabyte.Exception.ATMException;
import com.rabitdash.rabyte.Util.ACCOUNT_TYPE;
import com.rabitdash.rabyte.Util.Constants;
import com.rabitdash.rabyte.Accounts.CreditAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ATMClient {
    private static Bank bank;
    private Account curAccount;//当前操作的账户
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
    private JTextField nameTextField;
    private JPasswordField passwordField;
    private JPasswordField passwordField2;
    private JFormattedTextField personIdFormattedTextField;
    private JTextArea locationTextArea;
    private JFormattedTextField emailFormattedTextField2;
    private JButton commitButton;
    private JButton returnButton;
    private JPanel MainPanel;
    private JPanel RegisterPanel;
    private JPanel LoginPanel;
    private JPanel BusinessPanel;
    private JTextField loginIdTextField;
    private JPasswordField loginPasswordPasswordField;
    private JButton confirmButton;
    private JButton cancelButton;
    private JLabel accountIdLabel;
    private JLabel passwordLabel;
    private JComboBox comboBox2;
    private JTextField textField3;
    private JButton businessCommitButton;
    private JButton businessReturnButton;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel balanceLabel;
    private JLabel ceilingLabel;
    private JLabel loanLabel;
    private JLabel ceilingHeadLabel;
    private JLabel loanHeadLabel;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    public ATMClient() {
        bank = Bank.getInstance();
        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                MainPanel.setVisible(false);
                RegisterPanel.setVisible(true);
            }
        });
        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                RegisterPanel.setVisible(false);
                MainPanel.setVisible(true);
            }
        });
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                MainPanel.setVisible(false);
                LoginPanel.setVisible(true);
            }
        });
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                LoginPanel.setVisible(false);
                MainPanel.setVisible(true);
            }
        });
        commitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ACCOUNT_TYPE accountType = null;
                accountType = ACCOUNT_TYPE.values()[comboBox1.getSelectedIndex()];
                System.out.println(accountType);
                String name = nameTextField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String personId = personIdFormattedTextField.getText();
                String email = emailFormattedTextField2.getText();
                System.out.println(accountType + name + password + personId + email);
                try {
                    curAccount = bank.register(password, name, personId, email, accountType);
                    System.out.println(curAccount);
                } catch (ATMException exception) {
                    exception.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "注册成功,你的账号ID是：\n"
                        + curAccount.getId());
            }
        });
        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    curAccount = bank.login(Long.valueOf(loginIdTextField.getText()), String.valueOf(loginPasswordPasswordField.getPassword()));
                    LoginPanel.setVisible(false);
                    BusinessPanel.setVisible(true);
                } catch (ATMException exception) {
                    exception.printStackTrace();
                }
            }
        });
        BusinessPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                //更新显示
                idLabel.setText(String.valueOf(curAccount.getId()));
                nameLabel.setText(curAccount.getName());
                balanceLabel.setText(String.valueOf(curAccount.getBalance()));
//                if (curAccount.getType() == ACCOUNT_TYPE.CreditAccount || curAccount.getType() == ACCOUNT_TYPE.LoanCreditAccount) {
                if (curAccount instanceof CreditAccount) {
                    ceilingLabel.setVisible(true);
                    ceilingHeadLabel.setVisible(true);
                    ceilingLabel.setText(String.valueOf(((CreditAccount) curAccount).getCeiling()));
                } else {
                    ceilingHeadLabel.setVisible(false);
                    ceilingLabel.setVisible(false);
                }
                if (curAccount instanceof Loanable) {
                    loanLabel.setVisible(true);
                    loanHeadLabel.setVisible(true);
                    loanLabel.setText(String.valueOf(((Loanable) curAccount).getLoan()));
                } else {
                    loanLabel.setVisible(false);
                    loanHeadLabel.setVisible(false);
                }
//
//                idLabel.setText(String.valueOf(curAccount.getId()));
//                nameLabel.setText(curAccount.getName());
//                balanceLabel.setText(String.valueOf(curAccount.getBalance()));
//                if (curAccount.getType() == ACCOUNT_TYPE.CreditAccount || curAccount.getType() == ACCOUNT_TYPE.LoanCreditAccount) {
//                    ceilingLabel.setText(String.valueOf(((CreditAccount) curAccount).getCeiling()));
//                }
//                if (curAccount.getType() == ACCOUNT_TYPE.LoanCreditAccount || curAccount.getType() == ACCOUNT_TYPE.LoanSavingAccount) {
//                    loanLabel.setText(String.valueOf(((Loanable) curAccount).getLoan()));
//                }

            }
        });
        businessCommitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double num = Double.valueOf(textField3.getText());
//                System.out.println(curAccount.getType());
                try {
                    switch (comboBox2.getSelectedIndex()) {
                        case 0:
                            bank.deposit(curAccount.getId(), num);
                            break;
                        case 1:
                            bank.withdraw(curAccount.getId(), num);
                            break;
                        case 2:
                            if (!(curAccount instanceof Loanable)) {
                                JOptionPane.showMessageDialog(null,
                                        Constants.ERROR
                                                + Constants.NOT + Constants.LOAN + Constants.ACCOUNT);
                            } else {
                                bank.requestLoan(curAccount.getId(), num);
                            }
                            break;
                        case 3:
                            if (!(curAccount instanceof Loanable)) {
                                JOptionPane.showMessageDialog(null,
                                        Constants.ERROR
                                                + Constants.NOT + Constants.LOAN + Constants.ACCOUNT);
                            } else {
                                bank.payLoan(curAccount.getId(), num);
                            }
                            break;
                        case 4:
                            long transferId = Long.valueOf(JOptionPane.showInputDialog(null, "转账给："));
                            bank.transfer(curAccount.getId(), transferId, num);
                            break;

                    }
                } catch (ATMException exception) {
                    exception.printStackTrace();
                }

                //更新显示
                idLabel.setText(String.valueOf(curAccount.getId()));
                nameLabel.setText(curAccount.getName());
                balanceLabel.setText(String.valueOf(curAccount.getBalance()));
                if (curAccount instanceof CreditAccount) {
                    ceilingLabel.setVisible(true);
                    ceilingHeadLabel.setVisible(true);
                    ceilingLabel.setText(String.valueOf(((CreditAccount) curAccount).getCeiling()));
                } else {
                    ceilingHeadLabel.setVisible(false);
                    ceilingLabel.setVisible(false);
                }
                if (curAccount instanceof Loanable) {
                    loanLabel.setVisible(true);
                    loanHeadLabel.setVisible(true);
                    loanLabel.setText(String.valueOf(((Loanable) curAccount).getLoan()));
                } else {
                    loanLabel.setVisible(false);
                    loanHeadLabel.setVisible(false);
                }

            }
        });
        businessReturnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BusinessPanel.setVisible(false);
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
        passwordField = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RegisterPanel.add(passwordField, gbc);
        passwordField2 = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RegisterPanel.add(passwordField2, gbc);
        personIdFormattedTextField = new JFormattedTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RegisterPanel.add(personIdFormattedTextField, gbc);
        locationTextArea = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.BOTH;
        RegisterPanel.add(locationTextArea, gbc);
        emailFormattedTextField2 = new JFormattedTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RegisterPanel.add(emailFormattedTextField2, gbc);
        commitButton = new JButton();
        commitButton.setText("提交");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RegisterPanel.add(commitButton, gbc);
        nameTextField = new JTextField();
        nameTextField.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RegisterPanel.add(nameTextField, gbc);
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
        loginIdTextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        LoginPanel.add(loginIdTextField, gbc);
        loginPasswordPasswordField = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        LoginPanel.add(loginPasswordPasswordField, gbc);
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
        BusinessPanel = new JPanel();
        BusinessPanel.setLayout(new GridBagLayout());
        panel1.add(BusinessPanel, "Card4");
        BusinessPanel.setBorder(BorderFactory.createTitledBorder("BusinessPanel"));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}