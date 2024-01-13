/**
 * EditPostServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public class EditPostServiceLocator extends org.apache.axis.client.Service implements main.EditPostService {

    public EditPostServiceLocator() {
    }


    public EditPostServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EditPostServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EditPost
    private java.lang.String EditPost_address = "http://localhost:8080/Blog_Platform/services/EditPost";

    public java.lang.String getEditPostAddress() {
        return EditPost_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EditPostWSDDServiceName = "EditPost";

    public java.lang.String getEditPostWSDDServiceName() {
        return EditPostWSDDServiceName;
    }

    public void setEditPostWSDDServiceName(java.lang.String name) {
        EditPostWSDDServiceName = name;
    }

    public main.EditPost getEditPost() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EditPost_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEditPost(endpoint);
    }

    public main.EditPost getEditPost(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            main.EditPostSoapBindingStub _stub = new main.EditPostSoapBindingStub(portAddress, this);
            _stub.setPortName(getEditPostWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEditPostEndpointAddress(java.lang.String address) {
        EditPost_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (main.EditPost.class.isAssignableFrom(serviceEndpointInterface)) {
                main.EditPostSoapBindingStub _stub = new main.EditPostSoapBindingStub(new java.net.URL(EditPost_address), this);
                _stub.setPortName(getEditPostWSDDServiceName());
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
        if ("EditPost".equals(inputPortName)) {
            return getEditPost();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://main", "EditPostService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://main", "EditPost"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EditPost".equals(portName)) {
            setEditPostEndpointAddress(address);
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
