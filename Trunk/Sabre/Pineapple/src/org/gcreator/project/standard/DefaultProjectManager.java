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

import java.io.BufferedOutputStream;
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
import org.gcreator.project.ProjectFolder;
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
    public static final String[] PROJECT_TYPES = new String[] {
        /* Pineapple Project File */
        "pmf",
    };
    
    public static final float PROJECT_VERSION = 1.0F;
    
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
     * @throws NullPointerException If the given project is <tt>null</tt>.
     */
    public DefaultProjectManager(File f) throws NullPointerException {
        if (f == null) {
            throw new NullPointerException("File may not be null.");
        }
        this.project = load(f);
    }
    
    /**
     * Not supported.
     */
    public void save(File f) {
    }
    
    /**
     * {@inheritDoc}
     */
    public DefaultProject load(File f) {
        DefaultProject p = new DefaultProject();
        String format;
        int i = f.getName().lastIndexOf('.');
        if (i == -1 || i == f.getName().length()) {
            format = null;
        } else {
            format = f.getName().substring(i+1);
        }
        /* Pineapple Manifest File */
        if (format.equals("pmf")) {
           loadFromManifest(f, p);
        }
        
        return p;
    }

    public static String[] getProjectFileTypes() {
        return PROJECT_TYPES;
    }

    public static boolean save(ProjectElement e, Object newContent) {
        if (newContent instanceof String) {
            BufferedOutputStream out = null;
            try {
                String s = newContent.toString();
                out = new BufferedOutputStream(e.getFile().getOutputStream());
                out.write(s.getBytes());
                return true;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
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
     */
    protected void saveToManifest() {
        File f = new File(project.getProjectFolder().getPath() + File.separator + "/project.pmf");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        DocumentBuilder builder = createDocumentBuilder();
        if (builder == null) {
            System.err.println("Error: can't save projct XML to null builder.");
            return;
        }
        Document doc = builder.newDocument();
        Element root = doc.createElement("pineapple-project");
        root.setAttribute("version", Float.toString(PROJECT_VERSION));
        root.setAttribute("hasfolder", Boolean.toString(project.getProjectFolder() != null));
        /* Files */
        Element files = doc.createElement("files");
        for (ProjectElement p : project.getFiles()) {
            recursiveSave(p, files, doc);
        }
        root.appendChild(files);
        
        /* Settings */
        Element settings = doc.createElement("settings");
        for (String s : project.getSettings().keySet()) {
            Element setting = doc.createElement("settings");
            setting.setAttribute("key", s);
            setting.setAttribute("value", project.getSettings().get(s));
        }
        root.appendChild(settings);
        
        
        doc.appendChild(root);
        // Prepare the DOM document for writing
        Source source = new DOMSource(doc);
        Result result = null;

        // Write the DOM document to the file
        Transformer xformer;
        try {
            result = new StreamResult(new FileOutputStream(f));
        } catch (IOException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        try {
            xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected static DocumentBuilder createDocumentBuilder() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void recursiveSave(ProjectElement p, Element e, Document doc) {
        Element elem = doc.createElement("file");
        elem.setAttribute("path", p.getFile().toString());

        if (p instanceof ProjectFolder) {
            for (ProjectElement pe : ((ProjectFolder) p).getChildren()) {
                recursiveSave(pe, elem, doc);
            }
        }
        e.appendChild(elem);
    }

    /**
     * Loads a project from a manifest.
     * 
     * @param f The manifest file to load.
     * @param project The project to apply the manifest to.
     */
    protected void loadFromManifest(File f, DefaultProject project) {
        try {
            DocumentBuilder builder = createDocumentBuilder();
            if (builder == null) {
                System.err.println("Error: can't load projct XML from null builder.");
                return;
            }
            Document doc = builder.parse(f);
            Element root = doc.getDocumentElement();
            if (!root.getTagName().equals("pineapple-project")) {
                System.err.println("Error: not a valid Pineapple Project Manifest");
                return;
            }
            if (root.getAttribute("version").equals(Float.toString(PROJECT_VERSION))) {
                System.err.println("Error: wrong manifest version");
                return;
            }
            if (root.getAttribute("hasfolder").equals(Boolean.toString(Boolean.TRUE))) {
                project.setProjectFolder(f.getParentFile());
            }
            
            /* Files */
            Node files = root.getElementsByTagName("files").item(0);
            if (files == null) {
                System.err.println("Error: No <files> tag");
                return;
            }
            for (int i = 0; i < files.getChildNodes().getLength(); i++) {

                if (!(files instanceof Element)) {
                    System.err.println("Warning: " + files + " is not of class NodeImpl. Cannot load.");
                    return;
                }
                Element n = (Element) files;
                if (!n.hasAttribute("path")) {
                    System.err.println("Warning: " + n + " has not path attribute. Cannot load.");
                    return;
                }
                
                File file = new File(n.getAttribute("path"));
                if (!file.exists()) {
                    System.err.println("Error: file " + file + " does not exist.");
                    return;
                }
                try {
                    project.add(project.createElement(new FileFile(file)));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }

            /* Settings */
            Element settings = doc.createElement("settings");
            for (String s : project.getSettings().keySet()) {
                Element setting = doc.createElement("settings");
                setting.setAttribute("key", s);
                setting.setAttribute("value", project.getSettings().get(s));
            }
            root.appendChild(settings);


            doc.appendChild(root);
        } catch (SAXException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BasicFile createBasicFileFromFile(File f) {
        return new FileFile(f);
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
