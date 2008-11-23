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
package org.gcreator.project.standard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.gcreator.project.Project;
import org.gcreator.project.ProjectElement;
import org.gcreator.project.ProjectFile;
import org.gcreator.project.io.BasicFile;
import org.gcreator.project.io.ProjectManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * Defualt implementation of {@link ProjectManager}
 * for {@link DefaultProject} that uses the file system
 * for storing files.
 * 
 * @author Serge Humphrey
 */
public class DefaultProjectManager implements ProjectManager {

    protected DefaultProject project;
    public static final String[] PROJECT_TYPES = new String[]{
        /* Pineapple Project File */
        "pmf",
    };
    public static final float PROJECT_VERSION = 1.05F;

    /**
     * Creates a new manger, with a given project.
     * 
     * @param p The {@link Project} that manager belongs for.
     * This may not be <tt>null</tt>.
     * 
     * @throws NullPointerException If the given project is <tt>null</tt>.
     */
    public DefaultProjectManager(DefaultProject p) throws NullPointerException {
        if (p == null) {
            throw new NullPointerException("Project may not be null.");
        }
        this.project = p;
    }

    /**
     * Creates a new manger, and loads the project from a file.
     * 
     * @param f The {@link java.io.File} to load.
     * @param folder The folder for the project.
     * @param type The project type for the project.
     * @param initial The {@link DefaultProject} to load the file to.
     * If this is <tt>null</tt>, a new {@link DefaultProject} will be created.
     * @throws NullPointerException If the given project is <tt>null</tt>.
     */
    public DefaultProjectManager(File f, File folder, DefaultProjectType type, DefaultProject initial) throws NullPointerException {
        if (f == null) {
            throw new NullPointerException("File may not be null.");
        }
        this.project = load(f, folder, type, initial);
    }

    /**
     * Not supported.
     */
    public void save(File f) {
    }
    
    /**
     * {@inheritDoc}
     */
    public BasicFile createFile(Project p, String type){
        File f = new File(p.getProjectFolder(), "newFile."+type);
        return new FileFile(f);
    }

    /**
     * Creates a new {@link Project} from a {@link java.io.File}.
     * 
     * @param f The {@link java.io.File} to be loaded.
     * @param folder The folder dor the project.
     * @param t The project type for te project.
     * @param initial The {@link DefaultProject} to load the file to.
     * If this is <tt>null</tt>, a new {@link DefaultProject} will be created.
     * @return A new {@link Project} created from the given {@link java.io.File}.
     * 
     * @see #getProjectFileTypes() 
     * @see #allowsProject(java.io.File) 
     */
    public DefaultProject load(File f, File folder, DefaultProjectType t, DefaultProject initial) {
        if (initial == null) {
            initial = new DefaultProject(null, folder, t, this, false);
        }
        String format;
        int i = f.getName().lastIndexOf('.');
        if (i == -1 || i == f.getName().length()) {
            format = null;
        } else {
            format = f.getName().substring(i + 1);
        }
        if (format == null) {
            System.err.println("Error: File " + f + " has null format");
            return null;
        }

        /* Pineapple Manifest File */
        if (format.equals("pmf")) {
            loadFromManifest(f, initial);
        }

        return initial;
    }

    public static String[] getProjectFileTypes() {
        return PROJECT_TYPES;
    }

    /**
     * {@inheritDoc}
     */
    public String[] getImportFileTypes() {
        return null; /* No Importing supported yet. */
    }

    /**
     * {@inheritDoc}
     */
    public String[] getExportFileTypes() {
        return null; /* No Exporting supported yet. */
    }

