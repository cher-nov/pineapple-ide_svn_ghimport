/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey <bob@bobtheblueberry.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package org.gcreator.gui;

//<editor-fold defaultstate="collapsed" desc="Import Statements">
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import org.gcreator.core.Core;
import org.gcreator.managers.SettingsManager;
import org.gcreator.pineapple.PineapplePlugin;
import org.gcreator.tree.ProjectTreeNode;
import org.gcreator.project.Project;
import org.gcreator.plugins.DefaultEventTypes;
import org.gcreator.plugins.EventHandler;
import org.gcreator.managers.EventManager;
import org.gcreator.plugins.EventPriority;
import org.gcreator.plugins.Event;
import org.gcreator.project.ProjectElement;
import org.gcreator.project.DefaultProject;
import org.gcreator.project.ProjectFile;
import org.gcreator.project.ProjectFolder;
import org.gcreator.project.ProjectType;
import org.gcreator.project.io.BasicFile;
import org.gcreator.project.io.FormatSupporter;
import org.gcreator.tree.BaseTreeNode;
import org.gcreator.tree.FileTreeNode;
import org.noos.xing.mydoggy.ToolWindow;
import org.noos.xing.mydoggy.ToolWindowAnchor;
import org.noos.xing.mydoggy.plaf.MyDoggyToolWindowManager;
//</editor-fold>
/**
 * This deals with the main GUI stuff.
 * 
 * @author Luís Reis
 * @author Serge Humphrey
 */
public class PineappleGUI implements EventHandler {
    //<editor-fold defaultstate="collapsed" desc="Variables">
    /**
     * The project tree
     */
    public static JTree tree;
    /**
     * The root node of {@link #tree}
     */
    public static ProjectTreeNode projectNode;
    /**
     * The menubar of the application
     */
    public static JMenuBar menubar;
    /**
     * The file menu
     */
    public static JMenu fileMenu;
    /**
     * The project menu
     */
    public static JMenu projectMenu;
    /**
     * The edit menu
     */
    public static JMenu editMenu;
    /**
     * The tools menu
     */
    public static JMenu toolsMenu;
    /**
     * The help menu
     */
    public static JMenu helpMenu;
    
    public static JMenuItem fileNewProject;
    public static JMenuItem fileOpenFile;
    public static JMenuItem fileOpenProject;
    public static JMenuItem fileSaveProject;
    public static JMenuItem fileSave;
    public static JMenuItem fileExit;
    public static JMenuItem toolsPlugins;
    public static JMenuItem projectRemove;
    public static JMenuItem projectOpen;
    public static JMenuItem projectAdd;
    public static JMenuItem projectDelete;
    public static JMenuItem projecImport;
    public static JMenuItem projectExport;
    public static JMenuItem helpAbout;
    
