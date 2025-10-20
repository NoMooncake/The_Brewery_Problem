/**
 * -----------------------------------------------------------------------------
 * File Name: Console.java
 * Project: The_Brewery_Problem
 * Description:
 * [Add brief description here]
 * <p>
 * Author: Yue Wu
 * Date: 2025/10/19
 * Version: 2.0
 * -----------------------------------------------------------------------------
 */


package brewery.app;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * The {@code Console} class provides a unified logging utility for the Brewery System.
 * <p>
 * It standardizes terminal output across all modules (Inventory, Production, Recipes, etc.),
 * ensuring consistent formatting and clear visibility of different message types.
 * <p>
 * Instead of using {@code System.out.println()}, all components should use
 * {@link #info(String)}, {@link #ok(String)}, {@link #warn(String)}, or {@link #stage(String)}.
 * <p>
 * Example usage:
 * <pre>
 *     Console.stage("STAGE[A] Add Inventory");
 *     Console.ok("Added sugar 5.0 kg");
 *     Console.warn("Missing malt: need 2.0 kg more");
 * </pre>
 * Each line is automatically timestamped in HH:mm:ss format for traceability.
 *
 * <p><b>Design notes:</b>
 * <ul>
 *   <li>No static mutable state is kept (no global variables).</li>
 *   <li>All messages are pure output operations with single responsibility.</li>
 *   <li>This class does not depend on any external libraries.</li>
 * </ul>
 *
 * @author Yue Wu
 * @version Final Draft - October,19, 2025
 */
public final class Console {

    /** Formatter for displaying local time (e.g., 14:03:59). */
    private static final DateTimeFormatter TIME_FMT =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    /** Private constructor to prevent instantiation. */
    private Console() {}

    /**
     * Core logging method used internally by other helper methods.
     *
     * @param level the log level label (e.g., [INFO], [OK], [WARN])
     * @param msg   the message to display in the console
     */
    private static void log(String level, String msg) {
        String time = LocalTime.now().format(TIME_FMT);
        System.out.println("[" + time + "] " + level + " " + msg);
    }

    /**
     * Prints a general informational message.
     * Used for neutral events such as process steps or state transitions.
     *
     * @param msg the message to display
     */
    public static void info(String msg) {
        log("[INFO]", msg);
    }

    /**
     * Prints a success message.
     * Used for completed actions such as added ingredients or successful operations.
     *
     * @param msg the message to display
     */
    public static void ok(String msg) {
        log("[OK]", msg);
    }

    /**
     * Prints a warning or error message.
     * Used for unexpected situations such as missing inventory or invalid input.
     *
     * @param msg the message to display
     */
    public static void warn(String msg) {
        log("[WARN]", msg);
    }

    /**
     * Prints a stage header to clearly separate logical parts of the simulation.
     * Example output: {@code === STAGE[A] Add Inventory ===}
     *
     * @param title the name or label of the stage
     */
    public static void stage(String title) {
        System.out.println();
        System.out.println("=== " + title + " ===");
    }

    /**
     * Prints a divider for snapshot sections, typically used by
     * {@code MonitoringService} to separate system states.
     * Example output: {@code --- SNAPSHOT: INVENTORY ---}
     *
     * @param sectionName the name of the section being displayed
     */
    public static void divider(String sectionName) {
        System.out.println("--- SNAPSHOT: " + sectionName.toUpperCase() + " ---");
    }
}
