package common;

import java.util.function.BooleanSupplier;

import org.osbot.rs07.utility.ConditionalSleep;

/**
 * 
 * Helper class used to make Condition Sleeps much less cluttered for use in scripts
 * 
 * @author daniel.stewart
 *
 */
public final class Sleep extends ConditionalSleep {
	private final BooleanSupplier condition;

    public Sleep(final BooleanSupplier condition, final int timeout) {
        super(timeout);
        this.condition = condition;
    }

    @Override
    public final boolean condition() throws InterruptedException {
        return condition.getAsBoolean();
    }

    public static boolean sleepUntil(final BooleanSupplier condition, final int timeout) {
        return new Sleep(condition, timeout).sleep();
    }
}