    /**
     * Provides a way to deal with multiple documents.
     */
    public static DocumentInterfaceProvider dip;
    /**
     * Allows docking
     */
    public static MyDoggyToolWindowManager manager;
    /**
     * The current project
     */
    public static Project project = null;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Events">
    /**
     * Event when a file is deleted from the filesystem.
     */
    public static final String FILE_DELETED = "file-deleted";
    /**
     * Event when a file is removed from the project.
     */
    public static final String FILE_REMOVED = "file-removed";
    /**
     * When a file is opened.
     * This event should have the opened File as the first argument.
     * File can be null.
     * The second argument should be the File format, even if the File is null.
     */
    public static final String FILE_OPENED = "file-opened";
    /**
     * When a file changes.
     */
    public static final String FILE_CHANGED = "file-changed";
    /**
     * When a project is opened
     */
    public static final String PROJECT_OPENED = "project-opened";
    /**
     * When a project is saved
     */
    public static final String PROJECT_SAVED = "project-saved";
    /**
     * When a popup menu is created on the tree
     */
    public static final String TREE_MENU_INVOKED = "tree-menu-invoked";
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="PineappleGUI()">
    /**
     * Created and initilizes a new Pineapple GUI.
     */
    public PineappleGUI() {
        initialize();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="initialize()">
    /**
     * Initilizes the Pineapple GUI.
     */
    protected void initialize() {
        /* Core Events */
        EventManager.addEventHandler(this, DefaultEventTypes.APPLICATION_INITIALIZED, EventPriority.HIGH);
        EventManager.addEventHandler(this, DefaultEventTypes.WINDOW_CREATED, EventPriority.MEDIUM);
        EventManager.addEventHandler(this, DefaultEventTypes.WINDOW_DISPOSED, EventPriority.MEDIUM);
        /* Custom Events */

        EventManager.addEventHandler(this, FILE_OPENED, EventPriority.LOW);
        EventManager.addEventHandler(this, FILE_CHANGED, EventPriority.LOW);
        EventManager.addEventHandler(this, FILE_DELETED, EventPriority.LOW);
        EventManager.addEventHandler(this, FILE_REMOVED, EventPriority.LOW);
        EventManager.addEventHandler(this, TREE_MENU_INVOKED, EventPriority.HIGH);
        EventManager.addEventHandler(this, PROJECT_OPENED, EventPriority.HIGH);
        EventManager.addEventHandler(this, PROJECT_SAVED, EventPriority.HIGH);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="initializeWindow()">
    /**
     * Initilize's the Pineapple Window.
     */
    protected void initializeWindow() {
        MainFrame f = Core.getStaticContext().getMainFrame();
        SwingUtilities.updateComponentTreeUI(f);
        f.setTitle("Pineapple IDE");
        f.setIconImage(new ImageIcon(getClass().getResource(
                "/org/gcreator/pineapple/pineapple.png")).getImage());

        manager = new MyDoggyToolWindowManager();
        f.getContentPane().add(manager);

        project = new DefaultProject();

        //<editor-fold defaultstate="collapsed" desc="Tree Initialization">
        projectNode = new ProjectTreeNode(project);
        tree = new JTree(projectNode);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setVisible(true);
        tree.setCellRenderer(new ProjectTreeRenderer());
        tree.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                final Object o = tree.getPathForRow(tree.getClosestRowForLocation(e.getX(), e.getY())).getLastPathComponent();
                if (o == null) {
                    return;
                }
                if (e.getClickCount() >= 2 && e.getButton() == MouseEvent.BUTTON1 && o instanceof BaseTreeNode) {
                    BaseTreeNode node = (BaseTreeNode) o;
                    TreePath tp = tree.getClosestPathForLocation(e.getX(), e.getY());
                    tree.setSelectionPath(tp);

                    if (node != null && node instanceof FileTreeNode) {
                        openFile(node.getElement().getFile());
                    }
                } else if (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON3) {
                    JPopupMenu menu = new JPopupMenu("Tree");
                    EventManager.fireEvent(this, TREE_MENU_INVOKED, menu, o);
                    menu.show(tree, e.getX(), e.getY());
                }
            }
        });
        tree.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                Object o = tree.getSelectionPath().getLastPathComponent();
                if (o == null || !(o instanceof FileTreeNode)) {
                    return;
                }
                FileTreeNode t = (FileTreeNode) o;
                ProjectElement el = t.getElement();

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    openFile(el.getFile());
                } else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    deleteFile(el);
                }
            }
        });
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e) {
                Object o = e.getPath().getLastPathComponent();
                if (o == null || !(o instanceof BaseTreeNode)) {
                    projectRemove.setEnabled(false);
                    projectOpen.setEnabled(false);
                    projectDelete.setEnabled(false);
                    return;
                }
                BaseTreeNode node = (BaseTreeNode) o;

                projectRemove.setEnabled(project.getFiles().indexOf(node.getElement()) != -1);
                projectOpen.setEnabled(node instanceof FileTreeNode);
                projectDelete.setEnabled(true);
            }
        });
        tree.setScrollsOnExpand(true);
        tree.setShowsRootHandles(true);
        manager.registerToolWindow("Project", "Project", null, new JScrollPane(tree),
                ToolWindowAnchor.LEFT);
        //</editor-fold>

        dip = new TabbedInterfaceProvider();
        dip.setVisible(true);
        manager.setMainContent(dip);

        menubar = new JMenuBar();
        menubar.setVisible(true);
        f.setJMenuBar(menubar);

        //<editor-fold defaultstate="collapsed" desc="File menu">
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        fileMenu.setVisible(true);
        menubar.add(fileMenu);

        fileNewProject = new JMenuItem("New Project");
        fileNewProject.setMnemonic('w');
        fileNewProject.setVisible(true);
        fileNewProject.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                popupNewProjectDialog();
            }
        });
        fileMenu.add(fileNewProject);

        fileOpenProject = new JMenuItem("Open Project");
        fileOpenProject.setMnemonic('j');
        fileOpenProject.setVisible(true);
        fileOpenProject.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                openProject();
            }
        });
        fileMenu.add(fileOpenProject);

        fileSaveProject = new JMenuItem("Save Project");
        fileSaveProject.setMnemonic('v');
        fileSaveProject.setVisible(true);
        fileSaveProject.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                saveProject();
            }
        });
        fileMenu.add(fileSaveProject);

        fileOpenFile = new JMenuItem("Open File");
        fileOpenFile.setMnemonic('O');
        fileOpenFile.setVisible(true);
        fileOpenFile.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                openFile(false, false);
            }
        });
        fileMenu.add(fileOpenFile);

        fileSave = new JMenuItem("Save");
        fileSave.setMnemonic('S');
        fileSave.setVisible(true);
        fileSave.setEnabled(false);
        fileSave.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                saveFile();
            }
        });
        fileMenu.add(fileSave);

        fileExit = new JMenuItem("Exit");
        fileExit.setMnemonic('x');
        fileExit.setVisible(true);
        fileExit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                EventManager.fireEvent(this, DefaultEventTypes.WINDOW_DISPOSED);
            }
        });
        fileMenu.add(fileExit);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Project menu">
        projectMenu = new JMenu("Project");

        projectOpen = new JMenuItem("Open Selected...");
        projectOpen.setMnemonic('O');
        projectOpen.setVisible(true);
        projectOpen.setEnabled(false);
        projectOpen.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                try {
                    BaseTreeNode node = (BaseTreeNode) tree.getSelectionPath().getLastPathComponent();
                    openFile(node.getElement().getFile());
                } catch (Exception e) {
                }
            }
        });
        projectMenu.add(projectOpen);

        projectAdd = new JMenuItem("Add File/Folder...");
        projectAdd.setMnemonic('A');
        projectAdd.setVisible(true);
        projectAdd.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                openFile(true, true);
            }
        });
        projectMenu.add(projectAdd);

        projectRemove = new JMenuItem("Remove Selected");
        projectRemove.setMnemonic('R');
        projectRemove.setVisible(true);
        projectRemove.setEnabled(false);
        projectRemove.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                ProjectElement el = ((BaseTreeNode) tree.getSelectionPath().getLastPathComponent()).getElement();
                project.remove(el);
                EventManager.fireEvent(this, FILE_REMOVED, el);
            }
        });
        projectMenu.add(projectRemove);

        projectDelete = new JMenuItem("Delete Selected");
        projectDelete.setMnemonic('D');
        projectDelete.setVisible(true);
        projectDelete.setEnabled(false);
        projectDelete.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                ProjectElement el = ((BaseTreeNode) tree.getSelectionPath().getLastPathComponent()).getElement();
                deleteFile(el);
            }
        });
        projectMenu.add(projectDelete);


        menubar.add(projectMenu);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Edit menu">
        editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        editMenu.setEnabled(false);
        editMenu.setVisible(true);
        menubar.add(editMenu);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Tools menu">
        toolsMenu = new JMenu("Tools");
        toolsMenu.setMnemonic('T');
        toolsMenu.setEnabled(true);
        toolsMenu.setVisible(true);

        toolsPlugins = new JMenuItem("Plugins");
        toolsPlugins.setMnemonic('g');
        toolsPlugins.setEnabled(true);
        toolsPlugins.setVisible(true);
        toolsPlugins.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                openPluginDialog();
            }
        });
        toolsMenu.add(toolsPlugins);

        menubar.add(toolsMenu);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Help menu">
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        helpMenu.setEnabled(true);
        helpMenu.setVisible(true);
        
        helpAbout = new JMenuItem("About");
        helpAbout.setMnemonic('A');
        helpAbout.setEnabled(true);
        helpAbout.setVisible(true);
        helpAbout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                openAboutDialog();
            }
        });
        helpMenu.add(helpAbout);
        menubar.add(helpMenu);
        
        //</editor-fold>
        
        for (ToolWindow window : manager.getToolWindows()) {
            window.setAvailable(true);
        }

        /* Try to load the MyDoggy settings */
        try {
            File dataFolder = Core.getStaticContext().getApplicationDataFolder();
            File w = new File(dataFolder.getPath() + File.separator + "workspace.xml");
            if (w.exists()) {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(w));
                manager.getPersistenceDelegate().apply(in);
                in.close();
            }
        } catch (Exception e) {
            System.err.println("Error while loading workspace: " + e);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="openPluginDialog()">
    /**
     * Opens the plugin dialog
     */
    public void openPluginDialog() {
        PluginDialog d = new PluginDialog(Core.getStaticContext().getMainFrame());
        d.setVisible(true);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="openAboutDialog()">
    /**
     * Opens the about dialog
     */
    public void openAboutDialog() {
        AboutDialog d = new AboutDialog(Core.getStaticContext().getMainFrame());
        d.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="handleEvent(NotifyEvent)">
    /**
     * Handles any provided events
     * @param evt The sent event
     */
    @Override
    public void handleEvent(Event evt) {
        //<editor-fold defaultstate="collapsed" desc="APPLICATION_INITIALIZED">
        if (evt.getEventType().equals(DefaultEventTypes.APPLICATION_INITIALIZED)) {
            boolean lf = false;
            try {
                UIManager.setLookAndFeel(
                        "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                lf = true;
            } catch (Exception e) {
                System.out.println("Failed to install l&f: " + e.getMessage());
            }
            if (!lf) {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                }
            }
            PineapplePlugin.formats = new Vector<FormatSupporter>(4);
            EventManager.fireEvent(this, PineapplePlugin.REGISTER_FORMATS);

            PineapplePlugin.projectTypes = new Vector<ProjectType>(2);
            EventManager.fireEvent(this, PineapplePlugin.REGISTER_PROJECT_TYPES);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="WINDOW_CREATED">
        } else if (evt.getEventType().equals(DefaultEventTypes.WINDOW_CREATED)) {

            /* Initilize the main window */
            initializeWindow();
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="FILE_CHANGED">
        } else if (evt.getEventType().equals(FILE_CHANGED)) {

            DocumentPane pane = dip.getSelectedDocument();
            editMenu.removeAll();
            if (pane != null) {
                editMenu.setEnabled(pane.setupEditMenu(editMenu));
                fileSave.setEnabled(pane.canSave());
            } else {
                editMenu.setEnabled(false);
                fileSave.setEnabled(false);
            }
        //</editor-fold>
        } else if (evt.getEventType().equals(FILE_OPENED) && evt.getArguments().length >= 1) {

            DocumentPane p;
            Object[] arguments = evt.getArguments();
            BasicFile f = (BasicFile) arguments[0];
            FormatSupporter fs = getFormatSupporter(f);
            if (fs == null) {
                return;
            }
            p = fs.load(f);
            dip.add(p.getFile().getName(), p);
            evt.handleEvent();
            tree.updateUI();

        } else if (evt.getEventType().equals(DefaultEventTypes.WINDOW_DISPOSED)) {

            /* Save the MyDoggy settings */
            try {
                File dataFolder = Core.getStaticContext().getApplicationDataFolder();
                File f = new File(dataFolder.getPath() + File.separator + "workspace.xml");
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedOutputStream o = new BufferedOutputStream(new FileOutputStream(f));
                manager.getPersistenceDelegate().save(o);
                o.close();
            } catch (Exception e) {
            }

            for (DocumentPane doc : dip.getDocuments()) {
                if (doc != null) {
                    if (!doc.dispose()) {
                        evt.handleEvent();
                        return;
                    }
                }
            }

        } else if (evt.getEventType().equals(PROJECT_OPENED)) {

            if (evt.getArguments().length == 0) {
                return;
            }
            File f = (File) evt.getArguments()[0];
            ProjectType t = getProjectType(f);
            project = t.create(f);
            tree.updateUI();

        } else if (evt.getEventType().equals(FILE_DELETED)) {
            if (evt.getArguments().length > 0 && evt.getArguments()[0] instanceof ProjectElement) {
                ProjectElement e = (ProjectElement) evt.getArguments()[0];
                if (e.getParent() != null && e.getParent() instanceof ProjectFolder) {
                    ((ProjectFolder) e.getParent()).reload();
                }
                tree.updateUI();
            }
        } else if (evt.getEventType().equals(FILE_REMOVED)) {
            tree.updateUI();
        } else if (evt.getEventType().equals(TREE_MENU_INVOKED)) {
            if (evt.getArguments().length < 2 || !(evt.getArguments()[0] instanceof JPopupMenu)) {
                return;
            }
            JPopupMenu menu = (JPopupMenu) evt.getArguments()[0];
            final Object o = evt.getArguments()[1];

            if (o instanceof FileTreeNode) {
                menu.add("Open...").addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        openFile(((FileTreeNode) o).getElement().getFile());
                    }
                });
            }

            if (o instanceof BaseTreeNode && project.getFiles().indexOf(((BaseTreeNode) o).getElement()) != -1) {
                final BaseTreeNode t = (BaseTreeNode) o;
                menu.add("Remove").addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        project.remove(t.getElement());
                        EventManager.fireEvent(this, FILE_REMOVED, t.getElement());
                    }
                });
            }

            if (o instanceof BaseTreeNode) {
                menu.add("Delete").addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        deleteFile(((BaseTreeNode) o).getElement());
                    }
                });
            }
        } else if (evt.getEventType().equals(PROJECT_SAVED)) {
            if (evt.getArguments().length < 1) {
                return;
            }
            File f = (File) evt.getArguments()[0];
            project.getManager().save(f);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="openFile(final File)">
    /**
     * Opens a given file
     * @param f The file to open
     */
    public void openFile(final BasicFile f) {
        DocumentPane[] comps = dip.getDocuments();
        boolean canOpen = true;
        for (DocumentPane component : comps) {
            if (component != null && component.getFile() == f) {
                canOpen = false;
                break;
            }
        }
        if (canOpen) {
            Thread t = new Thread() {

                @Override
                public void run() {
                    String s = f.getName();
                    String format = "<none>";
                    ProjectFile el = new ProjectFile(f, format, project);
                    try {
                        int index = s.lastIndexOf('.') + 1;
                        if (index > 0) {
                            format = s.substring(s.lastIndexOf('.') + 1);
                            el.setFormat(format);
                        }
                    } catch (Exception e) {
                    }
                    EventManager.fireEvent(this, FILE_OPENED, f, format, el);
                    dip.updateUI();
                }
            };
            t.start();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="openProject()">
    /**
     * Opens a project
     */
    public void openProject() {
        if (project != null) {
            closeProject();
        }

        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        chooser.setDialogTitle("Select the project to open");
        final String[] formats = getSupportedProjectFormats();
        StringBuilder b = new StringBuilder(formats.length * 4);
        for (String s : formats) {
            b.append(s + " ");
        }
        final String desc = b.toString();

        chooser.addChoosableFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                for (String s : formats) {
                    if (f.getName().matches(".+\\." + s)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public String getDescription() {
                return desc;
            }
        });
        int res = chooser.showDialog(Core.getStaticContext().getMainFrame(), "OK");
        if (res != JFileChooser.CANCEL_OPTION) {
            EventManager.fireEvent(this, PROJECT_OPENED, chooser.getSelectedFile());
        }

        tree.updateUI();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="saveProject()">
    /**
     * Saves the project
     */
    public void saveProject() {
        if (project == null) {
            return;
        }

        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        chooser.setDialogTitle("Save Project");
        final String[] formats = project.getProjectType().getProjectFileTypes();
        StringBuilder b = new StringBuilder(formats.length * 4);
        for (String s : formats) {
            b.append(s + " ");
        }
        final String desc = b.toString();

        chooser.addChoosableFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                for (String s : formats) {
                    if (f.getName().matches(".+\\." + s)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public String getDescription() {
                return desc;
            }
        });

        int res = chooser.showDialog(Core.getStaticContext().getMainFrame(), "OK");
        if (res != JFileChooser.CANCEL_OPTION) {
            File f = chooser.getSelectedFile();
            if (!f.getName().contains(".")) {
                f = new File(f.getPath() + formats[0]);
            }
            EventManager.fireEvent(this, PROJECT_SAVED, f);
        }

        tree.updateUI();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="closeProject()">
    /**
     * Closes the current project
     */
    public void closeProject() {
        project.getFiles().clear();
        tree.updateUI();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="saveFile()">
    /**
     * Saves the currently open file
     */
    public void saveFile() {
        DocumentPane p = dip.getSelectedDocument();
        if (p != null) {
            p.save();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="openFile(boolean, boolean)">
    /**
     * Opens a file
     * 
     * @param addFile Wheather to add the file to the project.
     * @param allowFolder Wheather you want to allow the user to choose folders.
     */
    public void openFile(boolean addFile, boolean allowFolder) {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setDialogTitle("Select files to open");
        final String[] formats = getSupportedFileFormats();
        StringBuilder b = new StringBuilder(formats.length * 4);
        for (String s : formats) {
            b.append(s + " ");
        }
        final String desc = b.toString();

        chooser.addChoosableFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                for (String s : formats) {
                    if (f.getName().matches(".+\\." + s)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public String getDescription() {
                return desc;
            }
        });
        chooser.setFileSelectionMode(((allowFolder) ? JFileChooser.FILES_AND_DIRECTORIES : JFileChooser.FILES_ONLY));
        if (chooser.showDialog(Core.getStaticContext().getMainFrame(), "OK") != JFileChooser.CANCEL_OPTION) {
            File[] files = chooser.getSelectedFiles();
            for (File f : files) {
                if (!f.exists()) {
                    JOptionPane.showMessageDialog(Core.getStaticContext().getMainFrame(),
                            "File " + f + "Does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                BasicFile bf = project.getManager().createBasicFileFromFile(f);
                if (addFile) {
                    BaseTreeNode node = null;
                    for (ProjectElement e : project.getFiles()) {
                        if ((node = hasFile(f, e)) != null) {
                            break;
                        }
                    }

                    if (node == null) {
                        try {
                            ProjectElement e = project.createElement(bf);
                            node = e.getTreeNode();
                            project.add(e);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(PineappleGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    tree.updateUI();
                }
                if (!f.isDirectory()) {
                    openFile(bf);
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="hasFile(File, ProjectElement)">
    private static BaseTreeNode hasFile(File f, ProjectElement e) {
        if (e instanceof ProjectFile) {
            if (f.equals(e.getFile())) {
                return e.getTreeNode();
            }
        } else if (e instanceof ProjectFolder) {
            for (ProjectElement b : ((ProjectFolder) e).getChildren()) {
                BaseTreeNode o = hasFile(f, b);
                if (o != null) {
                    return o;
                }
            }
        }
        return null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="popupNewProjectDialog()">
    /**
     * Pops a New FolderProject Dialog
     */
    public void popupNewProjectDialog() {
        NewProjectDialog dialog = new NewProjectDialog(Core.getStaticContext().getMainFrame());
        dialog.setVisible(true);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="deleteFile(ProjectElement)">
    /**
     * Deletes a file from the file system
     * @param e The ProjectElement to be deleted
     */
    private void deleteFile(ProjectElement e) {
        if (JOptionPane.showConfirmDialog(tree,
                "<html>Are you sure you want to delete this file from your file system?<br/>This will be permanent.</html>") == JOptionPane.YES_OPTION) {
            e.getFile().delete();
            project.remove(e);
            EventManager.fireEvent(this, FILE_DELETED, e);
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getFormatSupporter(BasicFile f)">
    private FormatSupporter getFormatSupporter(BasicFile f) {
        String format;
        int i = f.getName().lastIndexOf('.');
        if (i < 0 || i >= f.getName().length()) {
            format = null;
        } else {
            format = f.getName().substring(i + 1);
        }

        String key = "files.formats.formatsupporter.remember." + format;
        if (format != null && SettingsManager.exists(key)) {
            try {
                String cname = SettingsManager.get(key);
                Class<?> c = Class.forName(cname);
                Object o = c.newInstance();
                return (FormatSupporter) o;
            } catch (Exception exc) {
            }
        }

        final Vector<FormatSupporter> supporters = new Vector<FormatSupporter>(2);

        for (FormatSupporter fs : PineapplePlugin.formats) {
            String[] s = fs.getFormats();
            if (s == null) {
                continue;
            }
            for (String ff : s) {
                if (format == null || f.getName().matches(".+\\." + ff)) {
                    supporters.add(fs);
                }
            }
        }

        if (supporters.size() == 0) {
            JOptionPane.showMessageDialog(manager, "<html>Error:<br/>File format not supported.</html>");
            return null;
        }
        if (supporters.size() == 1) {
            return supporters.get(0);
        }

        final JDialog d = new JDialog(Core.getStaticContext().getMainFrame(), "Open File", true);
        final JList list = new JList();
        list.setModel(new AbstractListModel() {

            private static final long serialVersionUID = 1;

            public int getSize() {
                return supporters.size();
            }

            public Object getElementAt(int index) {
                return supporters.get(index).getName();
            }
        });

        final JTextPane text = new JTextPane();
        text.setEditable(false);

        JSplitPane pane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT, new JScrollPane(list),
                new JScrollPane(text));
        d.add(pane);


        JCheckBox cbox = new JCheckBox("Remember this choice");
        if (format == null) {
            cbox.setEnabled(false);
        }
        JPanel south = new JPanel();
        south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
        Box box = Box.createHorizontalBox();
        box.add(cbox);
        box.add(Box.createHorizontalGlue());
        south.add(box);

        final  JButton ok,  cancel ;
        ok = new JButton("OK");
        ok.setEnabled(false);
        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                d.dispose();
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int i = e.getFirstIndex();
                ok.setEnabled(i >= 0);
                if (i >= 0) {
                    text.setText(supporters.get(list.getSelectedIndex()).getDescription());
                }
            }
        });
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                d.dispose();
            }
        });
        Box bottom = Box.createHorizontalBox();
        bottom.add(Box.createHorizontalGlue());
        bottom.add(ok);
        bottom.add(Box.createHorizontalStrut(8));
        bottom.add(cancel);
        bottom.add(Box.createHorizontalStrut(32));
        south.add(bottom);

        d.add(south, "South");
        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        d.setSize(360, 280);
        d.setVisible(true);

        if (cbox.isSelected() && format != null) {
            SettingsManager.set(key, supporters.get(list.getSelectedIndex()).getClass().getName());
        }

        return supporters.get(list.getSelectedIndex());
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getProjectType(File f)">
    private ProjectType getProjectType(File f) {
        String format;
        int i = f.getName().lastIndexOf('.');
        if (i < 0 || i >= f.getName().length()) {
            format = null;
        } else {
            format = f.getName().substring(i + 1);
        }

        String key = "files.projects.projecttypes.remember." + format;
        if (format != null && SettingsManager.exists(key)) {
            try {
                String cname = SettingsManager.get(key);
                Class<?> c = Class.forName(cname);
                Object o = c.newInstance();
                return (ProjectType) o;
            } catch (Exception exc) {
            }
        }

        final Vector<ProjectType> types = new Vector<ProjectType>(2);

        for (ProjectType pt : PineapplePlugin.projectTypes) {
            String[] s = pt.getProjectFileTypes();
            if (s == null) {
                continue;
            }
            for (String ff : s) {
                if (format == null || f.getName().matches(".+\\." + ff)) {
                    types.add(pt);
                }
            }
        }

        if (types.size() == 0) {
            JOptionPane.showMessageDialog(manager, "<html>Error:<br/>File format not supported.</html>");
            return null;
        }
        if (types.size() == 1) {
            return types.get(0);
        }
        final JDialog d = new JDialog(Core.getStaticContext().getMainFrame(), "Open File", true);
        final JList list = new JList();
        list.setModel(new AbstractListModel() {

            private static final long serialVersionUID = 1;

            public int getSize() {
                return types.size();
            }

            public Object getElementAt(int index) {
                return types.get(index).getName();
            }
        });

        final JTextPane text = new JTextPane();
        text.setEditable(false);

        JSplitPane pane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT, new JScrollPane(list),
                new JScrollPane(text));
        d.add(pane);


        JCheckBox cbox = new JCheckBox("Remember this choice");
        if (format == null) {
            cbox.setEnabled(false);
        }
        JPanel south = new JPanel();
        south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
        Box box = Box.createHorizontalBox();
        box.add(cbox);
        box.add(Box.createHorizontalGlue());
        south.add(box);

        final  JButton ok,  cancel ;
        ok = new JButton("OK");
        ok.setEnabled(false);
        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                d.dispose();
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int i = e.getFirstIndex();
                ok.setEnabled(i >= 0);
                if (i >= 0) {
                    text.setText(types.get(list.getSelectedIndex()).getDescription());
                }
            }
        });
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                d.dispose();
            }
        });
        Box bottom = Box.createHorizontalBox();
        bottom.add(Box.createHorizontalGlue());
        bottom.add(ok);
        bottom.add(Box.createHorizontalStrut(8));
        bottom.add(cancel);
        bottom.add(Box.createHorizontalStrut(32));
        south.add(bottom);

        d.add(south, "South");
        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        d.setSize(360, 280);
        d.setVisible(true);

        if (cbox.isSelected() && format != null) {
            SettingsManager.set(key, types.get(list.getSelectedIndex()).getClass().getName());
        }

        return types.get(list.getSelectedIndex());
    }
    //</editor-fold>
    
    private String[] getSupportedFileFormats() {
        final Vector<String> formats = new Vector<String>(2);

        for (FormatSupporter fs : PineapplePlugin.formats) {
            String[] s = fs.getFormats();
            if (s == null) {
                continue;
            }
            for (String ff : s) {
                formats.add(ff);
            }
        }
        return formats.toArray(new String[formats.size()]);
    }

    private String[] getSupportedProjectFormats() {
        final Vector<String> formats = new Vector<String>(2);

        for (ProjectType pt : PineapplePlugin.projectTypes) {
            String[] s = pt.getProjectFileTypes();
            if (s == null) {
                continue;
            }
            for (String ff : s) {
                formats.add(ff);
            }
        }
        return formats.toArray(new String[formats.size()]);
    }
}
