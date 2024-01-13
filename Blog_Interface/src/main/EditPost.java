/**
 * EditPost.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public interface EditPost extends java.rmi.Remote {
    public java.lang.String editPost(int authorId, int postId, java.lang.String updatedTitle, java.lang.String updatedContent) throws java.rmi.RemoteException;
}
