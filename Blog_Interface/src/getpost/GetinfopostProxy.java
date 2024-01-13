package getpost;

public class GetinfopostProxy implements getpost.Getinfopost {
  private String _endpoint = null;
  private getpost.Getinfopost getinfopost = null;
  
  public GetinfopostProxy() {
    _initGetinfopostProxy();
  }
  
  public GetinfopostProxy(String endpoint) {
    _endpoint = endpoint;
    _initGetinfopostProxy();
  }
  
  private void _initGetinfopostProxy() {
    try {
      getinfopost = (new getpost.GetinfopostServiceLocator()).getGetinfopost();
      if (getinfopost != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)getinfopost)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)getinfopost)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (getinfopost != null)
      ((javax.xml.rpc.Stub)getinfopost)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public getpost.Getinfopost getGetinfopost() {
    if (getinfopost == null)
      _initGetinfopostProxy();
    return getinfopost;
  }
  
  public java.lang.String searchPost(java.lang.String author_name, java.lang.String title) throws java.rmi.RemoteException{
    if (getinfopost == null)
      _initGetinfopostProxy();
    return getinfopost.searchPost(author_name, title);
  }
  
  
}