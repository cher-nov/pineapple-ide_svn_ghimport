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

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import org.gcreator.core.Core;
import org.gcreator.editors.ImagePreviewer;
import org.gcreator.editors.TextEditor;
import org.gcreator.tree.ProjectTreeNode;
import org.gcreator.project.Project;
import org.gcreator.plugins.DefaultEventTypes;
import org.gcreator.plugins.EventHandler;
import org.gcreator.plugins.EventManager;
import org.gcreator.plugins.EventPriority;
import org.gcreator.plugins.NotifyEvent;
import org.gcreator.project.BaseElement;
import org.gcreator.project.DefaultProject;
import org.gcreator.project.FileElement;
import org.gcreator.project.FolderElement;
import org.gcreator.tree.BaseTreeNode;
import org.gcreator.tree.FileTreeNode;
import org.noos.xing.mydoggy.ToolWindow;
import org.noos.xing.mydoggy.ToolWindowAnchor;
import org.noos.xing.mydoggy.plaf.MyDoggyToolWindowManager;

/**
 * This deals with the main GUI stuff.
 * 
 * @author Luís Reis
 */
public class PineappleGUI implements EventHandler {
    
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
    public static JMenuItem fileNewProject;
    public static JMenuItem fileOpenFile;
    public static JMenuItem fileOpenProject;
    public static JMenuItem fileSave;
    public static JMenuItem fileExit;
    public static JMenuItem toolsPlugins;
    public static JMenuItem projectRemove;
    public static JMenuItem projectOpen;
    public static JMenuItem projectAdd;
    
    /**
     * Provides a way to deal with multiple documents.
     */
    public static DocumentInterfaceProvider dip;
    /**
     * The current project
     */
    public static Project project = null;

    /**
     * Created and initilizes a new Pineapple GUI.
     */
    public PineappleGUI() {
        initialize();
    }

    /**
     * Initilizes the Pineapple GUI.
     */
    protected void initialize() {
        EventManager.addEventHandler(this, DefaultEventTypes.APPLICATION_INITIALIZED, EventPriority.HIGH);
        EventManager.addEventHandler(this, DefaultEventTypes.WINDOW_CREATED, EventPriority.MEDIUM);
        EventManager.addEventHandler(this, DefaultEventTypes.WINDOW_DISPOSED, EventPriority.MEDIUM);
        EventManager.addEventHandler(this, DefaultEventTypes.FILE_OPENED, EventPriority.LOW);
        EventManager.addEventHandler(this, DefaultEventTypes.FILE_CHANGED, EventPriority.MEDIUM);
        EventManager.addEventHandler(this, DefaultEventTypes.PROJECT_OPENED, EventPriority.MEDIUM);
    }
    private MyDoggyToolWindowManager manager;

