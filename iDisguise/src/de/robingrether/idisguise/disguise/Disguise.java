package de.robingrether.idisguise.disguise;

import java.io.Serializable;

import de.robingrether.idisguise.management.VersionHelper;
import de.robingrether.util.ObjectUtil;

/**
 * Represents a disguise.
 * 
 * @since 2.1.3
 * @author RobinGrether
 */
public abstract class Disguise implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 3699593353745149494L;
	protected final DisguiseType type;
	
	protected Disguise(DisguiseType type) {
		if((!VersionHelper.require1_9() && type.equals(DisguiseType.SHULKER)) || (!VersionHelper.require1_8() && ObjectUtil.equals(type, DisguiseType.ENDERMITE, DisguiseType.GUARDIAN, DisguiseType.RABBIT, DisguiseType.ARMOR_STAND)) || (!VersionHelper.require1_6() && type.equals(DisguiseType.HORSE))) {
			throw new OutdatedServerException("The given disguise type is not available on this server version.");
		}
		this.type = type;
	}
	
	/**
	 * Returns the disguise type
	 * 
	 * @since 2.1.3
	 * @return the disguise type
	 */
	public DisguiseType getType() {
		return this.type;
	}
	
	/**
	 * Creates and returns a copy of this object.
	 * 
	 * @since 3.0.1
	 * @return a clone of this instance
	 */
	public abstract Disguise clone();
	
	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * @since 3.0.1
	 * @return <code>true</code> if this object is the same as the <code>object</code> argument; <code>false</code> otherwise
	 */
	public boolean equals(Object object) {
		return object instanceof Disguise && ((Disguise)object).getType().equals(type);
	}
	
	/**
	 * Applies subtype updates based on command arguments.
	 * 
	 * @since 5.1.1
	 * @param argument the command argument
	 * @return <code>true</code>, if an update has been applied, <code>false</code> otherwise
	 */
	public abstract boolean applySubtype(String argument);
	
}