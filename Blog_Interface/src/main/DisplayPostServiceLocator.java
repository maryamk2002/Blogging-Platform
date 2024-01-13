/**
 * DisplayPostServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public class DisplayPostServiceLocator extends org.apache.axis.client.Service implements main.DisplayPostService {

    public DisplayPostServiceLocator() {
    }


    public DisplayPostServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DisplayPostServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DisplayPost
    private java.lang.String DisplayPost_address = "http://localhost:8080/Blog_Platform/services/DisplayPost";

    public java.lang.String getDisplayPostAddress() {
        return DisplayPost_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DisplayPostWSDDServiceName = "DisplayPost";

    public java.lang.String getDisplayPostWSDDServiceName() {
        return DisplayPostWSDDServiceName;
    }

    public void setDisplayPostWSDDServiceName(java.lang.String name) {
        DisplayPostWSDDServiceName = name;
    }

    public main.DisplayPost getDisplayPost() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DisplayPost_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDisplayPost(endpoint);
    }

    public main.DisplayPost getDisplayPost(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            main.DisplayPostSoapBindingStub _stub = new main.DisplayPostSoapBindingStub(portAddress, this);
            _stub.setPortName(getDisplayPostWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDisplayPostEndpointAddress(java.lang.String address) {
        DisplayPost_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (main.DisplayPost.class.isAssignableFrom(serviceEndpointInterface)) {
                main.DisplayPostSoapBindingStub _stub = new main.DisplayPostSoapBindingStub(new java.net.URL(DisplayPost_address), this);
                _stub.setPortName(getDisplayPostWSDDServiceName());
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
        if ("DisplayPost".equals(inputPortName)) {
            return getDisplayPost();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://main", "DisplayPostService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://main", "DisplayPost"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DisplayPost".equals(portName)) {
            setDisplayPostEndpointAddress(address);
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
