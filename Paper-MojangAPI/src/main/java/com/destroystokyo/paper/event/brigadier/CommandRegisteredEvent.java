package com.destroystokyo.paper.event.brigadier;

import com.destroystokyo.paper.brigadier.BukkitBrigadierCommand;
import com.mojang.brigadier.tree.ArgumentCommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.server.ServerEvent;
import org.jetbrains.annotations.NotNull;

public class CommandRegisteredEvent extends ServerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final String label;
    private final BukkitBrigadierCommand command;
    private final RootCommandNode root;
    private final ArgumentCommandNode defaultArgs;
    private LiteralCommandNode literal;
    private boolean cancelled = false;

    public CommandRegisteredEvent(String label, BukkitBrigadierCommand command, RootCommandNode root, LiteralCommandNode literal, ArgumentCommandNode defaultArgs) {
        this.label = label;
        this.command = command;
        this.root = root;
        this.literal = literal;
        this.defaultArgs = defaultArgs;
    }

    public String getCommandLabel() {
        return label;
    }

    /**
     * @return The Bukkit API Brigadier Wrapped Command Object to handle executions and suggestions
     */
    public BukkitBrigadierCommand getCommand() {
        return command;
    }

    /**
     * @return Gets the root command node being used to register a command to.
     */
    public RootCommandNode getRoot() {
        return root;
    }

    /**
     * Returns the Bukkit API's default handling of Arguments, if you wish to reuse it.
     * @return
     */
    public ArgumentCommandNode getDefaultArgs() {
        return defaultArgs;
    }

    /**
     * Returns the Bukkit API's default literal for this command, including the {@link #getDefaultArgs()} as a child already.
     * @return
     */
    public LiteralCommandNode getLiteral() {
        return literal;
    }

    public void setLiteral(LiteralCommandNode literal) {
        this.literal = literal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
