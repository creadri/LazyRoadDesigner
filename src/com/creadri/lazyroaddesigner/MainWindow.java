/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainWindow.java
 *
 * Created on 06-juil.-2011, 13:52:10
 */
package com.creadri.lazyroaddesigner;

import com.creadri.lazyroad.Pillar;
import com.creadri.lazyroad.PillarPart;
import com.creadri.lazyroad.Road;
import com.creadri.lazyroad.RoadPart;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 *
 * @author Nélis Adrien
 */
public class MainWindow extends javax.swing.JFrame {
    // road

    private Road road;
    private RoadPart roadPart;
    private String roadName;
    private ListRoadPartModel listRoadPartModel;
    private JDialogNewPart jdNewPart;
    // pillar
    private Pillar pillar;
    private PillarPart pillarPart;
    private String pillarName;
    private ListPillarPartModel listPillarPartModel;
    private MaterialArray isometrics;
    private MaterialArray materials;
    private MaterialTableModel materialTableModel;
    
    private JDialogPreviewer jdp;
    
    private Properties config;
    private File configFile;

    /** Creates new form MainWindow */
    public MainWindow() {
        // configuration file
        config = new Properties();
        
        try {
            configFile = new File(new File(System.getProperty("user.dir")), "config.properties");
            
            if (!configFile.exists()) {
                configFile.createNewFile();
            }
            
            config.load(new FileInputStream(configFile));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        materials = new MaterialArray(getClass().getResourceAsStream("/com/creadri/lazyroaddesigner/img/materialList.yml"));
        isometrics = new MaterialArray(getClass().getResourceAsStream("/com/creadri/lazyroaddesigner/img/isometric/materialList.yml"));

        materialTableModel = new MaterialTableModel(materials);

        listRoadPartModel = new ListRoadPartModel();
        listPillarPartModel = new ListPillarPartModel();

        initComponents();
        
        jdp = new JDialogPreviewer(this, rootPaneCheckingEnabled, isometrics);

        jtPalette.getColumnModel().getColumn(0).setPreferredWidth(16);

        try {
            jpRoadDesigner.setPlayer(ImageIO.read(getClass().getResource("/com/creadri/lazyroaddesigner/img/playerback.png")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        jdNewPart = new JDialogNewPart(this, true);

        jtPalette.setDefaultRenderer(Image.class, new MaterialImageDisplay());


        jfcOpenFile.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                return f.isDirectory() || (f.isFile() && f.exists() && f.getName().endsWith(".ser"));
            }

            @Override
            public String getDescription() {
                return "LazyRoad Serialized files";
            }
        });
        
        File f = new File(config.getProperty("openDir", System.getProperty("user.home")));
        if (f.exists()) {
            jfcOpenFile.setCurrentDirectory(f);
        }

        jfcSaveFile.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                return f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Directories";
            }
        });
        
        f = new File(config.getProperty("saveDir", System.getProperty("user.home")));
        if (f.exists()) {
            jfcOpenFile.setCurrentDirectory(f);
        }

        try {
            jepFAQ.setEditorKit(new HTMLEditorKit());
            StyleSheet css = new StyleSheet();       
            
            css.loadRules(new InputStreamReader(getClass().getResourceAsStream("/com/creadri/lazyroaddesigner/faqcss.css")), null);
            jepFAQ.read(getClass().getResourceAsStream("/com/creadri/lazyroaddesigner/faq.html"), new HTMLDocument(css));
            
            this.setIconImage(ImageIO.read(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/lazyroad.png")));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        jtpMain.setEnabledAt(1, false);
        jtpMain.setEnabledAt(2, false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jfcSaveFile = new javax.swing.JFileChooser();
        jfcOpenFile = new javax.swing.JFileChooser();
        jpmRoadPartDelete = new javax.swing.JPopupMenu();
        jmiRoadPartDelete = new javax.swing.JMenuItem();
        jmiRoadPartNewPopup = new javax.swing.JMenuItem();
        jpmPillarPartDelete = new javax.swing.JPopupMenu();
        jmiPillarPartDelete = new javax.swing.JMenuItem();
        jmiPillarPartNewPopup = new javax.swing.JMenuItem();
        jspMain = new javax.swing.JSplitPane();
        jspPalette = new javax.swing.JScrollPane();
        jtPalette = new javax.swing.JTable();
        jtpMain = new javax.swing.JTabbedPane();
        jpWelcome = new javax.swing.JPanel();
        jspFAQ = new javax.swing.JScrollPane();
        jepFAQ = new javax.swing.JEditorPane();
        jpRoad = new javax.swing.JPanel();
        jlName = new javax.swing.JLabel();
        jpRoadDetail = new javax.swing.JPanel();
        jbStairs = new javax.swing.JButton();
        jlStairWidth = new javax.swing.JLabel();
        jtfStairWidth = new javax.swing.JTextField();
        jlStairHeight = new javax.swing.JLabel();
        jtfStairHeight = new javax.swing.JTextField();
        jlRoadMaxGradient = new javax.swing.JLabel();
        jtfRoadMaxGradient = new javax.swing.JTextField();
        jbStairChange = new javax.swing.JButton();
        jsRoadDetail = new javax.swing.JSeparator();
        jlRoadPartDetail = new javax.swing.JLabel();
        jspPartList = new javax.swing.JScrollPane();
        jlPartList = new javax.swing.JList();
        jlGroundLayer = new javax.swing.JLabel();
        jtfGroundLayer = new javax.swing.JTextField();
        jlRoadWidth = new javax.swing.JLabel();
        jtfRoadWidth = new javax.swing.JTextField();
        jlRoadHeight = new javax.swing.JLabel();
        jtfRoadHeight = new javax.swing.JTextField();
        jlRepeatEvery = new javax.swing.JLabel();
        jtfRepeatEvery = new javax.swing.JTextField();
        jbRoadChange = new javax.swing.JButton();
        jpRoadDesigner = new com.creadri.lazyroaddesigner.JPanelDesigner();
        jpPillar = new javax.swing.JPanel();
        jlPillarName = new javax.swing.JLabel();
        jpPillarDetail = new javax.swing.JPanel();
        jlPillarPartDetail = new javax.swing.JLabel();
        jspPillarPartList = new javax.swing.JScrollPane();
        jlPillarPart = new javax.swing.JList();
        jlPillarRepeatEvery = new javax.swing.JLabel();
        jtfPillarRepeatEvery = new javax.swing.JTextField();
        jlBuildUntil = new javax.swing.JLabel();
        jtfBuildUntil = new javax.swing.JTextField();
        jlPillarWidth = new javax.swing.JLabel();
        jtfPillarWidth = new javax.swing.JTextField();
        jlPillarHeight = new javax.swing.JLabel();
        jtfPillarHeight = new javax.swing.JTextField();
        jbPillarChange = new javax.swing.JButton();
        jpPillarDesigner = new com.creadri.lazyroaddesigner.JPanelDesigner();
        jpLog = new javax.swing.JPanel();
        jspLog = new javax.swing.JScrollPane();
        jtaLog = new javax.swing.JTextArea();
        jmbMain = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiExit = new javax.swing.JMenuItem();
        jmRoad = new javax.swing.JMenu();
        jmiNewRoad = new javax.swing.JMenuItem();
        jmiRoadOpen = new javax.swing.JMenuItem();
        jmiRoadSave = new javax.swing.JMenuItem();
        jmiRoadPreview = new javax.swing.JMenuItem();
        jsRoadMenu = new javax.swing.JPopupMenu.Separator();
        jmiRoadPartNew = new javax.swing.JMenuItem();
        jmPillar = new javax.swing.JMenu();
        jmiPillarNew = new javax.swing.JMenuItem();
        jmiPillarOpen = new javax.swing.JMenuItem();
        jmiPillarSave = new javax.swing.JMenuItem();
        jsPillarMenu = new javax.swing.JPopupMenu.Separator();
        jmiPillarNewPart = new javax.swing.JMenuItem();

        jfcSaveFile.setDialogTitle("Save to Directory");
        jfcSaveFile.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jfcSaveFile.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        jfcSaveFile.getAccessibleContext().setAccessibleParent(this);

        jfcOpenFile.setDialogTitle("Open File");

        jmiRoadPartDelete.setText("Delete Selected");
        jmiRoadPartDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRoadPartDeleteActionPerformed(evt);
            }
        });
        jpmRoadPartDelete.add(jmiRoadPartDelete);

        jmiRoadPartNewPopup.setText("Create New Road Part");
        jmiRoadPartNewPopup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRoadPartNewActionPerformed(evt);
            }
        });
        jpmRoadPartDelete.add(jmiRoadPartNewPopup);

        jmiPillarPartDelete.setText("Delete Selected Part");
        jmiPillarPartDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPillarPartDeleteActionPerformed(evt);
            }
        });
        jpmPillarPartDelete.add(jmiPillarPartDelete);

        jmiPillarPartNewPopup.setText("Create New Pillar Part");
        jmiPillarPartNewPopup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPillarNewPartActionPerformed(evt);
            }
        });
        jpmPillarPartDelete.add(jmiPillarPartNewPopup);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lazy Road Designer 0.2.2");
        setLocationByPlatform(true);
        setName("lzdesigner"); // NOI18N
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jspPalette.setMinimumSize(new java.awt.Dimension(100, 300));
        jspPalette.setPreferredSize(new java.awt.Dimension(300, 450));

        jtPalette.setModel(materialTableModel);
        jtPalette.setFocusable(false);
        jspPalette.setViewportView(jtPalette);

        jspMain.setLeftComponent(jspPalette);

        jpWelcome.setLayout(new javax.swing.BoxLayout(jpWelcome, javax.swing.BoxLayout.LINE_AXIS));

        jspFAQ.setViewportView(jepFAQ);

        jpWelcome.add(jspFAQ);

        jtpMain.addTab("Welcome", new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/home.png")), jpWelcome); // NOI18N

        jpRoad.setLayout(new java.awt.GridBagLayout());

        jlName.setFont(jlName.getFont().deriveFont(jlName.getFont().getStyle() | java.awt.Font.BOLD, 20));
        jlName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlName.setText("Road Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jpRoad.add(jlName, gridBagConstraints);

        jpRoadDetail.setMinimumSize(new java.awt.Dimension(140, 400));
        jpRoadDetail.setPreferredSize(new java.awt.Dimension(140, 400));
        jpRoadDetail.setLayout(new java.awt.GridBagLayout());

        jbStairs.setText("Show Stairs");
        jbStairs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStairsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jbStairs, gridBagConstraints);

        jlStairWidth.setLabelFor(jtfRoadWidth);
        jlStairWidth.setText("Stair Width:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jlStairWidth, gridBagConstraints);

        jtfStairWidth.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jtfStairWidth, gridBagConstraints);

        jlStairHeight.setLabelFor(jtfStairHeight);
        jlStairHeight.setText("Stair Height:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jlStairHeight, gridBagConstraints);

        jtfStairHeight.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jtfStairHeight, gridBagConstraints);

        jlRoadMaxGradient.setLabelFor(jtfRoadMaxGradient);
        jlRoadMaxGradient.setText("Min Blocks:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jlRoadMaxGradient, gridBagConstraints);

        jtfRoadMaxGradient.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jtfRoadMaxGradient, gridBagConstraints);

        jbStairChange.setText("Change Stairs Values");
        jbStairChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStairChangeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jbStairChange, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jpRoadDetail.add(jsRoadDetail, gridBagConstraints);

        jlRoadPartDetail.setText("Road Parts");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jlRoadPartDetail, gridBagConstraints);

        jlPartList.setModel(listRoadPartModel);
        jlPartList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlPartList.setComponentPopupMenu(jpmRoadPartDelete);
        jlPartList.setVisibleRowCount(4);
        jlPartList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlPartListValueChanged(evt);
            }
        });
        jspPartList.setViewportView(jlPartList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jspPartList, gridBagConstraints);

        jlGroundLayer.setLabelFor(jtfGroundLayer);
        jlGroundLayer.setText("Ground Index:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jlGroundLayer, gridBagConstraints);

        jtfGroundLayer.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jtfGroundLayer, gridBagConstraints);

        jlRoadWidth.setLabelFor(jtfRoadWidth);
        jlRoadWidth.setText("Part Width: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jlRoadWidth, gridBagConstraints);

        jtfRoadWidth.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jtfRoadWidth, gridBagConstraints);

        jlRoadHeight.setLabelFor(jtfRoadHeight);
        jlRoadHeight.setText("Part Height: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jlRoadHeight, gridBagConstraints);

        jtfRoadHeight.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jtfRoadHeight, gridBagConstraints);

        jlRepeatEvery.setLabelFor(jtfRepeatEvery);
        jlRepeatEvery.setText("RepeatEvery:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jlRepeatEvery, gridBagConstraints);

        jtfRepeatEvery.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jtfRepeatEvery, gridBagConstraints);

        jbRoadChange.setText("Change Part Values");
        jbRoadChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRoadChangeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoadDetail.add(jbRoadChange, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoad.add(jpRoadDetail, gridBagConstraints);

        jpRoadDesigner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpRoadDesignerMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jpRoadDesignerLayout = new javax.swing.GroupLayout(jpRoadDesigner);
        jpRoadDesigner.setLayout(jpRoadDesignerLayout);
        jpRoadDesignerLayout.setHorizontalGroup(
            jpRoadDesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );
        jpRoadDesignerLayout.setVerticalGroup(
            jpRoadDesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpRoad.add(jpRoadDesigner, gridBagConstraints);

        jtpMain.addTab("Road", new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/road.png")), jpRoad); // NOI18N

        jpPillar.setLayout(new java.awt.GridBagLayout());

        jlPillarName.setFont(jlPillarName.getFont().deriveFont(jlPillarName.getFont().getStyle() | java.awt.Font.BOLD, 20));
        jlPillarName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPillarName.setText("Pillar Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jpPillar.add(jlPillarName, gridBagConstraints);

        jpPillarDetail.setMinimumSize(new java.awt.Dimension(140, 400));
        jpPillarDetail.setPreferredSize(new java.awt.Dimension(140, 400));
        jpPillarDetail.setLayout(new java.awt.GridBagLayout());

        jlPillarPartDetail.setText("Pillar Parts:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpPillarDetail.add(jlPillarPartDetail, gridBagConstraints);

        jlPillarPart.setModel(listPillarPartModel);
        jlPillarPart.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlPillarPart.setComponentPopupMenu(jpmPillarPartDelete);
        jlPillarPart.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlPillarPartValueChanged(evt);
            }
        });
        jspPillarPartList.setViewportView(jlPillarPart);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpPillarDetail.add(jspPillarPartList, gridBagConstraints);

        jlPillarRepeatEvery.setLabelFor(jtfPillarRepeatEvery);
        jlPillarRepeatEvery.setText("Repeat Every:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpPillarDetail.add(jlPillarRepeatEvery, gridBagConstraints);

        jtfPillarRepeatEvery.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpPillarDetail.add(jtfPillarRepeatEvery, gridBagConstraints);

        jlBuildUntil.setLabelFor(jtfBuildUntil);
        jlBuildUntil.setText("Max blocks to build:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpPillarDetail.add(jlBuildUntil, gridBagConstraints);

        jtfBuildUntil.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpPillarDetail.add(jtfBuildUntil, gridBagConstraints);

        jlPillarWidth.setLabelFor(jtfPillarWidth);
        jlPillarWidth.setText("Part Width: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpPillarDetail.add(jlPillarWidth, gridBagConstraints);

        jtfPillarWidth.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpPillarDetail.add(jtfPillarWidth, gridBagConstraints);

        jlPillarHeight.setLabelFor(jtfPillarHeight);
        jlPillarHeight.setText("Part Height: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpPillarDetail.add(jlPillarHeight, gridBagConstraints);

        jtfPillarHeight.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpPillarDetail.add(jtfPillarHeight, gridBagConstraints);

        jbPillarChange.setText("Change Pillar Part");
        jbPillarChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPillarChangeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpPillarDetail.add(jbPillarChange, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpPillar.add(jpPillarDetail, gridBagConstraints);

        jpPillarDesigner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpPillarDesignerMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jpPillarDesignerLayout = new javax.swing.GroupLayout(jpPillarDesigner);
        jpPillarDesigner.setLayout(jpPillarDesignerLayout);
        jpPillarDesignerLayout.setHorizontalGroup(
            jpPillarDesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );
        jpPillarDesignerLayout.setVerticalGroup(
            jpPillarDesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpPillar.add(jpPillarDesigner, gridBagConstraints);

        jtpMain.addTab("Pillar", new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/bridge.png")), jpPillar); // NOI18N

        jpLog.setLayout(new javax.swing.BoxLayout(jpLog, javax.swing.BoxLayout.LINE_AXIS));

        jtaLog.setColumns(20);
        jtaLog.setRows(5);
        jspLog.setViewportView(jtaLog);

        jpLog.add(jspLog);

        jtpMain.addTab("Log", new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/order-192.png")), jpLog); // NOI18N

        jspMain.setRightComponent(jtpMain);

        getContentPane().add(jspMain);

        jmFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/process.png"))); // NOI18N
        jmFile.setText("File");

        jmiExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jmiExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/sign-out.png"))); // NOI18N
        jmiExit.setText("Exit");
        jmiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });
        jmFile.add(jmiExit);

        jmbMain.add(jmFile);

        jmRoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/road.png"))); // NOI18N
        jmRoad.setText("Road");

        jmiNewRoad.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmiNewRoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/road.png"))); // NOI18N
        jmiNewRoad.setText("New Road");
        jmiNewRoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewRoadActionPerformed(evt);
            }
        });
        jmRoad.add(jmiNewRoad);

        jmiRoadOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jmiRoadOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/project.png"))); // NOI18N
        jmiRoadOpen.setText("Open Road");
        jmiRoadOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRoadOpenActionPerformed(evt);
            }
        });
        jmRoad.add(jmiRoadOpen);

        jmiRoadSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmiRoadSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/disc.png"))); // NOI18N
        jmiRoadSave.setText("Save Road");
        jmiRoadSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRoadSaveActionPerformed(evt);
            }
        });
        jmRoad.add(jmiRoadSave);

        jmiRoadPreview.setText("Road Preview");
        jmiRoadPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRoadPreviewActionPerformed(evt);
            }
        });
        jmRoad.add(jmiRoadPreview);
        jmRoad.add(jsRoadMenu);

        jmiRoadPartNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK));
        jmiRoadPartNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/plus.png"))); // NOI18N
        jmiRoadPartNew.setText("New Road Part");
        jmiRoadPartNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRoadPartNewActionPerformed(evt);
            }
        });
        jmRoad.add(jmiRoadPartNew);

        jmbMain.add(jmRoad);

        jmPillar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/bridge.png"))); // NOI18N
        jmPillar.setText("Pillar");

        jmiPillarNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/bridge.png"))); // NOI18N
        jmiPillarNew.setText("New Pillar");
        jmiPillarNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPillarNewActionPerformed(evt);
            }
        });
        jmPillar.add(jmiPillarNew);

        jmiPillarOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/project.png"))); // NOI18N
        jmiPillarOpen.setText("Open Pillar");
        jmiPillarOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPillarOpenActionPerformed(evt);
            }
        });
        jmPillar.add(jmiPillarOpen);

        jmiPillarSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/disc.png"))); // NOI18N
        jmiPillarSave.setText("Save Pillar");
        jmiPillarSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPillarSaveActionPerformed(evt);
            }
        });
        jmPillar.add(jmiPillarSave);
        jmPillar.add(jsPillarMenu);

        jmiPillarNewPart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/creadri/lazyroaddesigner/img/icons/plus.png"))); // NOI18N
        jmiPillarNewPart.setText("New Pillar Part");
        jmiPillarNewPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPillarNewPartActionPerformed(evt);
            }
        });
        jmPillar.add(jmiPillarNewPart);

        jmbMain.add(jmPillar);

        setJMenuBar(jmbMain);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * ROAD DESIGNER MOUSE HANDLE
     * @param evt 
     */
    private void jpRoadDesignerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRoadDesignerMousePressed
        if (roadPart == null) {
            System.out.println("ici ici ici");
            return;
        }

        if (evt.getButton() == MouseEvent.BUTTON1) {

            int selected = jtPalette.getSelectedRow();
            if (selected == -1) {
                selected = 0;
            }
            Material mat = materialTableModel.getMaterial(selected);

            jpRoadDesigner.fillBlock(evt.getX(), evt.getY(), mat.getImage());
            int row = jpRoadDesigner.getRow(); // y
            int column = jpRoadDesigner.getColumn(); // x

            roadPart.getIds()[row][column] = mat.getId();
            roadPart.getDatas()[row][column] = mat.getData();

        } else {
            jpRoadDesigner.fillAir(evt.getX(), evt.getY());
            int row = jpRoadDesigner.getRow(); // y
            int column = jpRoadDesigner.getColumn(); // x

            roadPart.getIds()[row][column] = 0;
            roadPart.getDatas()[row][column] = 0x00;
        }
    }//GEN-LAST:event_jpRoadDesignerMousePressed

    /**
     * NEW ROAD
     * @param evt 
     */
    private void jmiNewRoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewRoadActionPerformed

        roadName = JOptionPane.showInputDialog(this, "Enter a Name for the Road", "Road Name", JOptionPane.QUESTION_MESSAGE);

        if (roadName == null || roadName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "You must specify a name !", "Error on Road Name", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        roadName = roadName.replaceAll("\\s+", "_");

        road = new Road();
        
        road.setMaxGradient(2);

        listRoadPartModel.setRoad(road);

        jlName.setText(roadName);

        jtpMain.setEnabledAt(1, true);
        jtpMain.setSelectedIndex(1);

        jlPartList.clearSelection();
        jlPartList.updateUI();
        
        JOptionPane.showMessageDialog(this, "You have created your new empty road. You have to create new road parts in order to have a functional road !", "New Road Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jmiNewRoadActionPerformed

    /**
     * NEW ROAD PART
     * @param evt 
     */
    private void jmiRoadPartNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRoadPartNewActionPerformed

        if (road == null) {
            JOptionPane.showMessageDialog(this, "You must open or create a Road first !", "No Road", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (road.size() > 0) {
            RoadPart firstPart = road.getRoadPart(0);
            jdNewPart.setRepeatEvery(firstPart.getRepeatEvery() + 1);
            jdNewPart.setLayerheight(firstPart.getHeight());
            jdNewPart.setLayerwidth(firstPart.getWidth());
        }

        jdNewPart.setVisible(true);

        if (jdNewPart.getRepeatEvery() <= 0) {
            return;
        }

        RoadPart roadpart = new RoadPart(jdNewPart.getLayerheight(), jdNewPart.getLayerwidth());
        roadpart.setRepeatEvery(jdNewPart.getRepeatEvery());

        // copy the previous road part if there is one
        if (road.size() > 0) {
            RoadPart firstPart = road.getRoadPart(road.size() - 1);
            int firstids[][] = firstPart.getIds();
            byte firstdatas[][] = firstPart.getDatas();

            int ids[][] = roadpart.getIds();
            byte datas[][] = roadpart.getDatas();

            int imax = Math.min(firstPart.getHeight(), roadpart.getHeight());
            int jmax = Math.min(firstPart.getWidth(), roadpart.getWidth());
            for (int i = 0; i < imax; i++) {
                for (int j = 0; j < jmax; j++) {
                    ids[i][j] = firstids[i][j];
                    datas[i][j] = firstdatas[i][j];
                }
            }
        }

        if (!road.addRoadPart(roadpart)) {
            JOptionPane.showMessageDialog(this, "There is already a Road Part with Repeat Every value set on that value !", "Repeat Every error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        jlPartList.clearSelection();
        jlPartList.updateUI();
    }//GEN-LAST:event_jmiRoadPartNewActionPerformed

    /**
     * EXIT
     * @param evt 
     */
    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jmiExitActionPerformed

    /**
     * ROAD PART VALUE Changed
     * @param evt 
     */
    private void jlPartListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlPartListValueChanged

        roadPart = (RoadPart) jlPartList.getSelectedValue();

        if (roadPart == null) {
            return;
        }

        printRoadPart();
    }//GEN-LAST:event_jlPartListValueChanged

    /**
     * PRINT ROAD PART INTO DESIGNER AND RESET TEXTFIELD VALUES
     */
    private void printRoadPart() {
        int imax = roadPart.getHeight();
        int jmax = roadPart.getWidth();

        // update text fields
        jtfRoadHeight.setText(Integer.toString(imax));
        jtfRoadWidth.setText(Integer.toString(jmax));
        jtfGroundLayer.setText(Integer.toString(roadPart.getGroundLayer()));
        jtfRepeatEvery.setText(Integer.toString(roadPart.getRepeatEvery()));

        // update designer
        int[][] ids = roadPart.getIds();
        byte[][] datas = roadPart.getDatas();

        jpRoadDesigner.setDesignSize(jmax, imax);
        jpRoadDesigner.setGroundLayer(roadPart.getGroundLayer());

        for (int i = 0; i < imax; i++) {
            for (int j = 0; j < jmax; j++) {
                jpRoadDesigner.setImgAt(j, i, materials.getImageFromIdData(ids[i][j], datas[i][j]));
            }
        }

        jpRoadDesigner.updateUI();
    }

    /**
     * CHANGE ROAD PART VALUES
     * @param evt 
     */
    private void jbRoadChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRoadChangeActionPerformed
        if (roadPart == null) {
            return;
        }
        int newHeight = -1;
        int newWidth = -1;
        int newRepeatEvery = -1;
        int newGroundLayer = -1;

        try {
            newHeight = Integer.parseInt(jtfRoadHeight.getText());
            newWidth = Integer.parseInt(jtfRoadWidth.getText());
            newRepeatEvery = Integer.parseInt(jtfRepeatEvery.getText());
            newGroundLayer = Integer.parseInt(jtfGroundLayer.getText());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Values must be numbers !", "Values Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (newHeight <= 0 || newWidth <= 0 || newRepeatEvery <= 0 || newGroundLayer < 0) {
            JOptionPane.showMessageDialog(this, "Values must be superior to zero except for Ground Index which can be zero. No other values !", "Values Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (newHeight != roadPart.getHeight() || newWidth != roadPart.getWidth() || newGroundLayer != roadPart.getGroundLayer()) {
            // change the width and height (painfull)
            roadPart.setSize(newWidth, newHeight);
            roadPart.setGroundLayer(newGroundLayer);
            printRoadPart();
        }


        if (newRepeatEvery != roadPart.getRepeatEvery()) {
            // change the order (painfull also)
            road.getParts().remove(roadPart);
            roadPart.setRepeatEvery(newRepeatEvery);
            road.addRoadPart(roadPart);
            // update the gui list
            jlPartList.clearSelection();
            jlPartList.updateUI();
        }

    }//GEN-LAST:event_jbRoadChangeActionPerformed

    /**
     * SHOW STAIRS
     * @param evt 
     */
    private void jbStairsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStairsActionPerformed
        if (road == null) {
            return;
        }

        RoadPart stairs = road.getStairs();

        if (stairs == null) {
            // create default stairs
            if (road.size() == 0) {
                // still no parts, create default with basic options
                stairs = new RoadPart(1, 1);
                road.setStairs(stairs);
            } else {
                RoadPart defPart = road.getParts().get(road.size() - 1);
                stairs = new RoadPart(1, defPart.getWidth());
                road.setStairs(stairs);
            }

            int jmax = stairs.getWidth();
            for (int j = 0; j < jmax; j++) {
                stairs.getIds()[0][j] = 44;
            }
        }
        
        jlPartList.clearSelection();
        
        roadPart = stairs;

        // print the stairs
        printStairs(roadPart);
    }//GEN-LAST:event_jbStairsActionPerformed

    /**
     * CHANGE STAIRS VALUES
     * @param evt 
     */
    private void jbStairChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStairChangeActionPerformed
        if (road == null) {
            return;
        }

        RoadPart stairs = road.getStairs();

        int newHeight = -1;
        int newWidth = -1;
        int newMaxGradient = -1;

        try {
            newHeight = Integer.parseInt(jtfStairHeight.getText());
            newWidth = Integer.parseInt(jtfStairWidth.getText());
            newMaxGradient = Integer.parseInt(jtfRoadMaxGradient.getText());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Values must be numbers !", "Values Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (newHeight <= 0 || newWidth <= 0 || newMaxGradient <= 0) {
            JOptionPane.showMessageDialog(this, "Values must be superior to zero. No other values !", "Values Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (stairs == null) {
            stairs = new RoadPart(newHeight, newWidth);
            road.setStairs(stairs);
        }
        
        road.setMaxGradient(newMaxGradient);


        if (newHeight != stairs.getHeight() || newWidth != stairs.getWidth()) {
            // change the width and height (painfull)
            stairs.setSize(newWidth, newHeight);
            printStairs(stairs);
        }
    }//GEN-LAST:event_jbStairChangeActionPerformed

    /**
     * ROAD SAVE
     * @param evt 
     */
    private void jmiRoadSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRoadSaveActionPerformed
        if (road == null) {
            return;
        }

        if (road.size() == 0) {
            JOptionPane.showMessageDialog(this, "You must have at least one part in order to save the road", "Saving Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (road.getStairs() == null) {
            road.setStairs(new RoadPart(0, 0));
        }

        jfcSaveFile.showSaveDialog(this);

        File folder = jfcSaveFile.getSelectedFile();

        if (folder == null || !folder.isDirectory()) {
            folder = jfcSaveFile.getCurrentDirectory();
        }

        File saveFile = new File(folder, roadName.concat(".ser"));

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile));

            oos.writeObject(road);

            oos.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, "An error occured. More information in Log tab", "Saving Error", JOptionPane.ERROR_MESSAGE);

            jtaLog.append(ex.toString().concat("\n"));
        }

        saveConfig();
    }//GEN-LAST:event_jmiRoadSaveActionPerformed

    /**
     * ROAD OPEN
     * @param evt 
     */
    private void jmiRoadOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRoadOpenActionPerformed

        jfcOpenFile.showOpenDialog(this);

        File openFile = jfcOpenFile.getSelectedFile();

        if (openFile == null || openFile.isDirectory() || !openFile.exists()) {
            JOptionPane.showMessageDialog(this, "You cannot open that file", "File Open Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(openFile));

            road = (Road) ois.readObject();
            
            ois.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, "An error occured. More information in Log tab", "Open Error", JOptionPane.ERROR_MESSAGE);

            jtaLog.append(ex.toString().concat("\n"));
            return;
        }

        roadName = openFile.getName().substring(0, openFile.getName().length() - 4);

        RoadPart stairs = road.getStairs();
        jtfStairHeight.setText(Integer.toString(stairs.getHeight()));
        jtfStairWidth.setText(Integer.toString(stairs.getWidth()));
        jtfRoadMaxGradient.setText(Integer.toString(road.getMaxGradient()));
        
        jlName.setText(roadName);

        listRoadPartModel.setRoad(road);

        jlPartList.clearSelection();
        jlPartList.updateUI();

        jtpMain.setEnabledAt(1, true);
        jtpMain.setSelectedIndex(1);
        
        saveConfig();
    }//GEN-LAST:event_jmiRoadOpenActionPerformed

    private void jmiPillarNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPillarNewActionPerformed
        pillarName = JOptionPane.showInputDialog(this, "Enter a Name for the Pillar", "Pillar Name", JOptionPane.QUESTION_MESSAGE);

        if (pillarName == null || pillarName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "You must specify a name !", "Error on Pillar Name", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        pillarName = pillarName.replaceAll("\\s+", "_");

        pillar = new Pillar();

        listPillarPartModel.setPillar(pillar);

        jlPillarName.setText(pillarName);

        jtpMain.setEnabledAt(2, true);
        jtpMain.setSelectedIndex(2);

        jlPillarPart.clearSelection();
        jlPillarPart.updateUI();
    }//GEN-LAST:event_jmiPillarNewActionPerformed

    private void jmiRoadPartDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRoadPartDeleteActionPerformed
        if (road == null || roadPart == null) {
            return;
        }

        road.removeRoadPart(roadPart);

        jlPartList.clearSelection();
        jlPartList.updateUI();
    }//GEN-LAST:event_jmiRoadPartDeleteActionPerformed

    private void jmiPillarNewPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPillarNewPartActionPerformed

        if (pillar == null) {
            JOptionPane.showMessageDialog(this, "You must open or create a Pillar first !", "No Pillar", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (pillar.size() > 0) {
            PillarPart firstPart = pillar.getPillarPart(0);
            jdNewPart.setRepeatEvery(firstPart.getRepeatEvery() + 1);
            jdNewPart.setLayerheight(firstPart.getHeight());
            jdNewPart.setLayerwidth(firstPart.getWidth());
        }

        jdNewPart.setVisible(true);

        if (jdNewPart.getRepeatEvery() <= 0) {
            return;
        }

        PillarPart pillarpart = new PillarPart(jdNewPart.getLayerheight(), jdNewPart.getLayerwidth());
        pillarpart.setRepeatEvery(jdNewPart.getRepeatEvery());

        // copy the previous pillar part if there is one
        if (pillar.size() > 0) {
            PillarPart firstPart = pillar.getPillarPart(pillar.size() - 1);
            int firstids[][] = firstPart.getIds();
            byte firstdatas[][] = firstPart.getDatas();

            int ids[][] = pillarpart.getIds();
            byte datas[][] = pillarpart.getDatas();

            int imax = Math.min(firstPart.getHeight(), pillarpart.getHeight());
            int jmax = Math.min(firstPart.getWidth(), pillarpart.getWidth());
            for (int i = 0; i < imax; i++) {
                for (int j = 0; j < jmax; j++) {
                    ids[i][j] = firstids[i][j];
                    datas[i][j] = firstdatas[i][j];
                }
            }
        }

        if (!pillar.addPillarPart(pillarpart)) {
            JOptionPane.showMessageDialog(this, "There is already a Pillar Part with Repeat Every value set on that value !", "Repeat Every error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        jlPillarPart.clearSelection();
        jlPillarPart.updateUI();
    }//GEN-LAST:event_jmiPillarNewPartActionPerformed

    private void jbPillarChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPillarChangeActionPerformed
        if (pillarPart == null) {
            return;
        }
        int newHeight = -1;
        int newWidth = -1;
        int newRepeatEvery = -1;
        int newBuildUntil = -1;

        try {
            newHeight = Integer.parseInt(jtfPillarHeight.getText());
            newWidth = Integer.parseInt(jtfPillarWidth.getText());
            newRepeatEvery = Integer.parseInt(jtfPillarRepeatEvery.getText());
            newBuildUntil = Integer.parseInt(jtfBuildUntil.getText());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Values must be numbers !", "Values Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (newHeight <= 0 || newWidth <= 0 || newRepeatEvery <= 0 || newBuildUntil < 0) {
            JOptionPane.showMessageDialog(this, "Values must be superior to zero except for Build Until which can be zero. No other values !", "Values Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        pillarPart.setBuildUntil(newBuildUntil);

        if (newHeight != pillarPart.getHeight() || newWidth != pillarPart.getWidth()) {
            // change the width and height (painfull)
            pillarPart.setSize(newWidth, newHeight);
            printPillarPart();
        }


        if (newRepeatEvery != pillarPart.getRepeatEvery()) {
            // change the order (painfull also)
            pillar.getParts().remove(pillarPart);
            pillarPart.setRepeatEvery(newRepeatEvery);
            pillar.addPillarPart(pillarPart);
            // update the gui list
            jlPillarPart.updateUI();
            jlPillarPart.clearSelection();
        }
    }//GEN-LAST:event_jbPillarChangeActionPerformed

    private void jlPillarPartValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlPillarPartValueChanged
        pillarPart = (PillarPart) jlPillarPart.getSelectedValue();

        if (pillarPart == null) {
            return;
        }

        printPillarPart();
    }//GEN-LAST:event_jlPillarPartValueChanged

    private void jmiPillarOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPillarOpenActionPerformed

        jfcOpenFile.showOpenDialog(this);

        File openFile = jfcOpenFile.getSelectedFile();

        if (openFile == null || openFile.isDirectory() || !openFile.exists()) {
            JOptionPane.showMessageDialog(this, "You cannot open that file", "File Open Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(openFile));

            pillar = (Pillar) ois.readObject();

            ois.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, "An error occured. More information in Log tab", "Open Error", JOptionPane.ERROR_MESSAGE);

            jtaLog.append(ex.toString().concat("\n"));
            return;
        }

        pillarName = openFile.getName().substring(0, openFile.getName().length() - 4);

        jlPillarName.setText(pillarName);

        listPillarPartModel.setPillar(pillar);

        jlPillarPart.clearSelection();
        jlPillarPart.updateUI();
        
        jtpMain.setEnabledAt(2, true);
        jtpMain.setSelectedIndex(2);
        
        saveConfig();
    }//GEN-LAST:event_jmiPillarOpenActionPerformed

    
    private void saveConfig() {
        try {
            config.put("openDir", jfcOpenFile.getCurrentDirectory().getPath());
            config.put("saveDir", jfcSaveFile.getCurrentDirectory().getPath());
            
            config.store(new FileOutputStream(configFile), roadName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    private void jmiPillarSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPillarSaveActionPerformed
        if (pillar == null) {
            return;
        }
        
        if (pillar.size() == 0) {
            JOptionPane.showMessageDialog(this, "You must have at least one part in order to save the pillar", "Saving Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        jfcSaveFile.showSaveDialog(this);

        File folder = jfcSaveFile.getSelectedFile();

        if (folder == null || !folder.isDirectory()) {
            folder = jfcSaveFile.getCurrentDirectory();
        }

        File saveFile = new File(folder, pillarName.concat(".ser"));

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile));

            oos.writeObject(pillar);

            oos.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, "An error occured. More information in Log tab", "Saving Error", JOptionPane.ERROR_MESSAGE);

            jtaLog.append(ex.toString().concat("\n"));
        }
        
        saveConfig();
    }//GEN-LAST:event_jmiPillarSaveActionPerformed

    private void jpPillarDesignerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPillarDesignerMousePressed
        if (pillarPart == null) {
            return;
        }

        if (evt.getButton() == MouseEvent.BUTTON1) {

            int selected = jtPalette.getSelectedRow();
            if (selected == -1) {
                selected = 0;
            }
            Material mat = materialTableModel.getMaterial(selected);

            jpPillarDesigner.fillBlock(evt.getX(), evt.getY(), mat.getImage());
            int row = jpPillarDesigner.getRow(); // y
            int column = jpPillarDesigner.getColumn(); // x

            pillarPart.getIds()[row][column] = mat.getId();
            pillarPart.getDatas()[row][column] = mat.getData();

        } else {
            jpPillarDesigner.fillAir(evt.getX(), evt.getY());
            int row = jpPillarDesigner.getRow(); // y
            int column = jpPillarDesigner.getColumn(); // x

            pillarPart.getIds()[row][column] = 0;
            pillarPart.getDatas()[row][column] = 0x00;
        }
    }//GEN-LAST:event_jpPillarDesignerMousePressed

    private void jmiPillarPartDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPillarPartDeleteActionPerformed
        if (pillar == null || pillarPart == null) {
            return;
        }

        pillar.removePillarPart(pillarPart);

        jlPillarPart.clearSelection();
        jlPillarPart.updateUI();
    }//GEN-LAST:event_jmiPillarPartDeleteActionPerformed

    private void jmiRoadPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRoadPreviewActionPerformed
        
        if (road == null) {
            return;
        }
        jdp.setRoad(road);
        jdp.setVisible(true);
    }//GEN-LAST:event_jmiRoadPreviewActionPerformed

    /**
     * PRINT STAIRS INTO DESIGNER AND RESET TEXTFIELD VALUES
     * @param stairs 
     */
    private void printStairs(RoadPart stairs) {
        int imax = stairs.getHeight();
        int jmax = stairs.getWidth();

        // update text fields
        jtfStairHeight.setText(Integer.toString(imax));
        jtfStairWidth.setText(Integer.toString(jmax));

        // update designer
        int[][] ids = stairs.getIds();
        byte[][] datas = stairs.getDatas();

        jpRoadDesigner.setDesignSize(jmax, imax);

        for (int i = 0; i < imax; i++) {
            for (int j = 0; j < jmax; j++) {
                jpRoadDesigner.setImgAt(j, i, materials.getImageFromIdData(ids[i][j], datas[i][j]));
            }
        }

        jpRoadDesigner.updateUI();
    }

    private void printPillarPart() {
        int imax = pillarPart.getHeight();
        int jmax = pillarPart.getWidth();

        // update text fields
        jtfPillarHeight.setText(Integer.toString(imax));
        jtfPillarWidth.setText(Integer.toString(jmax));
        jtfBuildUntil.setText(Integer.toString(pillarPart.getBuildUntil()));
        jtfPillarRepeatEvery.setText(Integer.toString(pillarPart.getRepeatEvery()));

        // update designer
        int[][] ids = pillarPart.getIds();
        byte[][] datas = pillarPart.getDatas();

        jpPillarDesigner.setDesignSize(jmax, imax);

        for (int i = 0; i < imax; i++) {
            for (int j = 0; j < jmax; j++) {
                jpPillarDesigner.setImgAt(j, i, materials.getImageFromIdData(ids[i][j], datas[i][j]));
            }
        }

        jpPillarDesigner.updateUI();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }
                new MainWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbPillarChange;
    private javax.swing.JButton jbRoadChange;
    private javax.swing.JButton jbStairChange;
    private javax.swing.JButton jbStairs;
    private javax.swing.JEditorPane jepFAQ;
    private javax.swing.JFileChooser jfcOpenFile;
    private javax.swing.JFileChooser jfcSaveFile;
    private javax.swing.JLabel jlBuildUntil;
    private javax.swing.JLabel jlGroundLayer;
    private javax.swing.JLabel jlName;
    private javax.swing.JList jlPartList;
    private javax.swing.JLabel jlPillarHeight;
    private javax.swing.JLabel jlPillarName;
    private javax.swing.JList jlPillarPart;
    private javax.swing.JLabel jlPillarPartDetail;
    private javax.swing.JLabel jlPillarRepeatEvery;
    private javax.swing.JLabel jlPillarWidth;
    private javax.swing.JLabel jlRepeatEvery;
    private javax.swing.JLabel jlRoadHeight;
    private javax.swing.JLabel jlRoadMaxGradient;
    private javax.swing.JLabel jlRoadPartDetail;
    private javax.swing.JLabel jlRoadWidth;
    private javax.swing.JLabel jlStairHeight;
    private javax.swing.JLabel jlStairWidth;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenu jmPillar;
    private javax.swing.JMenu jmRoad;
    private javax.swing.JMenuBar jmbMain;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiNewRoad;
    private javax.swing.JMenuItem jmiPillarNew;
    private javax.swing.JMenuItem jmiPillarNewPart;
    private javax.swing.JMenuItem jmiPillarOpen;
    private javax.swing.JMenuItem jmiPillarPartDelete;
    private javax.swing.JMenuItem jmiPillarPartNewPopup;
    private javax.swing.JMenuItem jmiPillarSave;
    private javax.swing.JMenuItem jmiRoadOpen;
    private javax.swing.JMenuItem jmiRoadPartDelete;
    private javax.swing.JMenuItem jmiRoadPartNew;
    private javax.swing.JMenuItem jmiRoadPartNewPopup;
    private javax.swing.JMenuItem jmiRoadPreview;
    private javax.swing.JMenuItem jmiRoadSave;
    private javax.swing.JPanel jpLog;
    private javax.swing.JPanel jpPillar;
    private com.creadri.lazyroaddesigner.JPanelDesigner jpPillarDesigner;
    private javax.swing.JPanel jpPillarDetail;
    private javax.swing.JPanel jpRoad;
    private com.creadri.lazyroaddesigner.JPanelDesigner jpRoadDesigner;
    private javax.swing.JPanel jpRoadDetail;
    private javax.swing.JPanel jpWelcome;
    private javax.swing.JPopupMenu jpmPillarPartDelete;
    private javax.swing.JPopupMenu jpmRoadPartDelete;
    private javax.swing.JPopupMenu.Separator jsPillarMenu;
    private javax.swing.JSeparator jsRoadDetail;
    private javax.swing.JPopupMenu.Separator jsRoadMenu;
    private javax.swing.JScrollPane jspFAQ;
    private javax.swing.JScrollPane jspLog;
    private javax.swing.JSplitPane jspMain;
    private javax.swing.JScrollPane jspPalette;
    private javax.swing.JScrollPane jspPartList;
    private javax.swing.JScrollPane jspPillarPartList;
    private javax.swing.JTable jtPalette;
    private javax.swing.JTextArea jtaLog;
    private javax.swing.JTextField jtfBuildUntil;
    private javax.swing.JTextField jtfGroundLayer;
    private javax.swing.JTextField jtfPillarHeight;
    private javax.swing.JTextField jtfPillarRepeatEvery;
    private javax.swing.JTextField jtfPillarWidth;
    private javax.swing.JTextField jtfRepeatEvery;
    private javax.swing.JTextField jtfRoadHeight;
    private javax.swing.JTextField jtfRoadMaxGradient;
    private javax.swing.JTextField jtfRoadWidth;
    private javax.swing.JTextField jtfStairHeight;
    private javax.swing.JTextField jtfStairWidth;
    private javax.swing.JTabbedPane jtpMain;
    // End of variables declaration//GEN-END:variables
}