    /**
     * Saves the project to a manifest.
     * 
     */
    protected void saveToManifest() {
        if (project == null || project.getProjectFolder() == null) {
            return;
        }
        try {
            project.managing = true;
            File f = new File(project.getProjectFolder().getPath() + File.separator + "project.pmf");
            if (!f.exists()) {
                f.createNewFile();
            }
            DocumentBuilder builder = createDocumentBuilder();
            if (builder == null) {
                System.err.println("Error: can't save projct XML to null builder.");
                return;
            }
            Document doc = builder.newDocument();
            Element root = doc.createElement("pineapple-project");
            root.setAttribute("version", Float.toString(PROJECT_VERSION));
            root.setAttribute("name", project.getName());
            /* Files */
            Element files = doc.createElement("files");
            for (ProjectElement p : project.getFiles()) {
                Element elem = doc.createElement("file");
                elem.setAttribute("path", p.getFile().getPath());
                files.appendChild(elem);
            }
            root.appendChild(files);

            /* Settings */
            Element settings = doc.createElement("settings");
            for (String s : project.settings.keySet()) {
                Element setting = doc.createElement("settings");
                setting.setAttribute("key", s);
                setting.setAttribute("value", project.settings.get(s));
                settings.appendChild(setting);
            }
            root.appendChild(settings);

            doc.appendChild(root);
            // Prepare the DOM document for writing
            Source source = new DOMSource(doc);
            Result result = null;

            // Write the DOM document to the file
            Transformer xformer;
            result = new StreamResult(new FileOutputStream(f));
            xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(source, result);
        } catch (IOException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            project.managing = false;
        }
    }

    protected static DocumentBuilder createDocumentBuilder() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Loads a project from a manifest.
     * 
     * @param f The manifest file to load.
     * @param project The project to apply the manifest to.
     */
    protected void loadFromManifest(File f, DefaultProject project) {
        try {
            project.managing = true;
            DocumentBuilder builder = createDocumentBuilder();
            if (builder == null) {
                System.err.println("Error: can't load projct XML from null builder.");
                project = null;
                return;
            }
            Document doc = builder.parse(f);
            Element root = doc.getDocumentElement();
            if (!root.getTagName().equals("pineapple-project")) {
                System.err.println("Error: not a valid Pineapple Project Manifest");
                project = null;
                return;
            }
            if (!root.hasAttribute("version")) {
                System.err.println("Error: no manifest version");
                project = null;
                return;
            }
            if (!root.getAttribute("version").equals(Float.toString(PROJECT_VERSION))) {
                System.err.println("Error: wrong manifest version: " +
                        root.getAttribute("version") + ", current: " + Float.toString(PROJECT_VERSION));
                project = null;
                return;
            }

            project.setProjectFolder(f.getParentFile());


            /* Files */
            Node files = root.getElementsByTagName("files").item(0);
            if (files == null) {
                System.err.println("Error: No <files> tag");
                project = null;
                return;
            }
            for (int i = 0; i < files.getChildNodes().getLength(); i++) {
                Node node = files.getChildNodes().item(i);
                if (!(node instanceof Element)) {
                    System.err.println("Warning: " + node + " is not of class Element. Cannot load.");
                    continue;
                }
                Element n = (Element) node;
                if (!n.hasAttribute("path")) {
                    System.err.println("Warning: " + n + " has not path attribute. Cannot load.");
                    continue;
                }

                File file = new File(n.getAttribute("path"));
                if (!file.exists()) {
                    System.err.println("Error: file " + file + " does not exist.");
                    continue;
                }
                try {
                    project.add(project.createElement(new FileFile(file)));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            /* Settings */
            Node settings = doc.getElementsByTagName("settings").item(0);
            if (settings == null) {
                System.err.println("Error: No <settings> tag");
                return;
            }

            for (int i = 0; i < settings.getChildNodes().getLength(); i++) {
                Node node = files.getChildNodes().item(i);
                if (!(node instanceof Element)) {
                    System.err.println("Warning: " + node + " is not of class Element. Cannot load.");
                    continue;
                }
                Element setting = (Element) node;
                project.settings.put(setting.getAttribute("key"), setting.getAttribute("value"));
            }
        } catch (SAXException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            project.managing = true;
        }
    }

    public Project getProject() {
        return project;
    }

    /**
     * {@inheritDoc}
     */
    public void importFile(File f) {
    }

    /**
     * {@inheritDoc}
     */
    public void exportFile(File f) {
    }
}
