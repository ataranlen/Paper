package com.destroystokyo.paper.brigadier;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.suggestion.SuggestionProvider;

public interface BukkitBrigadierCommand <S> extends Command<S>, SuggestionProvider<S> {
}
