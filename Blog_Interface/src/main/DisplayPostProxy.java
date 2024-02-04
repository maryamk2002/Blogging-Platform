package main;

public class DisplayPostProxy implements main.DisplayPost {
  private String _endpoint = null;
  private main.DisplayPost displayPost = null;
  
  public DisplayPostProxy() {
    _initDisplayPostProxy();
  }
  
  public DisplayPostProxy(String endpoint) {
    _endpoint = endpoint;
    _initDisplayPostProxy();
  }
  
  private void _initDisplayPostProxy() {
    try {
      displayPost = (new main.DisplayPostServiceLocator()).getDisplayPost();
      if (displayPost != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)displayPost)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)displayPost)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (displayPost != null)
      ((javax.xml.rpc.Stub)displayPost)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public main.DisplayPost getDisplayPost() {
    if (displayPost == null)
      _initDisplayPostProxy();
    return displayPost;
  }
  
  public java.lang.String displayPost(int authorId, java.lang.String password) throws java.rmi.RemoteException{
    if (displayPost == null)
      _initDisplayPostProxy();
    return displayPost.displayPost(authorId, password);
  }
  
  public java.lang.String getAndDisplayPosts(int authorId, java.lang.String password) throws java.rmi.RemoteException{
    if (displayPost == null)
      _initDisplayPostProxy();
    return displayPost.getAndDisplayPosts(authorId, password);
  }
  
  
}