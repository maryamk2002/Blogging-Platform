/**
 * ModerateBlogService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package moderatemain;

public interface ModerateBlogService extends javax.xml.rpc.Service {
    public java.lang.String getmoderateBlogAddress();

    public moderatemain.ModerateBlog getmoderateBlog() throws javax.xml.rpc.ServiceException;

    public moderatemain.ModerateBlog getmoderateBlog(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
