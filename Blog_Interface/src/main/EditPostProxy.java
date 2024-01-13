package main;

public class EditPostProxy implements main.EditPost {
  private String _endpoint = null;
  private main.EditPost editPost = null;
  
  public EditPostProxy() {
    _initEditPostProxy();
  }
  
  public EditPostProxy(String endpoint) {
    _endpoint = endpoint;
    _initEditPostProxy();
  }
  
  private void _initEditPostProxy() {
    try {
      editPost = (new main.EditPostServiceLocator()).getEditPost();
      if (editPost != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)editPost)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)editPost)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (editPost != null)
      ((javax.xml.rpc.Stub)editPost)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public main.EditPost getEditPost() {
    if (editPost == null)
      _initEditPostProxy();
    return editPost;
  }
  
  public java.lang.String editPost(int authorId, int postId, java.lang.String updatedTitle, java.lang.String updatedContent) throws java.rmi.RemoteException{
    if (editPost == null)
      _initEditPostProxy();
    return editPost.editPost(authorId, postId, updatedTitle, updatedContent);
  }
  
  
}