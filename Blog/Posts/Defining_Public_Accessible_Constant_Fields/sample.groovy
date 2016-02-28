$ javap -p -constants Sample
Compiled from "sample.groovy"
public class Sample implements groovy.lang.GroovyObject {
  public static final java.lang.String DEFAULT = "default";
  private java.lang.String message;
  ...
  public void message(java.lang.String);
  ...
  public java.lang.String getMessage();
  public void setMessage(java.lang.String);
}
