/**
 * ModerateBlog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package moderatemain;

public interface ModerateBlog extends java.rmi.Remote {
    public java.lang.String blogModeration(int postId, java.lang.String moderationDecision, java.lang.String rejectionReason) throws java.rmi.RemoteException;
}
