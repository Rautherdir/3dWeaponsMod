package Rautherdir.ThreeDWeaponStand;

import org.lwjgl.util.vector.Vector3f;

public class Connection {
	public enum ConnectionType {
		generic;
	}
	
	private Vector3f Origin;
	private Vector3f Angle;
	private ConnectionType type;
	
	public Connection(Vector3f O, Vector3f A, ConnectionType type) {
		Origin = O;
		Angle = A;
		this.type = type;
	}
	
	public Vector3f getOrigin() {
		return Origin;
	}
	
	public Vector3f getAngle() {
		return Angle;
	}
	
	public boolean checkCompatibility(ConnectionType c) {
		
		return true;
	}
}
