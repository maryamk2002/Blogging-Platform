package main;

public class DeletePostProxy implements main.DeletePost {
  private String _endpoint = null;
  private main.DeletePost deletePost = null;
  
  public DeletePostProxy() {
    _initDeletePostProxy();
  }
  
  public DeletePostProxy(String endpoint) {
    _endpoint = endpoint;
    _initDeletePostProxy();
  }
  
  private void _initDeletePostProxy() {
    try {
      deletePost = (new main.DeletePostServiceLocator()).getDeletePost();
      if (deletePost != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)deletePost)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)deletePost)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (deletePost != null)
      ((javax.xml.rpc.Stub)deletePost)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public main.DeletePost getDeletePost() {
    if (deletePost == null)
      _initDeletePostProxy();
    return deletePost;
  }
  
  public java.lang.String removePost(int postId) throws java.rmi.RemoteException{
    if (deletePost == null)
      _initDeletePostProxy();
    return deletePost.removePost(postId);
  }
  
  
}