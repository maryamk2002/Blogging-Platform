/**
 * DisplayPost.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public interface DisplayPost extends java.rmi.Remote {
    public java.lang.String displayPost(int authorId, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String getAndDisplayPosts(int authorId, java.lang.String password) throws java.rmi.RemoteException;
}
