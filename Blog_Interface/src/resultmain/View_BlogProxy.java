package resultmain;

public class View_BlogProxy implements resultmain.View_Blog {
  private String _endpoint = null;
  private resultmain.View_Blog view_Blog = null;
  
  public View_BlogProxy() {
    _initView_BlogProxy();
  }
  
  public View_BlogProxy(String endpoint) {
    _endpoint = endpoint;
    _initView_BlogProxy();
  }
  
  private void _initView_BlogProxy() {
    try {
      view_Blog = (new resultmain.View_BlogServiceLocator()).getview_Blog();
      if (view_Blog != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)view_Blog)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)view_Blog)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (view_Blog != null)
      ((javax.xml.rpc.Stub)view_Blog)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public resultmain.View_Blog getView_Blog() {
    if (view_Blog == null)
      _initView_BlogProxy();
    return view_Blog;
  }
  
  public java.lang.String viewBlog() throws java.rmi.RemoteException{
    if (view_Blog == null)
      _initView_BlogProxy();
    return view_Blog.viewBlog();
  }
  
  
}