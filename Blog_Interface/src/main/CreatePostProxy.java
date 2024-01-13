package main;

public class CreatePostProxy implements main.CreatePost {
  private String _endpoint = null;
  private main.CreatePost createPost = null;
  
  public CreatePostProxy() {
    _initCreatePostProxy();
  }
  
  public CreatePostProxy(String endpoint) {
    _endpoint = endpoint;
    _initCreatePostProxy();
  }
  
  private void _initCreatePostProxy() {
    try {
      createPost = (new main.CreatePostServiceLocator()).getCreatePost();
      if (createPost != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)createPost)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)createPost)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (createPost != null)
      ((javax.xml.rpc.Stub)createPost)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public main.CreatePost getCreatePost() {
    if (createPost == null)
      _initCreatePostProxy();
    return createPost;
  }
  
  public java.lang.String addPost(int authorId, java.lang.String title, java.lang.String content) throws java.rmi.RemoteException{
    if (createPost == null)
      _initCreatePostProxy();
    return createPost.addPost(authorId, title, content);
  }
  
  
}