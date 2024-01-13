/**
 * ModerateBlogServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package moderatemain;

public class ModerateBlogServiceLocator extends org.apache.axis.client.Service implements moderatemain.ModerateBlogService {

    public ModerateBlogServiceLocator() {
    }


    public ModerateBlogServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ModerateBlogServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for moderateBlog
    private java.lang.String moderateBlog_address = "http://localhost:8080/Blog_Platform/services/moderateBlog";

    public java.lang.String getmoderateBlogAddress() {
        return moderateBlog_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String moderateBlogWSDDServiceName = "moderateBlog";

    public java.lang.String getmoderateBlogWSDDServiceName() {
        return moderateBlogWSDDServiceName;
    }

    public void setmoderateBlogWSDDServiceName(java.lang.String name) {
        moderateBlogWSDDServiceName = name;
    }

    public moderatemain.ModerateBlog getmoderateBlog() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(moderateBlog_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getmoderateBlog(endpoint);
    }

    public moderatemain.ModerateBlog getmoderateBlog(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            moderatemain.ModerateBlogSoapBindingStub _stub = new moderatemain.ModerateBlogSoapBindingStub(portAddress, this);
            _stub.setPortName(getmoderateBlogWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setmoderateBlogEndpointAddress(java.lang.String address) {
        moderateBlog_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (moderatemain.ModerateBlog.class.isAssignableFrom(serviceEndpointInterface)) {
                moderatemain.ModerateBlogSoapBindingStub _stub = new moderatemain.ModerateBlogSoapBindingStub(new java.net.URL(moderateBlog_address), this);
                _stub.setPortName(getmoderateBlogWSDDServiceName());
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
        if ("moderateBlog".equals(inputPortName)) {
            return getmoderateBlog();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://main", "moderateBlogService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://main", "moderateBlog"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("moderateBlog".equals(portName)) {
            setmoderateBlogEndpointAddress(address);
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
