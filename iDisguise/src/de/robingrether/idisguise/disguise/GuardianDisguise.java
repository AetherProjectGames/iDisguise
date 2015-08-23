package de.robingrether.idisguise.disguise;

import org.bukkit.Location;
import net.minecraft.server.v1_8_R3.EntityGuardian;
import net.minecraft.server.v1_8_R3.World;

/**
 * Represents a disguise as a guardian.
 * 
 * @since 4.0.1
 * @author Robingrether
 */
public class GuardianDisguise extends MobDisguise {
	
	private static final long serialVersionUID = 8098510434769803362L;
	private boolean isElder;
	
	/**
	 * Creates an instance.
	 * 
	 * @since 4.0.1
	 */
	public GuardianDisguise() {
		this(false);
	}
	
	/**
	 * Creates an instance.
	 * 
	 * @since 4.0.1
	 * @param isElder whether the guardian should be elder
	 */
	public GuardianDisguise(boolean isElder) {
		super(DisguiseType.GUARDIAN, true);
		this.isElder = isElder;
	}
	
	/**
	 * Returns whether the guardian is elder.
	 * 
	 * @since 4.0.1
	 * @return <code>true</code>, if the guardian is elder
	 */
	public boolean isElder() {
		return isElder;
	}
	
	/**
	 * Sets whether the guardian is elder.
	 * 
	 * @since 4.0.1
	 * @param isElder <code>true</code>, if the guardian should be elder
	 */
	public void setElder(boolean isElder) {
		this.isElder = isElder;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public GuardianDisguise clone() {
		GuardianDisguise clone = new GuardianDisguise(isElder);
		clone.setCustomName(customName);
		return clone;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object object) {
		return super.equals(object) && object instanceof GuardianDisguise && ((GuardianDisguise)object).isElder == isElder;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public EntityGuardian getEntity(World world, Location location, int id) {
		EntityGuardian guardian = (EntityGuardian)super.getEntity(world, location, id);
		guardian.setElder(isElder);
		return guardian;
	}
	
}