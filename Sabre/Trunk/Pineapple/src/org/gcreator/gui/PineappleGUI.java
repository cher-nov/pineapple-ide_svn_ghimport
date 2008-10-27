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

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Enumeration;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.TreePath;
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

/**
 * This deals with the main GUI stuff.
 * 
 * @author Luís Reis
 */
public class PineappleGUI implements EventHandler {

    /**
     * Owns {@link #tree} and the tabbed pane
     */
    public static JSplitPane splitter;
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
    public static JMenu fileMenu;
    public static JMenu editMenu;
    public static JMenuItem fileNewProject;
    public static JMenuItem fileOpenFile;
    public static JMenuItem fileOpenProject;
    public static JMenuItem fileSave;
    public static JMenuItem fileExit;
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
        EventManager.addEventHandler(this, DefaultEventTypes.WINDOW_CREATED, EventPriority.MEDIUM);
        EventManager.addEventHandler(this, DefaultEventTypes.WINDOW_DISPOSED, EventPriority.MEDIUM);
        EventManager.addEventHandler(this, DefaultEventTypes.FILE_OPENED, EventPriority.LOW);
        EventManager.addEventHandler(this, DefaultEventTypes.FILE_CHANGED, EventPriority.MEDIUM);
        EventManager.addEventHandler(this, DefaultEventTypes.PROJECT_OPENED, EventPriority.MEDIUM);
    }

    /**
     * Initilize's the Pineapple Window.
     */
    protected void initializeWindow() {
        MainFrame f = Core.getStaticContext().getMainFrame();
        f.setTitle("Pineapple IDE");
        f.setIconImage(new ImageIcon(getClass().getResource(
                "/org/gcreator/pineapple/pineapple.png")).getImage());
        splitter = new JSplitPane();
        splitter.setVisible(true);
        f.setLayout(new BorderLayout());
        f.add(splitter, BorderLayout.CENTER);

        project = new DefaultProject();
        projectNode = new ProjectTreeNode(project);
        project.add(new FolderElement(new File("./")));
        
        tree = new JTree(projectNode);
        tree.setVisible(true);
        tree.setCellRenderer(new ProjectTreeRenderer());
        tree.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                Object o = tree.getPathForRow(tree.getClosestRowForLocation(e.getX(), e.getY())).getLastPathComponent();
                System.out.println("you clicked: "+o + " "+ o.getClass());
                if (e.getClickCount() >= 2) {
                    if (o instanceof BaseTreeNode) {
                        TreePath tp = tree.getClosestPathForLocation(e.getX(), e.getY());
                        tree.setSelectionPath(tp);
                        BaseTreeNode node = (BaseTreeNode) o;
                    
                        if (node != null && node instanceof FileTreeNode) {
                            openFile(node.getElement().getFile());
                        }
                    }
                }
            }
        });
        tree.setScrollsOnExpand(true);
        tree.setShowsRootHandles(true);
        splitter.setLeftComponent(tree);

        dip = new TabbedInterfaceProvider();
        dip.setVisible(true);
        splitter.setRightComponent(dip);
        splitter.setDividerLocation(120);

        menubar = new JMenuBar();
        menubar.setVisible(true);
        f.add(menubar, BorderLayout.NORTH);

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
                openFile();
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

        editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        editMenu.setEnabled(false);
        editMenu.setVisible(true);
        menubar.add(editMenu);
    }

    /**
     * Handles any provided events
     * @param evt The sent event
     */
    @Override
    public void handleEvent(NotifyEvent evt) {
        if (evt.getEventType().equals(DefaultEventTypes.WINDOW_CREATED)) {
            
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
                    Enumeration children = projectNode.children();
                    boolean add = true;
                    while (children.hasMoreElements()) {
                        Object o = children.nextElement();
                        if (o instanceof FileElement) {
                            FileElement elem = (FileElement) o;
                            if (elem.getFile().equals(el)) {
                                add = false;
                                tree.setSelectionRow(project.getFiles().indexOf(elem));
                                break;
                            }
                        }
                    }
                    if (add) {
                        project.add(el);
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
     */
    public void openFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setDialogTitle("Select files to open");
        if (chooser.showDialog(Core.getStaticContext().getMainFrame(), "OK") != JFileChooser.CANCEL_OPTION) {
            File[] files = chooser.getSelectedFiles();
            for (File f : files) {
                if (f.exists()) {
                    openFile(f);
                }
            }
        }
    }

    /**
     * Pops a New FolderProject Dialog
     */
    public void popupNewProjectDialog() {
        NewProjectDialog dialog = new NewProjectDialog(Core.getStaticContext().getMainFrame());
        dialog.setVisible(true);
    }
}