    /**
     * Initilize's the Pineapple Window.
     */
    protected void initializeWindow() {
        MainFrame f = Core.getStaticContext().getMainFrame();
        f.setTitle("Pineapple IDE");
        f.setIconImage(new ImageIcon(getClass().getResource(
                "/org/gcreator/pineapple/pineapple.png")).getImage());

        manager = new MyDoggyToolWindowManager();
        f.getContentPane().add(manager);

        project = new DefaultProject();
        projectNode = new ProjectTreeNode(project);

        tree = new JTree(projectNode);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setVisible(true);
        tree.setCellRenderer(new ProjectTreeRenderer());
        tree.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                Object o = tree.getPathForRow(tree.getClosestRowForLocation(e.getX(), e.getY())).getLastPathComponent();
                if (o == null || !(o instanceof BaseTreeNode)) {
                    return;
                }
                BaseTreeNode node = (BaseTreeNode) o;

                if (e.getClickCount() >= 2) {
                   
                    TreePath tp = tree.getClosestPathForLocation(e.getX(), e.getY());
                    tree.setSelectionPath(tp);

                    if (node != null && node instanceof FileTreeNode) {
                        openFile(node.getElement().getFile());
                    }
                }
            }
        });
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e) {
                Object o = e.getPath().getLastPathComponent();
                if (o == null || !(o instanceof BaseTreeNode)) {
                    projectRemove.setEnabled(false);
                    projectOpen.setEnabled(false);
                    return;
                }
                BaseTreeNode node = (BaseTreeNode) o;
                
                projectRemove.setEnabled(project.getFiles().indexOf(node.getElement()) != -1);
                projectOpen.setEnabled(node instanceof FileTreeNode);
                e.getNewLeadSelectionPath();
            }
        });
        tree.setScrollsOnExpand(true);
        tree.setShowsRootHandles(true);
        manager.registerToolWindow("Project", "Project", null, new JScrollPane(tree),
                ToolWindowAnchor.LEFT);

        dip = new TabbedInterfaceProvider();
        dip.setVisible(true);
        manager.setMainContent(dip);

        menubar = new JMenuBar();
        menubar.setVisible(true);
        f.setJMenuBar(menubar);

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
                } catch (Exception e) {}
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
                project.remove(((BaseTreeNode)tree.getSelectionPath().getLastPathComponent()).getElement());
                tree.updateUI();
            }
        });
        projectMenu.add(projectRemove);
        
        menubar.add(projectMenu);
        
        editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        editMenu.setEnabled(false);
        editMenu.setVisible(true);
        menubar.add(editMenu);

        toolsMenu = new JMenu("Tools");
        toolsMenu.setMnemonic('T');
        toolsMenu.setEnabled(true);
        toolsMenu.setVisible(true);
        menubar.add(toolsMenu);

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

        for (ToolWindow window : manager.getToolWindows()) {
            window.setAvailable(true);
        }
    }

    /**
     * Opens the plugin dialog
     */
    public void openPluginDialog() {
        PluginDialog d = new PluginDialog(Core.getStaticContext().getMainFrame());
        d.setVisible(true);
    }

    /**
     * Handles any provided events
     * @param evt The sent event
     */
    @Override
    public void handleEvent(NotifyEvent evt) {
        if(evt.getEventType().equals(DefaultEventTypes.APPLICATION_INITIALIZED)) {
            try{
                for(UIManager.LookAndFeelInfo i :  UIManager.getInstalledLookAndFeels())
                    System.out.println("L&F: " + i.getClassName());
                UIManager.setLookAndFeel(
                        "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            }
            catch(Exception e){
                System.out.println("Failed to install l&f: " + e.getMessage());
            }
        }
        else if (evt.getEventType().equals(DefaultEventTypes.WINDOW_CREATED)) {

            /* Initilize the main window */
            initializeWindow();

        } else if (evt.getEventType().equals(DefaultEventTypes.FILE_CHANGED)) {

            DocumentPane pane = dip.getSelectedDocument();
            editMenu.removeAll();
            if (pane != null) {
                editMenu.setEnabled(pane.setupEditMenu(editMenu));
                fileSave.setEnabled(pane.canSave());
            } else {
                editMenu.setEnabled(false);
                fileSave.setEnabled(false);
            }

        } else if (evt.getEventType().equals(DefaultEventTypes.FILE_OPENED) && evt.getArguments().length >= 2) {

            DocumentPane p;
            Object[] arguments = evt.getArguments();
            File f = (File) arguments[0];
            String format = arguments[1].toString(); //Good to avoid exceptions
            boolean image = false;
            for (String s : ImageIO.getReaderFileSuffixes()) {
                if (format.equalsIgnoreCase(s)) {
                    image = true;
                    break;
                }
            }

            if (image) {
                ImagePreviewer imp = new ImagePreviewer(f);
                p = imp;
                if (evt.getArguments().length > 2 && evt.getArguments()[2] instanceof FileElement) {
                    BufferedImage img = imp.getImage();
                    FileElement el = (FileElement) evt.getArguments()[2];
                    Image img2 = img.getScaledInstance(((img.getWidth() > img.getHeight()) ? 16 : -1),
                            ((img.getWidth() > img.getHeight()) ? -1 : 16), Image.SCALE_FAST);
                    el.setIcon(new ImageIcon(img2));
                }
            } else {
                p = new TextEditor(f);
            }
            dip.add(p.getFile().getName(), p);
            evt.handleEvent();
            tree.updateUI();

        } else if (evt.getEventType().equals(DefaultEventTypes.WINDOW_DISPOSED)) {

            for (DocumentPane doc : dip.getDocuments()) {
                if (doc != null) {
                    if (!doc.dispose()) {
                        evt.handleEvent();
                        return;
                    }
                }
            }

        } else if (evt.getEventType().equals(DefaultEventTypes.PROJECT_OPENED)) {
            //TODO: open project.
        }
    }

    /**
     * Opens a given file
     * @param f The file to open
     */
    public void openFile(final File f) {
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
                    FileElement el = new FileElement(f, format);
                    try {
                        int index = s.lastIndexOf('.') + 1;
                        if (index > 0) {
                            format = s.substring(s.lastIndexOf('.') + 1);
                            el.setFormat(format);
                        }
                    } catch (Exception e) {
                    }
                    EventManager.fireEvent(this, DefaultEventTypes.FILE_OPENED, f, format, el);
                    dip.updateUI();
                }
            };
            t.start();
        }
    }

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
        int res = chooser.showDialog(Core.getStaticContext().getMainFrame(), "OK");
        if (res != JFileChooser.CANCEL_OPTION) {
            EventManager.fireEvent(this, DefaultEventTypes.PROJECT_OPENED, chooser.getSelectedFile());
        }

        tree.updateUI();
    }

    /**
     * Closes the current project
     */
    public void closeProject() {
        project.getFiles().clear();
        tree.updateUI();
    }

    /**
     * Saves the currently open file
     */
    public void saveFile() {
        DocumentPane p = dip.getSelectedDocument();
        if (p != null) {
            p.save();
        }
    }

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
        chooser.setFileSelectionMode(((allowFolder) ? JFileChooser.FILES_AND_DIRECTORIES : JFileChooser.FILES_ONLY));
        if (chooser.showDialog(Core.getStaticContext().getMainFrame(), "OK") != JFileChooser.CANCEL_OPTION) {
            File[] files = chooser.getSelectedFiles();
            for (File f : files) {
                if (!f.exists()) {
                    JOptionPane.showMessageDialog(Core.getStaticContext().getMainFrame(),
                            "File " + f + "Does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (addFile) {
                    BaseTreeNode node = null;
                    for (BaseElement e : project.getFiles()) {
                        if ((node = hasFile(f, e)) != null) {
                            break;
                        }
                    }

                    if (node == null) {
                        try {
                            BaseElement e = Project.createElement(f);
                            node = e.getTreeNode();
                            project.add(e);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(PineappleGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    tree.updateUI();
                }
                if (!f.isDirectory()) {
                    openFile(f);
                }
            }
        }
    }

    private static BaseTreeNode hasFile(File f, BaseElement e) {
        if (e instanceof FileElement) {
            if (f.equals(e.getFile())) {
                return e.getTreeNode();
            }
        } else if (e instanceof FolderElement) {
            for (BaseElement b : ((FolderElement) e).getChildren()) {
                BaseTreeNode o = hasFile(f, b);
                if (o != null) {
                    return o;
                }
            }
        }
        return null;
    }

    /**
     * Pops a New FolderProject Dialog
     */
    public void popupNewProjectDialog() {
        NewProjectDialog dialog = new NewProjectDialog(Core.getStaticContext().getMainFrame());
        dialog.setVisible(true);
    }
}
