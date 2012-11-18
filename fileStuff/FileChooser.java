package fileStuff;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
 * class FileChooser is a class designed to make the
 * use of files easier. It uses JFileChooser but hides
 * all the messy parts - that is, the user needn't
 * worry about the returnVal, the call to the dialog,
 * the call to getSelectedFile(), ... since it is all
 * handled automatically. FileChooser has methods to
 * simply return the chosen File handle (chooseFile()),
 * to return an opened Scanner on a chosen File
 * (openScanner()), to return a PrintWriter on a chosen
 * File (openPrintWriter()), to return an ObjectOutputStream
 * on a chosen file (openObjectWriter()), and to return
 * an ObjectInputStream on a chosen file (openObjectReader()).
 * 
 * @author Lynn R. Ziegler
 * 
 */
public class FileChooser {
  /**
   * chooseFile() simply uses class JFileChooser to open
   * a dialog to allow the user to choose a file and,
   * then, returns that file if one is chosen. If none is
   * chosen, null is returned.
   */
  public static File chooseFile() {
    JFileChooser fileChooser=new JFileChooser();
    int returnVal=fileChooser.showOpenDialog(null);
    if(returnVal==JFileChooser.APPROVE_OPTION) {
      return(fileChooser.getSelectedFile());
    }
    else return(null);
  }
  
  /**
   * openScanner() uses JFileChooser (via chooseFile())
   * to open a FileChooser whereby the user can select
   * the input file for the Scanner to work on and returns
   * that Scanner. If the operation fails, openScanner()
   * will throw a FileNotFoundException.
   */
  public static Scanner openScanner() 
               throws FileNotFoundException {
    File file=chooseFile();
    if(file!=null) {
      return(new Scanner(file));
    }
    else throw new FileNotFoundException(
              "Failed to open file for Scanner");
  }
  
  /**
   * openPrintWriter() uses JFileChooser (via choosefile())
   * to open a FileChooser whereby the user can select the
   * output file for the PrintWriter to work on and, then,
   * returns that PrintWriter. If the operation fails,
   * openPrintWriter() throws a FileNotFoundException.
   */
  public static PrintWriter openPrintWriter() 
               throws FileNotFoundException {
    File file=chooseFile();
    if(file!=null) {
      return(new PrintWriter(file));
    }
    else throw new FileNotFoundException(
              "Failed to open file for openPrintWriter");
  }
  
  /**
   * openObjectWriter uses JFileChooser (via fileChooser())
   * to open an ObjectOutputStream on a specified file and,
   * then, returns the ObjectOutputStream. Failure of the
   * attempt leads to either a FileNotFoundException or
   * an IOException.
   */
  public static ObjectOutputStream openObjectWriter()
               throws FileNotFoundException,IOException {
    File file=chooseFile();
    if(file!=null) {
      return new ObjectOutputStream(
               new FileOutputStream(file));
    }
    else throw new FileNotFoundException(
              "Failed to open file for openObjectWriter");
  }
  
  /**
   * openObjectReader uses JFileChooser (via fileChooser())
   * to open an ObjectInputStream on a specified file and,
   * then, returns the ObjectInputStream. Failure of the
   * attempt leads to either a FileNotFoundException or
   * an IOException.
   */
  public static ObjectInputStream openObjectReader()
               throws FileNotFoundException,IOException {
    File file=chooseFile();
    if(file!=null) {
      return new ObjectInputStream(new FileInputStream(file));
    }
    else throw new FileNotFoundException(
             "Failed to open file for openObjectReader");
  }
}
  