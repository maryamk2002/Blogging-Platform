package moderatemain;

public class ModerateBlogProxy implements moderatemain.ModerateBlog {
  private String _endpoint = null;
  private moderatemain.ModerateBlog moderateBlog = null;
  
  public ModerateBlogProxy() {
    _initModerateBlogProxy();
  }
  
  public ModerateBlogProxy(String endpoint) {
    _endpoint = endpoint;
    _initModerateBlogProxy();
  }
  
  private void _initModerateBlogProxy() {
    try {
      moderateBlog = (new moderatemain.ModerateBlogServiceLocator()).getmoderateBlog();
      if (moderateBlog != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)moderateBlog)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)moderateBlog)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (moderateBlog != null)
      ((javax.xml.rpc.Stub)moderateBlog)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public moderatemain.ModerateBlog getModerateBlog() {
    if (moderateBlog == null)
      _initModerateBlogProxy();
    return moderateBlog;
  }
  
  public java.lang.String blogModeration(int postId, java.lang.String moderationDecision, java.lang.String rejectionReason) throws java.rmi.RemoteException{
    if (moderateBlog == null)
      _initModerateBlogProxy();
    return moderateBlog.blogModeration(postId, moderationDecision, rejectionReason);
  }
  
  
}