/**
 * DeletePostServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public class DeletePostServiceLocator extends org.apache.axis.client.Service implements main.DeletePostService {

    public DeletePostServiceLocator() {
    }


    public DeletePostServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DeletePostServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DeletePost
    private java.lang.String DeletePost_address = "http://localhost:8080/Blog_Platform/services/DeletePost";

    public java.lang.String getDeletePostAddress() {
        return DeletePost_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DeletePostWSDDServiceName = "DeletePost";

    public java.lang.String getDeletePostWSDDServiceName() {
        return DeletePostWSDDServiceName;
    }

    public void setDeletePostWSDDServiceName(java.lang.String name) {
        DeletePostWSDDServiceName = name;
    }

    public main.DeletePost getDeletePost() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DeletePost_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDeletePost(endpoint);
    }

    public main.DeletePost getDeletePost(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            main.DeletePostSoapBindingStub _stub = new main.DeletePostSoapBindingStub(portAddress, this);
            _stub.setPortName(getDeletePostWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDeletePostEndpointAddress(java.lang.String address) {
        DeletePost_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (main.DeletePost.class.isAssignableFrom(serviceEndpointInterface)) {
                main.DeletePostSoapBindingStub _stub = new main.DeletePostSoapBindingStub(new java.net.URL(DeletePost_address), this);
                _stub.setPortName(getDeletePostWSDDServiceName());
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
        if ("DeletePost".equals(inputPortName)) {
            return getDeletePost();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://main", "DeletePostService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://main", "DeletePost"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DeletePost".equals(portName)) {
            setDeletePostEndpointAddress(address);
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
