/**
 * GetinfopostServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package getpost;

public class GetinfopostServiceLocator extends org.apache.axis.client.Service implements getpost.GetinfopostService {

    public GetinfopostServiceLocator() {
    }


    public GetinfopostServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GetinfopostServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Getinfopost
    private java.lang.String Getinfopost_address = "http://localhost:8080/Blog_Platform/services/Getinfopost";

    public java.lang.String getGetinfopostAddress() {
        return Getinfopost_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GetinfopostWSDDServiceName = "Getinfopost";

    public java.lang.String getGetinfopostWSDDServiceName() {
        return GetinfopostWSDDServiceName;
    }

    public void setGetinfopostWSDDServiceName(java.lang.String name) {
        GetinfopostWSDDServiceName = name;
    }

    public getpost.Getinfopost getGetinfopost() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Getinfopost_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGetinfopost(endpoint);
    }

    public getpost.Getinfopost getGetinfopost(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            getpost.GetinfopostSoapBindingStub _stub = new getpost.GetinfopostSoapBindingStub(portAddress, this);
            _stub.setPortName(getGetinfopostWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGetinfopostEndpointAddress(java.lang.String address) {
        Getinfopost_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (getpost.Getinfopost.class.isAssignableFrom(serviceEndpointInterface)) {
                getpost.GetinfopostSoapBindingStub _stub = new getpost.GetinfopostSoapBindingStub(new java.net.URL(Getinfopost_address), this);
                _stub.setPortName(getGetinfopostWSDDServiceName());
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
        if ("Getinfopost".equals(inputPortName)) {
            return getGetinfopost();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://main", "GetinfopostService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://main", "Getinfopost"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Getinfopost".equals(portName)) {
            setGetinfopostEndpointAddress(address);
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
