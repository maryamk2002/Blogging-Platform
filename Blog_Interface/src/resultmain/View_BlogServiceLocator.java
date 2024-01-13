/**
 * View_BlogServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package resultmain;

public class View_BlogServiceLocator extends org.apache.axis.client.Service implements resultmain.View_BlogService {

    public View_BlogServiceLocator() {
    }


    public View_BlogServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public View_BlogServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for view_Blog
    private java.lang.String view_Blog_address = "http://localhost:8080/Blog_Platform/services/view_Blog";

    public java.lang.String getview_BlogAddress() {
        return view_Blog_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String view_BlogWSDDServiceName = "view_Blog";

    public java.lang.String getview_BlogWSDDServiceName() {
        return view_BlogWSDDServiceName;
    }

    public void setview_BlogWSDDServiceName(java.lang.String name) {
        view_BlogWSDDServiceName = name;
    }

    public resultmain.View_Blog getview_Blog() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(view_Blog_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getview_Blog(endpoint);
    }

    public resultmain.View_Blog getview_Blog(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            resultmain.View_BlogSoapBindingStub _stub = new resultmain.View_BlogSoapBindingStub(portAddress, this);
            _stub.setPortName(getview_BlogWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setview_BlogEndpointAddress(java.lang.String address) {
        view_Blog_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (resultmain.View_Blog.class.isAssignableFrom(serviceEndpointInterface)) {
                resultmain.View_BlogSoapBindingStub _stub = new resultmain.View_BlogSoapBindingStub(new java.net.URL(view_Blog_address), this);
                _stub.setPortName(getview_BlogWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("view_Blog".equals(inputPortName)) {
            return getview_Blog();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://main", "view_BlogService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://main", "view_Blog"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("view_Blog".equals(portName)) {
            setview_BlogEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
