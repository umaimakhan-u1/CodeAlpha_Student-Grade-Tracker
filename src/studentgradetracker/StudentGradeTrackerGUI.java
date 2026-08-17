package studentgradetracker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentGradeTrackerGUI extends JFrame {

    private JTextField nameField;
    private JTextField gradeField;

    private JTable studentTable;
    private DefaultTableModel tableModel;

    private JLabel averageLabel;
    private JLabel highestLabel;
    private JLabel lowestLabel;

    private ArrayList<Student> students;

    private final Color BACKGROUND = new Color(245, 247, 251);
    private final Color CARD_BACKGROUND = Color.WHITE;
    private final Color PRIMARY = new Color(79, 70, 229);
    private final Color TEXT_DARK = new Color(31, 41, 55);
    private final Color TEXT_GRAY = new Color(107, 114, 128);
    private final Color BORDER = new Color(229, 231, 235);
    private final Color SUCCESS = new Color(16, 185, 129);
    private final Color DANGER = new Color(239, 68, 68);
    private final Color SECONDARY = new Color(100, 116, 139);

    public StudentGradeTrackerGUI() {

        students = new ArrayList<>();

        setTitle("Student Grade Tracker");
        setSize(950, 680);
        setMinimumSize(new Dimension(850, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createGUI();
    }

    private void createGUI() {

        JPanel mainPanel = new JPanel(new BorderLayout(0, 20));
        mainPanel.setBorder(new EmptyBorder(25, 30, 25, 30));
        mainPanel.setBackground(BACKGROUND);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setOpaque(false);

        JLabel titleLabel = new JLabel("Student Grade Tracker");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        titleLabel.setForeground(TEXT_DARK);

        JLabel subtitleLabel = new JLabel(
                "Manage student grades and generate a summary report"
        );
        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitleLabel.setForeground(TEXT_GRAY);

        titlePanel.add(titleLabel);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(subtitleLabel);

        headerPanel.add(titlePanel, BorderLayout.WEST);

        JLabel trackerLabel = new JLabel("GRADE MANAGEMENT");
        trackerLabel.setFont(new Font("SansSerif", Font.BOLD, 11));
        trackerLabel.setForeground(PRIMARY);

        headerPanel.add(trackerLabel, BorderLayout.EAST);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout(0, 15));
        centerPanel.setOpaque(false);

        JPanel inputPanel = new RoundedPanel(18, CARD_BACKGROUND);
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBorder(new EmptyBorder(18, 20, 18, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 8, 5, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = new JLabel("Student Name");
        styleLabel(nameLabel);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        inputPanel.add(nameLabel, gbc);

        nameField = new JTextField(15);
        styleTextField(nameField);

        gbc.gridx = 1;
        gbc.weightx = 1;
        inputPanel.add(nameField, gbc);

        JLabel gradeLabel = new JLabel("Grade");
        styleLabel(gradeLabel);

        gbc.gridx = 2;
        gbc.weightx = 0;
        inputPanel.add(gradeLabel, gbc);

        gradeField = new JTextField(8);
        styleTextField(gradeField);

        gbc.gridx = 3;
        gbc.weightx = 0.5;
        inputPanel.add(gradeField, gbc);

        JButton addButton = createModernButton(
                "＋  Add Student",
                PRIMARY
        );

        gbc.gridx = 4;
        gbc.weightx = 0;
        inputPanel.add(addButton, gbc);

        centerPanel.add(inputPanel, BorderLayout.NORTH);

        JPanel tableCard = new RoundedPanel(18, CARD_BACKGROUND);
        tableCard.setLayout(new BorderLayout());

        JPanel tableHeaderPanel = new JPanel(new BorderLayout());
        tableHeaderPanel.setBackground(CARD_BACKGROUND);
        tableHeaderPanel.setBorder(
                new EmptyBorder(18, 20, 12, 20)
        );

        JLabel tableTitle = new JLabel("Student Records");
        tableTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        tableTitle.setForeground(TEXT_DARK);

        JLabel tableHint = new JLabel(
                "Select a row to manage a student"
        );
        tableHint.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tableHint.setForeground(TEXT_GRAY);

        tableHeaderPanel.add(tableTitle, BorderLayout.WEST);
        tableHeaderPanel.add(tableHint, BorderLayout.EAST);

        tableCard.add(tableHeaderPanel, BorderLayout.NORTH);

        String[] columns = {
            "Student Name",
            "Grade"
        };

        tableModel = new DefaultTableModel(columns, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        studentTable = new JTable(tableModel);

        studentTable.setRowHeight(38);
        studentTable.setFont(new Font("SansSerif", Font.PLAIN, 14));
        studentTable.setForeground(TEXT_DARK);
        studentTable.setBackground(Color.WHITE);

        studentTable.setSelectionBackground(
                new Color(224, 231, 255)
        );

        studentTable.setSelectionForeground(TEXT_DARK);
        studentTable.setShowVerticalLines(false);
        studentTable.setShowHorizontalLines(true);

        studentTable.setGridColor(
                new Color(241, 245, 249)
        );

        studentTable.setIntercellSpacing(
                new Dimension(0, 1)
        );

        studentTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        studentTable.getTableHeader().setFont(
                new Font("SansSerif", Font.BOLD, 14)
        );

        studentTable.getTableHeader().setForeground(Color.WHITE);

        studentTable.getTableHeader().setBackground(
                new Color(55, 65, 81)
        );

        studentTable.getTableHeader().setPreferredSize(
                new Dimension(0, 42)
        );

        studentTable.getTableHeader().setBorder(null);

        studentTable.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(600);

        studentTable.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(200);

        DefaultTableCellRenderer renderer =
                new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(
                    JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column
            ) {

                Component component =
                        super.getTableCellRendererComponent(
                                table,
                                value,
                                isSelected,
                                hasFocus,
                                row,
                                column
                        );

                setBorder(
                        new EmptyBorder(0, 15, 0, 15)
                );

                if (isSelected) {

                    component.setBackground(
                            new Color(224, 231, 255)
                    );

                    component.setForeground(TEXT_DARK);

                } else {

                    if (row % 2 == 0) {
                        component.setBackground(Color.WHITE);
                    } else {
                        component.setBackground(
                                new Color(248, 250, 252)
                        );
                    }

                    component.setForeground(TEXT_DARK);
                }

                return component;
            }
        };

        studentTable.setDefaultRenderer(
                Object.class,
                renderer
        );

        JScrollPane scrollPane =
                new JScrollPane(studentTable);

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder()
        );

        scrollPane.getViewport()
                .setBackground(Color.WHITE);

        tableCard.add(
                scrollPane,
                BorderLayout.CENTER
        );

        JPanel tableButtonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                12
                        )
                );

        tableButtonPanel.setBackground(CARD_BACKGROUND);

        JButton deleteButton =
                createModernButton(
                        "Delete Selected",
                        DANGER
                );

        JButton clearButton =
                createModernButton(
                        "Clear All",
                        SECONDARY
                );

        tableButtonPanel.add(deleteButton);
        tableButtonPanel.add(clearButton);

        tableCard.add(
                tableButtonPanel,
                BorderLayout.SOUTH
        );

        centerPanel.add(
                tableCard,
                BorderLayout.CENTER
        );

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        JPanel summaryPanel =
                new JPanel(
                        new GridLayout(1, 3, 15, 0)
                );

        summaryPanel.setOpaque(false);

        averageLabel =
                createSummaryLabel(
                        "Average",
                        "0.00",
                        PRIMARY
                );

        highestLabel =
                createSummaryLabel(
                        "Highest",
                        "0.00",
                        SUCCESS
                );

        lowestLabel =
                createSummaryLabel(
                        "Lowest",
                        "0.00",
                        DANGER
                );

        summaryPanel.add(averageLabel);
        summaryPanel.add(highestLabel);
        summaryPanel.add(lowestLabel);

        mainPanel.add(
                summaryPanel,
                BorderLayout.SOUTH
        );

        add(mainPanel);

        addButton.addActionListener(
                e -> addStudent()
        );

        deleteButton.addActionListener(
                e -> deleteStudent()
        );

        clearButton.addActionListener(
                e -> clearStudents()
        );

        gradeField.addActionListener(
                e -> addStudent()
        );
    }

    private void styleTextField(JTextField field) {

        field.setFont(
                new Font("SansSerif", Font.PLAIN, 14)
        );

        field.setForeground(TEXT_DARK);

        field.setBackground(
                new Color(249, 250, 251)
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(209, 213, 219)
                        ),
                        new EmptyBorder(
                                9, 12, 9, 12
                        )
                )
        );

        field.setPreferredSize(
                new Dimension(
                        field.getPreferredSize().width,
                        40
                )
        );
    }

    private void styleLabel(JLabel label) {

        label.setFont(
                new Font("SansSerif", Font.BOLD, 13)
        );

        label.setForeground(TEXT_DARK);
    }

    private JButton createModernButton(
            String text,
            Color backgroundColor
    ) {

        JButton button = new JButton(text) {

            @Override
            protected void paintComponent(Graphics g) {

                Graphics2D g2 =
                        (Graphics2D) g.create();

                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                Color color = getBackground();

                if (getModel().isPressed()) {
                    color = color.darker();
                } else if (getModel().isRollover()) {
                    color = color.brighter();
                }

                g2.setColor(color);

                g2.fillRoundRect(
                        0,
                        0,
                        getWidth(),
                        getHeight(),
                        12,
                        12
                );

                g2.dispose();

                super.paintComponent(g);
            }
        };

        button.setFont(
                new Font("SansSerif", Font.BOLD, 13)
        );

        button.setForeground(Color.WHITE);
        button.setBackground(backgroundColor);

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        button.setBorder(
                new EmptyBorder(
                        10, 18, 10, 18
                )
        );

        return button;
    }

    private JLabel createSummaryLabel(
            String title,
            String value,
            Color accentColor
    ) {

        JLabel label =
                new JLabel(
                        "<html>"
                        + "<div style='text-align:center;'>"
                        + "<span style='font-size:12px; color:#6B7280;'>"
                        + title
                        + "</span>"
                        + "<br>"
                        + "<span style='font-size:22px; color:#1F2937;'>"
                        + value
                        + "</span>"
                        + "</div>"
                        + "</html>",
                        SwingConstants.CENTER
                );

        label.setOpaque(true);
        label.setBackground(CARD_BACKGROUND);

        label.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(
                                0, 5, 0, 0,
                                accentColor
                        ),
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(
                                        BORDER
                                ),
                                new EmptyBorder(
                                        10, 10, 10, 10
                                )
                        )
                )
        );

        return label;
    }

    private void addStudent() {

        String name =
                nameField.getText().trim();

        String gradeText =
                gradeField.getText().trim();

        if (name.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter the student's name.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        if (gradeText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter the student's grade.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        double grade;

        try {

            grade = Double.parseDouble(gradeText);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Grade must be a valid number.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        if (grade < 0 || grade > 100) {

            JOptionPane.showMessageDialog(
                    this,
                    "Grade must be between 0 and 100.",
                    "Invalid Grade",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        Student student =
                new Student(name, grade);

        students.add(student);

        tableModel.addRow(
                new Object[]{
                    student.getName(),
                    String.format(
                            "%.2f",
                            student.getGrade()
                    )
                }
        );

        updateSummary();

        nameField.setText("");
        gradeField.setText("");

        nameField.requestFocus();
    }

    private void deleteStudent() {

        int selectedRow =
                studentTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a student to delete.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        students.remove(selectedRow);
        tableModel.removeRow(selectedRow);

        updateSummary();
    }

    private void clearStudents() {

        if (students.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "There are no students to clear.",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE
            );

            return;
        }

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to remove all students?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION
                );

        if (result == JOptionPane.YES_OPTION) {

            students.clear();
            tableModel.setRowCount(0);

            updateSummary();
        }
    }

    private void updateSummary() {

        if (students.isEmpty()) {

            updateSummaryLabel(
                    averageLabel,
                    "Average",
                    "0.00",
                    PRIMARY
            );

            updateSummaryLabel(
                    highestLabel,
                    "Highest",
                    "0.00",
                    SUCCESS
            );

            updateSummaryLabel(
                    lowestLabel,
                    "Lowest",
                    "0.00",
                    DANGER
            );

            return;
        }

        double total = 0;

        double highest =
                students.get(0).getGrade();

        double lowest =
                students.get(0).getGrade();

        for (Student student : students) {

            double grade =
                    student.getGrade();

            total += grade;

            if (grade > highest) {
                highest = grade;
            }

            if (grade < lowest) {
                lowest = grade;
            }
        }

        double average =
                total / students.size();

        updateSummaryLabel(
                averageLabel,
                "Average",
                String.format("%.2f", average),
                PRIMARY
        );

        updateSummaryLabel(
                highestLabel,
                "Highest",
                String.format("%.2f", highest),
                SUCCESS
        );

        updateSummaryLabel(
                lowestLabel,
                "Lowest",
                String.format("%.2f", lowest),
                DANGER
        );
    }

    private void updateSummaryLabel(
            JLabel label,
            String title,
            String value,
            Color accentColor
    ) {

        label.setText(
                "<html>"
                + "<div style='text-align:center;'>"
                + "<span style='font-size:12px; color:#6B7280;'>"
                + title
                + "</span>"
                + "<br>"
                + "<span style='font-size:22px; color:#1F2937;'>"
                + value
                + "</span>"
                + "</div>"
                + "</html>"
        );

        label.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(
                                0, 5, 0, 0,
                                accentColor
                        ),
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(
                                        BORDER
                                ),
                                new EmptyBorder(
                                        10, 10, 10, 10
                                )
                        )
                )
        );
    }

    private static class RoundedPanel
            extends JPanel {

        private final int radius;
        private final Color backgroundColor;

        public RoundedPanel(
                int radius,
                Color backgroundColor
        ) {

            this.radius = radius;
            this.backgroundColor = backgroundColor;

            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setColor(backgroundColor);

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth() - 1,
                    getHeight() - 1,
                    radius,
                    radius
            );

            g2.setColor(
                    new Color(229, 231, 235)
            );

            g2.drawRoundRect(
                    0,
                    0,
                    getWidth() - 1,
                    getHeight() - 1,
                    radius,
                    radius
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            StudentGradeTrackerGUI app =
                    new StudentGradeTrackerGUI();

            app.setVisible(true);
        });
    }
}